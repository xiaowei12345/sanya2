package sanya.com.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import sanya.com.sanya.R;

public class SupportActivity extends AppCompatActivity {
    private EditText et_support;
    private TextView tv_commit;
    private TextView tv_length;
    private ImageView iv_commit;
    private CharSequence temp;
    //private LinearLayout lin2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support);
        et_support = (EditText) findViewById(R.id.et_support);
        tv_commit = (TextView) findViewById(R.id.tv_commit);
        tv_length = (TextView) findViewById(R.id.tv_length);
        iv_commit = (ImageView) findViewById(R.id.iv_commit);
        iv_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
        tv_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SupportActivity.this,"感谢您对我们的关注和建议,我们会持续改进",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        if (temp != null && temp.length() == 0) {
            tv_commit.setTextColor(0xffececec);
        }else{
            tv_commit.setTextColor(Color.BLACK);
        }
        et_support.addTextChangedListener(mEditText);
    }
    TextWatcher mEditText = new TextWatcher() {

        private int editStart ;
        private int editEnd ;
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            et_support.setVisibility(View.VISIBLE);
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            temp = s;
        }

        @Override
        public void afterTextChanged(Editable s) {
            editStart = et_support.getSelectionStart();
            editEnd = et_support.getSelectionEnd();
            tv_length.setText(temp.length()+"");
            if (temp.length() > 140) {
                Toast.makeText(SupportActivity.this,
                        "你输入的字数已经超过了限制！", Toast.LENGTH_SHORT)
                        .show();
                s.delete(editStart-1, editEnd);
                int tempSelection = editStart;
                et_support.setText(s);
                et_support.setSelection(tempSelection);
            }
        }
    };
}
