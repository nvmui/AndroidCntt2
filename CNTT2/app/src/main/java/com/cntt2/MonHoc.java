package com.cntt2;

public class MonHoc {
    public int mamon;
    public String tenmon;
    public int sotiet;

    public MonHoc(int mamon, String tenmon, int sotiet) {
        this.mamon = mamon;
        this.tenmon = tenmon;
        this.sotiet = sotiet;
    }

    public int getMamon() {
        return mamon;
    }

    public void setMamon(int mamon) {
        this.mamon = mamon;
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public int getSotiet() {
        return sotiet;
    }

    public void setSotiet(int sotiet) {
        this.sotiet = sotiet;
    }
}
