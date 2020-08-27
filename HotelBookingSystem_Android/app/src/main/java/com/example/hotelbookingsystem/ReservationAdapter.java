package com.example.hotelbookingsystem;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class ReservationAdapter extends BaseAdapter {
    public static final String SHARED_PREF_NAME = "mypref";
    public static final String KEY_un = "username";
    SharedPreferences sharedpreferences;

    Context context;
    ArrayList<Reservation> arrayList;
    Button viewReservation;
    EditText hotelName, hotelLocation, roomType, num_of_nights;

    public ReservationAdapter(Context context, ArrayList<Reservation> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.guest_view_reservation_summary,null);

        hotelName = view.findViewById(R.id.grs_hotelName);
        hotelLocation = view.findViewById(R.id.grs_hotelLocation);
        roomType = view.findViewById(R.id.grs_roomType);
        num_of_nights = view.findViewById(R.id.grs_numOfNights);
        viewReservation = view.findViewById(R.id.grs_viewReservation);

        Reservation reservation = arrayList.get(i);


        hotelName.setText(reservation.getHotel_name());
        hotelLocation.setText(reservation.getHotel_location());
        roomType.setText(reservation.getRoom_type());
        num_of_nights.setText(reservation.getNumber_of_nights());

        hotelName.setFocusable(false);
        hotelLocation.setFocusable(false);
        roomType.setFocusable(false);
        num_of_nights.setFocusable(false);



//        viewGM.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                sharedpreferences = context.getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
////
//                SharedPreferences.Editor session = sharedpreferences.edit();
//                session.putString(KEY_un, un.getText().toString());
//                session.apply();
//
//                Intent intent = new Intent(view.getContext(),adminViewGuestManager.class);
//                view.getContext().startActivity(intent);
//            }
//        });

        return view;
    }

    @Override
    public int getCount() {
        return this.arrayList.size();
    }
}
