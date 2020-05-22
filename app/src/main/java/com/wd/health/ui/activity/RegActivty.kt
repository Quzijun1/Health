package com.wd.health.ui.activity

import android.util.Log
import com.wd.health.R
import com.wd.health.base.BaseActivity
import com.wd.health.utils.RsaCoder
import kotlinx.android.synthetic.main.activity_loglin.*
import kotlinx.android.synthetic.main.activity_regview.*

/**ClassName: Health
 * @author 作者 : Quzijun
 * @version 创建时间：2020/5/22 19:44
 * @Description: 用途：完成特定功能
 */
class RegActivty : BaseActivity() {
    override fun initData() {

    }

    override fun initListener() {
        regactivity_reg.setOnClickListener {
            val name = regactivity_name.text.toString()
            val pwd = regactivity_pwd.text.toString()
            val pwd2 = regactivity_pwd2.text.toString()
            try {
                val s = RsaCoder.encryptByPublicKey(pwd)
                val ss = RsaCoder.encryptByPublicKey(pwd2)

                Log.d("11ss",""+s)
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_regview
    }
}