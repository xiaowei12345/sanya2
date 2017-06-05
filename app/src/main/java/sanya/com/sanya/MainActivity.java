package sanya.com.sanya;

import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.exception.DbException;
import com.zhy.android.percent.support.PercentLinearLayout;
import com.zhy.android.percent.support.PercentRelativeLayout;

import java.util.ArrayList;
import java.util.List;

import sanya.com.adapter.CollectAdapter;
import sanya.com.bean.Collect;
import sanya.com.fragment.FoodFragment;
import sanya.com.fragment.Fragment_Collect;
import sanya.com.fragment.Fragment_Guide;
import sanya.com.fragment.Fragment_More;
import sanya.com.fragment.Fragment_Nearby;
import sanya.com.fragment.InfoFragment;
import sanya.com.fragment.ReadFragment;
import sanya.com.fragment.RoadFragement;
import sanya.com.fragment.SceneryFragment;
import sanya.com.fragment.ShopFragment;
import sanya.com.fragment.StayFragment;
import sanya.com.fragment.TrafficFragment;
import sanya.com.fragment.TravelFragment;

public class MainActivity extends FragmentActivity  {
    private static final String TAG = "MainActivity" ;
    private Fragment mContent ;
    private Fragment_Guide guide;
    private FragmentManager fm;
    private FragmentTransaction tran;
    private RadioGroup rg;
    private Fragment_Nearby nearby;
    private Fragment_Collect collect;
    private Fragment_More more;
    private PercentRelativeLayout scenery;
    private PercentLinearLayout shop;
    private PercentLinearLayout road;
    private PercentLinearLayout stay;
    private PercentLinearLayout food;
    private PercentLinearLayout traffic;
    private PercentLinearLayout travel;

    private View view;
    private RoadFragement roadFragment;
    public static int num ;
    private TravelFragment travelFragment;
    private SceneryFragment sceneryFragment;
    private StayFragment stayFragment;
    private ReadFragment readFragment;
    private FoodFragment foodFragment;
    private ShopFragment shopFragment;
    private TrafficFragment trafficFragment;
    private InfoFragment infoFragment;

    private Collect collect1;
    private DbUtils dbUtils;
    private CollectAdapter adapter;
    private List<Collect> list = new ArrayList<>();
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = (LinearLayout) findViewById(R.id.layout_total);
        view = LayoutInflater.from(this).inflate(R.layout.fragment_guide, null);
        scenery = (PercentRelativeLayout) view.findViewById(R.id.scenery);
        road =(PercentLinearLayout) view.findViewById(R.id.road);
        shop =(PercentLinearLayout) view.findViewById(R.id.shop);
        stay =(PercentLinearLayout) view.findViewById(R.id.stay);
        food =(PercentLinearLayout) view.findViewById(R.id.food);
        traffic =(PercentLinearLayout) view.findViewById(R.id.traffic);
        travel =(PercentLinearLayout) view.findViewById(R.id.travel);
        rg =(RadioGroup)findViewById(R.id.rg);

        dbUtils = DbUtils.create(this, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath(), "Collect2");
        collect1 = new Collect();
        adapter = new CollectAdapter(list,this,null);



//        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//                Log.i(TAG,"6");
//                switch (i) {
//                    case R.id.rb_guide:
//                        switch (num){
//                            case 1:
////                                Bundle bundle = new Bundle();
////                                bundle.putSerializable("name",guide);
////                                sceneryFragment.setArguments(bundle);
//                                switchFragment(mContent, sceneryFragment);
//                                break;
//                            case 2:
//                                switchFragment(mContent,readFragment);
//                                break;
//                            case 3:
//                                switchFragment(mContent,roadFragment);
//                                break;
//                            case 4:
//                                switchFragment(mContent,shopFragment);
//                                break;
//                            case 5:
//                                switchFragment(mContent,foodFragment);
//                                break;
//                            case 6:
//                                switchFragment(mContent,trafficFragment);
//                                break;
//                            case 7:
//                                switchFragment(mContent,trafficFragment);
//                                break;
//                            case 8:
//                                switchFragment(mContent, travelFragment);
//                                break;
//                            case 9:
//                                switchFragment(mContent, infoFragment);
//                                break;
//                            default:
//                                switchFragment(mContent, guide);
//                                break;
//                        }
//                        break;
//                    case R.id.rb_nearby:
//                        Log.i(TAG, "8");
//                        switchFragment(mContent, nearby);
//                        break;
//                    case R.id.rb_collect:
//                        switchFragment(mContent, collect);
//                        break;
//                    case R.id.rb_more:
//                        switchFragment(mContent, more);
//                        break;
//                    default:
//                        break;
//                }
//            }
//        });
//    }
//    private  void switchFragment(Fragment from,Fragment to){
//        if (mContent!=to) {
//            mContent = to;
//            tran =fm.beginTransaction();
//            Log.i(TAG,"2");
//            if (!to.isAdded()) {
//                tran.hide(from).add(R.id.layout_total, to).commit();
//                int entryCount = fm.getBackStackEntryCount();
//                Log.i(TAG, "ssssstop"+entryCount);
//                Log.i(TAG, "3");
//            }else {
//                Log.i(TAG,"eeeeee");
//                tran.hide(from).show(to).commit();
//                Log.i(TAG, "4");
//                int entryCount = fm.getBackStackEntryCount();
//                Log.i(TAG, "ssssdown"+entryCount);
//            }
//        }
//    }
//    /* private long exitTime=0;
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        // TODO Auto-generated method stub
//        if (keyCode== KeyEvent.KEYCODE_BACK) {
//            if ((System.currentTimeMillis()-exitTime)>2000) {
//                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
//                exitTime = System.currentTimeMillis();
//            }else {
//                finish();
//            }
//            return false;
//        }
//        return super.onKeyDown(keyCode, event);
//    }*/
//    public void click(View view) {
//        Log.i("Tag","11111");
//        switch (view.getId()) {
//            case R.id.scenery:
//                switchFragment(mContent, sceneryFragment);
//                num  = 1;
//                Log.i("TAG", "2222");
//                break;
//            case R.id.beforego:
//                switchFragment(mContent,readFragment);
//                num  = 2;
//                break;
//            case R.id.road:
//                switchFragment(mContent,roadFragment);
//                num  = 3;
//                break;
//            case R.id.shop:
//
//                switchFragment(mContent,shopFragment);
//                num  = 4;
//                break;
//            case R.id.food:
//                switchFragment(mContent,foodFragment);
//                num  = 5;
//                break;
//            case R.id.stay:
//                switchFragment(mContent,stayFragment);
//                num  = 6;
//                break;
//            case R.id.traffic:
//                switchFragment(mContent,trafficFragment);
//                num  = 7;
//                break;
//            case R.id.travel:
//                switchFragment(mContent,travelFragment);
//                num  = 8;
//                break;
//            case R.id.message:
//                switchFragment(mContent,infoFragment);
//                num  = 9;
//                break;
//        }
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                FragmentManager manager = getSupportFragmentManager();
                tran = manager.beginTransaction();
                switch (i) {
                    case R.id.rb_guide:
                        switch (num) {
                            case 1:
                               switchFragment(mContent,sceneryFragment);
                                break;
                            case 2:
                                switchFragment(mContent,readFragment);
                                break;
                            case 3:
                                switchFragment(mContent,roadFragment);
                                break;
                            case 4:
                                switchFragment(mContent,shopFragment);
                                break;
                            case 5:
                                switchFragment(mContent,foodFragment);
                                break;
                            case 6:
                                switchFragment(mContent,trafficFragment);
                                break;
                            case 7:
                                switchFragment(mContent,trafficFragment);
                                break;
                            case 8:
                                switchFragment(mContent, travelFragment);
                                break;
                            case 9:
                                switchFragment(mContent, infoFragment);
                                break;
                            case 0:
                                if (mContent != null) {
                                    tran.remove(mContent);
                                }
                                tran.replace(R.id.layout_total, guide);
                                mContent = guide;
                                tran.commit();
                                break;
                        }
                        break;
                    case R.id.rb_nearby:
//                        Toast.makeText(getApplicationContext(),"111",Toast.LENGTH_LONG).show();
                        if (mContent != null) {
                            tran.remove(mContent);
                        }
                        tran.replace(R.id.layout_total, nearby);
                        mContent = nearby;
                        tran.commit();
                        break;
                    case R.id.rb_collect:
                        if (mContent != null) {
                            tran.remove(mContent);
                        }
                        tran.replace(R.id.layout_total, collect);
                        mContent = collect;
                        tran.commit();
                        try {
                            list = dbUtils.findAll(Collect.class);
                            if (list != null){
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            }
                        } catch (DbException e) {
                            e.printStackTrace();
                        }
                        break;
                    case R.id.rb_more:
                        if (mContent != null) {
                            tran.remove(mContent);
                        }
                        tran.replace(R.id.layout_total, more);
                        mContent = more;
                        tran.commit();
                    default:
                        break;
                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        nearby = new Fragment_Nearby();
        collect = new Fragment_Collect();
        collect.setLayout(linearLayout);
        more = new Fragment_More();
        sceneryFragment =  Application.sceneryFragment;
        roadFragment = new RoadFragement();
        travelFragment = new TravelFragment();
        stayFragment = new StayFragment();
        readFragment = new ReadFragment();
        foodFragment = new FoodFragment();
        shopFragment = new ShopFragment();
        trafficFragment = new TrafficFragment();
        infoFragment = new InfoFragment();
        guide = new Fragment_Guide();
        fm = getSupportFragmentManager();
        tran = fm.beginTransaction();
        mContent = guide;
        tran.replace(R.id.layout_total, guide);
        tran.commit();
    }

    public void click(View view) {
        FragmentManager manager = getSupportFragmentManager();
        tran = manager.beginTransaction();
        switch (view.getId()) {
            case R.id.scenery:
                switchFragment(mContent, sceneryFragment);
                num = 1;
                break;
            case R.id.beforego:
                switchFragment(mContent, readFragment);
                num = 2;
                break;
            case R.id.road:
                switchFragment(mContent, roadFragment);
                num = 3;
                break;
            case R.id.shop:
                switchFragment(mContent, shopFragment);
                num = 4;
                break;
            case R.id.food:
                switchFragment(mContent, foodFragment);
                num = 5;
                break;
            case R.id.stay:
                switchFragment(mContent, stayFragment);
                num = 6;
                break;
            case R.id.traffic:
                switchFragment(mContent, trafficFragment);
                num = 7;
                break;
            case R.id.travel:
                switchFragment(mContent, travelFragment);
                num = 8;
                break;
            case R.id.message:
                switchFragment(mContent, infoFragment);
                num = 9;
                break;
        }
    }

    private void switchFragment(Fragment from, Fragment to) {
        if (from != null) {
            tran.remove(from);
        }
        tran.replace(R.id.layout_total, to);
        tran.addToBackStack(null);
        mContent = to;
        tran.commit();
    }

    public void onBackPressed() {

        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStack();
        }else {
            super.onBackPressed();
        }
    }
}
