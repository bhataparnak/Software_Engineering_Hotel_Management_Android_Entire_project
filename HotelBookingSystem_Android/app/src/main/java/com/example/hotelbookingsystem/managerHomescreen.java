package com.example.hotelbookingsystem;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class managerHomescreen extends AppCompatActivity {
    Button manager_profile, manager_viewList, manager_availableRooms, manager_searchRoom, logout;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.managerhomepage);

        manager_profile = findViewById(R.id.manager_profile);
        manager_viewList = findViewById(R.id.manager_listReservation);
        manager_availableRooms = findViewById(R.id.manager_available);
        manager_searchRoom = findViewById(R.id.manager_search);
        logout = findViewById(R.id.manager_logout);

        manager_viewList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(managerHomescreen.this,reservation_summary_manager_Activity.class));
            }
        });

      manager_profile.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              startActivity(new Intent(managerHomescreen.this,managerProfile.class));
          }
      });

      manager_availableRooms.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(managerHomescreen.this, Available_rooms.class);
              startActivity(intent);
          }
      });

      manager_searchRoom.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent = new Intent(managerHomescreen.this, Searchroom.class);
              startActivity(intent);
          }
      });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(managerHomescreen.this,MainActivity.class));
            }
        });
    }
}