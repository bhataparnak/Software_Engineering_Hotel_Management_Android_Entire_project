package com.example.hotelbookingsystem;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Details_of_Reservation_Guest_Activity extends AppCompatActivity {

    DBManager DBManager;
    SQLiteDatabase sqLiteDatabase;
    Cursor cursor;
    Button ButtonLogOut, ButtonHome, ButtonModify, ButtonCancel;
    EditText roomTypeE, checkInDateE, checkOutDateE, numberOfRoomE, numberOfAdultsE, numberOfChildrenE, numberOfNightsE;
    //TextView totalPriceEDIT;
    TextView totalPriceE,pricePerNightE;
    Boolean editable = false;
    String bookId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_details_of_reservation_guest_);

        ButtonLogOut = (Button) findViewById(R.id.button_logout);
        ButtonHome = (Button) findViewById(R.id.button_home);
        ButtonModify = (Button) findViewById(R.id.button_Modify);
        ButtonCancel = (Button) findViewById(R.id.button_Cancel);

        bookId = getIntent().getStringExtra("id");
        String roomType = getIntent().getStringExtra("roomType");
        String numberOfRooms = getIntent().getStringExtra("numberOfRooms");
        String checkInDate = getIntent().getStringExtra("checkInDate");
        String checkOutDate = getIntent().getStringExtra("checkOutDate");
        String hotelName = getIntent().getStringExtra("hotelName");
        String hotelLocation = getIntent().getStringExtra("hotelLocation");
        String numberOfAdults = getIntent().getStringExtra("numberOfAdults");
        String numberOfChildren = getIntent().getStringExtra("numberOfChildren");
        String totalPrice = getIntent().getStringExtra("totalPrice");
        String numberOfNights = getIntent().getStringExtra("numberOfNights");
        String pricePerNight = getIntent().getStringExtra("pricePerNight");


        final TextView idE = (TextView) findViewById(R.id.textViewID);
        TextView hotelNameE = findViewById(R.id.textViewHotelName);
        TextView hotelLocationE = findViewById(R.id.textViewHotelLocation);
        roomTypeE = findViewById(R.id.textViewRoomType);
        checkInDateE = findViewById(R.id.textViewCheckInData);
        checkOutDateE = findViewById(R.id.textViewCheckOutData);
        numberOfRoomE = findViewById(R.id.textViewNumberOfRoom);
        numberOfAdultsE = findViewById(R.id.textViewAdults);
        numberOfChildrenE = findViewById(R.id.textViewChildren);
        numberOfNightsE = findViewById(R.id.textViewNumberOfNights);
        //totalPriceEDIT = findViewById(R.id.textViewPrice);

        totalPriceE = findViewById(R.id.textViewPrice);
        pricePerNightE = findViewById(R.id.textViewPricePerNight);

//        String toPrice = Integer.parseInt(pricePerNight * numberOfNights * numberOfRooms);



        idE.setText(bookId);
        roomTypeE.setText(roomType);
        checkInDateE.setText(checkInDate);
        checkOutDateE.setText(checkOutDate);
        hotelNameE.setText(hotelName);
        hotelLocationE.setText(hotelLocation);
        numberOfAdultsE.setText(numberOfAdults);
        numberOfChildrenE.setText(numberOfChildren);
        totalPriceE.setText(totalPrice);
        numberOfRoomE.setText(numberOfRooms);
        numberOfNightsE.setText(numberOfNights);
        pricePerNightE.setText(pricePerNight);

        DBManager = new DBManager(this);

        ButtonLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Details_of_Reservation_Guest_Activity.this, MainActivity.class));
            }
        });



        ButtonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Details_of_Reservation_Guest_Activity.this, userHomeScreen.class));
            }
        });


        ButtonModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editable) enableModifyView();
                else {
                    updateTable();
                    disableModifyView();
                }
            }
        });


        ButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(Details_of_Reservation_Guest_Activity.this);

                builder.setTitle("Confirm");
                builder.setMessage("Are you sure?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        // Do nothing but close the dialog
                        DBManager.deleteReservation(bookId);
                        Toast.makeText(Details_of_Reservation_Guest_Activity.this,"Reservation Deleted",Toast.LENGTH_LONG).show();
                        finish();

                        dialog.dismiss();
                    }
                });

                builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        dialog.dismiss();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();

            }
        });

    }



    private void enableModifyView() {
        roomTypeE.setEnabled(true);
        checkInDateE.setEnabled(true);
        checkOutDateE.setEnabled(true);
        numberOfRoomE.setEnabled(true);
        numberOfAdultsE.setEnabled(true);
        numberOfChildrenE.setEnabled(true);
        numberOfNightsE.setEnabled(true);

        ButtonModify.setText("Save");
        editable = true;
    }

    private void disableModifyView() {
        roomTypeE.setEnabled(false);
        checkInDateE.setEnabled(false);
        checkOutDateE.setEnabled(false);
        numberOfRoomE.setEnabled(false);
        numberOfAdultsE.setEnabled(false);
        numberOfChildrenE.setEnabled(false);
        numberOfNightsE.setEnabled(false);

        ButtonModify.setText("Modify");
        editable = false;
        Toast.makeText(Details_of_Reservation_Guest_Activity.this,"Reservation Modified",Toast.LENGTH_LONG).show();

    }

    private void updateTable() {
        String roomType = roomTypeE.getText().toString();
        String checkInDate = checkInDateE.getText().toString();
        String checkOutDate = checkOutDateE.getText().toString();
        String numberOfRoom = numberOfRoomE.getText().toString();
        String numberOfAdults = numberOfAdultsE.getText().toString();
        String numberOfChildren = numberOfChildrenE.getText().toString();
        String numberOfNight = numberOfNightsE.getText().toString();

        String price = pricePerNightE.getText().toString();

        int toPrice = Integer.parseInt(price);
        int numNight = Integer.parseInt(numberOfNight);
        int numRoo = Integer.parseInt(numberOfRoom);

        double ca = toPrice * numNight * numRoo * 1.0825;
        String totPrice = String.valueOf(ca);

        DBManager.updateTable(bookId, roomType, checkInDate, checkOutDate, numberOfRoom, numberOfAdults, numberOfChildren, numberOfNight,totPrice);

    }


}





