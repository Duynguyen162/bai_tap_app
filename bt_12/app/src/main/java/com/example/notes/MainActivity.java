package com.example.notes;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bai_12.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<String> arraywork;
    ArrayAdapter<String> arrAdapter;
    EditText edwork, edth, edtn;
    TextView txtdate;
    View btnwork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);
        edwork = findViewById(R.id.edtcongviec);
        edth = findViewById(R.id.edtthoigian);
        edtn = findViewById(R.id.edtngay);
        txtdate = findViewById(R.id.txtdate);
        btnwork = findViewById(R.id.btnnhap);

        // Khởi tạo ArrayList rỗng
        arraywork = new ArrayList<>();

        // Gán dữ liệu từ arraywork vào Adapter
        arrAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arraywork);
        lv.setAdapter(arrAdapter);

        // Hiển thị ngày hiện tại
        Date currentDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        txtdate.setText("Hôm Nay: " + simpleDateFormat.format(currentDate));

        // Xử lý khi nhấn nút nhập công việc
        btnwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edwork.getText().toString().equals("") ||
                        edth.getText().toString().equals("") ||
                        edtn.getText().toString().equals("")) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Info missing");
                    builder.setMessage("Please enter all information of the work");
                    builder.setPositiveButton("Continue", null);
                    builder.show();
                } else {
                    String str = edwork.getText().toString() + " - " + edth.getText().toString();
                    arraywork.add(str);
                    arrAdapter.notifyDataSetChanged();

                    // Reset lại các ô nhập
                    edwork.setText("");
                    edth.setText("");
                    edtn.setText("");
                }
            }
        });
    }
}
