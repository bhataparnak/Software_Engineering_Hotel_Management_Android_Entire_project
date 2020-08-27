package com.example.hotelbookingsystem;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class searchGusetManager extends AppCompatActivity {

    Button search,logout;
    EditText lastName;
    ListView lv_customerList;
    ArrayList<Profile> arrayList;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.search_guest_manager);


        lastName = findViewById(R.id.admin_lastname);
        search = findViewById(R.id.admin_search);
        lv_customerList = findViewById(R.id.admin_list);

        logout = findViewById(R.id.searchAdminLogout);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(searchGusetManager.this,MainActivity.class));
            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // startActivity(new Intent(searchGusetManager.this,custom_list.class));
                String abc = lastName.getText().toString();
                //arrayList = new ArrayList<>();
                DBManager dbManager = new DBManager(searchGusetManager.this);
                arrayList = dbManager.getAllUsers(abc);

                myAdapter = new MyAdapter(searchGusetManager.this,arrayList);
                lv_customerList.setAdapter(myAdapter);
                myAdapter.notifyDataSetChanged();


//                Cursor cursor = dbManager.getEveryone(abc);
//
//
//                String fn,ln,role;
//
//                List<Profile> ans = new ArrayList<>();
//
//
//                if(cursor.getCount()>0)
//                {
//                    while(cursor.moveToNext())
//                    {
//                     //   String un = cursor.getString(1);
//                        fn = cursor.getString(3);
//                        ln = cursor.getString(4);
//                        role = cursor.getString(15);
//
//                        Profile profile = new Profile(role,ln,fn);
//                        ans.add(profile);
//                    }
//                }
//
//
//
//                ArrayAdapter newS = new ArrayAdapter<Profile>(searchGusetManager.this,android.R.layout.simple_list_item_1,ans);
//                lv_customerList.setAdapter(newS);


              //  Toast.makeText(searchGusetManager.this,profile.toString(), Toast.LENGTH_SHORT).show();


            }
        });

//        String abc = lastName.getText().toString();
    }
}
