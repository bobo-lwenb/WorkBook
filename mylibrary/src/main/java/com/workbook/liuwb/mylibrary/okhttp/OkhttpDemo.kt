package com.workbook.liuwb.mylibrary.okhttp

import android.util.Log
import okhttp3.*
import java.io.IOException

class OkhttpDemo {
    private fun createGet() {
        val client = OkHttpClient.Builder()
                .addInterceptor(InterceptorDemo().appInterceptor)
                .addNetworkInterceptor(InterceptorDemo().netWorkInterceptor)
                .cookieJar(CookieJar.NO_COOKIES)
                .build()

        val request: Request = Request.Builder()
                .url("https://github.com/hongyangAndroid")
                .get()
                .build()

        val call: Call = client.newCall(request)
        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
            }

            override fun onResponse(call: Call, response: Response) {
                val htmlStr: String = response.body!!.string()
            }
        })
    }
}

class InterceptorDemo {
    val appInterceptor: Interceptor = object : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val request: Request = chain.request()
            //———请求之前要做的事情————
            val url: HttpUrl = request.url
            val urlStr = url.toUrl()

            val response: Response = chain.proceed(request)
            //———请求之后要做事情————
            Log.d("aa", "app interceptor:begin")

            return response
        }
    }

    val netWorkInterceptor: Interceptor = object : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val request: Request = chain.request()
            //———请求之前要做的事情————
            val response: Response = chain.proceed(request)
            //———请求之后要做事情————
            return response
        }
    }
}
