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

public class PendingAdapter extends BaseAdapter {
//
//    public static final String SHARED_PREF_NAME = "mypref";
//    public static final String KEY_un = "username";
//    SharedPreferences sharedpreferences;

    public static final String SHARED_PREF_NAME = "mypref";
    public static final String KEY_BOOKINGPen = "booking_id";


    SharedPreferences sharedpreferences;

    Context context;
    ArrayList<Reservation> arrayList;
    Button pendningPay;
    EditText pendingBooking,pendingHotel,pendingRooms,pendingNights,pendingAdults,pendingCheckIn,pendingCheckOut,pendingTotalPrice;

    public PendingAdapter(Context context, ArrayList<Reservation> arrayList) {
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
        view = inflater.inflate(R.layout.guest_custom_pen_reservations,null);

        pendingBooking = view.findViewById(R.id.pendingBooking);
        pendingHotel = view.findViewById(R.id.pendingHotelName);
        pendingRooms = view.findViewById(R.id.pendingRooms);
        pendingNights = view.findViewById(R.id.pendingNights);
        pendingAdults = view.findViewById(R.id.pendingAdults);
        pendingCheckIn = view.findViewById(R.id.pendingCheckIN);
        pendingCheckOut = view.findViewById(R.id.pendingCheckOut);
        pendingTotalPrice = view.findViewById(R.id.pendingTotalPrice);
        pendningPay = view.findViewById(R.id.pendingPay);



        Reservation reservation = arrayList.get(i);

        pendingBooking.setText(reservation.getBooking_id());
        pendingHotel.setText(reservation.getHotel_name());
        pendingRooms.setText(reservation.getNumber_of_rooms());
        pendingNights.setText(reservation.getNumber_of_nights());
        pendingAdults.setText(reservation.getNumber_of_adults());
        pendingCheckIn.setText(reservation.getCheck_in_date());
        pendingCheckOut.setText(reservation.getCheck_out_date());
        pendingTotalPrice.setText(reservation.getTotal_price());

        pendingTotalPrice.setFocusable(false);
        pendingBooking.setFocusable(false);
        pendingHotel.setFocusable(false);
        pendingNights.setFocusable(false);
        pendingCheckOut.setFocusable(false);
        pendingCheckIn.setFocusable(false);
        pendingRooms.setFocusable(false);
        pendingAdults.setFocusable(false);

        pendningPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedpreferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
                SharedPreferences.Editor session;
                session = sharedpreferences.edit();
                session.putString(KEY_BOOKINGPen, pendingBooking.getText().toString());
                session.apply();

                Intent intent = new Intent(view.getContext(),paymentScreen.class);
                view.getContext().startActivity(intent);
            }
        });



//
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
