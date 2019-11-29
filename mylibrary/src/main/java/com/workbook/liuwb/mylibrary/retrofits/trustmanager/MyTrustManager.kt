package com.workbook.liuwb.mylibrary.retrofits.trustmanager

import com.workbook.liuwb.mylibrary.retrofits.HttpsUtils

import java.security.KeyStore
import java.security.KeyStoreException
import java.security.NoSuchAlgorithmException
import java.security.cert.CertificateException
import java.security.cert.X509Certificate

import javax.net.ssl.TrustManagerFactory
import javax.net.ssl.X509TrustManager

class MyTrustManager @Throws(NoSuchAlgorithmException::class, KeyStoreException::class)
constructor(private val localTrustManager: X509TrustManager) : X509TrustManager {
    private val defaultTrustManager: X509TrustManager?

    init {
        val trustManagerFactory: TrustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
        trustManagerFactory.init(null as KeyStore?)
        defaultTrustManager = HttpsUtils.chooseTrustManager(trustManagerFactory.trustManagers)
    }


    @Throws(CertificateException::class)
    override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {

    }

    @Throws(CertificateException::class)
    override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {
        try {
            defaultTrustManager!!.checkServerTrusted(chain, authType)
        } catch (ce: CertificateException) {
            localTrustManager.checkServerTrusted(chain, authType)
        }

    }


    override fun getAcceptedIssuers(): Array<X509Certificate> {
        return arrayOf()
    }
}
