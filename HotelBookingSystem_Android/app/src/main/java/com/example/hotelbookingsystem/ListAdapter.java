package com.example.hotelbookingsystem;

import java.util.ArrayList;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import android.widget.Toast;

public class ListAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> ID;
    ArrayList<String> ReservationDate;
    ArrayList<String> RoomType;
    ArrayList<String> NumberOfRooms;
    ArrayList<String> CheckInDate;
    ArrayList<String> CheckOutDate;
    ArrayList<String> FirstName;
    ArrayList<String> LastName;
    ArrayList<String> NumberOfAdults;
    ArrayList<String> NumberOfChildren;
    ArrayList<String> TotalPrice;



    public ListAdapter(
            Context context2,
            ArrayList<String> id,
            ArrayList<String> reservationDate,
            ArrayList<String> roomType,
            ArrayList<String> numberOfRooms,
            ArrayList<String> checkIn,
            ArrayList<String> checkOut,
            ArrayList<String> firstName,
            ArrayList<String> lastName,
            ArrayList<String> numberOfAdults,
            ArrayList<String> numberOfChildren,
            ArrayList<String> totalPrice
    )
    {

        this.context = context2;
        this.ID = id;
        this.ReservationDate = reservationDate;
        this.RoomType = roomType;
        this.NumberOfRooms = numberOfRooms;
        this.CheckInDate = checkIn;
        this.CheckOutDate = checkOut;
        this.FirstName = firstName;
        this.LastName = lastName;
        this.NumberOfAdults = numberOfAdults;
        this.NumberOfChildren = numberOfChildren;
        this.TotalPrice = totalPrice;

    }

    public int getCount() {
        // TODO Auto-generated method stub
        return ID.size();
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    public View getView(final int position, View child, ViewGroup parent) {

        Holder holder;

        LayoutInflater layoutInflater;

        if (child == null) {
            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            child = layoutInflater.inflate(R.layout.items, null);

            holder = new Holder();

            holder.ID_TextView = (TextView) child.findViewById(R.id.textViewID);
            holder.ReservationDate_TextView = (TextView) child.findViewById(R.id.textViewReservationDate);
            holder.RoomType_TextView = (TextView) child.findViewById(R.id.textViewRoomType);
            holder.NumberOfRooms_TexView = (TextView) child.findViewById(R.id.textViewNumberOfRoom);
            holder.CheckInDate_TextView = (TextView) child.findViewById(R.id.textViewCheckInData);
            holder.CheckOutDate_TextView = (TextView) child.findViewById(R.id.textViewCheckOutData);
            holder.View_Button = (Button) child.findViewById(R.id.buttonView);


            child.setTag(holder);

        } else {

            holder = (Holder) child.getTag();
        }
        holder.ID_TextView.setText(ID.get(position));
        holder.ReservationDate_TextView.setText(ReservationDate.get(position));
        holder.RoomType_TextView.setText(RoomType.get(position));
        holder.NumberOfRooms_TexView.setText(NumberOfRooms.get(position));
        holder.CheckInDate_TextView.setText(CheckInDate.get(position));
        holder.CheckOutDate_TextView.setText(CheckOutDate.get(position));

        /*holder.FirstName_TextView.setText(FirstName.get(position));
        holder.LastName_TextView.setText(LastName.get(position));
        holder.NumberOfAdults_TextView.setText(NumberOfAdults.get(position));
        holder.NumberOfChildren_TextView.setText(NumberOfChildren.get(position));
        holder.TotalPrice_TextView.setText(TotalPrice.get(position));*/



        holder.View_Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Log.i("View Button Clicked", "**********");
                Toast.makeText(context, "View button Clicked", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(context, Details_of_Reservation_Activity.class);
                intent.putExtra("id", ID.get(position));
                intent.putExtra("roomType", RoomType.get(position));
                intent.putExtra("numberOfRooms", NumberOfRooms.get(position));
                intent.putExtra("checkInDate", CheckInDate.get(position));
                intent.putExtra("checkOutDate", CheckOutDate.get(position));

//                you need to add the below fields when you add a new reservation

                intent.putExtra("firstName", FirstName.get(position));
                intent.putExtra("lastName", LastName.get(position));
                intent.putExtra("numberOfAdults", NumberOfAdults.get(position));
                intent.putExtra("numberOfChildren", NumberOfChildren.get(position));
                intent.putExtra("totalPrice", TotalPrice.get(position));

                context.startActivity(intent);
            }
        });

        return child;
    }




    public class Holder {

        TextView ID_TextView;
        TextView ReservationDate_TextView;
        TextView RoomType_TextView;
        TextView NumberOfRooms_TexView;
        TextView CheckInDate_TextView;
        TextView CheckOutDate_TextView;
        /*TextView FirstName_TextView;
        TextView LastName_TextView;
        TextView NumberOfAdults_TextView;
        TextView NumberOfChildren_TextView;
        TextView TotalPrice_TextView;*/
        Button View_Button;
    }

}