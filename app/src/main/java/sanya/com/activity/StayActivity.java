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

public class StayActivity extends AppCompatActivity {

    private static final String TAG = "StayActivity";
    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.iv_position)
    ImageView ivPosition;
    @BindView(R.id.iv_cover)
    ImageView ivCover;
    @BindView(R.id.tv_subName)
    TextView tvSubName;
    @BindView(R.id.iv_collect)
    ImageView ivCollect;
    @BindView(R.id.rbar_level)
    RatingBar rbarLevel;
    @BindView(R.id.tv_levelDesc)
    TextView tvLevelDesc;
    @BindView(R.id.tv_introduce)
    TextView tvIntroduce;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_priceContent)
    TextView tvPriceContent;
    @BindView(R.id.tv_rank)
    TextView tvRank;
    @BindView(R.id.tv_rankContent)
    TextView tvRankContent;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tv_addressContents)
    TextView tvAddressContents;
    @BindView(R.id.iv_address)
    ImageView ivAddress;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_phoneContents)
    TextView tvPhoneContents;
    @BindView(R.id.iv_phone)
    ImageView ivPhone;
    @BindView(R.id.ll_phone)
    LinearLayout llPhone;
    @BindView(R.id.sl_sceneryInfo)
    ScrollView slSceneryInfo;

    private int num;
    private boolean flag = true;
    private Collect collect;

    private DbUtils dbUtils;
    private CollectAdapter adapter;
    private List<Collect> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stay);

        dbUtils = DbUtils.create(StayActivity.this, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath(), "Collect2");
        collect = new Collect();
        adapter = new CollectAdapter(list,this,null);

        ButterKnife.bind(this);
//        getSupportActionBar().hide();
        rbarLevel.setMax(5);
        num = getIntent().getIntExtra("key", 0);
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
                                collect.setImage(R.mipmap.favorites_list_item_icon_hotel);
                                collect.setName("亚龙湾人间天堂-鸟巢度假村");
                                collect.setType("住宿");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                adapter.list=list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(StayActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                        }else {
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                            try {
                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "亚龙湾人间天堂-鸟巢度假村"));
                                list = dbUtils.findAll(Collect.class);
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(StayActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
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
                                collect.setImage(R.mipmap.favorites_list_item_icon_hotel);
                                collect.setName("三亚喜来登度假酒店");
                                collect.setType("住宿");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                Log.i("queryAllRecord------->", list.toString());
                                adapter.list=list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(StayActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                        }else {
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                            try {
                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "三亚喜来登度假酒店"));
                                list = dbUtils.findAll(Collect.class);
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(StayActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
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
                                collect.setImage(R.mipmap.favorites_list_item_icon_hotel);
                                collect.setName("万达三亚海棠希尔顿逸林度假酒店");
                                collect.setType("住宿");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                Log.i("queryAllRecord------->", list.toString());
                                adapter.list=list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(StayActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                        }else {
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                            try {
                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "万达三亚海棠希尔顿逸林度假酒店"));
                                list = dbUtils.findAll(Collect.class);
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(StayActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
                            flag = true;
                        }

                        break;
                    case 3:
                        if(flag){
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                            //tv_edit.setText("编辑");
                            try {
                                Log.i("test","pppppppppppppppppppp");

                                collect.setFlag(true);
                                collect.setFg(true);
                                collect.setImage(R.mipmap.favorites_list_item_icon_hotel);
                                collect.setName("维景国际度假酒店");
                                collect.setType("住宿");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                Log.i("queryAllRecord------->", list.toString());
                                adapter.list=list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(StayActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                        }else {
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                            try {
                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "维景国际度假酒店"));
                                list = dbUtils.findAll(Collect.class);
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(StayActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
                            flag = true;
                        }

                        break;
                    case 4:
                        if(flag){
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                            //tv_edit.setText("编辑");
                            try {
                                Log.i("test","pppppppppppppppppppp");

                                collect.setFlag(true);
                                collect.setFg(true);
                                collect.setImage(R.mipmap.favorites_list_item_icon_hotel);
                                collect.setName("三亚凯莱仙人掌度假酒店");
                                collect.setType("住宿");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                Log.i("queryAllRecord------->", list.toString());
                                adapter.list=list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(StayActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                        }else {
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                            try {
                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "三亚凯莱仙人掌度假酒店"));
                                list = dbUtils.findAll(Collect.class);
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(StayActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
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
                                collect.setImage(R.mipmap.favorites_list_item_icon_hotel);
                                collect.setName("金棕榈度假酒店");
                                collect.setType("住宿");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                Log.i("queryAllRecord------->", list.toString());
                                adapter.list=list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(StayActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                        }else {
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                            try {
                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "金棕榈度假酒店"));
                                list = dbUtils.findAll(Collect.class);
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(StayActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
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
                                collect.setImage(R.mipmap.favorites_list_item_icon_hotel);
                                collect.setName("三亚明申锦江高尔夫酒店");
                                collect.setType("住宿");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                Log.i("queryAllRecord------->", list.toString());
                                adapter.list=list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(StayActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                        }else {
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                            try {
                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "三亚明申锦江高尔夫酒店"));
                                list = dbUtils.findAll(Collect.class);
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(StayActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
                            flag = true;
                        }

                        break;
                    case 7:
                        if(flag){
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                            //tv_edit.setText("编辑");
                            try {
                                Log.i("test","pppppppppppppppppppp");

                                collect.setFlag(true);
                                collect.setFg(true);
                                collect.setImage(R.mipmap.favorites_list_item_icon_hotel);
                                collect.setName("三亚世纪山水酒店");
                                collect.setType("住宿");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                Log.i("queryAllRecord------->", list.toString());
                                adapter.list=list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(StayActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                        }else {
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                            try {
                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "三亚世纪山水酒店"));
                                list = dbUtils.findAll(Collect.class);
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(StayActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
                            flag = true;
                        }

                        break;
                    case 8:
                        if(flag){
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                            //tv_edit.setText("编辑");
                            try {
                                Log.i("test","pppppppppppppppppppp");

                                collect.setFlag(true);
                                collect.setFg(true);
                                collect.setImage(R.mipmap.favorites_list_item_icon_hotel);
                                collect.setName("金广快捷酒店");
                                collect.setType("住宿");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                Log.i("queryAllRecord------->", list.toString());
                                adapter.list=list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(StayActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                        }else {
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                            try {
                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "金广快捷酒店"));
                                list = dbUtils.findAll(Collect.class);
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(StayActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
                            flag = true;
                        }

                        break;
                    case 9:
                        if(flag){
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                            //tv_edit.setText("编辑");
                            try {
                                Log.i("test","pppppppppppppppppppp");

                                collect.setFlag(true);
                                collect.setFg(true);
                                collect.setImage(R.mipmap.favorites_list_item_icon_hotel);
                                collect.setName("三亚盛福源大酒店");
                                collect.setType("住宿");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                Log.i("queryAllRecord------->", list.toString());
                                adapter.list=list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(StayActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                        }else {
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                            try {
                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "三亚盛福源大酒店"));
                                list = dbUtils.findAll(Collect.class);
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(StayActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
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
                                collect.setImage(R.mipmap.favorites_list_item_icon_hotel);
                                collect.setName("三亚兰海度假酒店公寓");
                                collect.setType("住宿");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                Log.i("queryAllRecord------->", list.toString());
                                adapter.list=list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(StayActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                        }else {
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                            try {
                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "三亚兰海度假酒店公寓"));
                                list = dbUtils.findAll(Collect.class);
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(StayActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
                            flag = true;
                        }

                        break;
                    case 11:
                        if(flag){
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                            //tv_edit.setText("编辑");
                            try {
                                Log.i("test","pppppppppppppppppppp");

                                collect.setFlag(true);
                                collect.setFg(true);
                                collect.setImage(R.mipmap.favorites_list_item_icon_hotel);
                                collect.setName("三亚远方有一层精品客栈");
                                collect.setType("住宿");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                Log.i("queryAllRecord------->", list.toString());
                                adapter.list=list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(StayActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                        }else {
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                            try {
                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "三亚远方有一层精品客栈"));
                                list = dbUtils.findAll(Collect.class);
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(StayActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
                            flag = true;
                        }

                        break;
                    case 12:
                        if(flag){
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                            //tv_edit.setText("编辑");
                            try {
                                Log.i("test","pppppppppppppppppppp");

                                collect.setFlag(true);
                                collect.setFg(true);
                                collect.setImage(R.mipmap.favorites_list_item_icon_hotel);
                                collect.setName("三亚七彩假日旅社家庭旅馆");
                                collect.setType("住宿");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                Log.i("queryAllRecord------->", list.toString());
                                adapter.list=list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(StayActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                        }else {
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                            try {
                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "三亚七彩假日旅舍家庭旅馆"));
                                list = dbUtils.findAll(Collect.class);
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(StayActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
                            flag = true;
                        }

                        break;
                    case 13:
                        if(flag){
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                            //tv_edit.setText("编辑");
                            try {
                                Log.i("test","pppppppppppppppppppp");

                                collect.setFlag(true);
                                collect.setFg(true);
                                collect.setImage(R.mipmap.favorites_list_item_icon_hotel);
                                collect.setName("三亚蓝天国际青年旅舍");
                                collect.setType("住宿");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                Log.i("queryAllRecord------->", list.toString());
                                adapter.list=list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(StayActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                        }else {
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                            try {
                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "三亚蓝天国际青年旅舍"));
                                list = dbUtils.findAll(Collect.class);
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(StayActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
                            flag = true;
                        }

                        break;
                    case 14:
                        if(flag){
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                            //tv_edit.setText("编辑");
                            try {
                                Log.i("test","pppppppppppppppppppp");

                                collect.setFlag(true);
                                collect.setFg(true);
                                collect.setImage(R.mipmap.favorites_list_item_icon_hotel);
                                collect.setName("三亚迷途驴友国际青年旅舍");
                                collect.setType("住宿");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                Log.i("queryAllRecord------->", list.toString());
                                adapter.list=list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(StayActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                        }else {
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                            try {
                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "三亚迷途驴友国际青年旅舍"));
                                list = dbUtils.findAll(Collect.class);
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(StayActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
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
                    ivCover.setImageBitmap(BitmapFactory.decodeStream(getResources().getAssets().open("Hotel1.jpg")));
                    is = getResources().getAssets().open("00004401json.txt");
                    try {
                        list = dbUtils.findAll(Selector.from(Collect.class).where("name", "=", "亚龙湾人间天堂-鸟巢度假村").orderBy("name",true));
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
                    ivCover.setImageBitmap(BitmapFactory.decodeStream(getResources().getAssets().open("Hotel2.jpg")));
                    is = getResources().getAssets().open("00004402json.txt");
                    try {
                        list = dbUtils.findAll(Selector.from(Collect.class).where("name", "=", "三亚喜来登度假酒店").orderBy("name",true));
                        if (list != null && list.size()!= 0){
                            Log.i("favorite","44444444444");
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
                    ivCover.setImageBitmap(BitmapFactory.decodeStream(getResources().getAssets().open("Hotel3.jpg")));
                    is = getResources().getAssets().open("00004403json.txt");
                    try {
                        list = dbUtils.findAll(Selector.from(Collect.class).where("name", "=", "万达三亚海棠湾希尔顿逸林度假酒店").orderBy("name",true));
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
            case 3:
                try {
                    ivCover.setImageBitmap(BitmapFactory.decodeStream(getResources().getAssets().open("Hotel4.jpg")));
                    is = getResources().getAssets().open("00004404json.txt");
                    try {
                        list = dbUtils.findAll(Selector.from(Collect.class).where("name", "=", "维景国际度假酒店").orderBy("name",true));
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
            case 4:
                try {
                    ivCover.setImageBitmap(BitmapFactory.decodeStream(getResources().getAssets().open("Hotel5.jpg")));
                    is = getResources().getAssets().open("00004405json.txt");
                    try {
                        list = dbUtils.findAll(Selector.from(Collect.class).where("name", "=", "三亚凯莱仙人掌度假酒店").orderBy("name",true));
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
            case 5:
                try {
                    ivCover.setImageBitmap(BitmapFactory.decodeStream(getResources().getAssets().open("Hotel6.jpg")));
                    is = getResources().getAssets().open("00004406json.txt");
                    try {
                        list = dbUtils.findAll(Selector.from(Collect.class).where("name", "=", "金棕榈度假酒店").orderBy("name",true));
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
            case 6:
                try {
                    ivCover.setImageBitmap(BitmapFactory.decodeStream(getResources().getAssets().open("Hotel7.jpg")));
                    is = getResources().getAssets().open("00004407json.txt");
                    try {
                        list = dbUtils.findAll(Selector.from(Collect.class).where("name", "=", "三亚明申锦江高尔夫酒店").orderBy("name",true));
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
            case 7:
                try {
                    ivCover.setImageBitmap(BitmapFactory.decodeStream(getResources().getAssets().open("Hotel8.jpg")));
                    is = getResources().getAssets().open("00004408json.txt");
                    try {
                        list = dbUtils.findAll(Selector.from(Collect.class).where("name", "=", "三亚世纪山水酒店").orderBy("name",true));
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
            case 8:
                try {
                    ivCover.setImageBitmap(BitmapFactory.decodeStream(getResources().getAssets().open("Hotel9.jpg")));
                    is = getResources().getAssets().open("00004409json.txt");
                    try {
                        list = dbUtils.findAll(Selector.from(Collect.class).where("name", "=", "金广快捷酒店").orderBy("name",true));
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
            case 9:
                try {
                    ivCover.setImageBitmap(BitmapFactory.decodeStream(getResources().getAssets().open("Hotel10.jpg")));
                    is = getResources().getAssets().open("00004410json.txt");
                    try {
                        list = dbUtils.findAll(Selector.from(Collect.class).where("name", "=", "三亚盛福源大酒店").orderBy("name",true));
                        if (list != null &&  list.size()!= 0){
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
                    ivCover.setImageBitmap(BitmapFactory.decodeStream(getResources().getAssets().open("Hotel11.jpg")));
                    is = getResources().getAssets().open("00004411json.txt");
                    try {
                        list = dbUtils.findAll(Selector.from(Collect.class).where("name", "=", "三亚兰海度假酒店公寓").orderBy("name",true));
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
            case 11:
                try {
                    ivCover.setImageBitmap(BitmapFactory.decodeStream(getResources().getAssets().open("Hotel2.jpg")));
                    is = getResources().getAssets().open("00004412json.txt");
                    try {
                        list = dbUtils.findAll(Selector.from(Collect.class).where("name", "=", "三亚远方有一层精品客栈").orderBy("name",true));
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
            case 12:
                try {
                    ivCover.setImageBitmap(BitmapFactory.decodeStream(getResources().getAssets().open("Hotel3.jpg")));
                    is = getResources().getAssets().open("00004413json.txt");
                    try {
                        list = dbUtils.findAll(Selector.from(Collect.class).where("name", "=", "三亚七彩假日旅社家庭旅馆").orderBy("name",true));
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
            case 13:
                try {
                    ivCover.setImageBitmap(BitmapFactory.decodeStream(getResources().getAssets().open("Hotel7.jpg")));
                    is = getResources().getAssets().open("00004414json.txt");
                    try {
                        list = dbUtils.findAll(Selector.from(Collect.class).where("name", "=", "三亚蓝天国际青年旅舍").orderBy("name",true));
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
            case 14:
                try {
                    ivCover.setImageBitmap(BitmapFactory.decodeStream(getResources().getAssets().open("Hotel9.jpg")));
                    is = getResources().getAssets().open("00004415json.txt");
                    try {
                        list = dbUtils.findAll(Selector.from(Collect.class).where("name", "=", "三亚迷途驴友国际青年旅舍").orderBy("name",true));
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
        }
        SceneryInfo sceneryInfo = JsonSceneryInfo.parse(FileUtils.readFile(is));
        setContentWithPhone(sceneryInfo.getName(), Integer.parseInt(sceneryInfo.getLevel()), sceneryInfo.getLevelDesc(), sceneryInfo.getIntroduce(), sceneryInfo.getList().get(0).getContents(),
                sceneryInfo.getList().get(1).getContents(), sceneryInfo.getList().get(2).getContents(), sceneryInfo.getList().get(3).getContents());


    }

    public void setContentWithPhone(String name, int rtNum, String title, String content, String price, String rank, String address, String phone) {
        tvName.setText(name);
        tvSubName.setText(name);
        rbarLevel.setRating(5 * rtNum / 5);
        tvLevelDesc.setText(title);
        tvIntroduce.setText(content);
        tvPriceContent.setText(price);
        tvRankContent.setText(rank);
        tvAddressContents.setText(address);
        tvPhoneContents.setText(phone);
    }
    public void click(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;

        }
    }

}
