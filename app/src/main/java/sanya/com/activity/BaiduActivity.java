package sanya.com.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import sanya.com.sanya.R;

public class BaiduActivity extends AppCompatActivity {
    private WebView wb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baidu);
        wb = (WebView) findViewById(R.id.wb);
        String url = getIntent().getStringExtra("url");
        wb.loadUrl(url);
    }
}
