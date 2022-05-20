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

public class MainActivity5 extends AppCompatActivity {
    TextView a,b,c,d,e,histori2;
    DatabaseReference reff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        getSupportActionBar().hide();

        Button button = findViewById(R.id.tombol6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity5.this, MainActivity6.class);
                startActivity(intent);


            }
        });

        TextView textview = findViewById(R.id.histori2);
        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity5.this, userlist2.class);
                startActivity(intent);


            }
        });

        a=(TextView) findViewById(R.id.tvarusbaterai);
        b=(TextView) findViewById(R.id.tvteganganbaterai);
        c=(TextView) findViewById(R.id.tvdayabaterai);
        d=(TextView) findViewById(R.id.waktu2);
        e=(TextView) findViewById(R.id.tanggal2);


        reff= FirebaseDatabase.getInstance().getReference().child("ina219").child("1-set");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String arus=snapshot.child("current_2").getValue().toString();
                String tegangan=snapshot.child("bus_voltagevoltage2").getValue().toString();
                String daya=snapshot.child("power_2").getValue().toString();
                String date=snapshot.child("date_today").getValue().toString();
                String waktu=snapshot.child("timenow").getValue().toString();
                a.setText(arus);
                b.setText(tegangan);
                c.setText(daya);
                e.setText(waktu);
                d.setText(date);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}