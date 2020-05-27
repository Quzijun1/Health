package com.wd.health.ui.activity

import android.content.Intent
import android.util.Log
import com.wd.health.R
import com.wd.health.base.BaseActivity
import com.wd.health.bean.LogBean
import com.wd.health.net.RetrofitUtil
import com.wd.health.utils.RsaCoder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_loglin.*
import kotlinx.android.synthetic.main.activity_regview.*
import org.jetbrains.anko.toast

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
            val name = regactivity_name.text.toString().trim()
            val pwd = regactivity_pwd.text.toString().trim()
            val pwd2 = regactivity_pwd2.text.toString().trim()
            val yzm = regactivity_yzm.text.toString().trim()
            val yqm = regactivity_yqm.text.toString().trim()

            try {
                val s = RsaCoder.encryptByPublicKey(pwd)
                val ss = RsaCoder.encryptByPublicKey(pwd2)
                val util = RetrofitUtil.getUtil()
                val createService = util.createService()
                createService?.let {
                    val onLog = it.onReg(name,yzm, s,ss,yqm)
                    onLog?.subscribeOn(Schedulers.io())
                        ?.observeOn(AndroidSchedulers.mainThread())
                        ?.subscribe(object : DisposableObserver<LogBean>(){
                            override fun onComplete() {

                            }

                            override fun onNext(t: LogBean) {
                                val message = t.message
                                Log.d("XXX",message)
                                if (message.equals("注册成功")){
                                    toast("注册成功")
                                    startActivity(
                                        Intent(
                                            this@RegActivty, LoginActivity::class.java
                                        )
                                    )
                                    finish()
                                }else{
                                    toast("注册失败")
                                }
                            }

                            override fun onError(e: Throwable) {
                                println(e?.message)
                            }
                        })
                }
                Log.d("11ss",""+s)
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
        regactivity_yz.setOnClickListener {
            val name = regactivity_name.text.toString().trim()
            val util = RetrofitUtil.getUtil()
            val createService = util.createService()
            createService?.let {
                val onLog = it.onSend(name)
                onLog?.subscribeOn(Schedulers.io())
                    ?.observeOn(AndroidSchedulers.mainThread())
                    ?.subscribe(object : DisposableObserver<LogBean>(){
                        override fun onComplete() {

                        }

                        override fun onNext(t: LogBean) {
                            val message = t.message
                            Log.d("XXX",message)
                            if (message.equals("发送成功")){
                                toast("发送成功")
                            }else{
                                toast("发送失败")
                            }
                        }

                        override fun onError(e: Throwable) {
                            println(e?.message)
                        }
                    })
            }
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_regview
    }
}