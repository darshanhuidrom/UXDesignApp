package com.globizs.uxdesignapp.adapter;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.globizs.uxdesignapp.R;
import com.globizs.uxdesignapp.modal.MontahData;
import com.globizs.uxdesignapp.util.Constant;

import java.util.ArrayList;

public class MonthListAdapter extends BaseAdapter {
    private  Context context;
    private  ArrayList<MontahData> data;
    private Dialog dialog;
    private int selected;
    MonthSelectedListener listener;


    public  interface MonthSelectedListener{
        void onMonthSelectedListener(String name, int position);
    }

    public MonthListAdapter(Dialog dialog,Context context, ArrayList<MontahData> data ,int selected,MonthSelectedListener listener){
        this.context=context;
        this.data=data;
        this.selected=selected;
        this.dialog=dialog;
        this.listener=listener;
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.list_item,parent,false);
        TextView textView = convertView.findViewById(R.id.list_item);
        RadioButton rb= convertView.findViewById(R.id.radioButton);
        RelativeLayout layout =convertView.findViewById(R.id.layout);
        textView.setText(data.get(position).getMonth());
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Click position " + position,
                        Toast.LENGTH_SHORT).show();
                dialog.dismiss();
                selected=position;
                listener.onMonthSelectedListener(Constant.MONTH_NAMES[position],position);
            }
        });
        if(selected==position){
            rb.setChecked(true);
        }
        else {
            rb.setChecked(false);
        }
        return convertView;
    }
}
