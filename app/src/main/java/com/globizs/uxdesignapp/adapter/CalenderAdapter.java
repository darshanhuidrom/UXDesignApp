package com.globizs.uxdesignapp.adapter;


import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.globizs.uxdesignapp.R;
import com.globizs.uxdesignapp.modal.DateData;
import com.globizs.uxdesignapp.util.CalenderCaculator;

import java.util.List;

public class CalenderAdapter extends RecyclerView.Adapter<CalenderAdapter.CustomViewHolder> {

    private RvAdapterClickListener rvAdapterClickListener;
    private Context context;
    public static String TAG= CalenderAdapter.class.getSimpleName();
    private List<DateData> dateDataList;
    private int startOfTheWeek;
// adding comments to check commits
    public CalenderAdapter(Context context, List<DateData> dateDataList, RvAdapterClickListener listener) {
        this.context = context;
        this.rvAdapterClickListener=listener;
        this.dateDataList=dateDataList;

    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.date_block, parent, false);
        CustomViewHolder viewHolder = new CustomViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        String dateNo = dateDataList.get(position).getDate();
        String status= dateDataList.get(position).getStatus();
        boolean isSunday= dateDataList.get(position).isSunday();
        boolean isEmpty= dateDataList.get(position).isEmpty();
        int month= dateDataList.get(position).getMonth();
        boolean isTodayDate = dateDataList.get(position).isTodayDate();
        holder.dateNo.setText(dateNo);
        holder.status.setText(status);
        if(isTodayDate&&(CalenderCaculator.getCurrentMonth()==month)){
            holder.dateNo.setTextColor(Color.RED);
        }
        else {
            holder.dateNo.setTextColor(Color.BLACK);
        }

        if(isSunday){
            holder.status.setBackgroundColor(Color.parseColor("#dacc04"));
            holder.status.setText("S");
        }
        if(isEmpty){
            holder.status.setBackgroundColor(Color.TRANSPARENT);
            holder.status.setText("");
        }

    }

    @Override
    public int getItemCount() {
        return dateDataList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        private TextView dateNo;
        private TextView status;

        public CustomViewHolder(View view) {
            super(view);
            dateNo = (TextView) view.findViewById(R.id.tv_date);
            status = (TextView) view.findViewById(R.id.tv_status);
        }

        @Override
        public void onClick(View v) {
            if (rvAdapterClickListener != null)
                rvAdapterClickListener.onItemClick(getAdapterPosition(), v);
        }
    }


    public interface RvAdapterClickListener {
        void onItemClick(int i, View v);
    }

    public void setRvAdapterClickLIstener(RvAdapterClickListener rvAdapterClickListener) {
        this.rvAdapterClickListener = rvAdapterClickListener;
    }

    public void setData(List<DateData> data){
        this.dateDataList=data;
        notifyDataSetChanged();

    }

}

