package sanya.com.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.czy1121.view.RoundButton;


import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import sanya.com.base.BaseActivity;
import sanya.com.db.Z_UserInfoDao;
import sanya.com.sanya.R;


/**
 * 注册界面
 */
public class Zhu_Activity extends BaseActivity {

    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.textView22)
    TextView textView22;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.textView23)
    TextView textView23;
    @BindView(R.id.et_mm)
    EditText etMm;
    @BindView(R.id.bt_getCode)
    RoundButton btGetCode;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;
    Z_UserInfoDao z_userInfoDao;
    @BindView(R.id.et_qrmm)
    EditText etQrmm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuces_);
        ButterKnife.bind(this);
        z_userInfoDao = new Z_UserInfoDao(this);

    }

    @OnClick({R.id.img_back, R.id.bt_getCode})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_back:
                finish();
                break;
            case R.id.bt_getCode:
                if (TextUtils.isEmpty(etPhone.getText().toString())) {
                    Toast.makeText(this, "请输入账号", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(etMm.getText().toString())) {
                    Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
                    return;
                }
                if ( etMm.getText().toString().length()<6 ||etQrmm.getText().toString().length()<6 ) {
                    Toast.makeText(this, "密码太短，请重新输入！", Toast.LENGTH_SHORT).show();
                    return;
                }
                if ( !etMm.getText().toString().equals(etQrmm.getText().toString())) {
                    Toast.makeText(this, "两次输入的密码不同，请重新输入！", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (z_userInfoDao.shifoucunzai(etPhone.getText().toString())) {
                    Toast.makeText(this, "账号已存在", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    z_userInfoDao.addUser(etPhone.getText().toString(), etMm.getText().toString());
                    Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
                    finish();
                }

                break;
        }
    }
}
