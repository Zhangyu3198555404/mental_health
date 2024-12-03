package com.example.pyhy.Login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pyhy.R;

public class UserInfoActivity extends AppCompatActivity {

    // 声明控件
    private ImageView avatarImageView;
    private TextView usernameTextView;
    private TextView accountTextView;
    private EditText bioEditText;
    private EditText interestsEditText;
    private TextView viewDohHoleLabel;
    private LinearLayout dohHoleContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 设置布局
        setContentView(R.layout.user_profile);

        // 初始化控件
        avatarImageView = findViewById(R.id.avatarImageView);
        usernameTextView = findViewById(R.id.usernameTextView);
        accountTextView = findViewById(R.id.accountTextView);
        bioEditText = findViewById(R.id.bioEditText);
        interestsEditText = findViewById(R.id.interestsEditText);
        viewDohHoleLabel = findViewById(R.id.viewDohHoleLabel);
        dohHoleContainer = findViewById(R.id.dohHoleContainer);

        // 设置用户信息（可以从 Intent 或数据库加载）
        // 这里我们假设设置了一个示例用户信息

        // 设置头像
        avatarImageView.setImageResource(R.drawable.user_head_png);  // 替换成实际头像图片

        // 设置用户名和账号
        usernameTextView.setText("用户名: JohnDoe");
        accountTextView.setText("账号: johndoe@gmail.com");

        // 设置个人简介和兴趣爱好（假设从数据库获取）
        bioEditText.setText("这是用户的个人简介...");
        interestsEditText.setText("兴趣: 旅游、编程、摄影");

        // 设置树洞信息（假设动态加载数据）
        // 示例树洞内容
        setDohHoleContent();
        
        findViewById(R.id.nav_messages).setOnClickListener(v -> {  // 消息
            Intent intent = new Intent(UserInfoActivity.this, MessagesActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.nav_short_videos).setOnClickListener(v -> {  // 短视频
            Intent intent = new Intent(UserInfoActivity.this, ShortVideosActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.nav_friends).setOnClickListener(v -> { // 好友
            Intent intent = new Intent(UserInfoActivity.this, FriendsActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.nav_user_info).setOnClickListener(v -> { // 用户信息
            Intent intent = new Intent(UserInfoActivity.this, UserInfoActivity.class);
            startActivity(intent);
        });
        
    }

    // 设置树洞内容的示例方法
    private void setDohHoleContent() {
        // 动态添加树洞内容（示例）
        for (int i = 0; i < 2; i++) {
            LinearLayout dohHoleLayout = new LinearLayout(this);
            dohHoleLayout.setOrientation(LinearLayout.HORIZONTAL);
            dohHoleLayout.setLayoutParams(new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            dohHoleLayout.setPadding(0, 0, 0, 12);

            // 树洞图片
            ImageView dohImageView = new ImageView(this);
            dohImageView.setLayoutParams(new LinearLayout.LayoutParams(60, 60));
//            dohImageView.setImageResource(R.drawable.doh_hole_image);  // 设置树洞图片

            // 树洞文本
            TextView dohTextView = new TextView(this);
            dohTextView.setLayoutParams(new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1));
            dohTextView.setText("这是树洞内容的描述...");
            dohTextView.setTextSize(14);
//            dohTextView.setTextColor(getResources().getColor(R.color.textPrimary));  // 设置字体颜色

            // 添加子控件到 LinearLayout
            dohHoleLayout.addView(dohImageView);
            dohHoleLayout.addView(dohTextView);

            // 将树洞内容添加到容器中
            dohHoleContainer.addView(dohHoleLayout);
        }
    }
}
