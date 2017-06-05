package sanya.com.activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

import sanya.com.sanya.MainActivity;
import sanya.com.sanya.R;
public class GuideActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
//        getSupportActionBar().hide();
        Mytask task = new Mytask();
        Timer timer=new Timer();
        timer.schedule(task,500);
    }

    class Mytask extends TimerTask
    {

        private SharedPreferences sf;

        @Override
        public void run() {
            sf = getSharedPreferences("user", Context.MODE_PRIVATE);
            boolean flag = sf.getBoolean("flag", false);
            if(!flag){
                Intent intent = new Intent(GuideActivity.this,WelcomeActivity.class);
                startActivity(intent);
                finish();

            }else{
                Intent intent = new Intent(GuideActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }

        }
    }
}
