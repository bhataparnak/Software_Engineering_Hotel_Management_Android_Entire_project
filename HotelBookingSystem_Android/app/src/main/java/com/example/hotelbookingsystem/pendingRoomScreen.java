package com.example.hotelbookingsystem;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class pendingRoomScreen extends AppCompatActivity {

    Button home,logout;
    ListView pendingList;
    PendingAdapter pendingAdapter;
    ArrayList<Reservation> arrayList1;

    SharedPreferences sharedpreferences;
    public static final String SHARED_PREF_NAME = "mypref";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guest_pending_reservation_layout);

        home = findViewById(R.id.pendingHome);
        logout = findViewById(R.id.pendingLogout);

        pendingList = findViewById(R.id.pendingList);

        sharedpreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        final String ln = sharedpreferences.getString(MainActivity.KEY_LASTNAME,"");
        final String fn = sharedpreferences.getString(MainActivity.KEY_FIRSTNAME,"");
        final String user = sharedpreferences.getString(MainActivity.KEY_USERNAME,"");

        DBManager dbManager = new DBManager(pendingRoomScreen.this);

        arrayList1 = dbManager.getPendningDetails(fn,ln,user);

        pendingAdapter = new PendingAdapter(pendingRoomScreen.this,arrayList1);
        pendingList.setAdapter(pendingAdapter);
        pendingAdapter.notifyDataSetChanged();



        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(pendingRoomScreen.this,userHomeScreen.class));
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(pendingRoomScreen.this,MainActivity.class));
            }
        });
    }
}
