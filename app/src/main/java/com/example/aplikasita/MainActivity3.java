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

public class MainActivity3 extends AppCompatActivity {
    LineChart linechart;
    DatabaseReference reff;
    ActionBar actionBar;
    ArrayList<Entry> yData;
    ValueEventListener valueEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        linechart = (LineChart) findViewById(R.id.linechart);

        reff= FirebaseDatabase.getInstance().getReference().child("ina219").child("2-push");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                yData = new ArrayList<>();
                float i =0;
                for (DataSnapshot ds : dataSnapshot.getChildren()){
                    i=i+1;
                    String SV = ds.child("power").getValue().toString();
                    Float SensorValue = Float.parseFloat(SV);
                    yData.add(new Entry(i,SensorValue));
                }
                final LineDataSet lineDataSet = new LineDataSet(yData,"Daya");
                LineData data = new LineData(lineDataSet);
                linechart.setData(data);
                linechart.notifyDataSetChanged();
                linechart.invalidate();

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