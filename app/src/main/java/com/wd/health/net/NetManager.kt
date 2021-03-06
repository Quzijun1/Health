package com.wd.doctor.net

import android.util.Log
import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.wd.health.net.ApiUrl

import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.io.IOException
import java.util.concurrent.TimeUnit

/**
 * @author 屈子俊
 * Class :1708A
 * @description:
 * @date :2020/5/18 19:52
 * @classname :NetManager
 * 网络工具类
 */
class NetManager private constructor(){
    val httpLoggingInterceptor by lazy { HttpLoggingInterceptor() }
    companion object{
        val netManager by lazy { NetManager() }
    }
    //发送网络请求   get
    private val okHttpClient by lazy {
        OkHttpClient.Builder()
            .connectTimeout(5,TimeUnit.SECONDS)
            .readTimeout(5,TimeUnit.SECONDS)
            .writeTimeout(5,TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()
    }
    val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(ApiUrl.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }
    //动态代理
    inline fun <reified T> creat(service: Class<T>): T{
        return  retrofit.create<T>()
    }
}