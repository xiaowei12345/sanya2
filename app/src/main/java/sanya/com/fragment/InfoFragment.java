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
import android.widget.*;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import sanya.com.sanya.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sep
 */
public class InfoFragment extends Fragment{

    private View view;
    private SlidingMenu menu;
    private ImageView btn_message_menu;
    private ImageView btn_message_back;
    private ImageView iv_message_dian1,iv_message_dian2,iv_message_dian3,iv_message_dian4;
    private ViewPager message_vp;
    private TextView tv_message_change;
    private ListView listview1,listview2,listview3,listview4;
    private View btn1,btn2,btn3,btn4;
    private List<ListView> list=new ArrayList<ListView>();
    private List<LinearLayout> viewlist=new ArrayList<>();
    private FragmentManager fm;
    private InfoFragment infoFragment;
    private FragmentTransaction tran;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.info_fragment,null);
        menu = new SlidingMenu(getActivity());
        menu.setMode(SlidingMenu.RIGHT);
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        menu.setFadeDegree(0.35f);
        menu.attachToActivity(getActivity(), SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
        menu.setMenu(R.layout.menu5);

        Config_beforego_thing.addAll();
        fm = getFragmentManager();
        infoFragment = Application.infoFragment;
        ImageView iv_back = (ImageView) view.findViewById(R.id.btn_message_back);
        iv_back.setOnClickListener(new View.OnClickListener() {

            private Fragment_Guide guide;

            public void onClick(View view) {
                guide = new Fragment_Guide();
                tran = fm.beginTransaction();
                tran.remove(infoFragment);
                tran.replace(R.id.layout_total, guide);
                tran.commit();
                MainActivity.num = 0;
            }
        });

        btn1= menu.findViewById(R.id.tip);
        btn2= menu.findViewById(R.id.special);
        btn3= menu.findViewById(R.id.city);
        btn4= menu.findViewById(R.id.culture);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message_vp.setCurrentItem(0);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message_vp.setCurrentItem(1);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message_vp.setCurrentItem(2);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message_vp.setCurrentItem(3);
            }
        });

        iv_message_dian1= (ImageView) view.findViewById(R.id.message_dian1);
        iv_message_dian2= (ImageView) view.findViewById(R.id.message_dian2);
        iv_message_dian3= (ImageView) view.findViewById(R.id.message_dian3);
        iv_message_dian4= (ImageView) view.findViewById(R.id.message_dian4);

        tv_message_change= (TextView) view.findViewById(R.id.tv_message_change);
        btn_message_menu= (ImageView) view.findViewById(R.id.btn_message_menu);
        btn_message_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menu.showMenu();
            }
        });


        message_vp= (ViewPager) view.findViewById(R.id.vp_message);

        listview1= (ListView) LayoutInflater.from(getActivity()).inflate(R.layout.viewpager1,null).findViewById(R.id.listview1);
        listview2= (ListView) LayoutInflater.from(getActivity()).inflate(R.layout.viewpager2,null).findViewById(R.id.listview2);
        listview3= (ListView) LayoutInflater.from(getActivity()).inflate(R.layout.viewpager3,null).findViewById(R.id.listview3);
        listview4= (ListView) LayoutInflater.from(getActivity()).inflate(R.layout.viewpager4,null).findViewById(R.id.listview4);


        ViewGroup viewGroup= (ViewGroup) listview1.getParent();
        viewGroup.removeAllViews();
        ViewGroup view1= (ViewGroup) listview2.getParent();
        view1.removeAllViews();
        ViewGroup view2= (ViewGroup) listview3.getParent();
        view2.removeAllViews();
        ViewGroup view3= (ViewGroup) listview4.getParent();
        view3.removeAllViews();


        list.add(listview1);
        list.add(listview2);
        list.add(listview3);
        list.add(listview4);

        Mybaseadaper1 adapter1=new Mybaseadaper1();

        Mybaseadaper2 adapter2=new Mybaseadaper2();

        Mybaseadaper3 adapter3=new Mybaseadaper3();

        Mybaseadaper4 adapter4=new Mybaseadaper4();

        listview1.setAdapter(adapter1);
        listview2.setAdapter(adapter2);
        listview3.setAdapter(adapter3);
        listview4.setAdapter(adapter4);

        MyPagerAdapter adapte=new MyPagerAdapter();
        message_vp.setAdapter(adapte);

        message_vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (position == 0) {
                    iv_message_dian1.setImageResource(R.mipmap.ic_dian_focused);
                    iv_message_dian2.setImageResource(R.mipmap.ic_dian_normal);
                    iv_message_dian3.setImageResource(R.mipmap.ic_dian_normal);
                    iv_message_dian4.setImageResource(R.mipmap.ic_dian_normal);
                    tv_message_change.setText("小贴士");
                } else
                if (position==1){
                    iv_message_dian1.setImageResource(R.mipmap.ic_dian_normal);
                    iv_message_dian2.setImageResource(R.mipmap.ic_dian_focused);
                    iv_message_dian3.setImageResource(R.mipmap.ic_dian_normal);
                    iv_message_dian4.setImageResource(R.mipmap.ic_dian_normal);
                    tv_message_change.setText("特色活动");
                }
                if (position == 2) {
                    iv_message_dian1.setImageResource(R.mipmap.ic_dian_normal);
                    iv_message_dian2.setImageResource(R.mipmap.ic_dian_normal);
                    iv_message_dian3.setImageResource(R.mipmap.ic_dian_focused);
                    iv_message_dian4.setImageResource(R.mipmap.ic_dian_normal);
                    tv_message_change.setText("城市概览");
                } else
                if (position==3){
                    iv_message_dian1.setImageResource(R.mipmap.ic_dian_normal);
                    iv_message_dian2.setImageResource(R.mipmap.ic_dian_normal);
                    iv_message_dian3.setImageResource(R.mipmap.ic_dian_normal);
                    iv_message_dian4.setImageResource(R.mipmap.ic_dian_focused);
                    tv_message_change.setText("文化周边");
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
            ImageView iv_ic;
        }

        @Override
        public View getView(int position, View convertview, ViewGroup viewGroup) {
            if (convertview==null)
            {
                vh=new Viewhold();
                convertview= LayoutInflater.from(getActivity()).inflate(R.layout.traffic_item1,null);
                vh.title= (TextView) convertview.findViewById(R.id.title1);
                vh.body= (TextView) convertview.findViewById(R.id.body1);
                vh.iv_ic= (ImageView) convertview.findViewById(R.id.iv_wenhao);
                convertview.setTag(vh);
            }
            else
            {
                vh= (Viewhold) convertview.getTag();
            }
            vh.iv_ic.setImageResource(R.mipmap.ic_wxts_pressed);
            vh.title.setText(Config_Message_tip.totalTitle[position]);
            vh.body.setText(Config_Message_tip.totalBody[position]);
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
                convertview= LayoutInflater.from(getActivity()).inflate(R.layout.shop_item1,null);
                vh.title= (TextView) convertview.findViewById(R.id.title1);
                vh.body= (TextView) convertview.findViewById(R.id.body1);
                vh.iv= (ImageView) convertview.findViewById(R.id.iv_shop);


                convertview.setTag(vh);
            }
            else
            {
                vh= (Viewhold) convertview.getTag();
            }

            vh.title.setText(Config_message_special.totalTitle[position]);
            vh.body.setText(Config_message_special.totalBody[position]);
            vh.iv.setImageResource(Config_message_special.totalImage[position]);

            return convertview;
        }
    }

    class Mybaseadaper3 extends BaseAdapter
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

            vh.title.setText(Config_Message_city.totalTitle[position]);
            vh.body.setText(Config_Message_city.totalBody[position]);


            return convertview;
        }
    }

    class Mybaseadaper4 extends BaseAdapter
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
                convertview= LayoutInflater.from(getActivity()).inflate(R.layout.shop_item1,null);
                vh.title= (TextView) convertview.findViewById(R.id.title1);
                vh.body= (TextView) convertview.findViewById(R.id.body1);
                vh.iv= (ImageView) convertview.findViewById(R.id.iv_shop);

                convertview.setTag(vh);
            }
            else
            {
                vh= (Viewhold) convertview.getTag();
            }

            vh.title.setText(Config_message_culture.totalTitle[position]);
            vh.body.setText(Config_message_culture.totalBody[position]);
            vh.iv.setImageResource(Config_message_culture.totalImage[position]);

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

            //            ViewGroup view= (ViewGroup) list.get(position).getParent();
            //            view.removeAllViews();

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
