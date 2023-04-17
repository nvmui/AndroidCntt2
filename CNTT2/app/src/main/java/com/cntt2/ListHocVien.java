package com.cntt2;

public class ListHocVien {
    public String maHV;
    public String hovaten;
    public String ngaysinh;
    public String lop;

    public ListHocVien(String maHV, String hovaten, String ngaysinh, String lop) {
        this.maHV = maHV;
        this.hovaten = hovaten;
        this.ngaysinh = ngaysinh;
        this.lop = lop;
    }

    public String getMaHV() {
        return maHV;
    }

    public void setMaHV(String maHV) {
        this.maHV = maHV;
    }

    public String getHovaten() {
        return hovaten;
    }

    public void setHovaten(String hovaten) {
        this.hovaten = hovaten;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }
}
