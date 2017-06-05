package sanya.com.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;
import sanya.com.adapter.ImagePagerAdapter;
import sanya.com.sanya.MainActivity;
import sanya.com.sanya.R;

import java.util.ArrayList;
import java.util.List;

public class WelcomeActivity extends Activity {

    private AutoScrollViewPager mViewPager;
    //存储ImageView集合
    private List<ImageView> viewList = new ArrayList<ImageView>();
    //图片的资源地址
    private int[] img_id = {R.mipmap.mainpic1, R.mipmap.mainpic2, R.mipmap.mainpic3, R.mipmap.mainpic4, R.mipmap.mainpic5, R.mipmap.mainpic6};
    //存放圆点View
    private ImageView imgRes[];
    //风景标题
    private TextView mTitleTextView;
    //风景概要
    private TextView mContentTextView;
    //风景描述资源
    private int titles[] = {R.string.first_title, R.string.second_title, R.string.third_title, R.string.fourth_title, R.string.fifth_title, R.string.sixth_title};
    private int contents[] = {R.string.first_content, R.string.second_content, R.string.third_content, R.string.fourth_content, R.string.fifth_content, R.string.sixth_content};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        mTitleTextView = (TextView) findViewById(R.id.tv_title);
        mContentTextView = (TextView) findViewById(R.id.tv_content);
        //初始化ViewPager
        mViewPager = (AutoScrollViewPager) findViewById(R.id.viewPager);
        //初始化数据源
        initData();
        ImagePagerAdapter adapter = new ImagePagerAdapter(viewList);
        //处理底部图标
        initBottomIcon();
        //绑定适配器
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(Integer.MAX_VALUE/2-Integer.MAX_VALUE/2%6);
        //启动ViewPager自动滚动
        mViewPager.startAutoScroll();
        //设置ViewPager自动滚动的间隔时间
        mViewPager.setInterval(4500);
        //设置手指触碰时是否停止自动滚动
        mViewPager.setStopScrollWhenTouch(false);
        // 设置循环滚动时滑动到从边缘滚动到下一个是否需要动画，默认为true
        mViewPager.setBorderAnimation(false);
        //设置ViewPager的监听动作
        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < imgRes.length; i++) {
                    imgRes[i].setEnabled(true);
                }
                imgRes[position%6].setEnabled(false);
                mTitleTextView.setText(titles[position%6]);
                mContentTextView.setText(contents[position%6]);
            }

            @Override
            public void onPageScrolled(int position, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /**
     * 加载导航图标,处理底部图标
     */
    private void initBottomIcon() {
        LinearLayout layout = (LinearLayout) findViewById(R.id.linearlayout);
        imgRes = new ImageView[6];
        //设置所有的导航图标可用
        for (int i = 0; i < imgRes.length; i++) {
            imgRes[i] = (ImageView) layout.getChildAt(i);
            imgRes[i].setEnabled(true);
        }
        //默认第一个图标不可用
        imgRes[0].setEnabled(false);
    }

    /**
     * 初始化数据源
     */
    private void initData() {
        for (int i = 0; i < img_id.length; i++) {
            ImageView img = new ImageView(this);
            img.setScaleType(ImageView.ScaleType.FIT_XY);
            img.setImageResource(img_id[i]);
            img.setClickable(true);
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            });
            viewList.add(img);
        }
    }

    //点击监听动作
    public void go(View view) {
        SharedPreferences sf  = getSharedPreferences("user", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sf.edit();
        editor.putBoolean("flag", true);
        editor.commit();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        // 停止自动滚动
        mViewPager.stopAutoScroll();
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 开启自动滚动
        mViewPager.startAutoScroll();
    }
}