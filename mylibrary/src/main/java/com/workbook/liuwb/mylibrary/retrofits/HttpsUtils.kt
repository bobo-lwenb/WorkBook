package com.workbook.liuwb.mylibrary.retrofits

import com.workbook.liuwb.mylibrary.retrofits.trustmanager.MyTrustManager
import com.workbook.liuwb.mylibrary.retrofits.trustmanager.UnSafeTrustManager
import java.io.IOException
import java.io.InputStream
import java.security.*
import java.security.cert.CertificateException
import java.security.cert.CertificateFactory
import javax.net.ssl.*

/**
 * Created by zhy on 15/12/14.
 */
object HttpsUtils {

    fun getSslSocketFactory(certificates: Array<InputStream>, bksFile: InputStream, password: String, isBothWay: Boolean): SSLParams {
        val sslParams = SSLParams()

        try {
            val trustManagers = prepareTrustManager(*certificates)
            val keyManagers = prepareKeyManager(bksFile, password)

            val sslContext = SSLContext.getInstance("TLS")

            val trustManager: X509TrustManager
            if (trustManagers != null) {
                trustManager = MyTrustManager(chooseTrustManager(trustManagers)!!)
            } else {
                trustManager = UnSafeTrustManager()
            }

            if (isBothWay) {
                sslContext.init(keyManagers, arrayOf<TrustManager>(trustManager), null)
            } else {
                sslContext.init(null, arrayOf<TrustManager>(trustManager), null)
            }

            sslParams.sSLSocketFactory = sslContext.socketFactory
            sslParams.trustManager = trustManager

            return sslParams
        } catch (e: NoSuchAlgorithmException) {
            throw AssertionError(e)
        } catch (e: KeyManagementException) {
            throw AssertionError(e)
        } catch (e: KeyStoreException) {
            throw AssertionError(e)
        }

    }

    private fun prepareTrustManager(vararg certificates: InputStream): Array<TrustManager>? {
        if (certificates.isEmpty()) return null

        try {
            val certificateFactory = CertificateFactory.getInstance("X.509")
            val keyStore = KeyStore.getInstance(KeyStore.getDefaultType())
            keyStore.load(null)

            for ((index, certificate) in certificates.withIndex()) {
                val certificateAlias = index.toString()
                keyStore.setCertificateEntry(certificateAlias, certificateFactory.generateCertificate(certificate))
                try {
                    certificate.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }

            }
            val trustManagerFactory: TrustManagerFactory? = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())

            trustManagerFactory!!.init(keyStore)

            return trustManagerFactory.trustManagers

        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        } catch (e: CertificateException) {
            e.printStackTrace()
        } catch (e: KeyStoreException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return null
    }

    private fun prepareKeyManager(bksFile: InputStream?, password: String?): Array<KeyManager>? {
        try {
            if (bksFile == null || password == null) return null

            val clientKeyStore: KeyStore = KeyStore.getInstance("BKS")
            clientKeyStore.load(bksFile, password.toCharArray())

            val keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm())
            keyManagerFactory.init(clientKeyStore, password.toCharArray())

            return keyManagerFactory.keyManagers

        } catch (e: KeyStoreException) {
            e.printStackTrace()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        } catch (e: UnrecoverableKeyException) {
            e.printStackTrace()
        } catch (e: CertificateException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return null
    }

    fun chooseTrustManager(trustManagers: Array<TrustManager>): X509TrustManager? {
        for (trustManager in trustManagers) {
            if (trustManager is X509TrustManager) {
                return trustManager
            }
        }
        return null
    }

    class SSLParams {
        var sSLSocketFactory: SSLSocketFactory? = null
        var trustManager: X509TrustManager? = null
    }

}