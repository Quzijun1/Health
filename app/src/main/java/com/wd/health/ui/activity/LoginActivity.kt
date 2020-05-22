package com.wd.health.ui.activity

import android.util.Log
import com.wd.health.R
import com.wd.health.base.BaseActivity
import com.wd.health.utils.RsaCoder
import kotlinx.android.synthetic.main.activity_loglin.*
import java.lang.Exception


/**ClassName: Health
 * @author 作者 : Quzijun
 * @version 创建时间：2020/5/21 20:26
 * @Description: 用途：完成特定功能
 */
class LoginActivity : BaseActivity() {


    override fun initData() {
        val name = logactivity_name.text.toString()
        val pwd = logactivity_pwd.text.toString()
        try {
            val s = RsaCoder.encryptByPublicKey("qzj123456")
            Log.d("11ss",""+s)
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    override fun initListener() {

    }

    override fun getLayoutId(): Int {
        return R.layout.activity_loglin
    }
}