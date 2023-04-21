package com.cntt2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.cntt2.lop.MonHoc;

import java.util.ArrayList;

public class ActivitySQLite extends AppCompatActivity {
    SQLiteDatabase db;
    EditText tenMon, sotiet;
    Button btnThem, btnXoa;
    ListView lvMon;
    ArrayList<MonHoc> lsmonhoc = new ArrayList<>();
    ArrayAdapter<MonHoc> adapter;
    int idUpdate = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        AnhXa();
        initData();
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xoaText();
            }
        });
        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (idUpdate < 0) {
                    saveMonhoc();
                } else {
                    updateMon();
                }
                LoadData();
                xoaText();
            }
        });
        adapter = new ArrayAdapter<MonHoc>(this, 0, lsmonhoc) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.item_monhoc, null);
                TextView stt = convertView.findViewById(R.id.tvTT);
                TextView tvId = convertView.findViewById(R.id.tvID);
                TextView tvTenmon = convertView.findViewById(R.id.tvTenMon);
                TextView tvTiet = convertView.findViewById(R.id.tvSoTiet);

                MonHoc mon = lsmonhoc.get(position);
                tvId.setText(mon.id + "");
                tvTenmon.setText(mon.tenmon);
                tvTiet.setText(mon.sotiet + "");
                return convertView;
            }
        };
        lvMon.setAdapter(adapter);
        lvMon.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                deleteMon(position);
                LoadData();
                return false;
            }
        });
        lvMon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showInfo(position);
            }
        });
        LoadData();
    }

    private void xoaText() {
        tenMon.setText("");
        sotiet.setText("");
        btnThem.setText("Thêm");
    }

    private void updateMon() {
        String tenm = tenMon.getText().toString();
        int stiet = Integer.parseInt(sotiet.getText().toString());
        String sql = "UPDATE tbl_mon set tenm='" + tenm + "', sotiet= '" + stiet + "' WHERE id= " + idUpdate;
        db.execSQL(sql);
    }

    private void showInfo(int position) {
        MonHoc m = lsmonhoc.get(position);
        tenMon.setText(m.getTenmon());
        sotiet.setText(m.getSotiet() + "");
        idUpdate = m.getId();
        btnThem.setText("Cập Nhật");
    }

    private void deleteMon(int position) {
        int id = lsmonhoc.get(position).getId();
        String sql = "DELETE FROM tbl_mon WHERE id=" + id;
        db.execSQL(sql);
    }

    //Load dữ liệu
    public void LoadData() {
        lsmonhoc.clear();
        String sql = "SELECT * FROM tbl_mon";
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int id = cursor.getInt(0);
            String tenmo = cursor.getString(1);
            int stiet = cursor.getInt(2);
            MonHoc m = new MonHoc();
            m.setId(id);
            m.setTenmon(tenmo);
            m.setSotiet(stiet);
            lsmonhoc.add(m);
            cursor.moveToNext();
        }
        adapter.notifyDataSetChanged();
    }

    private void saveMonhoc() {
        String tenm = tenMon.getText().toString();
        int stiet = Integer.parseInt(sotiet.getText().toString());
        String sql = "INSERT INTO tbl_mon(tenm, sotiet) VALUES('" + tenm + "'," + stiet + ")";
        db.execSQL(sql);
    }

    private void initData() {
        db = openOrCreateDatabase("qlmonhoc.db", 0, null);
        String sql = "CREATE TABLE if not exists tbl_mon(id integer primary key autoincrement, tenm text, sotiet integer)";
        db.execSQL(sql);
    }

    //Hàm ánh xạ
    public void AnhXa() {
        tenMon = findViewById(R.id.editTen);
        sotiet = findViewById(R.id.editSoTiet);
        btnThem = findViewById(R.id.btnThem);
        btnXoa = findViewById(R.id.btnXoa);
        lvMon = findViewById(R.id.lvDMMon);
    }
}