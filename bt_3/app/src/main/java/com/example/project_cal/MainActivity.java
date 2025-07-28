package com.example.project_cal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText editTextA,editTextB,editTextSum;
    Button btnTong , btnHieu,btnTich ,btnThuong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        editTextA = findViewById(R.id.editTextA);
        editTextB = findViewById(R.id.editTextB);
        editTextSum = findViewById(R.id.editTextAnswer);
        btnTong =findViewById(R.id.btnTong);
        btnHieu =findViewById(R.id.btnHieu);
        btnTich =findViewById(R.id.btnTich);
        btnThuong =findViewById(R.id.btnThuong);

        btnTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(editTextA.getText().toString());
                int b = Integer.parseInt(editTextB.getText().toString());
                String tong = Integer.toString(a+b);
                editTextSum.setText(tong);

            }
        });

        btnHieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(editTextA.getText().toString());
                int b = Integer.parseInt(editTextB.getText().toString());
                String hieu = Integer.toString(a-b);
                editTextSum.setText(hieu);
            }
        });


        btnTich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(editTextA.getText().toString());
                int b = Integer.parseInt(editTextB.getText().toString());
                String tich = Integer.toString(a*b);
                editTextSum.setText(tich);
            }
        });

        btnThuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(editTextA.getText().toString());
                int b = Integer.parseInt(editTextB.getText().toString());
                String thuong = Double.toString((double) a/b);
                editTextSum.setText(thuong);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}