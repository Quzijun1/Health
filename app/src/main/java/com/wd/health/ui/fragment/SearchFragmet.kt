package com.wd.health.ui.fragment

import android.view.LayoutInflater
import android.view.View
import com.wd.health.R
import com.wd.health.base.BaseFragment

/**
 * @author 袁晨冉
 * Class :1708A
 * @description:
 * @date :2020/5/22 20:16
 * @classname :搜索
 */
class SearchFragmet : BaseFragment() {
    override fun initView(): View? {
       return LayoutInflater.from(context).inflate(R.layout.fragment_search,null,false)
    }

    override fun initData() {
    }

    override fun initListener() {
    }
}