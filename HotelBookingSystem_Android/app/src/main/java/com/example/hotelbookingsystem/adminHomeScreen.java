package com.example.hotelbookingsystem;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class adminHomeScreen extends AppCompatActivity {

    Button admin_view, admin_search, admin_logout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adminhomepage);

        admin_view = findViewById(R.id.admin_view);
        admin_search = findViewById(R.id.admin_search);
        admin_logout = findViewById(R.id.admin_logout);

        admin_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(adminHomeScreen.this,adminProfile.class));
            }
        });
        admin_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(adminHomeScreen.this,searchGusetManager.class));
            }
        });

        admin_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(adminHomeScreen.this,MainActivity.class));
            }
        });
    }
}
