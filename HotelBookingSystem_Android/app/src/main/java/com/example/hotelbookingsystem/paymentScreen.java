package com.example.hotelbookingsystem;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class paymentScreen extends AppCompatActivity {

    Button home,logout,pay;
    EditText cvv,name,staddr,city,state,zip;
    SharedPreferences sharedpreferences;

    public static final String SHARED_PREF_NAME = "mypref";
    public static final String KEY_IDB = "booking_id";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guest_payment_screen);

        sharedpreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        final String id = sharedpreferences.getString(reserveRoomScreen.KEY_BOOKING,"");
        final String penID = sharedpreferences.getString(PendingAdapter.KEY_BOOKINGPen,"");

        home = findViewById(R.id.paymentHome);
        logout = findViewById(R.id.paymentLogout);
        pay = findViewById(R.id.paymentPay);

        cvv = findViewById(R.id.paymentCVV);
        name = findViewById(R.id.paymentName);
        staddr = findViewById(R.id.paymentAddr);
        city = findViewById(R.id.paymentCity);
        state = findViewById(R.id.paymentState);
        zip = findViewById(R.id.paymentZip);


        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String abc = staddr.getText().toString();
                String hk = "Paid";
                String ch = "Not Available";

               sharedpreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

               final String roomNumber = sharedpreferences.getString(viewRoomScreen.KEY_ROOMNUMBER,"");
               final String cid = sharedpreferences.getString(searchRoomScreen.KEY_CHECKINDATE,"");
               final String cod = sharedpreferences.getString(searchRoomScreen.KEY_CHECKOUTDATE,"");

                System.out.println("ROom numner is " + roomNumber);


               Room room = new Room(cid,cod,roomNumber,ch);

                DBManager dbManager = new DBManager(paymentScreen.this);
               String fin = dbManager.updateReservationStatus(id,abc,hk);

                String hkch = dbManager.updateResPending(penID,abc,hk);

                dbManager.updateRoomTable(roomNumber,ch,cid,cod);

                if (fin == id)
                {
                    SharedPreferences.Editor session = sharedpreferences.edit();
                    session.putString(KEY_IDB, id);

                    session.apply();

                    startActivity(new Intent(paymentScreen.this,confirmationScreen.class));
                }

                if(hkch == penID)
                {
                    SharedPreferences.Editor session = sharedpreferences.edit();
                    session.putString(KEY_IDB, penID);

                    session.apply();

                    startActivity(new Intent(paymentScreen.this,confirmationScreen.class));
                }
            }
        });
    }
}
