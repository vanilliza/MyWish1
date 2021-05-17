package com.example.mywish1.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;
import com.example.mywish1.R;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_signup, tv_forgot_password;
    private Context context;
    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init() {
        context = LoginActivity.this;
        tv_signup = findViewById(R.id.tv_signup);
        tv_forgot_password = findViewById(R.id.tv_forgot_password);
        btn_login = findViewById(R.id.btn_login);

        click();
    }

    private void click() {
        tv_signup.setOnClickListener(this);
        tv_forgot_password.setOnClickListener(this);
        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_signup:
                /*Intent signup = new Intent(context, SignupActivity.class);
                startActivity(signup);*/
                startActivity(new Intent(this, SignupActivity.class));
                break;

            case R.id.tv_forgot_password:
                Intent forgot = new Intent(context, ForgotPasswordActivity.class);
                startActivity(forgot);
                break;

            case R.id.btn_login:
                Intent dashboard = new Intent(context, DashBoardActivity.class);
                startActivity(dashboard);
                break;
        }
    }
}