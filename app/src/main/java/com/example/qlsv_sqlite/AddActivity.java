package com.example.qlsv_sqlite;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qlsv_sqlite.dao.SinhVienDao;
import com.example.qlsv_sqlite.model.SinhVien;
import android.os.Bundle;

public class AddActivity extends AppCompatActivity {
    EditText edtHoTen244,edtEmail244,edtDienThoai244;
    RadioGroup rgGioiTinh244;
    Button btnThem244,btnThoat244;
    int gioitinh = 1;
    private SinhVienDao svDao244;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        //AnhXa
        AnhXa();
        svDao244=new SinhVienDao(AddActivity.this);
        rgGioiTinh244.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i==R.id.rb_nam){
                    gioitinh=1;
                }
                else{
                    gioitinh=0;
                }
            }
        });
        btnThem244.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String hoten =edtHoTen244.getText().toString();
                String email =edtEmail244.getText().toString();
                String dienthoai =edtDienThoai244.getText().toString();
                SinhVien sv = new SinhVien(hoten,gioitinh,dienthoai,email);
                svDao244.ThemSinhVien(sv);
            }
        });

        btnThoat244.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public void AnhXa() {
        edtHoTen244 =(EditText) findViewById(R.id.edt_hoten);
        edtEmail244 =(EditText) findViewById(R.id.edt_email);
        edtDienThoai244 =(EditText) findViewById(R.id.edt_dienthoai);
        rgGioiTinh244=(RadioGroup) findViewById(R.id.rg_gioitinh);
        btnThem244=(Button) findViewById(R.id.btn_them);
        btnThoat244=(Button) findViewById(R.id.btn_thoat);

    }
}