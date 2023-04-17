package com.cntt2;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterHocVien extends BaseAdapter {
    final ArrayList<ListHocVien> listHocViens;

    public AdapterHocVien(ArrayList<ListHocVien> listHocViens) {
        this.listHocViens = listHocViens;
    }

    @Override
    public int getCount() {
        return listHocViens.size();
    }

    @Override
    public Object getItem(int position) {
        return listHocViens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        TextView tvma, tvhoten, tvngaysinh, tvlop;
        View viewProduct;
        if (convertView == null) {
            viewProduct = View.inflate(parent.getContext(), R.layout.item_list_hocvien, null);
        } else viewProduct = convertView;
        tvma=(TextView) viewProduct.findViewById(R.id.tvMahv);
        tvhoten=(TextView) viewProduct.findViewById(R.id.tvHoten);
        tvngaysinh=(TextView) viewProduct.findViewById(R.id.tvNgaySinh);
        tvlop=(TextView) viewProduct.findViewById(R.id.tvLop);
        //Gán giá trị hiển thị
        ListHocVien HocVien = (ListHocVien) getItem(i);
        tvma.setText(HocVien.maHV+"");
        Log.e("AA",HocVien.maHV+"");
        tvhoten.setText(HocVien.hovaten);
        Log.e("BB",HocVien.hovaten);
        tvngaysinh.setText(HocVien.ngaysinh);
        tvlop.setText(HocVien.lop);
        return viewProduct;
    }
}
