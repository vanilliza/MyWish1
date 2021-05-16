package com.example.mywish1.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import  com.example.mywish1.R;
import android.os.Bundle;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_create;
    private TextView tv_login, tv_forgot_password;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        init();
    }

    private void init() {
        context = SignupActivity.this;
        btn_create = findViewById(R.id.btn_create);
        tv_login = findViewById(R.id.tv_login);
        tv_forgot_password = findViewById(R.id.tv_forgot_password);
        click();
    }

    private void click() {
        btn_create.setOnClickListener(this);
        tv_login.setOnClickListener(this);
        tv_forgot_password.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_create:
                break;

            case R.id.tv_login:
                Intent login = new Intent(context, LoginActivity.class);
                startActivity(login);
                break;

            case R.id.tv_forgot_password:
                Intent forgot = new Intent(context, ForgotPasswordActivity.class);
                startActivity(forgot);
                break;
        }
    }
}