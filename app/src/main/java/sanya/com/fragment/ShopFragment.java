package sanya.com.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import sanya.com.activity.ShopDetailActivity;
import sanya.com.sanya.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sep
 */
public class ShopFragment extends Fragment {

    private View view;
    private SlidingMenu menu;
    private ImageView btn_shop_menu;
    private ImageView btn_shop_back;
    private ImageView iv_shop_dian1,iv_shop_dian2;
    private ViewPager shop_vp;
    private TextView tv_shop_change;
    private ListView listview1,listview2;
    private View btn1,btn2;
    private List<ListView> list=new ArrayList<ListView>();
    private FragmentManager fm;
    private FragmentTransaction tran;
    private ShopFragment shopFragment;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.shop_fragment,null);
        menu = new SlidingMenu(getContext());
        menu.setMode(SlidingMenu.RIGHT);
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        menu.setFadeDegree(0.35f);
        menu.attachToActivity(getActivity(), SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
        menu.setMenu(R.layout.menu3);
        fm = getFragmentManager();
        shopFragment = Application.shopFragment;

        Config_beforego_thing.addAll();
        ImageView iv_back = (ImageView) view.findViewById(R.id.btn_shop_back);
        iv_back.setOnClickListener(new View.OnClickListener() {

            private Fragment_Guide guide;

            public void onClick(View view) {
                guide = new Fragment_Guide();
                tran = fm.beginTransaction();
                tran.remove(shopFragment);
                tran.replace(R.id.layout_total, guide);
                tran.commit();
                MainActivity.num = 0;
            }
        });

        btn1= menu.findViewById(R.id.arrive);
        btn2= menu.findViewById(R.id.loadtraffic);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shop_vp.setCurrentItem(0);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shop_vp.setCurrentItem(1);
            }
        });

        iv_shop_dian1= (ImageView) view.findViewById(R.id.shop_dian1);
        iv_shop_dian2= (ImageView) view.findViewById(R.id.shop_dian2);

        tv_shop_change= (TextView) view.findViewById(R.id.tv_shop_change);
        btn_shop_menu= (ImageView)view. findViewById(R.id.btn_shop_menu);
        btn_shop_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menu.showMenu();
            }
        });


        shop_vp= (ViewPager) view.findViewById(R.id.vp_shop);

        listview1= (ListView) LayoutInflater.from(getContext()).inflate(R.layout.viewpager1,null).findViewById(R.id.listview1);
        listview2= (ListView) LayoutInflater.from(getContext()).inflate(R.layout.viewpager2,null).findViewById(R.id.listview2);

        list.add(listview1);
        list.add(listview2);

        Mybaseadaper1 adapter1=new Mybaseadaper1();

        Mybaseadaper2 adapter2=new Mybaseadaper2();
        listview1.setAdapter(adapter1);
        listview2.setAdapter(adapter2);
        listview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), ShopDetailActivity.class);
                intent.putExtra("key", i);
                startActivity(intent);
            }
        });
        MyPagerAdapter adapte=new MyPagerAdapter();
        shop_vp.setAdapter(adapte);

        shop_vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (position == 0) {
                    iv_shop_dian1.setImageResource(R.mipmap.ic_dian_focused);
                    iv_shop_dian2.setImageResource(R.mipmap.ic_dian_normal);
                    tv_shop_change.setText("当地特产");
                } else {
                    iv_shop_dian1.setImageResource(R.mipmap.ic_dian_normal);
                    iv_shop_dian2.setImageResource(R.mipmap.ic_dian_focused);
                    tv_shop_change.setText("购物店推荐");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return view;
    }
    class Mybaseadaper1 extends BaseAdapter
    {

        Viewhold vh;
        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        class Viewhold
        {
            TextView title;
            TextView body;
            ImageView iv;
            ImageView iv_ic;
        }

        @Override
        public View getView(int position, View convertview, ViewGroup viewGroup) {
            if (convertview==null)
            {
                vh=new Viewhold();
                convertview= LayoutInflater.from(getContext()).inflate(R.layout.shop_item1,null);
                vh.title= (TextView) convertview.findViewById(R.id.title1);
                vh.body= (TextView) convertview.findViewById(R.id.body1);
                vh.iv= (ImageView) convertview.findViewById(R.id.iv_shop);
                vh.iv_ic= (ImageView) convertview.findViewById(R.id.iv_wenhao);
                convertview.setTag(vh);
            }
            else
            {
                vh= (Viewhold) convertview.getTag();
            }
            vh.iv_ic.setImageResource(R.mipmap.ic_ms);
            vh.title.setText(Config_shop_load.totalTitle[position]);
            vh.body.setText(Config_shop_load.totalBody[position]);
            vh.iv.setImageResource(Config_shop_load.totalImage[position]);
            return convertview;
        }
    }


    class Mybaseadaper2 extends BaseAdapter
    {

        Viewhold vh;
        @Override
        public int getCount() {
            return 6;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        class Viewhold
        {
            TextView title;
            TextView body;
            ImageView iv;
        }

        @Override
        public View getView(int position, View convertview, ViewGroup viewGroup) {
            if (convertview==null)
            {
                vh=new Viewhold();
                convertview= LayoutInflater.from(getContext()).inflate(R.layout.shop_item1,null);
                vh.title= (TextView) convertview.findViewById(R.id.title1);
                vh.body= (TextView) convertview.findViewById(R.id.body1);
                vh.iv= (ImageView) convertview.findViewById(R.id.iv_shop);


                convertview.setTag(vh);
            }
            else
            {
                vh= (Viewhold) convertview.getTag();
            }

            vh.title.setText(Config_shop_shop.totalTitle[position]);
            vh.body.setText(Config_shop_shop.totalBody[position]);
            vh.iv.setImageResource(Config_shop_shop.totalImage[position]);

            return convertview;
        }
    }

    class MyPagerAdapter extends PagerAdapter {


        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(list.get(position));
            return list.get(position);
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(list.get(position));
        }
    }

}

