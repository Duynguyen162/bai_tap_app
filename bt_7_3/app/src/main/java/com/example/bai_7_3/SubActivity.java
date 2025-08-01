package com.example.bai_7_3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SubActivity extends AppCompatActivity {
    EditText edtRA, edtRB;
    Button btnSum,btnDifference;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sub2);

        edtRA = findViewById(R.id.edtRA);
        edtRB = findViewById(R.id.edtRB);
        btnSum = findViewById(R.id.btnSum);
        btnDifference = findViewById(R.id.btnDifference);
        intent = getIntent();
        int a = intent.getIntExtra("a", 0);
        int b = intent.getIntExtra("b", 0);
        edtRA.setText(String.valueOf(a));
        edtRB.setText(String.valueOf(b));
        btnSum.setOnClickListener(v -> {
            int result = a + b;
            Intent resultIntent = new Intent();
            resultIntent.putExtra("result", result);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
        btnDifference.setOnClickListener(v -> {
            int result = a - b;
            Intent resultIntent = new Intent();
            resultIntent.putExtra("result", result);
            setResult(RESULT_OK, resultIntent);
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}