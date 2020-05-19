package com.wd.health.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.wd.health.R
import java.math.RoundingMode

/**
 * @author 袁晨冉
 * Class :1708A
 * @description:
 * @date :2020/5/19 19:39
 * @classname :图片加载工具类
 */
class ImageUtil private constructor(){
    companion object{
        var instant:ImageUtil?=null
        get() {
            if (field==null){
                field= ImageUtil()
            }
            return field
        }
        private set
    }
    fun getPhone(path:String,imageView:ImageView){
      Glide.with(App.context!!)
          .load(path)
          .apply(RequestOptions.bitmapTransform(RoundedCorners(25)))
          .error(R.mipmap.id_card)
          .placeholder(R.mipmap.ic_launcher_round)
          .into(imageView)
    }

}