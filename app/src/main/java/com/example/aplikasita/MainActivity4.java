package com.example.aplikasita;


import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aplikasita.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {

    ListView myListView;
    ArrayList<String> myArraylist = new ArrayList<>();
    DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        ArrayAdapter<String> myArrayAdapter = new ArrayAdapter<String>(MainActivity4.this, android.R.layout.simple_list_item_1,myArraylist);

        myListView=(ListView) findViewById(R.id.listview1);
        myListView.setAdapter(myArrayAdapter);
        mRef = FirebaseDatabase.getInstance().getReference().child("ina219").child("2-push");
        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String arus=snapshot.child("current").getValue().toString();
                String tegangan=snapshot.child("bus_voltagevoltage").getValue().toString();
                String daya=snapshot.child("power").getValue().toString();
                myArraylist.add(arus);
                myArrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                myArrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}