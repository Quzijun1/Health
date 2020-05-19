package com.wd.health

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wd.health.utils.SpUtil

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //
        //
       var  keyname=SpUtil.DelegatesExt.spUtil("keyname","")

    }
}
