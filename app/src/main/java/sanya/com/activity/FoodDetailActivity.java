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
import sanya.com.Utils.SaveUtils_food;
import sanya.com.adapter.CollectAdapter;
import sanya.com.bean.Collect;
import sanya.com.bean.SceneryInfo;
import sanya.com.sanya.R;
import sanya.com.tools.FileUtils;
import sanya.com.tools.JsonSceneryInfo;

public class FoodDetailActivity extends AppCompatActivity {

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
    @BindView(R.id.tv_ticket)
    TextView tvTicket;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tv_addressContents)
    TextView tvAddressContents;
    @BindView(R.id.iv_address)
    ImageView ivAddress;
    @BindView(R.id.tv_trafficTitle)
    TextView tvTrafficTitle;
    @BindView(R.id.tv_trafficContent)
    TextView tvTrafficContent;
    @BindView(R.id.ll_traffic)
    LinearLayout llTraffic;
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
    @BindView(R.id.tv_food)
    TextView tvFood;
    @BindView(R.id.ll_food)
    LinearLayout llFood;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.ll_price)
    LinearLayout llPrice;
    @BindView(R.id.ll_address)
    LinearLayout llAddress;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.ll_time)
    LinearLayout llTime;
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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);
        ButterKnife.bind(this);
//        getSupportActionBar().hide();
        rbarLevel.setMax(5);
        num = getIntent().getIntExtra("key", 0);

        dbUtils = DbUtils.create(FoodDetailActivity.this, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath(), "Collect2");
        collect = new Collect();
        adapter = new CollectAdapter(list, this, null);

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
                                collect.setImage(R.mipmap.favorites_list_item_icon_restaurant);
                                collect.setName("第一市场");
                                collect.setType("美食");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                Log.i("queryAllRecord------->", list.toString());
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(FoodDetailActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
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
                            Toast.makeText(FoodDetailActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
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
                                collect.setImage(R.mipmap.favorites_list_item_icon_restaurant);
                                collect.setName("红砂码头鱼排");
                                collect.setType("美食");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                Log.i("queryAllRecord------->", list.toString());
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(FoodDetailActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                        } else {
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                            try {
                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "红沙码头鱼排"));
                                list = dbUtils.findAll(Collect.class);
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(FoodDetailActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
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
                                collect.setImage(R.mipmap.favorites_list_item_icon_restaurant);
                                collect.setName("黄流老鸭一条街");
                                collect.setType("美食");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                Log.i("queryAllRecord------->", list.toString());
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(FoodDetailActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                        } else {
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                            try {
                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "黄流老鸭一条街"));
                                list = dbUtils.findAll(Collect.class);
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(FoodDetailActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
                            flag = true;
                        }

                        break;
                    case 3:
                        if (flag) {
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                            //tv_edit.setText("编辑");
                            try {
                                collect.setFlag(true);
                                collect.setFg(true);
                                collect.setImage(R.mipmap.favorites_list_item_icon_restaurant);
                                collect.setName("海亚餐厅");
                                collect.setType("美食");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                Log.i("queryAllRecord------->", list.toString());
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(FoodDetailActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                        } else {
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                            try {
                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "海亚餐厅"));
                                list = dbUtils.findAll(Collect.class);
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(FoodDetailActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
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
                                collect.setImage(R.mipmap.favorites_list_item_icon_restaurant);
                                collect.setName("南山素斋");
                                collect.setType("美食");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                Log.i("queryAllRecord------->", list.toString());
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(FoodDetailActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                        } else {
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                            try {
                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "南山素斋"));
                                list = dbUtils.findAll(Collect.class);
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(FoodDetailActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
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
                                collect.setImage(R.mipmap.favorites_list_item_icon_restaurant);
                                collect.setName("拾味馆");
                                collect.setType("美食");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                Log.i("queryAllRecord------->", list.toString());
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(FoodDetailActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                        } else {
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                            try {
                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "拾味馆"));
                                list = dbUtils.findAll(Collect.class);
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(FoodDetailActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
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
                                collect.setImage(R.mipmap.favorites_list_item_icon_restaurant);
                                collect.setName("春园海鲜广场");
                                collect.setType("美食");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                Log.i("queryAllRecord------->", list.toString());
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(FoodDetailActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                        } else {
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                            try {
                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "春园海鲜广场"));
                                list = dbUtils.findAll(Collect.class);
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(FoodDetailActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
                            flag = true;
                        }

                        break;
                    case 7:
                        if (flag) {
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                            //tv_edit.setText("编辑");
                            try {
                                collect.setFlag(true);
                                collect.setFg(true);
                                collect.setImage(R.mipmap.favorites_list_item_icon_restaurant);
                                collect.setName("友谊路下岗职工海鲜广场");
                                collect.setType("美食");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                Log.i("queryAllRecord------->", list.toString());
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(FoodDetailActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                        } else {
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                            try {
                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "友谊路下岗职工海西岸广场"));
                                list = dbUtils.findAll(Collect.class);
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(FoodDetailActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
                            flag = true;
                        }

                        break;
                    case 8:
                        if (flag) {
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                            //tv_edit.setText("编辑");
                            try {
                                collect.setFlag(true);
                                collect.setFg(true);
                                collect.setImage(R.mipmap.favorites_list_item_icon_restaurant);
                                collect.setName("明记大排档");
                                collect.setType("美食");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                Log.i("queryAllRecord------->", list.toString());
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(FoodDetailActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                        } else {
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                            try {
                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "明记大排档"));
                                list = dbUtils.findAll(Collect.class);
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(FoodDetailActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
                            flag = true;
                        }

                        break;
                    case 9:
                        if (flag) {
                            ivCollect.setImageResource(R.mipmap.btn_favorited);
                            //tv_edit.setText("编辑");
                            try {
                                collect.setFlag(true);
                                collect.setFg(true);
                                collect.setImage(R.mipmap.favorites_list_item_icon_restaurant);
                                collect.setName("一品锅");
                                collect.setType("美食");
                                collect.setNum(0);
                                dbUtils.save(collect);
                                list = dbUtils.findAll(Collect.class);
                                Log.i("queryAllRecord------->", list.toString());
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                                Toast.makeText(FoodDetailActivity.this, "已收藏", Toast.LENGTH_SHORT).show();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            flag = false;
                        } else {
                            ivCollect.setImageResource(R.mipmap.btn_favorite);
                            try {
                                dbUtils.delete(Collect.class, WhereBuilder.b("name", "=", "一品锅"));
                                list = dbUtils.findAll(Collect.class);
                                adapter.list = list;
                                adapter.notifyDataSetChanged();
                            } catch (DbException e) {
                                e.printStackTrace();
                            }
                            Toast.makeText(FoodDetailActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
                            flag = true;
                        }

                        break;
                }
            }
        });

        InputStream is = null;
        switch (num) {
            case 0:
                try {
                    ivCover.setImageBitmap(BitmapFactory.decodeStream(getResources().getAssets().open("Restaurant2.jpg")));
                    is = getResources().getAssets().open("00004302json.txt");
                    SceneryInfo sceneryInfo = JsonSceneryInfo.parse(FileUtils.readFile(is));
                    SaveUtils_food saveUtils_food = new SaveUtils_food(this, flag, ivCollect, is, sceneryInfo);
                    saveUtils_food.Save();


                    llFood.setVisibility(View.GONE);
                    tvName.setText(sceneryInfo.getName());
                    tvSubName.setText(sceneryInfo.getName());
                    rbarLevel.setRating(5 * Integer.parseInt(sceneryInfo.getLevel()) / 5);
                    tvLevelDesc.setText(sceneryInfo.getLevelDesc());
                    tvIntroduce.setText(sceneryInfo.getIntroduce());
                    tvPrice.setText(sceneryInfo.getList().get(0).getContents());
                    tvAddressContents.setText(sceneryInfo.getList().get(1).getContents());
                    tvTrafficContent.setText(sceneryInfo.getList().get(2).getContents());
                    tvTime.setText(sceneryInfo.getList().get(3).getContents());
                    tvPhoneContents.setText(sceneryInfo.getList().get(4).getContents());

                } catch (IOException e) {
                    e.printStackTrace();
                }

                break;
            case 1:
                try {
                    ivCover.setVisibility(View.GONE);
                    is = getResources().getAssets().open("00004304json.txt");

                    SceneryInfo sceneryInfo = JsonSceneryInfo.parse(FileUtils.readFile(is));
                    SaveUtils_food saveUtils_food = new SaveUtils_food(this, flag, ivCollect, is, sceneryInfo);
                    saveUtils_food.Save();


                    tvName.setText(sceneryInfo.getName());
                    tvSubName.setText(sceneryInfo.getName());
                    rbarLevel.setRating(5 * Integer.parseInt(sceneryInfo.getLevel()) / 5);
                    tvLevelDesc.setText(sceneryInfo.getLevelDesc());
                    tvIntroduce.setText(sceneryInfo.getIntroduce());

                    tvFood.setText(sceneryInfo.getList().get(0).getContents());
                    llPrice.setVisibility(View.GONE);
                    tvAddressContents.setText(sceneryInfo.getList().get(1).getContents());
                    tvTrafficContent.setText(sceneryInfo.getList().get(2).getContents());
                    llTime.setVisibility(View.GONE);
                    llPhone.setVisibility(View.GONE);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 2:
                try {
                    ivCover.setImageBitmap(BitmapFactory.decodeStream(getResources().getAssets().open("Restaurant5.jpg")));
                    is = getResources().getAssets().open("00004305json.txt");
                    SceneryInfo sceneryInfo = JsonSceneryInfo.parse(FileUtils.readFile(is));

                    SaveUtils_food saveUtils_food = new SaveUtils_food(this, flag, ivCollect, is, sceneryInfo);
                    saveUtils_food.Save();

                    tvFood.setText(sceneryInfo.getList().get(0).getContents());
                    tvName.setText(sceneryInfo.getName());
                    tvSubName.setText(sceneryInfo.getName());
                    rbarLevel.setRating(5 * Integer.parseInt(sceneryInfo.getLevel()) / 5);
                    tvLevelDesc.setText(sceneryInfo.getLevelDesc());
                    tvIntroduce.setText(sceneryInfo.getIntroduce());
                    tvPrice.setText(sceneryInfo.getList().get(1).getContents());
                    tvAddressContents.setText(sceneryInfo.getList().get(2).getContents());
                    tvTrafficContent.setText(sceneryInfo.getList().get(3).getContents());
                    llTime.setVisibility(View.GONE);
                    llPhone.setVisibility(View.GONE);

                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                try {
                    ivCover.setImageBitmap(BitmapFactory.decodeStream(getResources().getAssets().open("Restaurant6.jpg")));
                    is = getResources().getAssets().open("00004306json.txt");
                    SceneryInfo sceneryInfo = JsonSceneryInfo.parse(FileUtils.readFile(is));

                    SaveUtils_food saveUtils_food = new SaveUtils_food(this, flag, ivCollect, is, sceneryInfo);
                    saveUtils_food.Save();

                    tvFood.setText(sceneryInfo.getList().get(0).getContents());
                    tvName.setText(sceneryInfo.getName());
                    tvSubName.setText(sceneryInfo.getName());
                    rbarLevel.setRating(5 * Integer.parseInt(sceneryInfo.getLevel()) / 5);
                    tvLevelDesc.setText(sceneryInfo.getLevelDesc());
                    tvIntroduce.setText(sceneryInfo.getIntroduce());
                    tvPrice.setText(sceneryInfo.getList().get(1).getContents());
                    tvAddressContents.setText(sceneryInfo.getList().get(2).getContents());
                    tvPhoneContents.setText(sceneryInfo.getList().get(3).getContents());
                    llTime.setVisibility(View.GONE);
                    llAddress.setVisibility(View.GONE);

                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 4:
                try {
                    ivCover.setVisibility(View.GONE);
                    is = getResources().getAssets().open("00004307json.txt");
                    SceneryInfo sceneryInfo = JsonSceneryInfo.parse(FileUtils.readFile(is));

                    SaveUtils_food saveUtils_food = new SaveUtils_food(this, flag, ivCollect, is, sceneryInfo);
                    saveUtils_food.Save();

                    tvName.setText(sceneryInfo.getName());
                    tvSubName.setText(sceneryInfo.getName());
                    rbarLevel.setRating(5 * Integer.parseInt(sceneryInfo.getLevel()) / 5);
                    tvLevelDesc.setText(sceneryInfo.getLevelDesc());
                    tvIntroduce.setText(sceneryInfo.getIntroduce());

                    tvFood.setText(sceneryInfo.getList().get(0).getContents());
                    tvPrice.setText(sceneryInfo.getList().get(1).getContents());
                    tvAddressContents.setText(sceneryInfo.getList().get(2).getContents());
                    tvTrafficContent.setText(sceneryInfo.getList().get(3).getContents());
                    tvPhoneContents.setText(sceneryInfo.getList().get(4).getContents());
                    llTime.setVisibility(View.GONE);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 5:
                try {
                    ivCover.setVisibility(View.GONE);
                    is = getResources().getAssets().open("00004308json.txt");
                    SceneryInfo sceneryInfo = JsonSceneryInfo.parse(FileUtils.readFile(is));

                    SaveUtils_food saveUtils_food = new SaveUtils_food(this, flag, ivCollect, is, sceneryInfo);
                    saveUtils_food.Save();

                    tvName.setText(sceneryInfo.getName());
                    tvSubName.setText(sceneryInfo.getName());
                    rbarLevel.setRating(5 * Integer.parseInt(sceneryInfo.getLevel()) / 5);
                    tvLevelDesc.setText(sceneryInfo.getLevelDesc());
                    tvIntroduce.setText(sceneryInfo.getIntroduce());

                    tvFood.setText(sceneryInfo.getList().get(0).getContents());
                    tvPrice.setText(sceneryInfo.getList().get(1).getContents());
                    tvAddressContents.setText(sceneryInfo.getList().get(2).getContents());
                    llTraffic.setVisibility(View.GONE);
                    tvPhoneContents.setText(sceneryInfo.getList().get(3).getContents());
                    llTime.setVisibility(View.GONE);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 6:
                try {
                    ivCover.setImageBitmap(BitmapFactory.decodeStream(getResources().getAssets().open("Restaurant3.jpg")));
                    is = getResources().getAssets().open("00004303json.txt");
                    SceneryInfo sceneryInfo = JsonSceneryInfo.parse(FileUtils.readFile(is));

                    SaveUtils_food saveUtils_food = new SaveUtils_food(this, flag, ivCollect, is, sceneryInfo);
                    saveUtils_food.Save();

                    tvName.setText(sceneryInfo.getName());
                    tvSubName.setText(sceneryInfo.getName());
                    rbarLevel.setRating(5 * Integer.parseInt(sceneryInfo.getLevel()) / 5);
                    tvLevelDesc.setText(sceneryInfo.getLevelDesc());
                    tvIntroduce.setText(sceneryInfo.getIntroduce());

                    tvFood.setText(sceneryInfo.getList().get(0).getContents());
                    tvPrice.setText(sceneryInfo.getList().get(1).getContents());
                    llAddress.setVisibility(View.GONE);
                    tvTrafficContent.setText(sceneryInfo.getList().get(4).getContents());
                    tvPhoneContents.setText(sceneryInfo.getList().get(3).getContents());
                    llTime.setVisibility(View.GONE);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 7:
                try {
                    ivCover.setImageBitmap(BitmapFactory.decodeStream(getResources().getAssets().open("Restaurant1.jpg")));
                    is = getResources().getAssets().open("00004301json.txt");
                    SceneryInfo sceneryInfo = JsonSceneryInfo.parse(FileUtils.readFile(is));

                    SaveUtils_food saveUtils_food = new SaveUtils_food(this, flag, ivCollect, is, sceneryInfo);
                    saveUtils_food.Save();

                    tvName.setText(sceneryInfo.getName());
                    tvSubName.setText(sceneryInfo.getName());
                    rbarLevel.setRating(5 * Integer.parseInt(sceneryInfo.getLevel()) / 5);
                    tvLevelDesc.setText(sceneryInfo.getLevelDesc());
                    tvIntroduce.setText(sceneryInfo.getIntroduce());

                    tvFood.setText(sceneryInfo.getList().get(0).getContents());
                    tvPrice.setText(sceneryInfo.getList().get(1).getContents());
                    tvAddressContents.setText(sceneryInfo.getList().get(2).getContents());
                    tvTrafficContent.setText(sceneryInfo.getList().get(3).getContents());
                    llPhone.setVisibility(View.GONE);
                    llTime.setVisibility(View.GONE);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 8:
                try {
                    ivCover.setImageBitmap(BitmapFactory.decodeStream(getResources().getAssets().open("Restaurant9.jpg")));
                    is = getResources().getAssets().open("00004309json.txt");
                    SceneryInfo sceneryInfo = JsonSceneryInfo.parse(FileUtils.readFile(is));

                    SaveUtils_food saveUtils_food = new SaveUtils_food(this, flag, ivCollect, is, sceneryInfo);
                    saveUtils_food.Save();

                    tvName.setText(sceneryInfo.getName());
                    tvSubName.setText(sceneryInfo.getName());
                    rbarLevel.setRating(5 * Integer.parseInt(sceneryInfo.getLevel()) / 5);
                    tvLevelDesc.setText(sceneryInfo.getLevelDesc());
                    tvIntroduce.setText(sceneryInfo.getIntroduce());

                    tvFood.setText(sceneryInfo.getList().get(0).getContents());
                    llPrice.setVisibility(View.GONE);
                    tvAddressContents.setText(sceneryInfo.getList().get(1).getContents());
                    tvTrafficContent.setText(sceneryInfo.getList().get(2).getContents());
                    llPhone.setVisibility(View.GONE);
                    llTime.setVisibility(View.GONE);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 9:
                try {
                    ivCover.setImageBitmap(BitmapFactory.decodeStream(getResources().getAssets().open("Restaurant10.jpg")));
                    is = getResources().getAssets().open("00004310json.txt");
                    SceneryInfo sceneryInfo = JsonSceneryInfo.parse(FileUtils.readFile(is));

                    SaveUtils_food saveUtils_food = new SaveUtils_food(this, flag, ivCollect, is, sceneryInfo);
                    saveUtils_food.Save();

                    tvName.setText(sceneryInfo.getName());
                    tvSubName.setText(sceneryInfo.getName());
                    rbarLevel.setRating(5 * Integer.parseInt(sceneryInfo.getLevel()) / 5);
                    tvLevelDesc.setText(sceneryInfo.getLevelDesc());
                    tvIntroduce.setText(sceneryInfo.getIntroduce());

                    llFood.setVisibility(View.GONE);
                    llPrice.setVisibility(View.GONE);
                    tvAddressContents.setText(sceneryInfo.getList().get(0).getContents());
                    tvTrafficContent.setText(sceneryInfo.getList().get(1).getContents());
                    llPhone.setVisibility(View.GONE);
                    llTime.setVisibility(View.GONE);
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
