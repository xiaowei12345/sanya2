package sanya.com.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import sanya.com.Utils.SaveUtils;
import sanya.com.activity.AboutActivity;
import sanya.com.activity.SupportActivity;
import sanya.com.sanya.R;

/**
 * Created by Sep
 */
public class Fragment_More extends Fragment {
    private RelativeLayout rl_support;
    private RelativeLayout rl_about;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_more,null);
        rl_about = (RelativeLayout) view.findViewById(R.id.rl_about);
        rl_support = (RelativeLayout) view.findViewById(R.id.rl_support);
        rl_support.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), SupportActivity.class);
                startActivity(intent);
            }
        });
        rl_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AboutActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
