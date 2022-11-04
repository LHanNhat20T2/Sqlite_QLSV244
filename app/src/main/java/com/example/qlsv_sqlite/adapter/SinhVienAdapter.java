package com.example.qlsv_sqlite.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.qlsv_sqlite.R;
import com.example.qlsv_sqlite.model.SinhVien;

import java.util.List;

public class SinhVienAdapter extends BaseAdapter {
    private List<SinhVien> sinhvienList244;
    private Context context244;
    public SinhVienAdapter(Context context244, List<SinhVien> listList244) {
        this.context244 = context244;
        this.sinhvienList244 = listList244;
    }

    @Override
    public int getCount() {
        return sinhvienList244.size();
    }

    @Override
    public Object getItem(int i) {
        return sinhvienList244.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder244;
        if (view == null)
        {
            viewHolder244 = new ViewHolder();
            //convert resource
            LayoutInflater inflater = (LayoutInflater) context244.getSystemService(context244.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.view_item_sinhvien, null);

            //anh xa
            viewHolder244.tvMaSV244 = view.findViewById(R.id.tv_masv);
            viewHolder244.tvHoTen244 = view.findViewById(R.id.tv_hoten);
            viewHolder244.tvDienThoai244 = view.findViewById(R.id.tv_sdt);
            viewHolder244.tvEmail244 = view.findViewById(R.id.tv_email);
            viewHolder244.ivGioiTinh244 = view.findViewById(R.id.iv_gioitinh);

            view.setTag(viewHolder244);
        }
        else
        {
            viewHolder244 = (ViewHolder) view.getTag();
        }

        //
        SinhVien sv244 = sinhvienList244.get(i);
        viewHolder244.tvMaSV244.setText("Mã SV: " + sv244.getMaSV244());
        viewHolder244.tvHoTen244.setText("Họ tên: " + sv244.getHoTen244());
        viewHolder244.tvDienThoai244.setText("Điện thoại: " + sv244.getDienThoai244());
        viewHolder244.tvEmail244.setText("Email: " + sv244.getEmail244());
        if (sv244.getGioiTinh244() == 0)
        {
            viewHolder244.ivGioiTinh244.setImageResource(R.drawable.avatarnu);
        }
        else
        {

            viewHolder244.ivGioiTinh244.setImageResource(R.drawable.gamer);
        }

        return view;
    }

    class ViewHolder
    {
        ImageView ivGioiTinh244;
        TextView tvMaSV244, tvHoTen244, tvDienThoai244, tvEmail244;
    }
}
