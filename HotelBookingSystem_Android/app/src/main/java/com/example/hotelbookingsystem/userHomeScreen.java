package com.example.hotelbookingsystem;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class userHomeScreen extends AppCompatActivity {
    Button view_profile, search_room, view_pending, view_reservations, logout;
    EditText heading;
    SharedPreferences sharedpreferences;

    public static final String SHARED_PREF_NAME = "mypref";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userhomepage);

        view_profile = findViewById(R.id.user_viewprofile);
        search_room = findViewById(R.id.user_searchroom);
        view_pending = findViewById(R.id.user_pending);
        view_reservations = findViewById(R.id.user_reservationSummary);
        logout = findViewById(R.id.manager_logout);

        sharedpreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        final String keyRole = sharedpreferences.getString(MainActivity.KEY_USERNAME,"");
//        System.out.println(keyRole);
        view_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(userHomeScreen.this,viewProfile.class));
            }
        });

        view_reservations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(userHomeScreen.this,reservation_summary_guest_Activity.class));
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(userHomeScreen.this,MainActivity.class));

            }
        });

        search_room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(userHomeScreen.this,searchRoomScreen.class));
            }
        });

        view_pending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(userHomeScreen.this,pendingRoomScreen.class));
            }
        });

    }
}
