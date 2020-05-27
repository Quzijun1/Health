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
    //注册接口
    @POST(ApiUrl.REG_URL)
    @FormUrlEncoded
    fun onReg(@Field("email") email: String?,@Field("code") code: String?,@Field("pwd1") pwd1: String?,@Field("pwd2") pwd2: String?,@Field("invitationCode") invitationCode: String?): Observable<LogBean>?
    //发送验证码接口
    @POST(ApiUrl.SENDOUTEMAILCODE_URL)
    @FormUrlEncoded
    fun onSend(@Field("email") email: String?): Observable<LogBean>?
}