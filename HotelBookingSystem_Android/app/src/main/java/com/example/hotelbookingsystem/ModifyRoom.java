package com.example.hotelbookingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ModifyRoom extends AppCompatActivity{
    Button cancel_modify,availLogout,navigate_home;
    TextView rn ;
    EditText roomPrice;
    DBManager db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_room);
        db = new DBManager(this);
        Intent intent = getIntent();
        final String roomNumber = intent.getStringExtra("roomNumber");
        final String room_Price = intent.getStringExtra("roomPrice");
        String room_Type = intent.getStringExtra("roomType");
        Log.i("room number intent " , roomNumber);
        rn = (TextView)findViewById((R.id.room_number_text)) ;
        rn.setText(roomNumber);
        cancel_modify = (Button)findViewById(R.id.cancel_edit);
        cancel_modify.setMovementMethod(LinkMovementMethod.getInstance());
        cancel_modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ModifyRoom.this, Available_rooms.class);
                startActivity(intent);
            }
        });


        availLogout = findViewById(R.id.availLogout);

        availLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ModifyRoom.this,MainActivity.class));
            }
        });

        navigate_home = (Button)findViewById(R.id.button8);
        navigate_home.setMovementMethod(LinkMovementMethod.getInstance());
        navigate_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ModifyRoom.this, managerHomescreen.class);
                startActivity(intent);
            }
        });

        final Spinner rtSpinner = (Spinner) findViewById(R.id.roomTyps);
        //final String roomType = mySpinner.getSelectedItem().toString();
        rtSpinner.setSelection(((ArrayAdapter<String>)rtSpinner.getAdapter()).getPosition(room_Type));

        // final Spinner rtSpinnerFinal = rtSpinner;

        roomPrice = (EditText)findViewById(R.id.edit_room_price);
        roomPrice.setText(room_Price);
        final String rp = roomPrice.getText().toString();
        Button btn = (Button)findViewById(R.id.save_edit);

        Spinner roomStatSp = (Spinner) findViewById(R.id.roomStat);
        final String roomStat = roomStatSp.getSelectedItem().toString();


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                // Displaying posotioned Toast message
                //db.updateRoomDetails();
                Log.i("inside save " ," inside save");
                final String rt = rtSpinner.getSelectedItem().toString();
                Log.i("inside save rt " ,rt);
                final String roomPr = roomPrice.getText().toString();
                Log.i("inside save roomPr " ,roomPr);
                db.updateRoomDetails(roomNumber,roomPr,roomStat,rt);
                Toast t = Toast.makeText(getApplicationContext(),
                        "Modified Room Details Successfully",
                        Toast.LENGTH_LONG);

                t.show();

                startActivity(new Intent(ModifyRoom.this,Available_rooms.class));
            }
        });

    }


}