package sanya.com.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import sanya.com.sanya.R;

public class TravelNoteOneActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travelone);
    }
    public void click(View view){
        switch (view.getId()){
            case R.id.iv_travel_back://返回上一页
                finish();
                break;
            case R.id.tv_checkdetail://查看详情
                String uriStr = getIntent().getStringExtra("url");
                if (TextUtils.isEmpty(uriStr)) {
                    Toast.makeText(this, "连接已失效", Toast.LENGTH_SHORT).show();
                } else {
                    Uri uri = Uri.parse(uriStr);
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.setData(uri);
                    startActivity(intent);
                }
                break;
        }
    }
}
