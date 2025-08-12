package com.example.bai_13_3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FullscreenImageActivity extends AppCompatActivity {
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fullscreen_image);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageView imageView = findViewById(R.id.fullscreenImageView);
        btnBack = findViewById(R.id.btn_back);

        // Lấy ID của hình ảnh được truyền từ MainActivity
        int imageId = getIntent().getIntExtra("imageId", -1);
        if (imageId != -1) {
            imageView.setImageResource(imageId);
        }

        btnBack.setOnClickListener(v -> {
            finish();
        });
    }
}