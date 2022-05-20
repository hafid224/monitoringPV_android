package com.example.aplikasita;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity2 extends AppCompatActivity {
    TextView a,b,c,d,e,histori1;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        getSupportActionBar().hide();

        Button button = findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);


            }
        });

        TextView textview = findViewById(R.id.histori1);
        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, userlist.class);
                startActivity(intent);


            }
        });

        a=(TextView) findViewById(R.id.tvaruspv);
        b=(TextView) findViewById(R.id.tvteganganpv);
        c=(TextView) findViewById(R.id.tvdayapv);
        d=(TextView) findViewById(R.id.waktu1);
        e=(TextView) findViewById(R.id.tanggal1);



        reff= FirebaseDatabase.getInstance().getReference().child("ina219").child("1-set");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String arus=snapshot.child("current").getValue().toString();
                String tegangan=snapshot.child("bus_voltagevoltage").getValue().toString();
                String daya=snapshot.child("power").getValue().toString();
                String date1=snapshot.child("date_today").getValue().toString();
                String waktu1=snapshot.child("timenow").getValue().toString();
                a.setText(arus);
                b.setText(tegangan);
                c.setText(daya);
                d.setText(waktu1);
                e.setText(date1);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}