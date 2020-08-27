package com.example.hotelbookingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

public class custom_list extends AppCompatActivity {

    Button search;
    EditText lastName;
    ListView cus_list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);

        lastName = findViewById(R.id.admin_lastname);
        cus_list = findViewById(R.id.cus_list);
        String abc = lastName.getText().toString();
        DBManager dbManager = new DBManager(custom_list.this);
//        List<Profile> res = dbManager.getUsers(abc);

//        ArrayAdapter ns = new ArrayAdapter<Profile>(this,android.R.layout.simple_list_item_1,res);
//        cus_list.setAdapter(ns);


    }
}