package com.cntt2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class ActivitySpinner extends AppCompatActivity {
    Spinner spinner, spinner1, spinner2;
    String[] nguyenthu;
    String[] presidents;
    String[] tpt = {"Trường THPT Nguyễn Trãi", "Trường THPT Nguyễn Hiền", "Trường THPT Trường Chinh", "Trường THPT Thái Phiên", "Trường THPT Lê Quý Đôn", "Trường THPT Phan Chu Trinh"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        spinner = (Spinner) findViewById(R.id.spinner1);
        spinner1 = (Spinner) findViewById(R.id.spinner);
        spinner2 = (Spinner) findViewById(R.id.spinner2);

//      sử dụng spiner 2
        nguyenthu = getResources().getStringArray(R.array.a_array);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, nguyenthu);
        spinner2.setAdapter(adapter1);

        presidents = getResources().getStringArray(R.array.presidents_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, presidents);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int i = parent.getSelectedItemPosition();
                Toast.makeText(getBaseContext(), "Bạn vừa chọn : " + presidents[i], Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, tpt);
//        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(arrayAdapter);
    }
}