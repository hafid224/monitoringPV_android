package com.example.aplikasita;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyViewholder2> {

    Context context;

    ArrayList<User> list;

    public MyAdapter2(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }

    public MyAdapter2(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewholder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewholder2(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder2 holder, int position) {

        User user= list.get(position);
        holder.current_2.setText(""+user.getCurrent_2());
        holder.bus_voltagevoltage2.setText(""+user.getBus_voltagevoltage2());
        holder.power_2.setText(""+user.getPower_2());
        holder.timenow.setText(user.getTimenow());
        holder.date_today.setText(user.getDate_today());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewholder2 extends RecyclerView.ViewHolder {

        TextView current_2, bus_voltagevoltage2, power_2, timenow, date_today;

        public MyViewholder2(@NonNull View itemView) {
            super(itemView);
            current_2 = itemView.findViewById(R.id.tvarus);
            bus_voltagevoltage2 = itemView.findViewById(R.id.tvtegangan);
            power_2 = itemView.findViewById(R.id.tvdaya);
            timenow = itemView.findViewById(R.id.tvwaktu);
            date_today = itemView.findViewById(R.id.tvtanggal);

        }
    }

}
