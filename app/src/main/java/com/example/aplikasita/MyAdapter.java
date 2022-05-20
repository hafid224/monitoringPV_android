package com.example.aplikasita;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;

    ArrayList<User> list;

    public MyAdapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        User user= list.get(position);
        holder.current.setText(""+user.getCurrent());
        holder.bus_voltagevoltage.setText(""+user.getBus_voltagevoltage());
        holder.power.setText(""+user.getPower());
        holder.timenow.setText(user.getTimenow());
        holder.date_today.setText(user.getDate_today());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView current, bus_voltagevoltage, power, timenow, date_today;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            current=itemView.findViewById(R.id.tvarus);
            bus_voltagevoltage=itemView.findViewById(R.id.tvtegangan);
            power=itemView.findViewById(R.id.tvdaya);
            timenow=itemView.findViewById(R.id.tvwaktu);
            date_today=itemView.findViewById(R.id.tvtanggal);
        }
    }
}
