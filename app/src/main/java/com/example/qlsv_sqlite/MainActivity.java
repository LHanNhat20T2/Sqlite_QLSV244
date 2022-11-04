package com.example.qlsv_sqlite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.qlsv_sqlite.adapter.SinhVienAdapter;
import com.example.qlsv_sqlite.dao.SinhVienDao;
import com.example.qlsv_sqlite.model.SinhVien;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lvSinhVien244;
    private List<SinhVien> sinhvienList244;
    private SinhVienAdapter adapter244;
    private SinhVienDao svDao244;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // anh xa
        lvSinhVien244 = (ListView) findViewById(R.id.lv_sinhvien);
        // do du lieu
        svDao244 = new SinhVienDao(MainActivity.this);
        sinhvienList244 = svDao244.TatCaSinhVien244();
//
        adapter244 = new SinhVienAdapter(getApplicationContext(), sinhvienList244);
        lvSinhVien244.setAdapter(adapter244);
        //
        SuKien_ListView();
    }
    private void SuKien_ListView() {
            lvSinhVien244.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    SinhVien sv244 = sinhvienList244.get(i);
                    Intent intent244= new Intent(MainActivity.this,EditActivity.class);
                    intent244.putExtra("DULIEU",sv244);
                    startActivity(intent244);
                }
            });
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_them)
        {
            Intent intent244 = new Intent(MainActivity.this, AddActivity.class);
            startActivity(intent244);
        }
        if (id == R.id.menu_thoat)
        {
            finish();
        }
        return true;
    }
    @Override
    protected void onResume() {
        super.onResume();
        sinhvienList244.clear();
        sinhvienList244.addAll(svDao244.TatCaSinhVien244());
        adapter244.notifyDataSetChanged();
    }
}