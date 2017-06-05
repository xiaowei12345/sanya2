package sanya.com.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import sanya.com.Utils.SpfUtils;
import sanya.com.base.BaseActivity;
import sanya.com.sanya.MainActivity;
import sanya.com.sanya.R;


/**
 * 闪屏页面
 */
public class Splash_Activity extends BaseActivity {


    private static final int GO_HOME = 1000;
    // 延迟3秒
    private static final long SPLASH_DELAY_MILLIS = 3000;
    /**
     * Handler:跳转到不同界面
     */
    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case GO_HOME:
                    if ((Boolean) SpfUtils.get(Splash_Activity.this, "islogin", false)) {
                        startActivity(new Intent(Splash_Activity.this, MainActivity.class));
                        finish();
                    } else {
                        startActivity(new Intent(Splash_Activity.this, LoginActivity.class));
                        finish();
                    }

                    break;
            }
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_);
        //延迟3秒
        mHandler.sendEmptyMessageDelayed(GO_HOME, SPLASH_DELAY_MILLIS);
    }
}
