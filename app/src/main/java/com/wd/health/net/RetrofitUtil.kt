package com.wd.health.net

import android.text.TextUtils
import com.wd.health.net.ApiService
import com.wd.health.utils.SpUtil
import okhttp3.Interceptor
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**ClassName: Doctor
 * @author 作者 : GuoJinYi
 * @version 创建时间：2020/5/18 0018 14:54
 * @Description: 用途：完成特定功能
 */
class RetrofitUtil {

    private var retrofit:Retrofit? = null


    private constructor(){
        //初始化okhttp
        var okHttpClient = OkHttpClient.Builder()
            .connectTimeout(5000,TimeUnit.SECONDS)
            .readTimeout(5000,TimeUnit.SECONDS)
            .writeTimeout(5000,TimeUnit.SECONDS)
            .addInterceptor(object :Interceptor{
                override fun intercept(chain: Interceptor.Chain): Response {
                    val request = chain.request()
                    val newBuilder = request.newBuilder()
                    val spUtil = SpUtil.getSpUtil()
                    val int1 = spUtil.getInt("id")
                    val string = spUtil.getString("sessionId")
                    newBuilder.addHeader("userId", int1.toString())
                    newBuilder.addHeader("sessionId", string.toString())
                    val newRequest = newBuilder.build()
                    return chain.proceed(newRequest)
                }

            })
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

        //初始化retrofit
        retrofit = Retrofit.Builder()
            .baseUrl(ApiUrl.BASE_URL)//网络路径
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) //Rxjava异步任务库
            .addConverterFactory(GsonConverterFactory.create()) //解析
            .build()
    }

    companion object{
        private var instance:RetrofitUtil? = null
        get() {
            if(field == null){
                field = RetrofitUtil()
            }
            return field
        }
        public fun getUtil():RetrofitUtil{
            return instance!!
        }
    }

    fun createService(): ApiService? {

        return retrofit?.create(ApiService::class.java)
    }

}