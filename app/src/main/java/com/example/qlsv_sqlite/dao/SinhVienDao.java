package com.example.qlsv_sqlite.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.qlsv_sqlite.database.DbHelper;
import com.example.qlsv_sqlite.model.SinhVien;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SinhVienDao {
    private DbHelper csdl244;
    public SinhVienDao(Context context244)
    {
        csdl244 = new DbHelper(context244);
    }

    //Lấy tất cả sinh viên
    public List<SinhVien> TatCaSinhVien244() {
        String sql = "SELECT * FROM SinhVien";
        List<SinhVien> sinhVienList244 = new ArrayList<SinhVien>();
        SQLiteDatabase database244 = csdl244.getReadableDatabase();
        Cursor cursor = database244.rawQuery(sql, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast())
        {
            int masv244 = cursor.getInt(0);
            String hoten244=cursor.getString(1);
            int gioitinh244 =cursor.getInt(2);
            String dienthoai244 =cursor.getString(3);
            String email244 =cursor.getString(4);
            SinhVien sv=new SinhVien (masv244,hoten244,gioitinh244,dienthoai244,email244);
            sinhVienList244.add(sv);
            cursor.moveToNext();
        }
        return sinhVienList244;
    }
    //Thêm Sinh Viên
    public void ThemSinhVien(SinhVien sv){
        SQLiteDatabase database =csdl244.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put("HoTen",sv.getHoTen244());
        values.put("GioiTinh",sv.getGioiTinh244());
        values.put("DienThoai",sv.getDienThoai244());
        values.put("Email",sv.getEmail244());
        database.insert("SinhVien","",values);
    }
    //cập nhât sinh viên
    public void CapNhatSinhVien(SinhVien sv) {
        SQLiteDatabase database =csdl244.getWritableDatabase();
        ContentValues values =new ContentValues();
        values.put("HoTen",sv.getHoTen244());
        values.put("Email",sv.getEmail244());
        values.put("DienThoai",sv.getDienThoai244());
        values.put("GioiTinh",sv.getGioiTinh244());
        String masv =String.valueOf(sv.getMaSV244());
        String thamso[]= {masv};
        database.update("SinhVien",values,"MaSV=?",thamso);



    }

}