package com.workbook.liuwb.mylibrary.retrofits.hostnameverifier

import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLSession

class UnsafeHostnameVerifier : HostnameVerifier {
    override fun verify(hostname: String, session: SSLSession): Boolean {
        return true
    }
}
