package sanya.com.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
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
import sanya.com.activity.StayActivity;
import sanya.com.adapter.StayAdapter;
import sanya.com.bean.Stay;
import sanya.com.sanya.Application;
import sanya.com.sanya.MainActivity;
import sanya.com.sanya.R;
import sanya.com.tools.FileUtils;
import sanya.com.tools.JsonStay;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sep
 */
public class StayFragment extends Fragment {
    private int[] image = {R.mipmap.hotel_1,R.mipmap.hotel_2,R.mipmap.hotel_3,R.mipmap.hotel_4,
            R.mipmap.hotel_5,R.mipmap.hotel_6,R.mipmap.hotel_7,R.mipmap.hotel_8,
            R.mipmap.hotel_9,R.mipmap.hotel_10,R.mipmap.hotel_11,R.mipmap.hotel_5,
            R.mipmap.hotel_3,R.mipmap.hotel_9,R.mipmap.hotel_6,R.mipmap.hotel_1,};
    private View view;
    private ListView lv_stay;
    public static final String TAG = "StayFragment";
    private FragmentTransaction tran;
    private InputStream is;
    private Handler handler = new Handler();
    private StayAdapter adapter;
    private List<Stay>list = new ArrayList<>();
    private FragmentManager fm;
    private StayFragment stayFragment;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.stay_fragment,null);
        lv_stay = (ListView) view. findViewById(R.id.lv_stay);
        adapter = new StayAdapter(list,image);
        lv_stay.setAdapter(adapter);
        fm = getFragmentManager();
        stayFragment = Application.stayFragment;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    is = getResources().getAssets().open("00004HotelJson.txt");
                    Log.i(TAG,"is===="+is.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                list = JsonStay.parse(FileUtils.readFile(is));
                Log.i(TAG,"is===="+list.toString());
             handler.post(new Runnable() {
                 @Override
                 public void run() {
                     adapter.addAll(list);
                 }
             });
            }
        }).start();
        lv_stay.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Log.i(TAG, "i---->" + i);
                Intent intent = new Intent(getActivity(), StayActivity.class);
                intent.putExtra("key", i);
                startActivity(intent);
            }
        });
        ImageView iv_back = (ImageView) view.findViewById(R.id.iv_back);
        iv_back.setOnClickListener(new View.OnClickListener() {

            private Fragment_Guide guide;

            public void onClick(View view) {
                guide = new Fragment_Guide();
                tran = fm.beginTransaction();
                tran.remove(stayFragment);
                tran.replace(R.id.layout_total, guide);
                tran.commit();
                MainActivity.num = 0;
            }
        });
        return view;

    }


}
