package com.example.hotelbookingsystem;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class guestViewReservationSummary extends AppCompatActivity {

//    Button viewReservation;
//    EditText hotelName, hotelLocation, roomType, num_of_nights;
    SharedPreferences sharedpreferences;
    ListView guestResList;
    ReservationAdapter reservationAdapter;
    ArrayList<Reservation> arrayList1;


    public static final String SHARED_PREF_NAME = "mypref";



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guest_res_summ);

//        viewReservation = findViewById(R.id.grs_viewReservation);
//        hotelName = findViewById(R.id.grs_hotelName);
//        hotelLocation = findViewById(R.id.grs_hotelLocation);
//        roomType = findViewById(R.id.grs_roomType);
//        num_of_nights = findViewById(R.id.grs_numOfNights);
        guestResList = findViewById(R.id.guestReservationSummList);



        //Getting first name and lastname form session

        sharedpreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        final String ln = sharedpreferences.getString(MainActivity.KEY_LASTNAME,"");
        final String fn = sharedpreferences.getString(MainActivity.KEY_FIRSTNAME,"");
        final String user = sharedpreferences.getString(MainActivity.KEY_USERNAME,"");
        System.out.println("Last name is : " + ln + "\n\n" + "Firstname is : " + fn + "\n\n");

        DBManager dbManager = new DBManager(guestViewReservationSummary.this);

        arrayList1 = dbManager.getSummDetails(fn,ln,user);

        reservationAdapter = new ReservationAdapter(guestViewReservationSummary.this,arrayList1);
        guestResList.setAdapter(reservationAdapter);
        reservationAdapter.notifyDataSetChanged();
//
//        hotelName.setText(reservation.getHotel_name());
//        hotelLocation.setText(reservation.getHotel_location());
//        roomType.setText(reservation.getRoom_type());
//        num_of_nights.setText(reservation.getNumber_of_nights());
//
//        hotelName.setFocusable(false);
//        hotelLocation.setFocusable(false);
//        roomType.setFocusable(false);
//        num_of_nights.setFocusable(false);

    }
}
