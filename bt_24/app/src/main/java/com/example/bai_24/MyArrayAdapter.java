package com.example.bai_24;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyArrayAdapter extends ArrayAdapter<Tygia> {
    Activity context;
    int resource;
    List<Tygia> objects;

    public MyArrayAdapter(Activity context, int resource, List<Tygia> objects) {
        super(context, resource, objects);
        // TODO Auto-generated constructor stub
        this.context = context;
        this.objects = objects;
        this.resource = resource;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    // TODO Auto-generated method stub
        LayoutInflater inflater = this.context.getLayoutInflater();
        View item.inflater.inflate(this.resource, null);
        Tygia tygia.this.objects.get(position);
        ImageView imgHinh = (ImageView) item.findViewById(R.id.imgHinh);
        TextView txtType = (TextView) item.findViewById(R.id.txtType);
        TextView txtMuaTM = (TextView) item.findViewById(R.id.txtMuaTM);
        TextView txtBanTM = (TextView) item.findViewById(R.id.txtBanTM);
        TextView txtMuaCK = (TextView) item.findViewById(R.id.txtMuaCK);
        TextView txtBanCK = (TextView) item.findViewById(R.id.txtBanCK);
        imgHinh.setImageBitmap(tygia.getBitmap());
        txtType.setText(tygia.getType());
        txtMuaTM.setText(tygia.getMuatienmat());
        txtBanTM.setText(tygia.getBantuenmat());
        txtMuaCK.setText(tygia.getMuack());
        txtBanCK.setText(tygia.getBanck());
        return item;
    }
}