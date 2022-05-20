package com.example.aplikasita;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity6 extends AppCompatActivity {
    LineChart linechart2;
    DatabaseReference reff2;
    ActionBar actionBar;
    ArrayList<Entry> yData2;
    ValueEventListener valueEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        linechart2 = (LineChart) findViewById(R.id.linechart2);

        reff2= FirebaseDatabase.getInstance().getReference().child("ina219").child("2-push");
        reff2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                yData2 = new ArrayList<>();
                float i =0;
                for (DataSnapshot ds : dataSnapshot.getChildren()){
                    i=i+1;
                    String SV = ds.child("power_2").getValue().toString();
                    Float SensorValue = Float.parseFloat(SV);
                    yData2.add(new Entry(i,SensorValue));
                }
                final LineDataSet lineDataSet = new LineDataSet(yData2,"Daya");
                LineData data = new LineData(lineDataSet);
                linechart2.setData(data);
                linechart2.notifyDataSetChanged();
                linechart2.invalidate();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}