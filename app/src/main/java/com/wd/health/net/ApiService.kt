package com.wd.health.net

import com.wd.health.bean.LogBean
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**ClassName: Health
 * @author 作者 : Quzijun
 * @version 创建时间：2020/5/22 22:29
 * @Description: 用途：完成特定功能
 */
interface ApiService {
    //登录接口
    @POST(ApiUrl.LOG_URL)
    @FormUrlEncoded
    fun onLog(@Field("email") email: String?,@Field("pwd") pwd: String?): Observable<LogBean>?
}