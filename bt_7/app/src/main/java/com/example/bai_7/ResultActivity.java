package com.example.bai_7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {
    EditText edtKQ;
    Button btnBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_result2);
        edtKQ = findViewById(R.id.edtKQ);
        btnBack = findViewById(R.id.button);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("mypackage");
        int a = bundle.getInt("soa");
        int b = bundle.getInt("sob");
        String kq = "";
        if (a == 0 && b == 0) {
            kq = "vô số nghiệm";
        } else if (a == 0 && b != 0) {
            kq = "vô nghiệm";
        } else {
            DecimalFormat dcf = new DecimalFormat("0.##");
            kq = "x = " + dcf.format((-b * 1.0/ a));
        }
        edtKQ.setText(kq);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}