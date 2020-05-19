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
class SpUtil<T>(val name: String,val default:T) {
    val prefs: SharedPreferences by lazy {
        App.instance().getSharedPreferences("SP", Context.MODE_PRIVATE) }

    operator fun getValue(
        thisRef: Any?, property: KProperty<*>
    ): T = getSharedPreferences(name, default)

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) = putSharedPreferences(name, value)

    private fun putSharedPreferences(name: String, value: T) = with(prefs.edit()) {
        when(value) {
            is Int -> putInt(name, value)
            is Float -> putFloat(name, value)
            is Long -> putLong(name, value)
            is Boolean -> putBoolean(name, value)
            is String -> putString(name, value)
            else -> throw IllegalArgumentException("SharedPreference can't be save this type")
        }.apply()
    }

    private fun getSharedPreferences(name:String, default: T): T = with(prefs) {
        val res: Any = when(default) {
            is Int -> getInt(name, default)
            is Float -> getFloat(name, default)
            is Long -> getLong(name, default)
            is Boolean -> getBoolean(name, default)
            is String -> getString(name, default).toString()
            else -> throw IllegalArgumentException("SharedPreference can't be get this type")
        }
        return res as T
    }
    object DelegatesExt {
        fun <T> spUtil(name: String, default: T) = SpUtil(name, default)
    }
}


