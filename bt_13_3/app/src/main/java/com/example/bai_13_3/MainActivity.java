package com.example.bai_13_3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private int[] imageIds = {
            R.drawable.image1, R.drawable.image2, R.drawable.image3,
            R.drawable.image4, R.drawable.image5,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        GridView gridView = findViewById(R.id.gridView);
        gridView.setAdapter(new ImageAdapter(this, imageIds));

        gridView.setOnItemClickListener((parent, view, position, id) -> {
            // Khi người dùng click vào hình ảnh, chuyển sang cửa sổ khác để phóng to hình ảnh
            Intent intent = new Intent(MainActivity.this, FullscreenImageActivity.class);
            intent.putExtra("imageId", imageIds[position]);
            startActivity(intent);
        });
    }
}