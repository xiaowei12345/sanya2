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
public class ReadFragment extends Fragment {
    private SlidingMenu menu;
    private ImageView btn_menu;
    private ImageView btn_back;
    private ImageView iv_dian1,iv_dian2;
    private ViewPager vp;
    private TextView tv_change;
    private ListView listview1,listview2;
    private View btn1,btn2;
    private List<ListView> list=new ArrayList<ListView>();
    private View view;
    private FragmentManager fm;
    private ReadFragment readFragment;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.read_fragment,null);
        menu = new SlidingMenu(getContext());
        menu.setMode(SlidingMenu.RIGHT);
       menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        menu.setFadeDegree(0.35f);
        menu.attachToActivity(getActivity(), SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
        menu.setMenu(R.layout.menu1);
        fm = getFragmentManager();
        readFragment = Application.readFragment;

        Config_beforego_thing.addAll();
        ImageView iv_back = (ImageView) view.findViewById(R.id.btn_back);
        iv_back.setOnClickListener(new View.OnClickListener() {

            private FragmentTransaction tran;
            private Fragment_Guide guide;

            public void onClick(View view) {
                guide = new Fragment_Guide();
                tran = fm.beginTransaction();
                tran.remove(readFragment);
                tran.replace(R.id.layout_total, guide);
                tran.commit();
                MainActivity.num = 0;
            }
        });

        btn1= menu.findViewById(R.id.ask);
        btn2= menu.findViewById(R.id.thing);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vp.setCurrentItem(0);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vp.setCurrentItem(1);
            }
        });

        iv_dian1= (ImageView)view.findViewById(R.id.dian1);
        iv_dian2= (ImageView) view.findViewById(R.id.dian2);

        tv_change= (TextView)view.findViewById(R.id.tv_change);
        btn_menu= (ImageView) view.findViewById(R.id.btn_menu);
        btn_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menu.showMenu();
            }
        });

        vp= (ViewPager) view.findViewById(R.id.vp_beforego);

        listview1= (ListView) LayoutInflater.from(getContext()).inflate(R.layout.viewpager1,null).findViewById(R.id.listview1);
        listview2= (ListView) LayoutInflater.from(getContext()).inflate(R.layout.viewpager2,null).findViewById(R.id.listview2);

        list.add(listview1);
        list.add(listview2);

        Mybaseadaper1 adapter1=new Mybaseadaper1();

        Mybaseadaper2 adapter2=new Mybaseadaper2();
        listview1.setAdapter(adapter1);
        listview2.setAdapter(adapter2);
        MyPagerAdapter adapte=new MyPagerAdapter();
        vp.setAdapter(adapte);

        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                if (position == 0) {
                    iv_dian1.setImageResource(R.mipmap.ic_dian_focused);
                    iv_dian2.setImageResource(R.mipmap.ic_dian_normal);
                    tv_change.setText("有问必答");
                } else {
                    iv_dian1.setImageResource(R.mipmap.ic_dian_normal);
                    iv_dian2.setImageResource(R.mipmap.ic_dian_focused);
                    tv_change.setText("必备物品");
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
        }

        @Override
        public View getView(int position, View convertview, ViewGroup viewGroup) {
            if (convertview==null)
            {
                vh=new Viewhold();
                convertview= LayoutInflater.from(getContext()).inflate(R.layout.item1,null);
                vh.title= (TextView) convertview.findViewById(R.id.title1);
                vh.body= (TextView) convertview.findViewById(R.id.body1);


                convertview.setTag(vh);
            }
            else
            {
                vh= (Viewhold) convertview.getTag();
            }

            vh.title.setText(Config_beforego_ask.totalTitle[position]);
            vh.body.setText(Config_beforego_ask.totalBody[position]);

            return convertview;
        }
    }

    class Mybaseadaper2 extends BaseAdapter
    {


        @Override
        public int getCount() {
            return 6;
        }

        @Override
        public Object getItem(int i) {
            return new Object();
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        class Viewhold
        {
            LinearLayout linear;
            TextView title;
            TextView tvs[];
        }

        @Override
        public View getView(int position, View convertview, ViewGroup viewGroup) {
            Viewhold vh;
            if (convertview==null)
            {

                vh=new Viewhold();
                convertview= LayoutInflater.from(getContext()).inflate(R.layout.item2,viewGroup,false);
                vh.linear= (LinearLayout) convertview.findViewById(R.id.linear);
                vh.title= (TextView) convertview.findViewById(R.id.title);

                convertview.setTag(vh);
            }
            else
            {
                vh= (Viewhold) convertview.getTag();
            }
            vh.tvs = new TextView[Config_beforego_thing.totalBody.get(position).size()];
            for (int i=0;i<Config_beforego_thing.totalBody.get(position).size();i++) {
                vh.tvs[i]=new TextView(getContext());
            }
            vh.title.setText(Config_beforego_thing.totalTitle[position]);
            vh.linear.removeAllViews();
            for (int i=0;i<Config_beforego_thing.totalBody.get(position).size();i++)
            {
                //                慢慢拉可以  拉快了就指针溢出了
                Config_beforego_thing.totalBody.get(position);
                Config_beforego_thing.totalBody.get(position).get(i);
                vh.tvs[i].setText("");


                vh.tvs[i].setText(Config_beforego_thing.totalBody.get(position).get(i));
                ListView.LayoutParams layoutParams = new ListView.LayoutParams(ListView.LayoutParams.MATCH_PARENT, ListView.LayoutParams.WRAP_CONTENT);
                vh.tvs[i].setLayoutParams(layoutParams);
                vh.tvs[i].setPadding(5,5,5,5);
                vh.linear.addView(vh.tvs[i]);
            }
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



