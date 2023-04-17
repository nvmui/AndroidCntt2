package com.cntt2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ActivityListview extends AppCompatActivity {
    ListView lvHocVien;
    ArrayList<ListHocVien> listHocViens;
    AdapterHocVien adapterHocVien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        lvHocVien = (ListView) findViewById(R.id.lvDS_Hocvien);
        //Khỏi tạo danh sách cách học viên
        listHocViens = new ArrayList<>();
        listHocViens.add(new ListHocVien("1", "Nguyên An", "12/3/2003", "CNTT1_21"));
        listHocViens.add(new ListHocVien("2", "Nguyên An", "12/3/2003", "CNTT1_21"));
        listHocViens.add(new ListHocVien("3", "Nguyên An", "12/3/2003", "CNTT1_21"));
        listHocViens.add(new ListHocVien("4", "Nguyên An", "12/3/2003", "CNTT1_21"));
        listHocViens.add(new ListHocVien("5", "Nguyên An", "12/3/2003", "CNTT1_21"));
        listHocViens.add(new ListHocVien("6", "Nguyên Hoàng", "11/4/2003", "CNTT2_21"));
        listHocViens.add(new ListHocVien("7", "Nguyên Ngọc", "20/3/2003", "CNTT2_21"));
        adapterHocVien = new AdapterHocVien(listHocViens);
        lvHocVien.setAdapter(adapterHocVien);
    }
}