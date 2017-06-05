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
import com.lidroid.xutils.db.sqlite.WhereBuilder;
import com.lidroid.xutils.exception.DbException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import sanya.com.Utils.SaveUtils;
import sanya.com.adapter.CollectAdapter;
import sanya.com.bean.Collect;
import sanya.com.bean.SceneryInfo;
import sanya.com.sanya.R;
import sanya.com.tools.FileUtils;
import sanya.com.tools.JsonSceneryInfo;

public class ShopDetailActivity extends AppCompatActivity {

    private boolean flag = true;

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
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.ll_address)
    LinearLayout llAddress;
    @BindView(R.id.tv_ticket)
    TextView tvTicket;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.ll_phone)
    LinearLayout llPhone;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.ll_time)
    LinearLayout llTime;
    @BindView(R.id.tv_trafficTitle)
    TextView tvTrafficTitle;
    @BindView(R.id.tv_traffic)
    TextView tvTraffic;
    @BindView(R.id.ll_traffic)
    LinearLayout llTraffic;
    @BindView(R.id.tv_buy)
    TextView tvBuy;
    @BindView(R.id.ll_buy)
    LinearLayout llBuy;
    @BindView(R.id.sl_sceneryInfo)
    ScrollView slsceneryInfo;

    private DbUtils dbUtils;
    private CollectAdapter adapter;
    private List<Collect> list = new ArrayList<>();
    private Collect collect;
    private int num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_detail);
        ButterKnife.bind(this);
//        getSupportActionBar().hide();

        dbUtils = DbUtils.create(ShopDetailActivity.this, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath(), "Collect2");
        collect = new Collect();
        adapter = new CollectAdapter(list,this,null);

        ivCollect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (num) {
                    case 0:
                        if (flag) {
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                            //tv_edit.setText("编辑");
                            try {
                                Log.i("test", "pppppppppppppppppppp");

                                collect.setFlag(true);
                                collect.setFg(true);
                                collect.setImage(R.mipmap.favorites_list_item_icon_market);
                                collect.setName("免税店购物");
                                collect.setType("购物");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                Log.i("queryAllRecord------->", list.toString());
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(ShopDetailActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                        } else {
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                            try {
                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "免税店购物"));
                                list = dbUtils.findAll(Collect.class);
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(ShopDetailActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
                            flag = true;
                        }

                        break;
                    case 1:
                        if (flag) {
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                            //tv_edit.setText("编辑");
                            try {
                                Log.i("test", "pppppppppppppppppppp");

                                collect.setFlag(true);
                                collect.setFg(true);
                                collect.setImage(R.mipmap.favorites_list_item_icon_market);
                                collect.setName("第一市场");
                                collect.setType("购物");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                Log.i("queryAllRecord------->", list.toString());
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(ShopDetailActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                        } else {
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                            try {
                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "第一市场"));
                                list = dbUtils.findAll(Collect.class);
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(ShopDetailActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
                            flag = true;
                        }

                        break;
                    case 2:
                        if (flag) {
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                            //tv_edit.setText("编辑");
                            try {
                                Log.i("test", "pppppppppppppppppppp");

                                collect.setFlag(true);
                                collect.setFg(true);
                                collect.setImage(R.mipmap.favorites_list_item_icon_market);
                                collect.setName("鸿港水果市场");
                                collect.setType("购物");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                Log.i("queryAllRecord------->", list.toString());
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(ShopDetailActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                        } else {
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                            try {
                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "鸿港水果市场"));
                                list = dbUtils.findAll(Collect.class);
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(ShopDetailActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
                            flag = true;
                        }

                        break;
                    case 3:
                        if (flag) {
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                            //tv_edit.setText("编辑");
                            try {
                                Log.i("test", "pppppppppppppppppppp");

                                collect.setFlag(true);
                                collect.setFg(true);
                                collect.setImage(R.mipmap.favorites_list_item_icon_market);
                                collect.setName("旺豪超市");
                                collect.setType("购物");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                Log.i("queryAllRecord------->", list.toString());
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(ShopDetailActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                        } else {
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                            try {
                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "旺豪超市"));
                                list = dbUtils.findAll(Collect.class);
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(ShopDetailActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
                            flag = true;
                        }

                        break;
                    case 4:
                        if (flag) {
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                            //tv_edit.setText("编辑");
                            try {
                                Log.i("test", "pppppppppppppppppppp");

                                collect.setFlag(true);
                                collect.setFg(true);
                                collect.setImage(R.mipmap.favorites_list_item_icon_market);
                                collect.setName("红旗街");
                                collect.setType("购物");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                Log.i("queryAllRecord------->", list.toString());
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(ShopDetailActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                        } else {
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                            try {
                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "红旗街"));
                                list = dbUtils.findAll(Collect.class);
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(ShopDetailActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
                            flag = true;
                        }

                        break;
                    case 5:
                        if (flag) {
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                            //tv_edit.setText("编辑");
                            try {
                                Log.i("test", "pppppppppppppppppppp");

                                collect.setFlag(true);
                                collect.setFg(true);
                                collect.setImage(R.mipmap.favorites_list_item_icon_market);
                                collect.setName("解放路步行街");
                                collect.setType("购物");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                Log.i("queryAllRecord------->", list.toString());
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(ShopDetailActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                        } else {
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                            try {
                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "解放路步行街"));
                                list = dbUtils.findAll(Collect.class);
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(ShopDetailActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
                            flag = true;
                        }

                        break;
                    case 6:
                        if (flag) {
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                            //tv_edit.setText("编辑");
                            try {
                                Log.i("test", "pppppppppppppppppppp");

                                collect.setFlag(true);
                                collect.setFg(true);
                                collect.setImage(R.mipmap.favorites_list_item_icon_market);
                                collect.setName("明珠广场");
                                collect.setType("购物");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                Log.i("queryAllRecord------->", list.toString());
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(ShopDetailActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                        } else {
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                            try {
                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "明珠广场"));
                                list = dbUtils.findAll(Collect.class);
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(ShopDetailActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
                            flag = true;
                        }

                        break;
                }
            }
        });

        rbarLevel.setMax(5);
        num = getIntent().getIntExtra("key", 0);
        InputStream is = null;

        switch (num) {
            case 0:
                try {
                    ivCover.setImageBitmap(BitmapFactory.decodeStream(getResources().getAssets().open("shopping6.jpg")));
                    is = getResources().getAssets().open("00004206json.txt");
                    SceneryInfo sceneryInfo = JsonSceneryInfo.parse(FileUtils.readFile(is));

                    SaveUtils saveUtils = new SaveUtils(this ,flag, ivCollect ,is, sceneryInfo);
                    saveUtils.Save();

                    tvName.setText(sceneryInfo.getName());
                    tvSubName.setText(sceneryInfo.getName());
                    rbarLevel.setRating(5 * Integer.parseInt(sceneryInfo.getLevel()) / 5);
                    tvLevelDesc.setText(sceneryInfo.getLevelDesc());
                    tvIntroduce.setText(sceneryInfo.getIntroduce());

                    tvAddress.setText(sceneryInfo.getList().get(0).getContents());
                    tvPhone.setText(sceneryInfo.getList().get(1).getContents());
                    tvTime.setText(sceneryInfo.getList().get(2).getContents());
                    tvTraffic.setText(sceneryInfo.getList().get(3).getContents());
                    tvBuy.setText(sceneryInfo.getList().get(4).getContents());

                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;
            case 1:
                try {
                    ivCover.setImageBitmap(BitmapFactory.decodeStream(getResources().getAssets().open("Shopping2.jpg")));
                    is = getResources().getAssets().open("00004202json.txt");

                    SceneryInfo sceneryInfo = JsonSceneryInfo.parse(FileUtils.readFile(is));
                    SaveUtils saveUtils = new SaveUtils(this ,flag, ivCollect ,is, sceneryInfo);
                    saveUtils.Save();

                    tvName.setText(sceneryInfo.getName());
                    tvSubName.setText(sceneryInfo.getName());
                    rbarLevel.setRating(5 * Integer.parseInt(sceneryInfo.getLevel()) / 5);
                    tvLevelDesc.setText(sceneryInfo.getLevelDesc());
                    tvIntroduce.setText(sceneryInfo.getIntroduce());

                    tvBuy.setText(sceneryInfo.getList().get(0).getContents());
                    tvAddress.setText(sceneryInfo.getList().get(1).getContents());
                    tvTraffic.setText(sceneryInfo.getList().get(2).getContents());
                    tvTime.setText(sceneryInfo.getList().get(3).getContents());
                    tvPhone.setText(sceneryInfo.getList().get(4).getContents());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    ivCover.setImageBitmap(BitmapFactory.decodeStream(getResources().getAssets().open("Restaurant10.jpg")));
                    is = getResources().getAssets().open("00004311json.txt");
                    SceneryInfo sceneryInfo = JsonSceneryInfo.parse(FileUtils.readFile(is));
                    SaveUtils saveUtils = new SaveUtils(this ,flag, ivCollect ,is, sceneryInfo);
                    saveUtils.Save();

                    tvName.setText(sceneryInfo.getName());
                    tvSubName.setText(sceneryInfo.getName());
                    rbarLevel.setRating(5 * Integer.parseInt(sceneryInfo.getLevel()) / 5);
                    tvLevelDesc.setText(sceneryInfo.getLevelDesc());
                    tvIntroduce.setText(sceneryInfo.getIntroduce());

                    tvAddress.setText(sceneryInfo.getList().get(0).getContents());
                    llTraffic.setVisibility(View.GONE);
                    llPhone.setVisibility(View.GONE);
                    llTime.setVisibility(View.GONE);
                    llBuy.setVisibility(View.GONE);

                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                try {
                    ivCover.setImageBitmap(BitmapFactory.decodeStream(getResources().getAssets().open("Shopping4.jpg")));
                    is = getResources().getAssets().open("00004204json.txt");
                    SceneryInfo sceneryInfo = JsonSceneryInfo.parse(FileUtils.readFile(is));
                    SaveUtils saveUtils = new SaveUtils(this ,flag, ivCollect ,is, sceneryInfo);
                    saveUtils.Save();

                    tvName.setText(sceneryInfo.getName());
                    tvSubName.setText(sceneryInfo.getName());
                    rbarLevel.setRating(5 * Integer.parseInt(sceneryInfo.getLevel()) / 5);
                    tvLevelDesc.setText(sceneryInfo.getLevelDesc());
                    tvIntroduce.setText(sceneryInfo.getIntroduce());

                    tvBuy.setText(sceneryInfo.getList().get(0).getContents());
                    tvAddress.setText(sceneryInfo.getList().get(1).getContents());
                    tvPhone.setText(sceneryInfo.getList().get(2).getContents());
                    llTraffic.setVisibility(View.GONE);
                    llTime.setVisibility(View.GONE);

                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
//            case 4:
//                try {
//                    ivCover.setVisibility(View.GONE);
//                    is = getResources().getAssets().open("00004307json.txt");
//                    SceneryInfo sceneryInfo = JsonSceneryInfo.parse(FileUtils.readFile(is));
//
//                    tvName.setText(sceneryInfo.getName());
//                    tvSubName.setText(sceneryInfo.getName());
//                    rbarLevel.setRating(5 * Integer.parseInt(sceneryInfo.getLevel()) / 5);
//                    tvLevelDesc.setText(sceneryInfo.getLevelDesc());
//                    tvIntroduce.setText(sceneryInfo.getIntroduce());
//
//                    tvTraffic.setText(sceneryInfo.getList().get(0).getContents());
//                    tvBuy.setText(sceneryInfo.getList().get(1).getContents());
//                    llPhone.setVisibility(View.GONE);
//                    llTime.setVisibility(View.GONE);
//                    llAddress.setVisibility(View.GONE);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                break;
            case 4:
                try {
                    ivCover.setImageBitmap(BitmapFactory.decodeStream(getResources().getAssets().open("Shopping3.jpg")));
                    is = getResources().getAssets().open("00004203json.txt");
                    SceneryInfo sceneryInfo = JsonSceneryInfo.parse(FileUtils.readFile(is));
                    SaveUtils saveUtils = new SaveUtils(this ,flag, ivCollect ,is, sceneryInfo);
                    saveUtils.Save();

                    tvName.setText(sceneryInfo.getName());
                    tvSubName.setText(sceneryInfo.getName());
                    rbarLevel.setRating(5 * Integer.parseInt(sceneryInfo.getLevel()) / 5);
                    tvLevelDesc.setText(sceneryInfo.getLevelDesc());
                    tvIntroduce.setText(sceneryInfo.getIntroduce());

                    tvTraffic.setText(sceneryInfo.getList().get(0).getContents());
                    tvBuy.setText(sceneryInfo.getList().get(1).getContents());
                    llPhone.setVisibility(View.GONE);
                    llTime.setVisibility(View.GONE);
                    llAddress.setVisibility(View.GONE);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 5:
                try {
                    ivCover.setImageBitmap(BitmapFactory.decodeStream(getResources().getAssets().open("Shopping5.jpg")));
                    is = getResources().getAssets().open("00004205json.txt");
                    SceneryInfo sceneryInfo = JsonSceneryInfo.parse(FileUtils.readFile(is));
                    SaveUtils saveUtils = new SaveUtils(this ,flag, ivCollect ,is, sceneryInfo);
                    saveUtils.Save();

                    tvName.setText(sceneryInfo.getName());
                    tvSubName.setText(sceneryInfo.getName());
                    rbarLevel.setRating(5 * Integer.parseInt(sceneryInfo.getLevel()) / 5);
                    tvLevelDesc.setText(sceneryInfo.getLevelDesc());
                    tvIntroduce.setText(sceneryInfo.getIntroduce());

                    tvAddress.setText(sceneryInfo.getList().get(0).getContents());
                    tvPhone.setText(sceneryInfo.getList().get(2).getContents());
                    tvTraffic.setText(sceneryInfo.getList().get(1).getContents());
                    llTime.setVisibility(View.GONE);
                    llBuy.setVisibility(View.GONE);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    public void click(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                this.finish();
                break;

        }
    }
}
