package sanya.com.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import sanya.com.sanya.R;
import sanya.com.view.pinnedlist.ContactSeriesAdapter;
import sanya.com.view.pinnedlist.PinnedHeaderListView;

import java.util.ArrayList;
import java.util.List;

public class RoadActivity extends AppCompatActivity {
private List<String > list1 = new ArrayList<String >();
private List<String > list2 = new ArrayList<String >();
private List<String > list3 = new ArrayList<String >();

private List<String > list4 = new ArrayList<String >();
    private ContactSeriesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_road);
        list1.add("DAY1");
        list1.add("DAY2");
        list2.add("亚龙湾-热带天堂森林公园");
        list2.add("蜈支洲岛-南田温泉");

        list3.add("DAY1");
        list3.add("DAY2");
        list3.add("DAY3");
        list3.add("DAY4");
        list4.add("亚龙湾-热带天堂森林公园");
        list4.add("蜈支洲岛-南田温泉");
        list4.add("南山-天涯海角");
        list4.add("第一市场-椰梦长廊");

        PinnedHeaderListView lv_road = (PinnedHeaderListView) findViewById(R.id.pinnedListView);
        Intent intent = getIntent();
       int num =  intent.getIntExtra("num",0);
        switch (num){
            case 1:
                adapter = new ContactSeriesAdapter(list1,list2);
                break;
           default:
                adapter = new ContactSeriesAdapter(list3,list4);
                break;
        }

        lv_road.setAdapter(adapter);
    }
    public void click(View view){
        finish();
    }
}
