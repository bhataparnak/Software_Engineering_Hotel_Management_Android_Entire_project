package com.example.hotelbookingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Details_of_Reservation_Activity extends AppCompatActivity {


    Button ButtonLogOut, ButtonHome;
    TextView idE,firstNameE,lastNameE,roomTypeE,checkInDateE,checkOutDateE,numberOfRoomE,numberOfAdultsE,numberOfChildrenE,totalPriceE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_details_of_reservation_);


        ButtonLogOut= (Button)findViewById(R.id.button_logout);
        ButtonHome = (Button) findViewById(R.id.button_home);


        String id = getIntent().getStringExtra("id");
        String roomType = getIntent().getStringExtra("roomType");
        String numberOfRooms = getIntent().getStringExtra("numberOfRooms");
        String checkInDate = getIntent().getStringExtra("checkInDate");
        String checkOutDate = getIntent().getStringExtra("checkOutDate");
        String firstName = getIntent().getStringExtra("firstName");
        String lastName = getIntent().getStringExtra("lastName");
        String numberOfAdults = getIntent().getStringExtra("numberOfAdults");
        String numberOfChildren = getIntent().getStringExtra("numberOfChildren");
        String totalPrice = getIntent().getStringExtra("totalPrice");



        idE = (TextView) findViewById(R.id.textViewID);
         firstNameE = (TextView)findViewById(R.id.textViewFirstNAME);
        lastNameE = findViewById(R.id.textViewLastNAME);
        roomTypeE = findViewById(R.id.textViewRoomType);
        checkInDateE = findViewById(R.id.textViewCheckInData);
        checkOutDateE = findViewById(R.id.textViewCheckOutData);
        numberOfRoomE = findViewById(R.id.textViewNumberOfRoom);
        numberOfAdultsE = findViewById(R.id.textViewAdults);
        numberOfChildrenE = findViewById(R.id.textViewChildren);
        totalPriceE = findViewById(R.id.textViewPrice);


        idE.setText(id);
        roomTypeE.setText(roomType);
        checkInDateE.setText(checkInDate);
        checkOutDateE.setText(checkOutDate);
        firstNameE.setText(firstName);
        lastNameE.setText(lastName);
        numberOfAdultsE.setText(numberOfAdults);
        numberOfChildrenE.setText(numberOfChildren);
        totalPriceE.setText(totalPrice);
        numberOfRoomE.setText(numberOfRooms);



        ButtonLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Details_of_Reservation_Activity.this, MainActivity.class));
            }
        });



        ButtonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Details_of_Reservation_Activity.this, managerHomescreen.class));
            }
        });


    }
}
