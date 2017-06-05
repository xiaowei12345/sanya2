package sanya.com.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Camera;
import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.zhy.android.percent.support.PercentLinearLayout;
import com.zhy.android.percent.support.PercentRelativeLayout;
import sanya.com.activity.WelcomeActivity;
import sanya.com.sanya.Application;
import sanya.com.sanya.R;

/**
 * Created by Sep
 */
public class Fragment_Guide extends Fragment implements View.OnClickListener{

    private static final String TAG = "Fragment_Guide";
    private View jd, lx, gw, ms, zs, jt, yj, mContainer;
    private TextView tv_jd, tv_lx, tv_gw, tv_ms, tv_zs, tv_jt, tv_yj, tv_mContainer;
    private ImageView iv_jd, iv_lx, iv_gw, iv_ms, iv_zs, iv_jt, iv_yj, imageview;
    private View[] totalView;
    private TextView[] totalTextView;
    private ImageView[] totalImageView;
    private TextView textview;
    private Handler handler = new Handler();
    private int count = 0;
    private boolean flag = false;
    private PercentRelativeLayout scenery;
    private PercentLinearLayout shop;
    private PercentLinearLayout road;
    private PercentLinearLayout stay;
    private PercentLinearLayout food;
    private PercentLinearLayout traffic;
    private PercentLinearLayout travel;
    private Fragment mContent ;
    private RoadFragement roadFragment;
    private int currentFragment;
    private FragmentManager fm;
    private TravelFragment travelFragment;
    private SceneryFragment sceneryFragment;
    private StayFragment stayFragment;
    private ReadFragment readFragment;
    private FoodFragment foodFragment;
    private ShopFragment shopFragment;
    private TrafficFragment trafficFragment;
    private InfoFragment infoFragment;
    private FragmentTransaction tran;
    private PercentLinearLayout read;
    private PercentLinearLayout info;
    private Thread thread;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_guide, null);
        sceneryFragment =  Application.sceneryFragment;
        roadFragment = new RoadFragement();
        travelFragment = new TravelFragment();
        stayFragment = new StayFragment();
        readFragment = new ReadFragment();
        foodFragment = new FoodFragment();
        shopFragment = new ShopFragment();
        trafficFragment = new TrafficFragment();
        infoFragment = new InfoFragment();
        mContent = this;
        fm = getFragmentManager();
        tran = fm.beginTransaction();
       ImageView tp = (ImageView) view.findViewById(R.id.tp);
        tp.setOnClickListener(this);
        jd = view.findViewById(R.id.scenery);
        tv_jd = (TextView) view.findViewById(R.id.tv_scenery);
        iv_jd = (ImageView) view.findViewById(R.id.iv_scenery);

        lx = view.findViewById(R.id.road);
        tv_lx = (TextView) view.findViewById(R.id.tv_road);
        iv_lx = (ImageView) view.findViewById(R.id.iv_road);

        gw = view.findViewById(R.id.shop);
        tv_gw = (TextView) view.findViewById(R.id.tv_shop);
        iv_gw = (ImageView) view.findViewById(R.id.iv_shop);

        zs = view.findViewById(R.id.stay);
        tv_zs = (TextView) view.findViewById(R.id.tv_stay);
        iv_zs = (ImageView) view.findViewById(R.id.iv_stay);

        ms = view.findViewById(R.id.food);
        tv_ms = (TextView) view.findViewById(R.id.tv_food);
        iv_ms = (ImageView) view.findViewById(R.id.iv_food);

        jt = view.findViewById(R.id.traffic);
        tv_jt = (TextView) view.findViewById(R.id.tv_traffic);
        iv_jt = (ImageView) view.findViewById(R.id.iv_traffic);

        yj = view.findViewById(R.id.travel);
        tv_yj = (TextView) view.findViewById(R.id.tv_travel);
        iv_yj = (ImageView) view.findViewById(R.id.iv_travel);

        View view1 = new View(getContext());
        ImageView iv = new ImageView(getContext());
        TextView tv = new TextView(getContext());
        totalView=new View[]{jd,  gw, ms, zs, yj,view1};
        totalImageView=new ImageView[]{iv_jd,  iv_gw, iv_ms, iv_zs,  iv_yj,iv};
        totalTextView=new TextView[]{tv_jd,  tv_gw, tv_ms, tv_zs,  tv_yj,tv};



        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        MyTask task = new MyTask();
        thread=new Thread(task);
        thread.start();
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), WelcomeActivity.class);
        startActivity(intent);
    }

    //    @Override
//    public void onPause() {
//        super.onPause();
//        thread.interrupt();
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        thread.start();
//    }

    private final class SwapViews implements Runnable {
        private final int mPosition;

        public SwapViews(int position) {
            mPosition = position;
        }

        public void run() {
            final float centerX = mContainer.getWidth() / 2.0f;
            final float centerY = mContainer.getHeight() / 2.0f;
            Rotate3d rotation;
            if (mPosition > -1) {
                imageview.setVisibility(View.VISIBLE);
                imageview.requestFocus();
                rotation = new Rotate3d(90, 180, centerX, centerY, 310.0f, false);
            } else {
                imageview.setVisibility(View.GONE);
                rotation = new Rotate3d(90, 0, centerX, centerY, 310.0f, false);
            }
            rotation.setDuration(500);
            rotation.setFillAfter(true);
            rotation.setInterpolator(new DecelerateInterpolator());
            mContainer.startAnimation(rotation);
        }
    }

    private final class DisplayNextView implements Animation.AnimationListener {
        private final int mPosition;

        private DisplayNextView(int position) {
            mPosition = position;

        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            Toast.makeText(getContext(), "131", Toast.LENGTH_SHORT).show();
            mContainer.post(new SwapViews(mPosition));

        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    private void applyRotation(int position, float start, float end) {
        // Find the center of the container

        final float centerX = mContainer.getWidth() / 2.0f;
        final float centerY = mContainer.getHeight() / 2.0f;
        final Rotate3d rotation =
                new Rotate3d(start, end, centerX, centerY, 310.0f, true);
        rotation.setDuration(500);
        rotation.setFillAfter(true);
        rotation.setInterpolator(new AccelerateInterpolator());
        rotation.setAnimationListener(new DisplayNextView(position));
        rotation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {


                textview.setAlpha(0);
            }

            @Override
            public void onAnimationEnd(Animation animation) {


                textview.setAlpha(1);


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mContainer.startAnimation(rotation);
    }

    private class MyTask implements Runnable {


        @Override
        public void run() {
            ///1
            for (int i = 0; ; i++) {
                //
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (i % 2 == 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                mContainer = totalView[(count / 4) % 6];
                imageview = totalImageView[(count / 4) % 6];
                textview = totalTextView[(count / 4) % 6];
                Log.i("------------------>", "--->" + count);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < totalTextView.length; i++) {
                            totalTextView[i].setAlpha(1);
                        }
                        switch (count % 24 - 1) {
                            case 1:

                                imageview.setImageResource(R.mipmap.scene);
                                 imageview.setScaleType(ImageView.ScaleType.FIT_XY);
                                textview.setTextColor(Color.WHITE);
                                textview.setBackgroundColor(0x88000000);

                                textview.setText(R.string.scenery);
                                break;
                            case 3:
                                imageview.setImageResource(R.mipmap.jd);
                                imageview.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                                textview.setBackgroundColor(Color.WHITE);
                                textview.setTextColor(Color.BLACK);
                                mContainer.setBackgroundColor(Color.WHITE);

                                textview.setText(R.string.scenery);
                                break;
                            case 5:
                                imageview.setImageResource(R.mipmap.gw_w);
                                textview.setTextColor(Color.WHITE);
                                mContainer.setBackgroundColor(0xff2f61b7);

                                textview.setText(R.string.shop);
                                break;
                            case 7:

                                imageview.setImageResource(R.mipmap.gw);
                                textview.setTextColor(Color.BLACK);
                                mContainer.setBackgroundColor(Color.WHITE);

                                textview.setText(R.string.shop);
                                break;
                            case 9:
                                imageview.setImageResource(R.mipmap.ms_w);
                                textview.setTextColor(Color.WHITE);
                                mContainer.setBackgroundColor(0xffffa940);

                                textview.setText(R.string.food);
                                break;
                            case 11:
                                imageview.setImageResource(R.mipmap.ms);
                                textview.setTextColor(Color.BLACK);
                                mContainer.setBackgroundColor(Color.WHITE);

                                textview.setText(R.string.food);
                                break;
                            case 13:
                                imageview.setImageResource(R.mipmap.zs_w);
                                textview.setTextColor(Color.WHITE);
                                mContainer.setBackgroundColor(0xff55b638);

                                textview.setText(R.string.stay);
                                break;
                            case 15:
                                imageview.setImageResource(R.mipmap.zs);
                                textview.setTextColor(Color.BLACK);
                                mContainer.setBackgroundColor(Color.WHITE);

                                textview.setText(R.string.stay);
                                break;
                            case 17:
                                imageview.setImageResource(R.mipmap.yj_w);
                                textview.setTextColor(Color.WHITE);
                                mContainer.setBackgroundColor(0xff4056ff);

                                textview.setText(R.string.travel);
                                break;
                            case 19:
                                imageview.setImageResource(R.mipmap.yj);
                                textview.setTextColor(Color.BLACK);
                                mContainer.setBackgroundColor(Color.WHITE);

                                textview.setText(R.string.travel);

                                break;
                            default:
                                break;
                        }
                        if (count % 2 != 0) {
                            applyRotation(0, 0, 90);
                        } else {
                            applyRotation(0, -90, 0);

                        }


                    }
                });
                count++;
            }

        }
    }


}
class Rotate3d extends Animation {
    private final float mFromDegrees;
    private final float mToDegrees;
    private final float mCenterX;
    private final float mCenterY;
    private final float mDepthZ;
    private final boolean mReverse;
    private Camera mCamera;

    public Rotate3d(float fromDegrees, float toDegrees,
                    float centerX, float centerY, float depthZ, boolean reverse) {
        mFromDegrees = fromDegrees;
        mToDegrees = toDegrees;
        mCenterX = centerX;
        mCenterY = centerY;
        mDepthZ = depthZ;
        mReverse = reverse;
    }

    @Override
    public void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        mCamera = new Camera();
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        final float fromDegrees = mFromDegrees;
        float degrees = fromDegrees + ((mToDegrees - fromDegrees) * interpolatedTime);
        final float centerX = mCenterX;
        final float centerY = mCenterY;
        final Camera camera = mCamera;
        final Matrix matrix = t.getMatrix();
        camera.save();
        if (mReverse) {
            camera.translate(0.0f, 0.0f, 0.0f);
        } else {
            camera.translate(0.0f, 0.0f, 0.0f);
        }
        camera.rotateY(degrees);
        camera.getMatrix(matrix);
        camera.restore();

        matrix.preTranslate(-centerX, -centerY);
        matrix.postTranslate(centerX, centerY);
    }
}
