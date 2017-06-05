package sanya.com.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.db.sqlite.Selector;
import com.lidroid.xutils.exception.DbException;

import java.util.ArrayList;
import java.util.List;

import sanya.com.activity.FoodDetailActivity;
import sanya.com.activity.SceneryActivity;
import sanya.com.activity.ShopDetailActivity;
import sanya.com.activity.StayActivity;
import sanya.com.adapter.CollectAdapter;
import sanya.com.adapter.GroupAdapter;
import sanya.com.bean.Collect;
import sanya.com.sanya.R;

/**
 * Created by Sep
 */
public class Fragment_Collect extends Fragment {
    private PopupWindow popupWindow;
    private ListView lv_group;
    private View view;
    private TextView tvtitle;
    private List<String> groups;
    private RelativeLayout rll;
    private ImageView iv;
    private ListView lv;
    private DbUtils mdbUtils;
    private List<Collect>list = new ArrayList<Collect>();
    private CollectAdapter adapter;
//    private Button bt;
//    private Button bt1;
    private TextView tv_edit;
    private TextView tv_delete;
    private Collect collect = new Collect();
    private long index;
    private View layout;

    public Fragment_Collect() {
    }

    public void  setLayout(LinearLayout layout) {
        this.layout = layout;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        View view1 = inflater.inflate(R.layout.fragment_collect,null);
        tvtitle = (TextView) view1.findViewById(R.id.tvtitle);
        rll = (RelativeLayout) view1.findViewById(R.id.rll);
        iv = (ImageView) view1.findViewById(R.id.iv);
//        bt = (Button) view.findViewById(R.id.bt);
//        bt1 = (Button) view.findViewById(R.id.bt1);
        //iv_forword = (ImageView) view1.findViewById(R.id.iv_forword);
        //tv_delete = (TextView) view1.findViewById(R.id.tv_delete);
        tv_edit = (TextView) view1.findViewById(R.id.tv_edit);
        //SaveUtils su = new SaveUtils(getActivity(),null);
        //-----------修改-------
        lv = (ListView) view1.findViewById(R.id.lv);
        adapter = new CollectAdapter(list,getActivity(),tv_edit);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Collect collect = list.get(position);
                if (collect.getType().equals("景点")){
                    Intent intent = new Intent(getActivity(), SceneryActivity.class);
                    intent.putExtra("key", collect.getNum());
                    startActivity(intent);
                }
                if (collect.getType().equals("美食")){
                    Intent intent = new Intent(getActivity(), FoodDetailActivity.class);
                    intent.putExtra("key", collect.getNum());
                    startActivity(intent);
                }
                if (collect.getType().equals("购物")){
                    Intent intent = new Intent(getActivity(), ShopDetailActivity.class);
                    intent.putExtra("key", collect.getNum());
                    startActivity(intent);
                }
                if (collect.getType().equals("住宿")){
                    Intent intent = new Intent(getActivity(), StayActivity.class);
                    intent.putExtra("key", collect.getNum());
                    startActivity(intent);
                }

            }
        });
        //------------------
        tv_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //-----------修改-------
                if (tv_edit.getText().equals("编辑")) {
                    tv_edit.setText("完成");
                    update();
                    lv.setItemsCanFocus(false);
                    //lv.setFocusable(false);
                } else {
                    tv_edit.setText("编辑");
                    update1();
                    //lv.setFocusable(true);
                    lv.setItemsCanFocus(true);
                }
                //------------------
            }
        });
        View emptyview = view1.findViewById(R.id.empty_iv);
        lv.setEmptyView(emptyview);

        //1.创建数据库
        createDatabase();

        queryAllRecord();
//                bt.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        tv_edit.setText("编辑");
//                        try {
//                            collect.setFlag(true);
//                            collect.setFg(true);
//                            collect.setImage(R.mipmap.favorites_list_item_icon_hotel);
//                            collect.setName("xxx天堂");
//                            collect.setType("购物");
//                            mdbUtils.save(collect);
//                        } catch (DbException e) {
//                            e.printStackTrace();
//                            Log.i("test","dbexception"+e.getMessage());
//                        }
//                        queryAllRecord();
//                    }
//                });
//                bt1.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        try {
//                            mdbUtils.deleteAll(Collect.class);
//                        } catch (DbException e) {
//                            e.printStackTrace();
//                        }
//                        queryAllRecord();
//                    }
//                });
        iv.setTag("favorites_img_drop_down_normal");
        popupWindow = new PopupWindow(view1, 200, 270);
        tvtitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showWindow(v);
            }
        });
        if (adapter == null)
        {
            tv_edit.setVisibility(View.GONE);
        }
        return view1;
    }
    private void update() {
        for (Collect collect:list){
            collect.setFlag(false);
        }
        try {
            mdbUtils.updateAll(list,"flag");
        } catch (DbException e) {
            e.printStackTrace();
        }
        queryAllRecord();
        //adapter.list=list;
        Log.i("FragmentCollect","编辑----->list"+list.toString());
        adapter.notifyDataSetChanged();
    }
    private void update1() {
        for (Collect collect:list){
            collect.setFlag(true);
        }
        try {
            mdbUtils.updateAll(list, "flag");
        } catch (DbException e) {
            e.printStackTrace();
        }
        queryAllRecord();
        adapter.list=list;
        Log.i("FragmentCollect","完成----->list"+list.toString());
        adapter.notifyDataSetChanged();
    }
    private void queryAllRecord() {
        try {
            list = mdbUtils.findAll(Collect.class);
//            Log.i("queryAllRecord------->", list.toString());

            if (list != null && list.size()!=0){
                adapter.list = list;
                tv_edit.setVisibility(View.VISIBLE);
            }else {
                tv_edit.setVisibility(View.GONE);
            }
            adapter.notifyDataSetChanged();
        } catch (DbException e) {
            e.printStackTrace();
        }
    }
    private void createDatabase() {
        Activity activity=getActivity();
        Log.i("-------",activity.toString());
        //1.
        mdbUtils = DbUtils.create(getActivity(), Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath(),"Collect2");
    }
    private void showWindow(View parent) {
        iv.setImageResource(R.mipmap.favorites_img_drop_down_selected);

        if (popupWindow == null) {

            final LayoutInflater layoutInflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = layoutInflater.inflate(R.layout.list_item, null);

            lv_group = (ListView) view.findViewById(R.id.lvGroup);
            // 加载数据
            groups = new ArrayList<String>();
            groups.add("全部");
            groups.add("景点");
            groups.add("美食");
            groups.add("购物");
            groups.add("住宿");

            GroupAdapter groupAdapter = new GroupAdapter(getActivity(), groups);
            lv_group.setAdapter(groupAdapter);

            // 创建一个PopuWidow对象
            popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    iv.setImageResource(R.mipmap.favorites_img_drop_down_normal);
                }
            });
        }
        //iv.setImageResource(R.mipmap.favorites_img_drop_down_selected);
        // 使其聚集
        popupWindow.setFocusable(true);
        // 设置允许在外点击消失
        popupWindow.setOutsideTouchable(true);

        // 这个是为了点击“返回Back”也能使其消失，并且并不会影响你的背景
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        WindowManager windowManager = (WindowManager) getActivity().getSystemService(Context.WINDOW_SERVICE);
        //popupWindow.showAsDropDown(tvtitle);
        // 显示的位置为:屏幕的宽度的一半-PopupWindow的高度的一半
        int xPos = windowManager.getDefaultDisplay().getWidth() / 2
                - popupWindow.getWidth() / 2;


        Log.i("coder", "windowManager.getDefaultDisplay().getWidth()/2:"
                + windowManager.getDefaultDisplay().getWidth() / 2);
        //
        Log.i("coder", "popupWindow.getWidth()/2:" + popupWindow.getWidth() / 2);

        //Log.i("coder", "xPos:" + xPos);
        ViewGroup p = (ViewGroup) rll.getParent();
        if (p != null) {
            p.removeAllViewsInLayout();
        }
//        popupWindow.showAtLocation(layout, Gravity.CENTER_HORIZONTAL,xPos,0);

        lv_group.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view,
                                    int position, long id) {
                String test = groups.get(position);
                if (test.equals("住宿"))
                {
                    try {
                        list = mdbUtils.findAll(Selector.from(Collect.class).where("type","=","住宿").orderBy("type",true));
                        adapter.list = list;
                        adapter.notifyDataSetChanged();
                    } catch (DbException e) {
                        e.printStackTrace();
                    }
                }
                if (test.equals("美食"))
                {
                    try {
                        list = mdbUtils.findAll(Selector.from(Collect.class).where("type","=","美食").orderBy("type",true));
                        adapter.list = list;
                        adapter.notifyDataSetChanged();
                    } catch (DbException e) {
                        e.printStackTrace();
                    }
                }
                if (test.equals("景点"))
                {
                    try {
                        list = mdbUtils.findAll(Selector.from(Collect.class).where("type","=","景点").orderBy("type",true));
                        adapter.list = list;
                        adapter.notifyDataSetChanged();
                    } catch (DbException e) {
                        e.printStackTrace();
                    }
                }
                if (test.equals("购物"))
                {
                    try {
                        list = mdbUtils.findAll(Selector.from(Collect.class).where("type","=","购物").orderBy("type",true));
                        adapter.list = list;
                        adapter.notifyDataSetChanged();
                    } catch (DbException e) {
                        e.printStackTrace();
                    }
                }
                if (test.equals("全部"))
                {
                    try {
                        list = mdbUtils.findAll(Collect.class);
                        adapter.list = list;
                        adapter.notifyDataSetChanged();
                    } catch (DbException e) {
                        e.printStackTrace();
                    }
                }
                Toast.makeText(getActivity(),
                        "groups.get(position)" + groups.get(position), Toast.LENGTH_SHORT)
                        .show();
                if (popupWindow != null) {
                    popupWindow.dismiss();
                }
            }
        });
    }
}
