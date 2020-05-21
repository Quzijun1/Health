package com.wd.health.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wd.health.R
import com.wd.phone.base.BaseActivity

class MainActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }

    override fun initData() {

    }

    override fun initListener() {
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }
}
