package com.cntt2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ActivitySQLiteDiem extends AppCompatActivity {
    EditText tenmonhoc, sotiet;
    Button btnAddMon, btnXoaText;
    ListView lvDSMon;
    SQLiteDatabase db;
    ArrayList<MonHoc> monHocs = new ArrayList<>();
    ArrayAdapter<MonHoc> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_diem);
        AnhXa();
        initDataBase();
        btnAddMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddMonHoc();
                loadData();
            }
        });
        adapter=new ArrayAdapter<MonHoc>(this,0,monHocs){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.item_dsmonhoc, null);
                TextView ma_mon=convertView.findViewById(R.id.mamon);
                TextView ten_mon=convertView.findViewById(R.id.tenmon);
                TextView so_tiet=convertView.findViewById(R.id.sotiet);
                MonHoc mon = monHocs.get(position);
                ma_mon.setText(mon.mamon + "");
                ten_mon.setText(mon.tenmon);
                so_tiet.setText(mon.sotiet + "");
                return convertView;
            }
        };
        lvDSMon.setAdapter(adapter);
        loadData();
    }

    private void loadData() {
        monHocs.clear();
        String sql = "SELECT * FROM tbl_dmmon";
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int id = cursor.getInt(0);
            String tenmo = cursor.getString(1);
            int stiet = cursor.getInt(2);
            MonHoc m = new MonHoc(id, tenmo,stiet);

//            m.setId(id);
//            m.setTenmon(tenmo);
//            m.setSotiet(stiet);
            monHocs.add(m);
            cursor.moveToNext();
        }
        adapter.notifyDataSetChanged();
    }

    private void AddMonHoc() {
        String ten_mon = tenmonhoc.getText().toString();
        int so_tiet = Integer.parseInt(sotiet.getText().toString());
        if (ten_mon == "") {
            Toast.makeText(this, "Bạn phải nhập tên môn", Toast.LENGTH_LONG).show();
        } else {
            String sql = "insert into tbl_dmmon(tenmon,sotiet) values(" +
                    "'" + ten_mon + "'," + so_tiet + ")";
            db.execSQL(sql);
        }
    }

    private void initDataBase() {
        db = openOrCreateDatabase("qldiem.db", 0, null);
        String sql = "create table if not exists tbl_dmmon(mamon integer primary key autoincrement, tenmon text not null, sotiet integer)";
        db.execSQL(sql);
    }

    private void AnhXa() {
        tenmonhoc = findViewById(R.id.edit_TenMon);
        sotiet = findViewById(R.id.edit_Sotiet);
        btnAddMon = findViewById(R.id.btnAddMon);
        btnXoaText = findViewById(R.id.btnXoaText);
        lvDSMon = findViewById(R.id.lvDSMon);
    }
}