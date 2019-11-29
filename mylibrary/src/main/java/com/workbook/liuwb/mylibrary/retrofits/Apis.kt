package com.workbook.liuwb.mylibrary.retrofits

import com.workbook.liuwb.mylibrary.retrofits.model.searchdemo.HubBean
import com.workbook.liuwb.mylibrary.retrofits.model.searchdemo.SearchBean
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.*

interface Apis {

    @GET("article/list/{index}/json/")
    fun getToday(@Path("index") index: String): Call<String>

    @GET("article/list/{index}/json/")
    fun getToday1(@Path("index") index: String): Observable<String>

    @FormUrlEncoded
    @POST("article/query/{page}/json")
    fun searchDatas(@Field("k") key: String, @Path("page") index: String): Call<SearchBean>

    @FormUrlEncoded
    @POST("article/query/{page}/json")
    fun searchDatas1(@Field("k") key: String, @Path("page") index: String): Observable<SearchBean>

    @GET("users/basil2style")
    fun getGithub(): Observable<HubBean>

    /*
     @GET("word/word")
     @Headers("apikey:81bf9da930c7f9825a3c3383f1d8d766")
     Call<ResponseBody> getNews(@Query("num") String num, @Query("page") String page);

     @GET("word/word")
     Call<ResponseBody> getNewsDyna(@Header("apikey") String apikey, @Query("num") String num, @Query("page") String page);

     @FormUrlEncoded
     @POST("word/word")
     Call<ResponseBody> postData(@Field("id") String id, @Field("name") String name);

     @HTTP(method = "GET", path = "word/{id}", hasBody = false)
     Call<ResponseBody> httpGET(@Path("id") String id);

     @HTTP(method = "POST", path = "word/word", hasBody = true)
     Call<ResponseBody> httpPOST(@Body SearchBean news);
     */

}
