package sanya.com.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Administrator on 15-12-1.
 */
public class ImagePagerAdapter extends PagerAdapter {
    private List<ImageView> list;

    public ImagePagerAdapter(List<ImageView> list) {
        super();
        this.list = list;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    //判断下一个对象是否是一个View
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    //销毁
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(list.get(position%6));
    }

    //实例化View添加View到ViewGroup,并返回添加的View
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(list.get(position%6));
        return list.get(position%6);
    }
}
