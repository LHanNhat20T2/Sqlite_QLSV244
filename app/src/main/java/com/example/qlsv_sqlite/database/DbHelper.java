package com.example.qlsv_sqlite.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(@Nullable Context context) {
        super(context,"SLSinhVien.sqlite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlSVCreate = "CREATE TABLE IF NOT EXISTS "+
                "SinhVien(MaSV INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "HoTen VARCHAR(200)," +
                "GioiTinh INTEGER," +
                "DienThoai VARCHAR(200), " +
                "Email VARCHAR(200))";
        sqLiteDatabase.execSQL(sqlSVCreate);
        String SqlInsert1="INSERT INTO SinhVien(HoTen,GioiTinh,DienThoai,Email) VALUES('Lương Hàn Nhật','1','2050531200244','hannhat244@gmail.com')";
        String SqlInsert2="INSERT INTO SinhVien(HoTen,GioiTinh,DienThoai,Email) VALUES('Hàn Nhật 1','1','2050531200244','hannhat244@gmail.com')";
        String SqlInsert3="INSERT INTO SinhVien(HoTen,GioiTinh,DienThoai,Email) VALUES('Hàn Nhật 2','0','2050531200244','hannhat244@gmail.com')";
        sqLiteDatabase.execSQL(SqlInsert1);
        sqLiteDatabase.execSQL(SqlInsert2);
        sqLiteDatabase.execSQL(SqlInsert3);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
