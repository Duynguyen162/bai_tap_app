package com.example.bai_13_so2_1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    MyArrayAdapter myArrayAdapter;

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

    }
    private void initial() {
        GridView gridView = findViewById(R.id.gridView);
        List<Image> imageList = List.of(
                new Image("Image 1", R.drawable.image1),
                new Image("Image 2", R.drawable.image2),
                new Image("Image 3", R.drawable.image3),
                new Image("Image 4", R.drawable.image4),
                new Image("Image 5", R.drawable.image5)
        );
        myArrayAdapter = new MyArrayAdapter(this,R.layout.list_view_item, imageList);
        gridView.setAdapter(myArrayAdapter);

        gridView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(this,ResultActivity.class);
            Image current = myArrayAdapter.getItem(position);
            Bundle bundle = new Bundle();
            bundle.putString("name", current.getName());
            bundle.putInt("imgId", current.getImgId());
            intent.putExtras(bundle);
            startActivity(intent);
        });



    }
}