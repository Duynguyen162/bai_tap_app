package com.example.bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    Button btnChandoan;
    EditText editChieucao, editCannang, editBMI, editChandoan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnChandoan = findViewById(R.id.btnBMI);
        editChieucao = findViewById(R.id.edtchieucao);
        editCannang = findViewById(R.id.edtcannang);
        editBMI = findViewById(R.id.edtBMI);
        editChandoan = findViewById(R.id.edtChandoan);

        btnChandoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy chiều cao và cân nặng
                double H = Double.parseDouble(editChieucao.getText().toString());
                double W = Double.parseDouble(editCannang.getText().toString());

                // Tính BMI
                double BMI = W / Math.pow(H, 2);

                // Chan đoán
                String chandoan;
                if (BMI < 18) {
                    chandoan = "Bạn gầy";
                } else if (BMI < 24.9) {
                    chandoan = "Bạn bình thường";
                } else if (BMI < 29.9) {
                    chandoan = "Bạn béo phì độ 1";
                } else if (BMI < 34.9) {
                    chandoan = "Bạn béo phì độ 2";
                } else {
                    chandoan = "Bạn béo phì độ 3";
                }

                // Hiển thị kết quả
                DecimalFormat dcf = new DecimalFormat("0.0");
                editBMI.setText(dcf.format(BMI));
                editChandoan.setText(chandoan);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}