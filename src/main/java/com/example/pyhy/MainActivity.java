package com.example.pyhy;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout relativeLayout;
    private EditText usernameEditText, passwordEditText;
    private Button loginButton, registerButton;
    private TextView registerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // 在 onCreate 中初始化 RelativeLayout
        relativeLayout = findViewById(R.id.loginRelative);

        // 设置窗口Insets监听器
        ViewCompat.setOnApplyWindowInsetsListener(relativeLayout, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // 获取界面上的控件
        usernameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        registerButton = findViewById(R.id.registerButton);
        registerTextView = findViewById(R.id.registerTextView);

        // 设置登录按钮点击事件
        loginButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty()) {
                // 进行简单的验证
                if (username.isEmpty()) {
                    usernameEditText.setError("用户名不能为空");
                }
                if (password.isEmpty()) {
                    passwordEditText.setError("密码不能为空");
                }
            } else {
                // 登录逻辑
                // 发送请求到服务器进行验证
                // Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                // startActivity(intent);
                // finish(); // 关闭当前登录界面
            }
        });

        // 设置注册链接点击事件
        registerTextView.setOnClickListener(v -> {
            // 跳转到注册页面
            Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(intent);
        });
        // 立即注册按钮
        registerButton.setOnClickListener(v ->{
            // 跳转到注册界面
            Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
            startActivity(intent);

        });
    }
}
