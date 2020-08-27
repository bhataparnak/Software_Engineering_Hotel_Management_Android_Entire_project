package com.example.hotelbookingsystem;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class searchRoomScreen extends AppCompatActivity {


    Button home,logout,search;
    Button homer,logoutr;
    EditText nadults,nchild,cidate,codate;
    Spinner Hloc, Hroom, HNroom;

    ListView room_listView;
    searchRoomAdapter searchRoomAdapter;
    ArrayList<Hotel> arrayList;
    SharedPreferences sharedpreferences;

    public static final String SHARED_PREF_NAME = "mypref";

    public static final String KEY_ADULT = "number_of_adults";
    public static final String KEY_CHILDREN = "numebr_of_children";
    public static final String KEY_CHECKINDATE = "check_in_date";
    public static final String KEY_CHECKOUTDATE = "check_out_date";
    public static final String KEY_NUMBEROFNIGHTS = "number_of_nights";
    public static final String KEY_NUMBEROFROOMS = "number_of_rooms";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_room);

        home = findViewById(R.id.userHome);
        logout = findViewById(R.id.logout);
        search = findViewById(R.id.search_r);

        Hloc = (Spinner) findViewById(R.id.Hloc);
        Hroom = (Spinner) findViewById(R.id.Hroomtype);
        HNroom = (Spinner) findViewById(R.id.HNroom);

        nadults = findViewById(R.id.Nadults);
        nchild = findViewById(R.id.Nchild);
        cidate = findViewById(R.id.cidate);
        codate = findViewById(R.id.codate);

        Calendar c = Calendar.getInstance();
        Date today = c.getTime();

        c.add(Calendar.DAY_OF_YEAR,1);
        Date tomorrow = c.getTime();


        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
        String formattedDate = df.format(today);
        String tomDate = df.format(tomorrow);

        cidate.setText(formattedDate);
        codate.setText(tomDate);

        final String[] arr = tomDate.split("/");
        String tomYear = arr[2];
        String tomDay = arr[1];
        String tomMonth = arr[0];

        final String[] arr1 = formattedDate.split("/");
        String toYear = arr1[2];
        String toDay = arr1[1];
        String toMonth = arr1[0];
        int numOfNights1 = 0;

        if(Integer.parseInt(tomYear) >= Integer.parseInt(toYear))
        {
            if(Integer.parseInt(toMonth) == Integer.parseInt(tomMonth) )
            {
                numOfNights1 = (Integer.parseInt(tomDay)) - (Integer.parseInt(toDay));
            }
        }


       // System.out.println(numOfNights1);




        System.out.println("Hotel Room Type is " + Hroom.getSelectedItem().toString());

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Hotel Room Type is " + Hroom.getSelectedItem().toString());

                String checkinDate = cidate.getText().toString();
                String checkOutDate = codate.getText().toString();

                String[] arr1 = checkinDate.split("/");
                String[] arr = checkOutDate.split("/");

                String tomYear = arr[2];
                String tomDay = arr[1];
                String tomMonth = arr[0];

                String toYear = arr1[2];
                String toDay = arr1[1];
                String toMonth = arr1[0];
                int numOfNights = 0;

                if(Integer.parseInt(tomYear) >= Integer.parseInt(toYear))
                {
                    if(Integer.parseInt(toMonth) == Integer.parseInt(tomMonth) )
                    {
                        numOfNights = (Integer.parseInt(tomDay)) - (Integer.parseInt(toDay));
                    }
                }

                System.out.println(numOfNights);

                sharedpreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
//
                SharedPreferences.Editor session = sharedpreferences.edit();
                session.putString(KEY_ADULT, nadults.getText().toString());
                session.putString(KEY_CHILDREN,nchild.getText().toString());
                session.putString(KEY_CHECKINDATE,cidate.getText().toString());
                session.putString(KEY_CHECKOUTDATE,codate.getText().toString());
                session.putString(KEY_NUMBEROFNIGHTS, String.valueOf(numOfNights));
                session.putString(KEY_NUMBEROFROOMS,HNroom.getSelectedItem().toString());
                session.apply();


//                String result = "";
//                String arr[] = cidate.getText().toString().split("/");
//                String year = arr[2];
//                String day = arr[1];
//                String month = arr[0];
//
//                Date dnow = new Date()

                if(numOfNights < 1)
                {
                    Toast.makeText(searchRoomScreen.this, "Check out cannot be same as check in", Toast.LENGTH_SHORT).show();
                }
                else
                {

                    setContentView(R.layout.room_list);
//
//
//
                    room_listView = findViewById(R.id.room_listView);

                    DBManager dbManager = new DBManager(searchRoomScreen.this);
                    arrayList = dbManager.getRoomDetails(Hroom.getSelectedItem().toString(),numOfNights);

                    searchRoomAdapter = new searchRoomAdapter(searchRoomScreen.this,arrayList);
                    room_listView.setAdapter(searchRoomAdapter);
                    searchRoomAdapter.notifyDataSetChanged();

                }




            }
        });


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(searchRoomScreen.this, userHomeScreen.class));

            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(searchRoomScreen.this,MainActivity.class));
            }
        });
    }
}
