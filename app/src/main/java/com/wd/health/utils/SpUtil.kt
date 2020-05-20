package com.wd.health.utils

import android.content.Context
import android.content.SharedPreferences
import kotlin.reflect.KProperty

/**
 * @author 袁晨冉
 * Class :1708A
 * @description:
 * @date :2020/5/18 20:13
 * @classname :sendPrefens工具类
 */
class SpUtil {
    val sharedPrefanaces: SharedPreferences by lazy {
        App.instance().getSharedPreferences("SP", Context.MODE_PRIVATE) }
    val edit=sharedPrefanaces.edit();

    companion object{
        private var instance:SpUtil? = null
            get() {
                if(field == null){
                    field = SpUtil()
                }
                return field
            }
        fun getSpUtil():SpUtil{
            return instance!!
        }
    }

    //存储
    fun putString(key:String,value:String){
        edit.putString(key,value)
        edit.commit()
    }
    fun putInt(key:String,value:Int){
        edit.putInt(key,value)
        edit.commit()
    }

    //取出
    fun getString(key:String): String? {
        val str = sharedPrefanaces.getString(key, null)
        return str
    }
    fun getInt(key:String): Int? {
        val int = sharedPrefanaces.getInt(key, -1)
        return int
    }
}


