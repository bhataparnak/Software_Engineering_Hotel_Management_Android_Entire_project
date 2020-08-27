package com.example.hotelbookingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import static com.example.hotelbookingsystem.DBManager.Booking_id;
import static com.example.hotelbookingsystem.DBManager.Number_of_rooms;
import static com.example.hotelbookingsystem.DBManager.Reservations;

public class Modify_Reservation_Guest_Activity extends AppCompatActivity {


    DBManager DBManager;
    SQLiteDatabase sqLiteDatabase;
    Cursor cursor;
    Button ButtonLogOut, ButtonHome, ButtonModify;


    String[] autoRoomType = { "Standard","Deluxe","Suite"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_modify_reservation_guest_);


        ButtonLogOut = (Button) findViewById(R.id.button_logout);
        ButtonHome = (Button) findViewById(R.id.button_home);
        ButtonModify = (Button) findViewById(R.id.button_Modify);

        //Create Array Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_singlechoice, autoRoomType);
        //Find TextView control
        AutoCompleteTextView acTextView = (AutoCompleteTextView) findViewById(R.id.autoRoomType);
        //Set the number of characters the user must type before the drop down list is shown
        acTextView.setThreshold(1);
        //Set the adapter
        acTextView.setAdapter(adapter);

        DBManager = new DBManager(this);
        //////


        ButtonLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Modify_Reservation_Guest_Activity.this, MainActivity.class));
            }
        });



        ButtonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Modify_Reservation_Guest_Activity.this, userHomeScreen.class));
            }
        });


        ButtonModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqLiteDatabase = DBManager.getWritableDatabase();

                String updateQuery = "UPDATE " + Reservations + " SET " + Number_of_rooms + " = 223 WHERE " + Booking_id + " = '3'";
                Cursor cursor = sqLiteDatabase.rawQuery(updateQuery, null);
                cursor.moveToFirst();
                cursor.close();

                Log.i("Modified Successful", "********");
                startActivity(new Intent(Modify_Reservation_Guest_Activity.this, Details_of_Reservation_Guest_Activity.class));
            }
        });
    }
}