package com.globizs.edulooker.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.globizs.edulooker.R;
import com.globizs.edulooker.datamodal.MontahData;

import java.util.ArrayList;

public class MonthArrayAdapter extends ArrayAdapter {


    int selectedItem;
    private AlertDialog.Builder builderSingle;

    public static class ViewHolder {
        TextView title;
        RadioButton rb;
        RelativeLayout layout;
    }

    public MonthArrayAdapter(Context context, ArrayList<MontahData> dataList, int selectedItem) {
        super(context, R.layout.list_item, dataList);
        this.selectedItem = selectedItem;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MontahData item = (MontahData) getItem(position);
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_item, parent, false);
            viewHolder.title = (TextView) convertView.findViewById(R.id.list_item);
            viewHolder.rb = (RadioButton) convertView.findViewById(R.id.radioButton);
            viewHolder.layout = (RelativeLayout) convertView.findViewById(R.id.layout);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.title.setText(item.getMonth());
        if (position == selectedItem) {
            viewHolder.rb.setChecked(true);
        } else {
            viewHolder.rb.setChecked(false);
        }

        viewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return convertView;
    }


}
