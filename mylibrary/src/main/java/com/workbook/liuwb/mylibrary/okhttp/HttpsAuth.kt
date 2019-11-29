package com.workbook.liuwb.mylibrary.okhttp

import android.content.Context
import okhttp3.OkHttpClient
import java.io.InputStream
import java.security.KeyStore
import java.security.cert.Certificate
import java.security.cert.CertificateFactory
import javax.net.ssl.*

class HttpsAuth {
    private fun danxiangAuth(context: Context) {
        // 获取证书输入流
        val ins: InputStream = context.assets.open("")
        // 将证书输入流生成证书对象
        val certificate: Certificate = CertificateFactory.getInstance("X.509").generateCertificate(ins)
        // 获取证书管理器
        val keyStore: KeyStore = KeyStore.getInstance(KeyStore.getDefaultType())
        // 删除系统默认证书
        keyStore.load(null)
        // 为证书管理器重新设置证书
        keyStore.setCertificateEntry("0", certificate)
        // 创建信任证书管理器工厂
        val trustManagerFactory: TrustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
        // 为工厂初始化要信任的证书
        trustManagerFactory.init(keyStore)
        // 通过工厂获取信任证书管理器列表
        val trustManager: Array<TrustManager> = trustManagerFactory.trustManagers
        // 获取SSL环境实例
        val sslContext: SSLContext = SSLContext.getInstance("TLS")
        // 初始化SSL环境实例
        sslContext.init(null, trustManager, null)

        val client = OkHttpClient.Builder()
                .sslSocketFactory(sslContext.socketFactory, trustManager[0] as X509TrustManager)
                .build()
    }

    private fun shuangxiangAuth(context: Context) {
        /** 管理服务端信任的证书 **/
        // 获取证书输入流
        val insCer: InputStream = context.assets.open("")

        // 将证书输入流生成证书对象
        val certificate: Certificate = CertificateFactory.getInstance("X.509").generateCertificate(insCer)
        // 获取证书管理器
        val keyStore: KeyStore = KeyStore.getInstance(KeyStore.getDefaultType())
        // 删除系统默认证书
        keyStore.load(null)
        // 为证书管理器重新设置证书
        keyStore.setCertificateEntry("0", certificate)

        // 创建信任证书管理器工厂
        val trustManagerFactory: TrustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
        // 为工厂初始化要信任的证书
        trustManagerFactory.init(keyStore)
        // 通过工厂获取信任证书管理器列表
        val trustManager: Array<TrustManager> = trustManagerFactory.trustManagers

        /** 管理本地进行身份验证的密钥 **/

        // 获取JKS密钥输入流
        val insJKS: InputStream = context.assets.open("")
        // 获取BKS类型的密钥管理器
        val clientKeyStore: KeyStore = KeyStore.getInstance("BKS")
        // 使用密钥输入流和密码初始化密钥管理器
        clientKeyStore.load(insJKS, "111111".toCharArray())
        // 获取密钥管理器工厂
        val keyManagerFactory: KeyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm())
        // 使用密钥管理器和密码和密码初始化密钥管理器工厂
        keyManagerFactory.init(clientKeyStore, "111111".toCharArray())
        // 通过工厂获取密钥列表
        val keyManager: Array<KeyManager> = keyManagerFactory.keyManagers

        /** 生成SSLContext **/

        // 获取SSL环境实例
        val sslContext: SSLContext = SSLContext.getInstance("TLS")
        // 初始化SSL环境实例
        sslContext.init(keyManager, trustManager, null)

        val client = OkHttpClient.Builder()
                .sslSocketFactory(sslContext.socketFactory, trustManager[0] as X509TrustManager)
                .build()
    }

}