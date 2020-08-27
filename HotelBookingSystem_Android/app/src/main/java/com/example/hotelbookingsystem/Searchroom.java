package com.example.hotelbookingsystem;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

public class Searchroom extends AppCompatActivity {
    Button navigate_home, search_room, log, availLogout;
    TextView room_number , room_status , room_price , room_type ;
    DBManager db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = new DBManager(this);
        setContentView(R.layout.activity_searchroom);
        navigate_home = (Button)findViewById(R.id.button8);
        navigate_home.setMovementMethod(LinkMovementMethod.getInstance());
        navigate_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Searchroom.this, managerHomescreen.class);
                startActivity(intent);
            }
        });




        log = findViewById(R.id.availLogout);

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Searchroom.this,MainActivity.class));
            }
        });

        search_room = (Button)findViewById(R.id.search_room);
        search_room.setMovementMethod(LinkMovementMethod.getInstance());
        search_room.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent roomintent = new Intent(Searchroom.this, Searchroom.class);
                Log.i("inside oncick ","inside oncick");
                room_number = (TextView)findViewById( R.id.room_number );
                room_status = (TextView)findViewById( R.id.room_status );
                room_price = (TextView)findViewById( R.id.room_price );
                room_type = (TextView)findViewById( R.id.room_type );
                /*room_number.setText("1234");
                room_status.setText("occ");
                room_price.setText("1000");
                room_type.setText("st");*/

                EditText editText=findViewById(R. id. editText1);
                String roomNumber =editText. getText(). toString();
                HashMap<String,String> roomMap =  db.getHotelData(roomNumber);
                room_number = (TextView)findViewById( R.id.room_number );
                room_status = (TextView)findViewById( R.id.room_status );
                room_price = (TextView)findViewById( R.id.room_price );
                room_type = (TextView)findViewById( R.id.room_type );
                room_number.setText(roomMap.get("RoomNumber"));
                room_status.setText(roomMap.get("roomStatus"));
                room_price.setText(roomMap.get("pricePerNight"));
                room_type.setText(roomMap.get("roomType"));
                Log.i("RoomNumber ",room_number.getText().toString());
                Log.i("roomStatus ",room_status.getText().toString());
                Log.i("pricePerNight ",room_price.getText().toString());
                Log.i("roomType ",room_type.getText().toString());
                //startActivity(roomintent);
            }
        });

    }
}