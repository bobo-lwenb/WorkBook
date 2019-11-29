package com.workbook.liuwb.mylibrary.retrofits.converter

import com.workbook.liuwb.mylibrary.utils.Logger
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

class StringConverterFactory : Converter.Factory() {

    override fun responseBodyConverter(type: Type?, annotations: Array<Annotation>?, retrofit: Retrofit?): Converter<ResponseBody, String>? {
        return Converter { value ->
            Logger.e("responseBodyConverter ====》》")
            value.string()
        }
    }

    override fun requestBodyConverter(type: Type?, parameterAnnotations: Array<Annotation>?, methodAnnotations: Array<Annotation>?, retrofit: Retrofit?): Converter<String, RequestBody>? {
        return Converter { value ->
            Logger.e("requestBodyConverter ====》》")
            RequestBody.create("application/json; charset=UTF-8".toMediaTypeOrNull(), value)
        }
    }

    companion object {

        fun create(): StringConverterFactory {
            return StringConverterFactory()
        }
    }
}
