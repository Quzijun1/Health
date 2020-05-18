package com.wd.phone.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

/**ClassName: Phone
 * @author 作者 : Quzijun
 * @version 创建时间：2020/5/14 10:10
 * @Description: 用途：完成特定功能
 */
abstract class BaseActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initListener()
        initData()
    }

    abstract fun initData()

    abstract fun initListener()

    abstract fun getLayoutId(): Int
}