package com.wd.health.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.wd.health.R
import com.wd.health.adapter.HomePageAdapter
import com.wd.health.base.BaseActivity
import com.wd.health.ui.fragment.FnformationFragment
import com.wd.health.ui.fragment.KnowledgeFragment
import com.wd.health.ui.fragment.SearchFragmet
import kotlinx.android.synthetic.main.activity_home_page.*

class HomePageActivity : BaseActivity() {
    override fun initData() {
        var myList=ArrayList<Fragment>()
        var fnformationFragment=FnformationFragment()
        var knowledgeFragment=KnowledgeFragment()
        var searchFragmet=SearchFragmet()
        myList.add(fnformationFragment)
        myList.add(knowledgeFragment)
        myList.add(searchFragmet)
        var homePageAdapter=HomePageAdapter(myList,supportFragmentManager)
        home_page_vp.adapter=homePageAdapter
        home_page_vp.setCurrentItem(1)
        home_page_tab.setupWithViewPager(home_page_vp)

    }

    override fun initListener() {
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_home_page
    }


}
