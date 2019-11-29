package com.workbook.liuwb.mylibrary.retrofits.hostnameverifier

import android.net.Uri

import javax.net.ssl.HostnameVerifier
import javax.net.ssl.HttpsURLConnection
import javax.net.ssl.SSLSession

class SafeHostnameVerifier(private val hostName: String) : HostnameVerifier {

    override fun verify(hostname: String, session: SSLSession): Boolean {
        val hv = HttpsURLConnection.getDefaultHostnameVerifier()
        val uri = Uri.parse(hostName)
        return hv.verify(uri.host, session)
    }
}
