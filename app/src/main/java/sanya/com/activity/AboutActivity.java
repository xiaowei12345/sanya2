package sanya.com.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import sanya.com.sanya.R;

public class AboutActivity extends AppCompatActivity {
    private ImageView iv_sina;
    private ImageView iv_baidu;
    private ImageView iv_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        iv_baidu = (ImageView) findViewById(R.id.iv_baidu);
        iv_sina = (ImageView) findViewById(R.id.iv_sina);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        iv_baidu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutActivity.this,BaiduActivity.class);
                intent.putExtra("url","http://lvyou.baidu.com/");
                startActivity(intent);
            }
        });
        iv_sina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutActivity.this,BaiduActivity.class);
                intent.putExtra("url","http://e.weibo.com/baidulvyou");
                startActivity(intent);
            }
        });
    }
}
