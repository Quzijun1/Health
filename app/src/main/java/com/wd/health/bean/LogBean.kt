package com.wd.health.bean

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

/**ClassName: Health
 * @author 作者 : Quzijun
 * @version 创建时间：2020/5/22 22:36
 * @Description: 用途：完成特定功能
 */
data class LogBean(
    var result: LogResultBean,
    var message: String,
    var status: String
):Serializable{
    class LogResultBean(
        var age:Int,
        var email:String,
        var headPic: String,
        var height: Int,
        var id: Int,
        var jiGuangPwd: String,
        var nickName: String,
        var sessionId: String,
        var sex: Int,
        var userName: String,
        var weight: Int,
        var whetherBingWeChat: Int
    )
}