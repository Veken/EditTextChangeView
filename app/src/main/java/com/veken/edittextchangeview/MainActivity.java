package com.veken.edittextchangeview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.veken.inputlayoutview.InputLayoutView;

public class MainActivity extends Activity {

    private InputLayoutView rlUser;
    private InputLayoutView rlPwd;
    private TextView tvUser;
    private TextView tvPwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rlUser = (InputLayoutView) findViewById(R.id.rl_user);
        rlPwd = (InputLayoutView) findViewById(R.id.rl_pwd);
        tvUser = (TextView) findViewById(R.id.tv_user);
        tvPwd = (TextView) findViewById(R.id.tv_pwd);
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


}
