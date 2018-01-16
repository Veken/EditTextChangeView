package com.veken.edittextchangeview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.rl_user)
    InputLayoutView rlUser;
    @Bind(R.id.rl_pwd)
    InputLayoutView rlPwd;
    @Bind(R.id.tv_user)
    TextView tvUser;
    @Bind(R.id.tv_pwd)
    TextView tvPwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        rlUser.setOnEditTextChangeListener(new InputLayoutView.OnEditTextChangeListener() {
            @Override
            public void onEditTextChangeListener(String text) {
                tvUser.setText(text);
            }
        });
        rlPwd.setOnEditTextChangeListener(new InputLayoutView.OnEditTextChangeListener() {
            @Override
            public void onEditTextChangeListener(String text) {
                tvPwd.setText(text);
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
