package com.cntt2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText soA, soB;
    Button btnTinhTong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        soA = (EditText) findViewById(R.id.SoA);
        soB = (EditText) findViewById(R.id.SoB);
        btnTinhTong = (Button) findViewById(R.id.btnTinhTong);
        btnTinhTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int soa= Integer.parseInt(soA.getText().toString());
                int sob=Integer.parseInt(soB.getText().toString());
                Intent intent=new Intent(MainActivity.this,ActivityTinhtong.class);
                intent.putExtra("soa",soa);
                intent.putExtra("sob",sob);
                startActivity(intent);
            }
        });
    }
}