package com.example.pyhy;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.sql.ResultSet;

public class RegisterActivity extends AppCompatActivity {

    private EditText usernameEditText, ageEditText, emailOrPhoneEditText, passwordEditText, descriptionEditText;
    private RadioGroup genderRadioGroup;
    private CheckBox hobbyReading, hobbySports, hobbyMusic;
    private Button registerButton;

    public RegisterActivity(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // 获取控件
        usernameEditText = findViewById(R.id.usernameEditText);
        ageEditText = findViewById(R.id.ageEditText);
        emailOrPhoneEditText = findViewById(R.id.emailOrPhoneEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        descriptionEditText = findViewById(R.id.descriptionEditText);
        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        hobbyReading = findViewById(R.id.hobbyReading);
        hobbySports = findViewById(R.id.hobbySports);
        hobbyMusic = findViewById(R.id.hobbyMusic);
        registerButton = findViewById(R.id.registerButton);

        // 注册按钮点击事件
        registerButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString().trim();
            String age = ageEditText.getText().toString().trim();
            String emailOrPhone = emailOrPhoneEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();
            String description = descriptionEditText.getText().toString().trim();

            // 获取性别
            int selectedGenderId = genderRadioGroup.getCheckedRadioButtonId();
            RadioButton selectedGenderButton = findViewById(selectedGenderId);
            String gender = selectedGenderButton != null ? selectedGenderButton.getText().toString() : "";

            // 获取爱好
            StringBuilder hobbies = new StringBuilder();
            if (hobbyReading.isChecked()) hobbies.append("阅读, ");
            if (hobbySports.isChecked()) hobbies.append("运动, ");
            if (hobbyMusic.isChecked()) hobbies.append("音乐, ");

            // 移除最后一个逗号和空格
            if (hobbies.length() > 0) {
                hobbies.setLength(hobbies.length() - 2);
            }

            // 验证输入字段
            if (username.isEmpty() || age.isEmpty() || emailOrPhone.isEmpty() || password.isEmpty() || gender.isEmpty()) {
                Toast.makeText(this, "请填写所有必填项", Toast.LENGTH_SHORT).show();
                return;
            }

            // 注册逻辑
            // 在这里可以实现将数据发送到服务器

            // 显示注册成功提示
            Toast.makeText(this, "注册成功！", Toast.LENGTH_SHORT).show();
            finish();  // 关闭注册页面，返回登录页面
        });
    }
}
