package com.example.qlsv_sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qlsv_sqlite.dao.SinhVienDao;
import com.example.qlsv_sqlite.model.SinhVien;

public class EditActivity extends AppCompatActivity {
    private EditText edtHoTen244,edtEmail244,edtDienThoai244;
    private RadioGroup rgGioiTinh244;
    private RadioButton rbNam244, rbNu244;
    private Button btnLuu244,btnThoat244;
    private SinhVienDao svDAO244;
    int gioitinh244;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_edit);
        svDAO244=new SinhVienDao(EditActivity.this);
        //Lấy dữ liệu
        Intent intent244 = getIntent();
        SinhVien sinhvien244 = (SinhVien) intent244.getSerializableExtra("DULIEU");
        //anhxa
        AnhXa();
        //lấy dữ liệu lên view
        edtHoTen244.setText(sinhvien244.getHoTen244());
        edtEmail244.setText(sinhvien244.getEmail244());
        edtDienThoai244.setText(sinhvien244.getDienThoai244());
        if(sinhvien244.getGioiTinh244()==1)
        {
            rbNam244.setChecked(true);
            gioitinh244=1;
        }
        else{
            rbNu244.setChecked(true);
            gioitinh244=0;
        }


        btnThoat244.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //su kien cho gioi tinh
        rgGioiTinh244.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i==R.id.rb_nam){
                    gioitinh244=1;

                }
                else {
                    gioitinh244=0;
                }
            }
        });
        //lưu
        btnLuu244.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sinhvien244.setHoTen244(edtHoTen244.getText().toString());
                sinhvien244.setEmail244(edtEmail244.getText().toString());
                sinhvien244.setDienThoai244(edtDienThoai244.getText().toString());
                sinhvien244.setGioiTinh244(gioitinh244);
                svDAO244.CapNhatSinhVien(sinhvien244);
                Toast.makeText(EditActivity.this, "Lưu thành công", Toast.LENGTH_SHORT).show();
            }
        });
}
private void AnhXa() {
        edtHoTen244= (EditText) findViewById(R.id.edt_hoten);
    edtEmail244= (EditText) findViewById(R.id.edt_email);
    edtDienThoai244= (EditText) findViewById(R.id.edt_dienthoai);
    rgGioiTinh244=(RadioGroup) findViewById(R.id.rg_gioitinh);
    rbNam244=(RadioButton) findViewById(R.id.rb_nam);
    rbNu244=(RadioButton) findViewById(R.id.rb_nu);
    btnLuu244=(Button)  findViewById(R.id.btn_luu);
    btnThoat244=(Button)  findViewById(R.id.btn_thoat);
    }
}
