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

public class searchRoomAdapter extends BaseAdapter {

    public static final String SHARED_PREF_NAME = "mypref";
    public static final String KEY_hn = "hotelName";
    public static final String KEY_rt = "roomType";

    SharedPreferences sharedpreferences;

    Context context;
    ArrayList<Hotel> arrayList;
    Button viewRoom;

    public searchRoomAdapter(Context context, ArrayList<Hotel> arrayList) {
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
        view = inflater.inflate(R.layout.room_list_adapter,null);
        final EditText rlHname = (EditText)view.findViewById(R.id.rlHname);
        EditText rlHloc = (EditText)view.findViewById(R.id.rlHloc);
        final EditText rlRtype = (EditText)view.findViewById(R.id.rlRtype);
        EditText rlNnights = (EditText)view.findViewById(R.id.rlNnights);
        EditText rlPprice = (EditText)view.findViewById(R.id.rlPprice);
//        final EditText un = (EditText)view.findViewById(R.id.admin_umg);
        viewRoom = (Button) view.findViewById(R.id.rlView);



        Hotel hotel = arrayList.get(i);
        rlHname.setText(hotel.getHotelName());
        rlHloc.setText(hotel.getHotelLocation());
        rlRtype.setText(hotel.getRoomType());
        rlNnights.setText(hotel.getNumberOfRooms());
        rlPprice.setText(hotel.getPricePerNight());


        viewRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                sharedpreferences = context.getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
//
                SharedPreferences.Editor session = sharedpreferences.edit();
                session.putString(KEY_hn, rlHname.getText().toString());
                session.putString(KEY_rt,rlRtype.getText().toString());
                session.apply();



                Intent intent = new Intent(view.getContext(),viewRoomScreen.class);
                view.getContext().startActivity(intent);
            }
        });

        return view;
    }



    @Override
    public int getCount() {
        return this.arrayList.size();
    }
}
