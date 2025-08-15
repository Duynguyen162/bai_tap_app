package com.example.bai_24;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    ListView lvTigia;
    TextView txtdate;
    ArrayList<Tygia> dstygia;
    MyArrayAdapter myadapter;
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

        lvTygia = (ListView) findViewById(R.id.lvl);
        txtdate = (TextView) findViewById(R.id.txtdate);
        getdate();
        dstygia = new ArrayList<Tygia>();
        myadapter = new MyArrayAdapter(MainActivity.this, R.layout.item, dstygia);

        lvTygia.setAdapter(myadapter);
        TyGiaTask task = new TyGiaTask();
        task.execute();
    }
    public void getdate() {
        // Lấy ngày giờ hệ thống
        Date currentDate = Calendar.getInstance().getTime();
        // Format theo định dạng dd/MM/yyyy
        SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
        // Hiển thị lên TextView
        txtdate.setText("Hôm Nay: " + simpleDate.format(currentDate));
    }
    class TyGiaTask extends AsyncTask<Void, Void, ArrayList<Tygia>> {
        @Override
        protected ArrayList<Tygia> doInBackground(Void... params) {
            // TODO Auto-generated method stub
            ArrayList<Tygia> ds = new ArrayList<Tygia>();
            try {
                // Đây là link Server
                URL url = new URL("https://dongabank.com.vn/exchange/export/");
                // Mở Connection ra
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                // Thiết lập Method là Get dữ liệu
                connection.setRequestMethod("GET");
                // Thiết lập thuộc tính nếu đó thuộc loại Json nào, do biết sử dụng công cụ HttpRequester trong FireFox
                connection.setRequestProperty("Content-type", "application/json; charset=utf-8");
                connection.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible)");
                connection.setRequestProperty("Accept", "*/*");
                // Lấy dữ liệu mà server trả về
                InputStream is = connection.getInputStream();
                // Chuyển dữ liệu kiểu UTF-8 và Đưa vào bộ đệm để đọc dữ liệu
                InputStreamReader isr = new InputStreamReader(is, "UTF-8");
                BufferedReader br = new BufferedReader(isr);

                String line = br.readLine();
                StringBuilder builder = new StringBuilder();
                while (line != null) {
                    builder.append(line);
                    line = br.readLine();
                }
                String json = builder.toString();
                // Bôi ngoặc tròn trong dữ liệu trả về
                json = json.replace("(", "");
                json = json.replace(")", "");
                JSONObject jsonObject = new JSONObject(json);
                JSONArray jsonArray = jsonObject.getJSONArray("items");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject item = jsonArray.getJSONObject(i);
                    Tygia tiGia = new Tygia();
                    tiGia.setType(item.getString("type"));
                    if (item.has("imageurl")) {
                        tiGia.setImageurl(item.getString("imageurl"));
                        URL url = new URL(tiGia.getImageurl());
                        connection = (HttpURLConnection) url.openConnection();
                        connection.setRequestMethod("GET");
                        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible)");
                        connection.setRequestProperty("Accept", "*/*");
                        Bitmap bitmap = BitmapFactory.decodeStream(connection.getInputStream());
                        tiGia.setBitmap(bitmap);
                    }
                    if (item.has("muatiemmat")) {
                        tiGia.setMuatiemmat(item.getString("muatiemmat"));
                    }
                    if (item.has("muack")) {
                        tiGia.setMuack(item.getString("muack"));
                    }
                    if (item.has("bantienmat")) {
                        tiGia.setBantienmat(item.getString("bantienmat"));
                    }
                    if (item.has("banck")) {
                        tiGia.setBanck(item.getString("banck"));
                    }
                    ds.add(tiGia);
                }
                Log.d("JSON_DONGA", json);
            } catch (Exception ex) {
                // TODO: handle exception
                Log.e("Lỗi", ex.toString());
            }
            return ds;
        }
    }
    @Override
    protected void onPreExecute() {
        // TODO Auto-generated method stub
        super.onPreExecute();
        myadapter.clear();
    }

    @Override
    protected void onPostExecute(ArrayList<Tygia> result) {
        // TODO Auto-generated method stub
        super.onPostExecute(result);
        myadapter.clear();
        myadapter.addAll(result);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        // TODO Auto-generated method stub
        super.onProgressUpdate(values);
    }

}