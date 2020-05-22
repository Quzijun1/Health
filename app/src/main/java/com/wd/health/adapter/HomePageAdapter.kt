package com.wd.health.adapter

import android.os.Parcel
import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.wd.health.R
import kotlinx.android.synthetic.main.activity_home_page.view.*

/**
 * @author 袁晨冉
 * Class :1708A
 * @description:
 * @date :2020/5/22 19:07
 * @classname :首页框架适配器
 */
class HomePageAdapter(var mList : List<Fragment>, fm: FragmentManager?) : FragmentStatePagerAdapter(fm!!) {
    override fun getItem(position: Int): Fragment {
       return mList.get(position)
    }

    override fun getCount(): Int {
        return mList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when(position){
            0-> return "知识库"
            1-> return "资讯"
            2-> return "搜索"
            else-> return ""
        }
    }
    }




