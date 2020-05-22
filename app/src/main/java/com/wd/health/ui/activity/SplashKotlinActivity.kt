package com.wd.health.ui.activity;

import android.content.Intent
import android.view.View
import androidx.core.view.ViewCompat
import androidx.core.view.ViewPropertyAnimatorListener
import com.wd.health.R
import com.wd.health.base.BaseActivity
import com.wd.health.ui.activity.GuideActivity

import kotlinx.android.synthetic.main.activity_splash.*


/**
 * @description：  引导页
 * @author: 屈子俊
 * @date: 2020/5/18 16:14
 */
class SplashKotlinActivity : BaseActivity(), ViewPropertyAnimatorListener {

    override fun initData() {
   }

    override fun initListener() {
        //设置动画效果  及监听
        ViewCompat.animate(img).scaleX(1.0f).scaleY(1.0f).setListener(this).duration = 3000
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    //动画结束
    override fun onAnimationEnd(view: View?) {
        //进入主页面
//        startActivityAndFinish<MainKotlinActivity>()
        val intent = Intent()
        //获取intent对象
        intent.setClass(this,GuideActivity::class.java)
        // 获取class是使用::反射
        startActivity(intent)
        finish()

    }
  //动画取消
    override fun onAnimationCancel(view: View?) {

    }
   //动画开始
    override fun onAnimationStart(view: View?) {
   }


}