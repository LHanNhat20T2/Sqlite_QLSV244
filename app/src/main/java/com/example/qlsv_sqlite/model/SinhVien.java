package com.example.qlsv_sqlite.model;

import java.io.Serializable;

public class SinhVien implements Serializable {
    private int MaSV244;
    private String HoTen244;
    private int GioiTinh244;
    private String DienThoai244;
    private String Email244;


    public SinhVien() {
    }
    public SinhVien(String hoTen244, int gioiTinh244, String dienThoai244, String email244) {
        HoTen244 = hoTen244;
        GioiTinh244 = gioiTinh244;
        DienThoai244 = dienThoai244;
        Email244 = email244;
    }

    public SinhVien(int maSV244, String hoTen244, int gioiTinh244, String dienThoai244, String email244) {
        MaSV244 = maSV244;
        HoTen244 = hoTen244;
        GioiTinh244 = gioiTinh244;
        DienThoai244 = dienThoai244;
        Email244 = email244;
    }

    public int getMaSV244() {
        return MaSV244;
    }

    public void setMaSV244(int maSV244) {
        MaSV244 = maSV244;
    }

    public String getHoTen244() {
        return HoTen244;
    }

    public void setHoTen244(String hoTen244) {
        HoTen244 = hoTen244;
    }

    public int getGioiTinh244() {
        return GioiTinh244;
    }

    public void setGioiTinh244(int gioiTinh244) {
        GioiTinh244 = gioiTinh244;
    }

    public String getDienThoai244() {
        return DienThoai244;
    }

    public void setDienThoai244(String dienThoai244) {
        DienThoai244 = dienThoai244;
    }

    public String getEmail244() {
        return Email244;
    }

    public void setEmail244(String email244) {
        Email244 = email244;
    }
}
