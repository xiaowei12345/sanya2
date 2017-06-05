package sanya.com.activity;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.lidroid.xutils.DbUtils;
import com.lidroid.xutils.db.sqlite.Selector;
import com.lidroid.xutils.db.sqlite.WhereBuilder;
import com.lidroid.xutils.exception.DbException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sanya.com.adapter.CollectAdapter;
import sanya.com.bean.Collect;
import sanya.com.bean.SceneryInfo;
import sanya.com.sanya.R;
import sanya.com.tools.FileUtils;
import sanya.com.tools.JsonSceneryInfo;

public class SceneryActivity extends AppCompatActivity implements View.OnClickListener {


    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_phoneContents)
    TextView tvPhoneContents;
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.ll_phone)
    LinearLayout llPhone;
    @BindView(R.id.ll_traffic)
    LinearLayout llTraffic;
    @BindView(R.id.ll_suggest)
    LinearLayout llSuggest;
    @BindView(R.id.ll_guide)
    LinearLayout llGuide;
    //private List<ScenerySubInfo> list = new ArrayList<ScenerySubInfo>();
    public static final String TAG = "SceneryActivity";
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.iv_cover)
    ImageView ivCover;
    @BindView(R.id.tv_subName)
    TextView tvSubName;
    @BindView(R.id.rbar_level)
    RatingBar rbarLevel;
    @BindView(R.id.tv_levelDesc)
    TextView tvLevelDesc;
    @BindView(R.id.tv_introduce)
    TextView tvIntroduce;
    @BindView(R.id.tv_ticket)
    TextView tvTicket;
    @BindView(R.id.tv_ticketContent)
    TextView tvTicketContent;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_timeContent)
    TextView tvTimeContent;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tv_addressContents)
    TextView tvAddressContents;
    @BindView(R.id.tv_trafficTitle)
    TextView tvTrafficTitle;
    @BindView(R.id.tv_trafficContent)
    TextView tvTrafficContent;
    @BindView(R.id.tv_note)
    TextView tvNote;
    @BindView(R.id.tv_noteContent)
    TextView tvNoteContent;
    @BindView(R.id.tv_brower)
    TextView tvBrower;
    @BindView(R.id.tv_browerContent)
    TextView tvBrowerContent;
    @BindView(R.id.sl_sceneryInfo)
    ScrollView slSceneryInfo;
    @BindView(R.id.iv_collect)
    ImageView ivCollect;
    private LinearLayout ll_phone;
    private String traffic;
    private String suggest;
    private String guide;
    private int trafficNum;
    private int suggestNum;
    private int guideNum;

    private DbUtils dbUtils;
    private CollectAdapter adapter;
    private List<Collect> list = new ArrayList<>();
    private Collect collect;
    private int num;
    private boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenery);
        ButterKnife.bind(this);
//        getSupportActionBar().hide();
        rbarLevel.setMax(5);
        num = getIntent().getIntExtra("key", 0);

        dbUtils = DbUtils.create(SceneryActivity.this, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath(), "Collect2");
        collect = new Collect();
        adapter = new CollectAdapter(list,this,null);

        ivCollect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (num) {
                    case 0:
                        if(flag){
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                            //tv_edit.setText("编辑");
                            try {
                                Log.i("test","pppppppppppppppppppp");

                                collect.setFlag(true);
                                collect.setFg(true);
                                collect.setImage(R.mipmap.favorites_list_item_icon_scene);
                                collect.setName("蜈支洲岛");
                                collect.setType("景点");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                Log.i("queryAllRecord------->", list.toString());
                                adapter.list=list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(SceneryActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                        }else {
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                            try {
                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "蜈支洲岛"));
                                list = dbUtils.findAll(Collect.class);
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(SceneryActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
                            flag = true;
                        }

                        break;
                    case 1:
                        if(flag){
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                            //tv_edit.setText("编辑");
                            try {
                                Log.i("test","pppppppppppppppppppp");

                                collect.setFlag(true);
                                collect.setFg(true);
                                collect.setImage(R.mipmap.favorites_list_item_icon_scene);
                                collect.setName("亚龙湾旅游度假区");
                                collect.setType("景点");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                Log.i("queryAllRecord------->", list.toString());
                                adapter.list=list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(SceneryActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                        }else {
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                            try {
                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "亚龙湾旅游度假区"));
                                list = dbUtils.findAll(Collect.class);
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(SceneryActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
                            flag = true;
                        }

                        break;
                    case 2:
                        if(flag){
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                            //tv_edit.setText("编辑");
                            try {
                                Log.i("test","pppppppppppppppppppp");

                                collect.setFlag(true);
                                collect.setFg(true);
                                collect.setImage(R.mipmap.favorites_list_item_icon_scene);
                                collect.setName("亚热带天堂森林公园");
                                collect.setType("住宿");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                Log.i("queryAllRecord------->", list.toString());
                                adapter.list=list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(SceneryActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                        }else {
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                            try {
                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "亚热带天堂森林公园"));
                                list = dbUtils.findAll(Collect.class);
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(SceneryActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
                            flag = true;
                        }

                        break;
                    case 3:
                        Toast.makeText(getApplicationContext(),"111",Toast.LENGTH_LONG).show();
                        if(flag){
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                            //tv_edit.setText("编辑");
                            try {
                                Log.i("test","pppppppppppppppppppp");

                                collect.setFlag(true);
                                collect.setFg(true);
                                collect.setImage(R.mipmap.favorites_list_item_icon_scene);
                                collect.setName("蜈支洲岛");
                                collect.setType("景点");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                Log.i("queryAllRecord------->", list.toString());
                                adapter.list=list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(SceneryActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                        }else {
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                            try {
                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "蜈支洲岛"));
                                list = dbUtils.findAll(Collect.class);
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(SceneryActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
                            flag = true;
                        }

//                        if(flag){
//                            ivCollect.setImageResource(R.mipmap.btn_favorited);
//                            //tv_edit.setText("编辑");
//                            try {
//                                Log.i("test","pppppppppppppppppppp");
//
//                                collect.setFlag(true);
//                                collect.setFg(true);
//                                collect.setImage(R.mipmap.favorites_list_item_icon_scene);
//                                collect.setName("天涯海角旅游景区");
//                                collect.setType("景点");
//                                collect.setNum(0);
//                                dbUtils.save(collect);
//                                list = dbUtils.findAll(Collect.class);
//                                Log.i("queryAllRecord------->", list.toString());
//                                adapter.list=list;
//                                adapter.notifyDataSetChanged();
//                                Toast.makeText(SceneryActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
//                            } catch (DbException e) {
//                                e.printStackTrace();
//                            }
//                            flag = false;
//                        }else {
//                            ivCollect.setImageResource(R.mipmap.btn_favorite);
//                            try {
//                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "天涯海角旅游景区"));
//                                list = dbUtils.findAll(Collect.class);
//                                adapter.list = list;
//                                adapter.notifyDataSetChanged();
//                            } catch (DbException e) {
//                                e.printStackTrace();
//                            }
//                            Toast.makeText(SceneryActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
//                            flag = true;
//                        }

                        break;
                    case 4:
                        if(flag){
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                            //tv_edit.setText("编辑");
                            try {
                                Log.i("test","pppppppppppppppppppp");

                                collect.setFlag(true);
                                collect.setFg(true);
                                collect.setImage(R.mipmap.favorites_list_item_icon_scene);
                                collect.setName("大东海旅游度假区");
                                collect.setType("景点");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                Log.i("queryAllRecord------->", list.toString());
                                adapter.list=list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(SceneryActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                        }else {
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                            try {
                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "大东海旅游度假区"));
                                list = dbUtils.findAll(Collect.class);
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(SceneryActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
                            flag = true;
                        }

                        break;
                    case 5:
                        if(flag){
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                            //tv_edit.setText("编辑");
                            try {
                                Log.i("test","pppppppppppppppppppp");

                                collect.setFlag(true);
                                collect.setFg(true);
                                collect.setImage(R.mipmap.favorites_list_item_icon_scene);
                                collect.setName("三亚湾旅游度假区");
                                collect.setType("景点");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                Log.i("queryAllRecord------->", list.toString());
                                adapter.list=list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(SceneryActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                        }else {
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                            try {
                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "三亚湾旅游度假区"));
                                list = dbUtils.findAll(Collect.class);
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(SceneryActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
                            flag = true;
                        }

                        break;
                    case 6:
                        if(flag){
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                            //tv_edit.setText("编辑");
                            try {
                                Log.i("test","pppppppppppppppppppp");

                                collect.setFlag(true);
                                collect.setFg(true);
                                collect.setImage(R.mipmap.favorites_list_item_icon_scene);
                                collect.setName("大小洞天景区");
                                collect.setType("景点");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                Log.i("queryAllRecord------->", list.toString());
                                adapter.list=list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(SceneryActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                        }else {
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                            try {
                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "大小洞天景区"));
                                list = dbUtils.findAll(Collect.class);
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(SceneryActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
                            flag = true;
                        }

                        break;
                    case 7:
                        if(flag){
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                            //tv_edit.setText("编辑");
                            try {
                                collect.setFlag(true);
                                collect.setFg(true);
                                collect.setImage(R.mipmap.favorites_list_item_icon_scene);
                                collect.setName("呀诺达雨林景区");
                                collect.setType("景点");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                Log.i("queryAllRecord------->", list.toString());
                                adapter.list=list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(SceneryActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                        }else {
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                            try {
                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "呀诺达雨林景区"));
                                list = dbUtils.findAll(Collect.class);
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(SceneryActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
                            flag = true;
                        }

                        break;
                    case 8:
                        if(flag){
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                            //tv_edit.setText("编辑");
                            try {
                                collect.setFlag(true);
                                collect.setFg(true);
                                collect.setImage(R.mipmap.favorites_list_item_icon_scene);
                                collect.setName("南山寺景区");
                                collect.setType("景点");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                Log.i("queryAllRecord------->", list.toString());
                                adapter.list=list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(SceneryActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                        }else {
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                            try {
                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "南山寺景区"));
                                list = dbUtils.findAll(Collect.class);
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(SceneryActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
                            flag = true;
                        }

                        break;
                    case 9:
                        if(flag){
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                            //tv_edit.setText("编辑");
                            try {
                                collect.setFlag(true);
                                collect.setFg(true);
                                collect.setImage(R.mipmap.favorites_list_item_icon_scene);
                                collect.setName("南田温泉");
                                collect.setType("景点");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                Log.i("queryAllRecord------->", list.toString());
                                adapter.list=list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(SceneryActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                        }else {
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                            try {
                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "南田温泉"));
                                list = dbUtils.findAll(Collect.class);
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(SceneryActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
                            flag = true;
                        }

                        break;
                    case 10:
                        if(flag){
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                            //tv_edit.setText("编辑");
                            try {
                                Log.i("test","pppppppppppppppppppp");

                                collect.setFlag(true);
                                collect.setFg(true);
                                collect.setImage(R.mipmap.favorites_list_item_icon_scene);
                                collect.setName("西岛(西玳瑁洲)景区");
                                collect.setType("景点");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                Log.i("queryAllRecord------->", list.toString());
                                adapter.list=list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(SceneryActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                        }else {
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                            try {
                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "西岛(西玳瑁洲)景区"));
                                list = dbUtils.findAll(Collect.class);
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(SceneryActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
                            flag = true;
                        }

                        break;
                    case 11:
                        if(flag){
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                            //tv_edit.setText("编辑");
                            try {
                                collect.setFlag(true);
                                collect.setFg(true);
                                collect.setImage(R.mipmap.favorites_list_item_icon_scene);
                                collect.setName("鹿回头景区");
                                collect.setType("景点");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                Log.i("queryAllRecord------->", list.toString());
                                adapter.list=list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(SceneryActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                        }else {
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                            try {
                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "鹿回头景区"));
                                list = dbUtils.findAll(Collect.class);
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(SceneryActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
                            flag = true;
                        }

                        break;

                }
            }
        });

        Log.i(TAG, "num-->" + num);
        InputStream is = null;
        switch (num) {
            case 0:
                try {
                    ivCover.setImageBitmap(BitmapFactory.decodeStream(getResources().getAssets().open("Scene7.jpg")));
                    is = getResources().getAssets().open("00004103json.txt");
                    try {
                        list = dbUtils.findAll(Selector.from(Collect.class).where("name", "=", "蜈支洲岛").orderBy("name",true));
                        if (list != null && list.size()!= 0){
                            adapter.list = list;
                            adapter.notifyDataSetChanged();
                            flag=false;
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                        }else {
                            flag = true;
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                        }
                    } catch (DbException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;
            case 1:
                try {
                    ivCover.setImageBitmap(BitmapFactory.decodeStream(getResources().getAssets().open("Scene1.jpg")));
                    is = getResources().getAssets().open("00004101json.txt");
                    try {
                        list = dbUtils.findAll(Selector.from(Collect.class).where("name", "=", "亚龙湾旅游度假区").orderBy("name",true));
                        if (list != null &&list.size()!= 0){
                            adapter.list = list;
                            adapter.notifyDataSetChanged();
                            flag=false;
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                        }else {
                            flag = true;
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                        }
                    } catch (DbException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    ivCover.setImageBitmap(BitmapFactory.decodeStream(getResources().getAssets().open("Scene5.jpg")));
                    is = getResources().getAssets().open("00004102json.txt");
                    try {
                        list = dbUtils.findAll(Selector.from(Collect.class).where("name", "=", "亚热带天堂森林公园").orderBy("name",true));
                        if (list != null &&list.size()!= 0){
                            adapter.list = list;
                            adapter.notifyDataSetChanged();
                            flag=false;
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                        }else {
                            flag = true;
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                        }
                    } catch (DbException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                try {
                    ivCover.setImageBitmap(BitmapFactory.decodeStream(getResources().getAssets().open("Scene13.jpg")));
                    is = getResources().getAssets().open("00004108json.txt");
                    try {
                        list = dbUtils.findAll(Selector.from(Collect.class).where("name", "=", "天涯海角旅游景区").orderBy("name",true));
                        if (list != null &&list.size()!= 0){
                            adapter.list = list;
                            adapter.notifyDataSetChanged();
                            flag=false;
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                        }else {
                            flag = true;
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                        }
                    } catch (DbException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 4:
                try {
                    ivCover.setImageBitmap(BitmapFactory.decodeStream(getResources().getAssets().open("Scene9.jpg")));
                    is = getResources().getAssets().open("00004105json.txt");
                    try {
                        list = dbUtils.findAll(Selector.from(Collect.class).where("name", "=", "大东海旅游度假区").orderBy("name",true));
                        if (list != null &&list.size()!= 0){
                            adapter.list = list;
                            adapter.notifyDataSetChanged();
                            flag=false;
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                        }else {
                            flag = true;
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                        }
                    } catch (DbException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 5:
                try {
                    ivCover.setImageBitmap(BitmapFactory.decodeStream(getResources().getAssets().open("scene10.jpg")));
                    is = getResources().getAssets().open("00004106json.txt");
                    try {
                        list = dbUtils.findAll(Selector.from(Collect.class).where("name", "=", "三亚湾旅游度假区").orderBy("name",true));
                        if (list != null &&list.size()!= 0){
                            adapter.list = list;
                            adapter.notifyDataSetChanged();
                            flag=false;
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                        }else {
                            flag = true;
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                        }
                    } catch (DbException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 6:
                try {
                    ivCover.setImageBitmap(BitmapFactory.decodeStream(getResources().getAssets().open("Scene12.jpg")));
                    is = getResources().getAssets().open("00004107json.txt");
                    try {
                        list = dbUtils.findAll(Selector.from(Collect.class).where("name", "=", "大小洞天景区").orderBy("name",true));
                        if (list != null &&list.size()!= 0){
                            adapter.list = list;
                            adapter.notifyDataSetChanged();
                            flag=false;
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                        }else {
                            flag = true;
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                        }
                    } catch (DbException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 7:
                try {
                    ivCover.setImageBitmap(BitmapFactory.decodeStream(getResources().getAssets().open("Scene14.jpg")));
                    is = getResources().getAssets().open("00004109json.txt");
                    try {
                        list = dbUtils.findAll(Selector.from(Collect.class).where("name", "=", "呀诺达雨林景区").orderBy("name",true));
                        if (list != null &&list.size()!= 0){
                            adapter.list = list;
                            adapter.notifyDataSetChanged();
                            flag=false;
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                        }else {
                            flag = true;
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                        }
                    } catch (DbException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 8:
                try {
                    ivCover.setImageBitmap(BitmapFactory.decodeStream(getResources().getAssets().open("Scene15.jpg")));
                    is = getResources().getAssets().open("00004110json.txt");
                    try {
                        list = dbUtils.findAll(Selector.from(Collect.class).where("name", "=", "南山寺景区").orderBy("name",true));
                        if (list != null &&list.size()!= 0){
                            adapter.list = list;
                            adapter.notifyDataSetChanged();
                            flag=false;
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                        }else {
                            flag = true;
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                        }
                    } catch (DbException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 9:
                try {
                    ivCover.setImageBitmap(BitmapFactory.decodeStream(getResources().getAssets().open("Scene8.jpg")));
                    is = getResources().getAssets().open("00004104json.txt");
                    try {
                        list = dbUtils.findAll(Selector.from(Collect.class).where("name", "=", "南田温泉").orderBy("name",true));
                        if (list != null &&list.size()!= 0){
                            adapter.list = list;
                            adapter.notifyDataSetChanged();
                            flag=false;
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                        }else {
                            flag = true;
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                        }
                    } catch (DbException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 10:
                try {
                    ivCover.setImageBitmap(BitmapFactory.decodeStream(getResources().getAssets().open("Scene.jpg")));
                    is = getResources().getAssets().open("00004112json.txt");
                    try {
                        list = dbUtils.findAll(Selector.from(Collect.class).where("name", "=", "西岛(西玳瑁洲)景区").orderBy("name",true));
                        if (list != null &&list.size()!= 0){
                            adapter.list = list;
                            adapter.notifyDataSetChanged();
                            flag=false;
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                        }else {
                            flag = true;
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                        }
                    } catch (DbException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 11:
                try {
                    ivCover.setImageBitmap(BitmapFactory.decodeStream(getResources().getAssets().open("Scene16.jpg")));
                    is = getResources().getAssets().open("00004111json.txt");
                    try {
                        list = dbUtils.findAll(Selector.from(Collect.class).where("name", "=", "鹿回头景区").orderBy("name",true));
                        if (list != null &&list.size()!= 0){
                            adapter.list = list;
                            adapter.notifyDataSetChanged();
                            flag=false;
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                        }else {
                            flag = true;
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                        }
                    } catch (DbException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }

//        InputStream is = null;
//        try {
//            switch(num){
//                case 0:
//                    is = getResources().getAssets().open("00004103json.txt");
//                    break;
//                case 1:
//                    is = getResources().getAssets().open("00004103json.txt");
//                    break;
//            }
//        }catch(Exception e){}

        SceneryInfo sceneryInfo = JsonSceneryInfo.parse(FileUtils.readFile(is));
        if (sceneryInfo.getList().size() == 7) {
            traffic = sceneryInfo.getList().get(4).getContents();
            suggest = sceneryInfo.getList().get(5).getContents();
            guide = sceneryInfo.getList().get(6).getContents();
            traffic = traffic.replace("\",\"", "\n");
            guide = guide.replace("\",\"", "\n");
            suggest = suggest.replace("\",\"", "\n");

            setContentWithPhone(sceneryInfo.getName(), Integer.parseInt(sceneryInfo.getLevel()), sceneryInfo.getLevelDesc(), sceneryInfo.getIntroduce(), sceneryInfo.getList().get(0).getContents(),
                    sceneryInfo.getList().get(1).getContents(), sceneryInfo.getList().get(2).getContents(), sceneryInfo.getList().get(3).getContents(), traffic, suggest, guide);
        } else {
            traffic = sceneryInfo.getList().get(3).getContents();
            suggest = sceneryInfo.getList().get(4).getContents();
            guide = sceneryInfo.getList().get(5).getContents();
            traffic = traffic.replace("\",\"", "\n");
            guide = guide.replace("\",\"", "\n");
            suggest = suggest.replace("\",\"", "\n");

            setContentNoPhone(sceneryInfo.getName(), Integer.parseInt(sceneryInfo.getLevel()), sceneryInfo.getLevelDesc(), sceneryInfo.getIntroduce(), sceneryInfo.getList().get(0).getContents(), sceneryInfo.getList().get(1).getContents(), sceneryInfo.getList().get(2).getContents(),
                    traffic, suggest, guide);
        }
        llTraffic.setOnClickListener(this);
        llGuide.setOnClickListener(this);
        llSuggest.setOnClickListener(this);
    }

    public void setContentWithPhone(String name, int rtNum, String title, String content, String price, String time, String address, String phone, String traffic, String suggest, String guide) {
        tvName.setText(name);
        tvSubName.setText(name);
        rbarLevel.setRating(5 * rtNum / 5);
        tvLevelDesc.setText(title);
        tvIntroduce.setText(content);
        tvTicketContent.setText(price);
        tvTimeContent.setText(time);
        tvAddressContents.setText(address);
        tvPhoneContents.setText(phone);
        tvTrafficContent.setText(traffic);
        tvNoteContent.setText(suggest);
        tvBrowerContent.setText(guide);
    }

    public void setContentNoPhone(String name, int rtNum, String title, String content, String price, String time, String address, String traffic, String suggest, String guide) {
        ll_phone = (LinearLayout) findViewById(R.id.ll_phone);
        ll_phone.setVisibility(View.GONE);
        tvName.setText(name);
        tvSubName.setText(name);
        rbarLevel.setRating(5 * rtNum / 5);
        tvLevelDesc.setText(title);
        tvIntroduce.setText(content);
        tvTicketContent.setText(price);
        tvTimeContent.setText(time);
        tvAddressContents.setText(address);
        tvTrafficContent.setText(traffic);
        tvNoteContent.setText(suggest);
        tvBrowerContent.setText(guide);

    }

    public void click(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_traffic:
                Log.i("TAG", "traffic 2===>>" + trafficNum);
                tvTrafficContent.setMaxLines(50);
                tvTrafficContent.setText(traffic);
                break;
            case R.id.ll_guide:
                tvBrowerContent.setMaxLines(50);
                tvBrowerContent.setText(guide);
                break;
            case R.id.ll_suggest:
                tvNoteContent.setMaxLines(50);
                tvNoteContent.setText(suggest);
                break;
        }
    }
}
