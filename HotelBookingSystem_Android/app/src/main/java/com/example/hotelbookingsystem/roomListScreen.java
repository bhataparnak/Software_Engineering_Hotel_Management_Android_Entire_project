//package com.example.hotelbookingsystem;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ListView;
//import android.widget.Spinner;
//
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//
//import java.util.ArrayList;
//
//public class roomListScreen extends AppCompatActivity {
//
//    Button homer, logoutr;
//
//    Button home,logout,search;
//
//    EditText nadults,nchild,cidate,codate;
//    Spinner Hloc, Hroom, HNroom;
//
//    ListView room_listView;
//    searchRoomAdapter searchRoomAdapter;
//    ArrayList<Hotel> arrayList;
//
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.room_list);
//
//
//        home = findViewById(R.id.userHome);
//        logout = findViewById(R.id.logout);
//        search = findViewById(R.id.search_r);
//
//        Hloc = (Spinner) findViewById(R.id.Hloc);
//        Hroom = (Spinner) findViewById(R.id.Hroomtype);
//        HNroom = (Spinner) findViewById(R.id.HNroom);
//
//        nadults = findViewById(R.id.Nadults);
//        nchild = findViewById(R.id.Nchild);
//        cidate = findViewById(R.id.cidate);
//        codate = findViewById(R.id.codate);
//
////                System.out.println("Hotel Room Type is " + Hroom.getSelectedItem().toString());
//
//
//
//                homer = findViewById(R.id.userHomer);
//                logoutr = findViewById(R.id.logoutr);
//
//                room_listView = findViewById(R.id.room_listView);
//
//                DBManager dbManager = new DBManager(roomListScreen.this);
//                arrayList = dbManager.getRoomDetails(Hroom.getSelectedItem().toString());
//
//                searchRoomAdapter = new searchRoomAdapter(roomListScreen.this,arrayList);
//                room_listView.setAdapter(searchRoomAdapter);
//                searchRoomAdapter.notifyDataSetChanged();
//
//
//
//
//        home.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                startActivity(new Intent(roomListScreen.this, userHomeScreen.class));
//
//            }
//        });
//
//        logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(roomListScreen.this,MainActivity.class));
//            }
//        });
//
//
//    }
//}
