package sanya.com.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import sanya.com.activity.SceneryActivity;
import sanya.com.adapter.SceneryAdapter;
import sanya.com.sanya.Application;
import sanya.com.sanya.Config;
import sanya.com.sanya.MainActivity;
import sanya.com.sanya.R;

/**
 * Created by Sep
 */
public class SceneryFragment extends Fragment  {
    private int[] image = {R.mipmap.scenery1,R.mipmap.scenery2,R.mipmap.scenery3,R.mipmap.scenery4
            ,R.mipmap.scenery5,R.mipmap.scenery6,R.mipmap.scenery7,R.mipmap.scenery8
            ,R.mipmap.scenery9,R.mipmap.scenery10,R.mipmap.scenery11,R.mipmap.scenery12};
    private ListView lv_scenery;
    private String[] name = {Config.SCENERY_NAME_1,Config.SCENERY_NAME_2,Config.SCENERY_NAME_3,Config.SCENERY_NAME_4,
            Config.SCENERY_NAME_5,Config.SCENERY_NAME_6,Config.SCENERY_NAME_7,Config.SCENERY_NAME_8,
            Config.SCENERY_NAME_9,Config.SCENERY_NAME_10,Config.SCENERY_NAME_11,Config.SCENERY_NAME_12,};
    private String[] levelDesc = {Config.SCENERY_LEVELDESC_1,Config.SCENERY_LEVELDESC_2,Config.SCENERY_LEVELDESC_3,Config.SCENERY_LEVELDESC_4,
            Config.SCENERY_LEVELDESC_5,Config.SCENERY_LEVELDESC_6,Config.SCENERY_LEVELDESC_7,Config.SCENERY_LEVELDESC_8,
            Config.SCENERY_LEVELDESC_9,Config.SCENERY_LEVELDESC_10,Config.SCENERY_LEVELDESC_11,Config.SCENERY_LEVELDESC_12};
    private String[] introduce = {Config.SCENERY_INTRODUCE_1,Config.SCENERY_INTRODUCE_2,Config.SCENERY_INTRODUCE_3,Config.SCENERY_INTRODUCE_4,
            Config.SCENERY_INTRODUCE_5,Config.SCENERY_INTRODUCE_6,Config.SCENERY_INTRODUCE_7,Config.SCENERY_INTRODUCE_8,
            Config.SCENERY_INTRODUCE_9,Config.SCENERY_INTRODUCE_10,Config.SCENERY_INTRODUCE_11,Config.SCENERY_INTRODUCE_12};
    private int[] rBar = {Config.SCENERY_RatingBar_1,Config.SCENERY_RatingBar_2,Config.SCENERY_RatingBar_3,Config.SCENERY_RatingBar_4,
            Config.SCENERY_RatingBar_5,Config.SCENERY_RatingBar_6,Config.SCENERY_RatingBar_7,Config.SCENERY_RatingBar_8,
            Config.SCENERY_RatingBar_9,Config.SCENERY_RatingBar_10,Config.SCENERY_RatingBar_11,Config.SCENERY_RatingBar_12};
    private View view;
    private Fragment mContent ;
    private Fragment_Guide guide;
    private FragmentManager fm;
    private FragmentTransaction tran;
    private SceneryFragment sceneryFragment;
    public static final String TAG = "SceneryFragment";

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.scenery_fragment,null);

        lv_scenery = (ListView) view. findViewById(R.id.lv_scenery);
        SceneryAdapter adapter = new SceneryAdapter(image,name,levelDesc,introduce,rBar);
        lv_scenery.setAdapter(adapter);
        sceneryFragment = Application.sceneryFragment;
        fm = getFragmentManager();

        lv_scenery.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i(TAG,"i---->"+i);
                Intent intent = new Intent(getActivity(), SceneryActivity.class);
                intent.putExtra("key",i);
                startActivity(intent);
            }
        });

        ImageView iv_back = (ImageView) view.findViewById(R.id.iv_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Log.i(TAG, "aaaaa");
                // mContent = sceneryFragment;
                //  switchFragment(mContent, guide);
                // fm.popBackStack();
                //                 tran=fm.beginTransaction();
                //                tran.remove(SceneryFragment.this).commit();

                //                int entryCount = fm.getBackStackEntryCount();
                //
                //                int entryCount1 = getActivity().getSupportFragmentManager().getBackStackEntryCount();
                //
                //              getActivity().getSupportFragmentManager().popBackStack();


                //               Log.i(TAG, "ssssstacks"+entryCount1);
                //                Bundle bundle = getArguments();
                //                guide = (Fragment_Guide) bundle.getSerializable("name");
                //                 guide = Application.fragment_guide;
                //                switchFragment(mContent,guide);
                guide = new Fragment_Guide();
                tran=fm.beginTransaction();
                tran.remove(sceneryFragment);
                tran.replace(R.id.layout_total, guide);
                tran.addToBackStack(null);
                tran.commit();
                MainActivity.num = 0 ;
            }
        });
        return view;
    }
}
