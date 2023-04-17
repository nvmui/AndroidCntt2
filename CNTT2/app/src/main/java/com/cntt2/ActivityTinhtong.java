package com.cntt2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTinhtong extends AppCompatActivity {
    TextView tvsoa, tvsob, tvkq, tvkqtich;
    Button btnTich;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinhtong);
        AnhXa();
        Intent intent = getIntent();
        int a, b;
        a = intent.getIntExtra("soa", 0);
        b = intent.getIntExtra("sob", 0);
        tvsoa.setText("Số a là:" + a + "");
        tvsob.setText("Số b là:" + b + "");
        tvkq.setText("Kết quả của " + a + " + " + b + " là:");
    }

    //Hàm khởi tạo
    public void AnhXa() {
        tvsoa = (TextView) findViewById(R.id.tvSoA);
        tvsob = (TextView) findViewById(R.id.tvSoB);
        tvkq = (TextView) findViewById(R.id.tvKQ);
        tvkqtich = (TextView) findViewById(R.id.tvKQtich);
        btnTich = (Button) findViewById(R.id.btnTich);
    }
}