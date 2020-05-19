package com.wd.health.utils

import android.app.Application
import android.content.Context

/**
 * @author 袁晨冉
 * Class :1708A
 * @description:
 * @date :2020/5/18 20:26
 * @classname :全局App类
 */
  class App : Application() {
    lateinit var context:Context
    override fun onCreate() {
        super.onCreate()
        context=this;
    }


}