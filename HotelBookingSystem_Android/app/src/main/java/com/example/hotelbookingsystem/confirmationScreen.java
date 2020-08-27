package com.example.hotelbookingsystem;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class confirmationScreen extends AppCompatActivity {

    Button logout, home;
    EditText hotelName,hotelLocation, tax,fn,ln,billedAddr,billedPrice,cid,cod,nNights,reserveNumRooms,resNumAdults,reserveNumChildre,reserveBooking;
    SharedPreferences sharedpreferences;

    public static final String SHARED_PREF_NAME = "mypref";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.guest_confirmation_screen);

        sharedpreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        final String bid = sharedpreferences.getString(paymentScreen.KEY_IDB,"");
        //final String role = sharedpreferences.getString(MainActivity.KEY_ROLE,"");

        logout = findViewById(R.id.confirmHome);
        home = findViewById(R.id.confirmLogout);


        tax = findViewById(R.id.confirmTax);
        fn = findViewById(R.id.confirmFirst);
        ln = findViewById(R.id.confirmLast);
        billedAddr = findViewById(R.id.confirmBilledAddress);
        billedPrice = findViewById(R.id.confirmBilledPrice);
        hotelName = findViewById(R.id.viewHotelName);
        hotelLocation = findViewById(R.id.viewHotelLocation);
        cid = findViewById(R.id.viewCheckInDate);
        cod = findViewById(R.id.viewCheckOutDate);
        nNights = findViewById(R.id.viewNights);

        reserveNumRooms = findViewById(R.id.reserveNumRooms);
        resNumAdults = findViewById(R.id.reserveNumAdults);
        reserveNumChildre = findViewById(R.id.reserveNumChildren);
        reserveBooking = findViewById(R.id.reserveBooking);

        DBManager dbManager = new DBManager(confirmationScreen.this);
        Reservation reservation = dbManager.getConfirmDetails(bid);



//
        hotelName.setText(reservation.getHotel_name());
        hotelLocation.setText(reservation.getHotel_location());
        cid.setText(reservation.getCheck_in_date());
        cod.setText(reservation.getCheck_out_date());
        nNights.setText(reservation.getNumber_of_nights());
        resNumAdults.setText(reservation.getNumber_of_adults());
        reserveNumChildre.setText(reservation.getNumber_of_children());
        reserveBooking.setText(reservation.getBooking_id());
        reserveNumRooms.setText(reservation.getNumber_of_rooms());
        tax.setText(reservation.getTax());
        fn.setText(reservation.getFirst_name());
        ln.setText(reservation.getLast_name());
        billedAddr.setText(reservation.getBilling_address());
        billedPrice.setText(reservation.getBilled_price());



        hotelName.setFocusable(false);
        hotelLocation.setFocusable(false);
        cid.setFocusable(false);
        cod.setFocusable(false);
        nNights.setFocusable(false);
        reserveNumRooms.setFocusable(false);
        resNumAdults.setFocusable(false);
        reserveNumChildre.setFocusable(false);
        reserveBooking.setFocusable(false);
        tax.setFocusable(false);
        fn.setFocusable(false);
        ln.setFocusable(false);
        billedPrice.setFocusable(false);
        billedAddr.setFocusable(false);




        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(confirmationScreen.this,userHomeScreen.class));
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(confirmationScreen.this,MainActivity.class));
            }
        });
    }
}
