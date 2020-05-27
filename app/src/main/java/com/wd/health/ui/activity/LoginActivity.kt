package com.wd.health.ui.activity

import android.content.Intent
import android.util.Log
import com.wd.health.R
import com.wd.health.base.BaseActivity
import com.wd.health.bean.LogBean
import com.wd.health.net.RetrofitUtil
import com.wd.health.utils.RsaCoder
import com.wd.health.utils.SpUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_loglin.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.toast


/**ClassName: Health
 * @author 作者 : Quzijun
 * @version 创建时间：2020/5/21 20:26
 * @Description: 用途：完成特定功能
 */
class LoginActivity : BaseActivity(),AnkoLogger {


    override fun initData() {

    }

    override fun initListener() {
        logactivity_log.setOnClickListener {
            val name = logactivity_name.text.toString().trim()
            val pwd = logactivity_pwd.text.toString().trim()

            try {
                val s = RsaCoder.encryptByPublicKey(pwd)
                Log.d("11ss","1"+s)
                val util = RetrofitUtil.getUtil()
                val createService = util.createService()
                createService?.let {
                    val onLog = it.onLog(name, s)
                    onLog?.subscribeOn(Schedulers.io())
                        ?.observeOn(AndroidSchedulers.mainThread())
                        ?.subscribe(object : DisposableObserver<LogBean>(){
                            override fun onComplete() {

                            }

                            override fun onNext(t: LogBean) {
                                val message = t.message
                                val result = t.result
                                val id = result.id
                                val sessionId = result.sessionId
                                val spUtil = SpUtil.getSpUtil()
                                spUtil.putInt("id",id)
                                spUtil.putString("sessionId",sessionId)
                                Log.d("XXX",message)
                                if (message.equals("登录成功")){
                                    toast("登录成功")
                                    startActivity(
                                        Intent(
                                            this@LoginActivity, HomePageActivity::class.java
                                        )
                                    )
                                    finish()
                                }else{
                                    toast("登录失败")
                                }
                            }

                            override fun onError(e: Throwable) {
                                println(e?.message)
                            }
                        })
                }
//                val creat = NetManager.netManager.creat(ApiService::class.java)
//                val onLog = creat.onLog(name, s)
//                onLog?.subscribeOn(Schedulers.io())
//                    ?.observeOn(AndroidSchedulers.mainThread())
//                    ?.subscribe(object : DisposableObserver<LogBean>(){
//                        override fun onComplete() {
//
//                        }
//
//                        override fun onNext(t: LogBean) {
//                            println(t.toString())
//                            val result = t.result
//                            val message = t.message
//                            Log.d("ssss","1"+message)
//                            Log.d("ssss","1")
//                            if (message.equals("登录成功")){
//                                toast("登录成功")
//                            }else{
//                                toast("登录失败")
//                            }
//                        }
//
//                        override fun onError(e: Throwable) {
//
//                        }
//
//                    })

            }catch (e:Exception){
                e.printStackTrace()
            }
        }
        logactivity_wj.setOnClickListener {  }
        logactivity_reg.setOnClickListener {
            startActivity(
                Intent(
                    this@LoginActivity, RegActivty::class.java
                )
            )
            finish()
        }
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_loglin
    }
}
