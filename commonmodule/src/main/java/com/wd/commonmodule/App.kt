package com.wd.commonmodule

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

/**
 * @author 袁晨冉
 * Class :1708A
 * @description:
 * @date :2020/5/21 14:56
 * @classname :全局Application
 */
class App: Application(){

    override fun onCreate() {
        super.onCreate()
        ARouter.openDebug()
        ARouter.openDebug()
        ARouter.init(this)
    }
}