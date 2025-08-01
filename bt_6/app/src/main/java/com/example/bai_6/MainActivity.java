package com.example.bai_6;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtten, editCMND, editBosung;
    CheckBox chkdocbao, chkdocsach, chkdoccode;
    Button btnsend;
    RadioGroup group;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edtten = findViewById(R.id.edtten);
        editCMND = findViewById(R.id.editCMND);
        editBosung = findViewById(R.id.editBosung);
        chkdocbao = findViewById(R.id.chkdocbao);
        chkdocsach = findViewById(R.id.chkdocsach);
        chkdoccode = findViewById(R.id.chkdoccode);
        btnsend = findViewById(R.id.btnsend);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void doShowInformation() {
        // kiểm tra tên hợp lệ
        String ten = edtten.getText().toString();
        ten = ten.trim();
        if (ten.length() < 3) {
            edtten.requestFocus();
            edtten.selectAll();
            Toast.makeText(this, "Tên phải >= 3 ký tự", Toast.LENGTH_LONG).show();
            return;
        }

        // kiểm tra CMND hợp lệ
        String cmnd = editCMND.getText().toString();
        cmnd = cmnd.trim();
        if (cmnd.length() != 9) {
            editCMND.requestFocus();
            editCMND.selectAll();
            Toast.makeText(this, "CMND phải đúng 9 ký tự", Toast.LENGTH_LONG).show();
            return;
        }

        // Kiểm tra bằng cấp
        String bangcap = "";
        group = findViewById(R.id.idgroup);
        int id = group.getCheckedRadioButtonId(); // Trả về Id
        if (id == -1) {
            Toast.makeText(this, "Phải chọn bằng cấp", Toast.LENGTH_LONG).show();
            return;
        }

        RadioButton rad = findViewById(id);
        bangcap = rad.getText() + "";

        // Kiểm tra sở thích
        String sothich = "";
        if (chkdocbao.isChecked())
            sothich += chkdocbao.getText() + "\n";
        if (chkdocsach.isChecked())
            sothich += chkdocsach.getText() + "\n";
        if (chkdoccode.isChecked())
            sothich += chkdoccode.getText() + "\n";

        // Lấy thông tin bổ sung
        String bosungtt = editBosung.getText() + "";

        // Tạo Dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông tin cá nhân");
        builder.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
                dialog.cancel();
            }
        });

        // tạo nội dung
        String msg = "Họ tên:\n";
        msg += ten + "\n";
        msg += "CMND:\n";
        msg += cmnd + "\n";
        msg += "Bằng cấp:\n";
        msg += bangcap + "\n";
        msg += "Sở thích:\n";
        msg += sothich;
        msg += "Thông tin bổ sung:\n";
        msg += bosungtt + "\n";

        builder.setMessage(msg); // thiết lập nội dung
        builder.create().show(); // hiển thị Dialog
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AlertDialog.Builder b = new
                AlertDialog.Builder(MainActivity.this);
        b.setTitle("Question");
        b.setMessage("Are you sure you want to exit?");
        b.setIcon(R.drawable.inform);
        b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        b.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        b.show();
    }
}