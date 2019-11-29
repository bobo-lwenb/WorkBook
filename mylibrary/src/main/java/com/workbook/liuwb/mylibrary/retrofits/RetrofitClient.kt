package com.workbook.liuwb.mylibrary.retrofits

import android.content.Context
import com.workbook.liuwb.mylibrary.BuildConfig
import com.workbook.liuwb.mylibrary.retrofits.hostnameverifier.UnsafeHostnameVerifier
import com.workbook.liuwb.mylibrary.retrofits.interceptor.LoggingInterceptor
import com.workbook.liuwb.mylibrary.retrofits.model.searchdemo.HubBean
import com.workbook.liuwb.mylibrary.retrofits.model.searchdemo.SearchBean
import com.workbook.liuwb.mylibrary.utils.Logger
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient private constructor(context: Context) {

    companion object {
        private val retrofit: RetrofitClient? = null
        fun getInstance(context: Context): RetrofitClient {
            return retrofit ?: RetrofitClient(context)
        }
    }

    private val apis: Apis

    init {
        val loggingInterceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Logger.e("HttpLoggingInterceptor ====》》$message")
            }
        })
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val loggerInterceptor = LoggingInterceptor()

        val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .hostnameVerifier(UnsafeHostnameVerifier())
                .authenticator(object : Authenticator {
                    override fun authenticate(route: Route?, response: okhttp3.Response): Request? {
                        println("Authenticating for response: $response");
                        println("Challenges: " + response.challenges());
                        val credential: String = Credentials.basic("jesse", "password1");
                        return response.request.newBuilder()
                                .header("Authorization", credential)
                                .build()
                    }
                })
                .build()

        val retrofit = Retrofit.Builder()
                .client(okHttpClient)
//                .addConverterFactory(StringConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BuildConfig.baseUrl)
                .build()

        apis = retrofit.create(Apis::class.java)
    }

    fun getToday() {
        val call = apis.getToday("1")
        call.enqueue(object : Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {

            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                val string = "123"
            }
        })
    }

    fun getTheday() {
        apis.getToday1("1")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<String> {
                    override fun onComplete() {
                    }

                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onNext(t: String) {
                        val string = "123"
                    }

                    override fun onError(e: Throwable) {
                    }
                })
    }

    fun searchData() {
        val call = apis.searchDatas("hello world", "0")
        call.enqueue(object : Callback<SearchBean> {
            override fun onFailure(call: Call<SearchBean>, t: Throwable) {
            }

            override fun onResponse(call: Call<SearchBean>, response: Response<SearchBean>) {
                val bean: SearchBean? = response.body()
            }

        })
    }

    fun searchData1() {
        apis.searchDatas1("hello world", "0")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<SearchBean> {
                    override fun onComplete() {
                    }

                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onNext(t: SearchBean) {
                        val string = "123"
                    }

                    override fun onError(e: Throwable) {
                    }

                })
    }

    fun getGithub() {
        apis.getGithub()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<HubBean> {
                    override fun onComplete() {
                    }

                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onNext(t: HubBean) {
                        val string = "123"
                    }

                    override fun onError(e: Throwable) {
                    }

                })
    }

}