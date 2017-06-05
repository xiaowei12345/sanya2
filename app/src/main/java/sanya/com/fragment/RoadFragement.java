package sanya.com.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import sanya.com.activity.RoadActivity;
import sanya.com.sanya.Application;
import sanya.com.sanya.MainActivity;
import sanya.com.sanya.R;

/**
 * Created by Sep
 */
public class RoadFragement extends Fragment implements View.OnClickListener{

    private ImageView iv_back;
    private LinearLayout linearLayout1;
    private LinearLayout linearLayout2;
    private View view;
    private Intent intent;
    private FragmentManager fm;
    private FragmentTransaction tran;
    private RoadFragement roadFragement;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.road_fragment,null);
        iv_back = (ImageView) view.findViewById(R.id.iv_back);
        linearLayout1 = (LinearLayout) view.findViewById(R.id.linearLayout_1);
        linearLayout2 = (LinearLayout) view.findViewById(R.id.linearLayout_2);
        fm = getFragmentManager();
        roadFragement = Application.roadFragement;
        linearLayout1.setOnClickListener(this);
        linearLayout2.setOnClickListener(this);
        iv_back.setOnClickListener(new View.OnClickListener() {

            private Fragment_Guide guide;

            public void onClick(View view) {
                guide = new Fragment_Guide();
                tran = fm.beginTransaction();
                tran.remove(roadFragement);
                tran.replace(R.id.layout_total, guide);
                tran.commit();
                MainActivity.num = 0;
            }
        });

        return view;
    }
    @Override
    public void onClick(View view) {
            switch (view.getId()){
                case R.id.linearLayout_1:
                    intent = new Intent(getActivity(), RoadActivity.class);
                    intent.putExtra("num", 1);
                    break;
                case R.id.linearLayout_2:
                    intent = new Intent(getActivity(), RoadActivity.class);
                    intent.putExtra("num", 2);
                    break;
            }
            startActivity(intent);
        }

}
