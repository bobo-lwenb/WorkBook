package com.workbook.liuwb.mylibrary.retrofits.converter

import com.google.gson.Gson
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

class MyGsonConverterFactory : Converter.Factory() {
    override fun responseBodyConverter(type: Type?, annotations: Array<Annotation>?, retrofit: Retrofit?): Converter<ResponseBody, *>? {
        return Converter<ResponseBody, Type> { value ->
            val result = value.string()
            Gson().fromJson<Type>(result, type)
        }
    }

    override fun requestBodyConverter(type: Type?, parameterAnnotations: Array<Annotation>?, methodAnnotations: Array<Annotation>?, retrofit: Retrofit?): Converter<*, RequestBody>? {
        return Converter<Type, RequestBody> { value ->
            val string = Gson().toJson(value)
            RequestBody.create("application/json; charset=UTF-8".toMediaTypeOrNull(), string)
        }
    }

    companion object {
        fun create(): MyGsonConverterFactory {
            return MyGsonConverterFactory()
        }
    }
}
