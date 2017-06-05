package sanya.com.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import sanya.com.sanya.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sep
 */
public class TrafficFragment extends Fragment{

    private View view;
    private SlidingMenu menu;
    private ImageView btn_traffic_menu;
    private ImageView btn_traffic_back;
    private ImageView iv_traffic_dian1,iv_traffic_dian2;
    private ViewPager traffic_vp;
    private TextView tv_traffic_change;
    private ListView listview1,listview2;
    private View btn1,btn2;
    private List<ListView> list=new ArrayList<ListView>();
    private TrafficFragment trafficFragment;
    private FragmentManager fm;
    private FragmentTransaction tran;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.traffic_fragment,null);
        menu = new SlidingMenu(getActivity());
        menu.setMode(SlidingMenu.RIGHT);
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        menu.setFadeDegree(0.35f);
        menu.attachToActivity(getActivity(), SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
        menu.setMenu(R.layout.menu2);

        fm = getFragmentManager();
        trafficFragment = Application.trafficFragment;

        Config_beforego_thing.addAll();
        ImageView iv_back = (ImageView) view.findViewById(R.id.btn_traffic_back);
        iv_back.setOnClickListener(new View.OnClickListener() {

            private Fragment_Guide guide;

            public void onClick(View view) {
                guide = new Fragment_Guide();
                tran = fm.beginTransaction();
                tran.remove(trafficFragment);
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
                traffic_vp.setCurrentItem(0);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                traffic_vp.setCurrentItem(1);
            }
        });

        iv_traffic_dian1= (ImageView) view.findViewById(R.id.traffic_dian1);
        iv_traffic_dian2= (ImageView)  view.findViewById(R.id.traffic_dian2);

        tv_traffic_change= (TextView)  view.findViewById(R.id.tv_traffic_change);
        btn_traffic_menu= (ImageView)  view.findViewById(R.id.btn_traffic_menu);
        btn_traffic_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menu.showMenu();
            }
        });


        traffic_vp= (ViewPager)  view.findViewById(R.id.vp_traffic);

        listview1= (ListView) LayoutInflater.from(getActivity()).inflate(R.layout.viewpager1,null).findViewById(R.id.listview1);
        listview2= (ListView) LayoutInflater.from(getActivity()).inflate(R.layout.viewpager2,null).findViewById(R.id.listview2);

        list.add(listview1);
        list.add(listview2);

        Mybaseadaper1 adapter1=new Mybaseadaper1();

        Mybaseadaper2 adapter2=new Mybaseadaper2();
        listview1.setAdapter(adapter1);
        listview2.setAdapter(adapter2);
        MyPagerAdapter adapte=new MyPagerAdapter();
        traffic_vp.setAdapter(adapte);

        traffic_vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (position == 0) {
                    iv_traffic_dian1.setImageResource(R.mipmap.ic_dian_focused);
                    iv_traffic_dian2.setImageResource(R.mipmap.ic_dian_normal);
                    tv_traffic_change.setText("到达与离开");
                } else {
                    iv_traffic_dian1.setImageResource(R.mipmap.ic_dian_normal);
                    iv_traffic_dian2.setImageResource(R.mipmap.ic_dian_focused);
                    tv_traffic_change.setText("当地交通");
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
        }

        @Override
        public View getView(int position, View convertview, ViewGroup viewGroup) {
            if (convertview==null)
            {
                vh=new Viewhold();
                convertview= LayoutInflater.from(getActivity()).inflate(R.layout.traffic_item1,null);
                vh.title= (TextView) convertview.findViewById(R.id.title1);
                vh.body= (TextView) convertview.findViewById(R.id.body1);


                convertview.setTag(vh);
            }
            else
            {
                vh= (Viewhold) convertview.getTag();
            }

            vh.title.setText(Config_Traffic_arrive.totalTitle[position]);
            vh.body.setText(Config_Traffic_arrive.totalBody[position]);

            return convertview;
        }
    }


    class Mybaseadaper2 extends BaseAdapter
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
        }

        @Override
        public View getView(int position, View convertview, ViewGroup viewGroup) {
            if (convertview==null)
            {
                vh=new Viewhold();
                convertview= LayoutInflater.from(getActivity()).inflate(R.layout.traffic_item1,null);
                vh.title= (TextView) convertview.findViewById(R.id.title1);
                vh.body= (TextView) convertview.findViewById(R.id.body1);


                convertview.setTag(vh);
            }
            else
            {
                vh= (Viewhold) convertview.getTag();
            }

            vh.title.setText(Config_Traffic_load.totalTitle[position]);
            vh.body.setText(Config_Traffic_load.totalBody[position]);

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

