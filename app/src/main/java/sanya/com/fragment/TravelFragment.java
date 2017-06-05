package sanya.com.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import sanya.com.activity.*;
import sanya.com.adapter.TravelAdapter;
import sanya.com.sanya.Application;
import sanya.com.sanya.MainActivity;
import sanya.com.sanya.R;


/**
 * Created by Sep
 */
public class TravelFragment extends Fragment implements AdapterView.OnItemClickListener {
    private Intent intent;
    private ListView lv_travel;
    public static final String TAG = "TravelFragment";
    private int[] image = {R.mipmap.travel1,R.mipmap.travel2,R.mipmap.travel3,R.mipmap.travel4,R.mipmap.travel5};
    private TravelAdapter adapter;
    private TravelFragment travelFragment;
    private FragmentManager fm;
    private FragmentTransaction tran;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.travel_fragment,null);
        lv_travel = (ListView) view. findViewById(R.id.lv_travel);
        adapter = new TravelAdapter(image);
        lv_travel.setAdapter(adapter);

        lv_travel.setOnItemClickListener(this);
        fm = getFragmentManager();
        travelFragment = Application.travelFragment;
        ImageView iv_back = (ImageView) view.findViewById(R.id.iv_travel_back);
        iv_back.setOnClickListener(new View.OnClickListener() {

            private Fragment_Guide guide;

            public void onClick(View view) {
                guide = new Fragment_Guide();
                tran = fm.beginTransaction();
                tran.remove(travelFragment);
                tran.replace(R.id.layout_total, guide);
                tran.commit();
                MainActivity.num = 0;
            }
        });

        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        switch (i) {
            case 0:

                intent = new Intent(getActivity(), TravelNoteOneActivity.class);
                startActivity(intent);
                break;
            case 1:
                intent = new Intent(getContext(), TravelNoteTwoActivity.class);
                startActivity(intent);
                break;
            case 2:
                intent = new Intent(getContext(), TravelNoteThreeActivity.class);
                startActivity(intent);
                break;
            case 3:
                intent = new Intent(getContext(), TravelNoteFourActivity.class);
                startActivity(intent);
                break;
            case 4:
                intent = new Intent(getContext(), TravelNoteFiveActivity.class);
                startActivity(intent);
                break;
        }

    }
}
