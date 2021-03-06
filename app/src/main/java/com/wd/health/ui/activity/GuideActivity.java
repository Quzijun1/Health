package com.wd.health.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.wd.health.R;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Health
 *
 * @author 作者 : Quzijun
 * @version 创建时间：2020/5/21 15:39
 * @Description: 用途：完成特定功能
 */
public class GuideActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager mViewPager;
    //容器
    private List<View> mList = new ArrayList<>();
    private View view1, view2, view3, view4,view5;
    //小圆点
    private ImageView point1, point2, point3, point4,point5;
    //跳过
    private Button btn_back;
    private Button ms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        initView();
    }

    //初始化View
    private void initView() {

        point1 = (ImageView) findViewById(R.id.point1);
        point2 = (ImageView) findViewById(R.id.point2);
        point3 = (ImageView) findViewById(R.id.point3);
        point4 = (ImageView) findViewById(R.id.point4);
        point5 = (ImageView) findViewById(R.id.point5);

        btn_back = (Button) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(this);
        //设置默认图片
        setPointImg(true, false, false, false,false);
        mViewPager = (ViewPager) findViewById(R.id.mViewPager);
        view1 = View.inflate(this, R.layout.pager_item_one, null);
        view2 = View.inflate(this, R.layout.pager_item_two, null);
        view3 = View.inflate(this, R.layout.pager_item_three, null);
        view4 = View.inflate(this, R.layout.pager_item_four, null);
        view5 = View.inflate(this, R.layout.pager_item_five, null);
        ms = view5.findViewById(R.id.ms);
        ms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GuideActivity.this, LoginActivity.class));
                finish();
            }
        });
        mList.add(view1);
        mList.add(view2);
        mList.add(view3);
        mList.add(view4);
        mList.add(view5);

        //设置适配器
        mViewPager.setAdapter(new GuideAdapter());

        //监听ViewPager滑动
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            //pager切换
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        setPointImg(true, false, false, false,false);
                        btn_back.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        setPointImg(false, true, false, false,false);
                        btn_back.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        setPointImg(false, false, true, false,false);
                        btn_back.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        setPointImg(false, false, false, true,false);
                        btn_back.setVisibility(View.VISIBLE);
                        break;
                    case 4:
                        setPointImg(false, false, false, false,true);
                        btn_back.setVisibility(View.GONE);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                break;
        }
    }

    class GuideAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ((ViewPager) container).addView(mList.get(position));
            return mList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ((ViewPager) container).removeView(mList.get(position));
            //super.destroyItem(container, position, object);
        }
    }

    //设置小圆点的选中效果
    private void setPointImg(boolean isCheck1, boolean isCheck2, boolean isCheck3, boolean isCheck4,boolean isCheck5) {
        if (isCheck1) {
            point1.setBackgroundResource(R.mipmap.wallet_icon);
        } else {
            point1.setBackgroundResource(R.mipmap.button);
        }

        if (isCheck2) {
            point2.setBackgroundResource(R.mipmap.wallet_icon);
        } else {
            point2.setBackgroundResource(R.mipmap.button);
        }

        if (isCheck3) {
            point3.setBackgroundResource(R.mipmap.wallet_icon);
        } else {
            point3.setBackgroundResource(R.mipmap.button);
        }

        if (isCheck4) {
            point4.setBackgroundResource(R.mipmap.wallet_icon);
        } else {
            point4.setBackgroundResource(R.mipmap.button);
        }
        if (isCheck5) {
            point5.setBackgroundResource(R.mipmap.wallet_icon);
        } else {
            point5.setBackgroundResource(R.mipmap.button);
        }
    }
}
