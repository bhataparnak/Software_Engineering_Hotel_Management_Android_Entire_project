package com.example.hotelbookingsystem;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class viewProfile extends AppCompatActivity {
//    ScrollView sc = (ScrollView) findViewById(R.id.profile_scroll);

    Button modify,home,logout;
    EditText pro_user,pro_pwd,pro_first,pro_last,pro_staddr,pro_city,pro_state,pro_zip,pro_email,pro_phone,pro_cname,pro_cnum,pro_cexp,pro_role;
    Spinner pro_ctype;
    TextView pro_name;
    SharedPreferences sharedpreferences;

    public static final String SHARED_PREF_NAME = "mypref";
//    public static final String KEY_FIRSTNAME = "firstName";
//    public static final String KEY_LASTNAME = "lastName";
//    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_profile);
        sharedpreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        final String user = sharedpreferences.getString(MainActivity.KEY_USERNAME,"");
        final String role = sharedpreferences.getString(MainActivity.KEY_ROLE,"");

        pro_name = findViewById(R.id.pro_name);
        pro_user = findViewById(R.id.pro_user);
        pro_pwd = findViewById(R.id.pro_pwd);
        pro_first = findViewById(R.id.pro_first);
        pro_last = findViewById(R.id.pro_last);
        pro_staddr = findViewById(R.id.pro_staddr);
        pro_city = findViewById(R.id.pro_city);
        pro_state = findViewById(R.id.pro_state);
        pro_zip = findViewById(R.id.pro_zip);
        pro_email = findViewById(R.id.pro_email);
        pro_phone = findViewById(R.id.pro_phone);
        pro_cname = findViewById(R.id.pro_cname);
        pro_ctype = findViewById(R.id.pro_ctype);
        pro_cnum = findViewById(R.id.pro_cnum);
        pro_cexp = findViewById(R.id.pro_cexp);

        modify = findViewById(R.id.pro_modify);




//        Profile profile = null;

        // Getting the editable fields and buttons with ID's


        DBManager dbManager = new DBManager(viewProfile.this);
        Profile profile = dbManager.viewProfileDetails(user,role);

//        SharedPreferences.Editor session = sharedpreferences.edit();
//        session.putString(KEY_FIRSTNAME, profile.getFirstName());
//        session.putString(KEY_LASTNAME,profile.getLastName());
//        session.apply();
//        session.commit();

        //Setting the details from db to show

        setData(profile);


        //To make fields non Editable
        nonEdit();

        home = findViewById(R.id.guestViewHome);
        logout = findViewById(R.id.guestViewLogout);


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(viewProfile.this,userHomeScreen.class));
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(viewProfile.this,MainActivity.class));
            }
        });

        modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    edit();
                    modify.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            //Have to save those details in DataBase

                            DBManager dbManager = new DBManager(viewProfile.this);
                            Profile profile = new Profile(pro_user.getText().toString(),pro_pwd.getText().toString(),pro_last.getText().toString(),pro_first.getText().toString(),
                                    pro_cname.getText().toString(),pro_cnum.getText().toString(),pro_cexp.getText().toString(),pro_staddr.getText().toString(),pro_city.getText().toString(),
                                    pro_state.getText().toString(),pro_zip.getText().toString(),pro_email.getText().toString(),pro_phone.getText().toString(),pro_ctype.getSelectedItem().toString());

                            Reservation reservation = new Reservation(pro_first.getText().toString(),pro_last.getText().toString());

                            final boolean updateResult = dbManager.updateProfile(profile,user,role,reservation);

                            AlertDialog.Builder builder = new AlertDialog.Builder(viewProfile.this);

                            builder.setTitle("Confirm");
                            builder.setMessage("Are you sure?");

                            builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                                public void onClick(DialogInterface dialog, int which) {
                                    // Do nothing but close the dialog
                                    if(updateResult)
                                    {
                                        startActivity(new Intent(viewProfile.this,viewProfile.class));
                                    }
                                    dialog.dismiss();
                                }
                            });

                            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    // Do nothing
                                    dialog.dismiss();
                                }
                            });

                            AlertDialog alert = builder.create();
                            alert.show();



                            //Redirect to View Profile page with updated information showing on the screen
                        }
                    });

            }
        });




       // Toast.makeText(this, profile.toString(), Toast.LENGTH_SHORT).show();


    }

    public void nonEdit()
    {
        pro_user.setFocusable(false);
        pro_pwd.setFocusable(false);
        pro_first.setFocusable(false);
        pro_last.setFocusable(false);
        pro_staddr.setFocusable(false);
        pro_state.setFocusable(false);
        pro_city.setFocusable(false);
        pro_zip.setFocusable(false);
        pro_email.setFocusable(false);
        pro_phone.setFocusable(false);
        pro_cname.setFocusable(false);
        pro_ctype.setFocusable(false);
        pro_cnum.setFocusable(false);
        pro_cexp.setFocusable(false);

    }

    public void edit()
    {
        pro_pwd.setFocusableInTouchMode(true);
        pro_first.setFocusableInTouchMode(true);
        pro_last.setFocusableInTouchMode(true);
        pro_staddr.setFocusableInTouchMode(true);
        pro_state.setFocusableInTouchMode(true);
        pro_city.setFocusableInTouchMode(true);
        pro_zip.setFocusableInTouchMode(true);
        pro_email.setFocusableInTouchMode(true);
        pro_phone.setFocusableInTouchMode(true);
        pro_cname.setFocusableInTouchMode(true);

        pro_name.setText("Modify Details");
    }

    public void setData(Profile profile)
    {
        pro_user.setText(profile.getUsername());
        pro_pwd.setText(profile.getPassword());
        pro_first.setText(profile.getFirstName());
        pro_last.setText(profile.getLastName());
        pro_staddr.setText(profile.getStreetAddress());
        pro_city.setText(profile.getCity());
        pro_state.setText(profile.getState());
        pro_zip.setText(profile.getZipCode());
        pro_email.setText(profile.getEmail());
        pro_phone.setText(profile.getPhone());
        pro_cname.setText(profile.getCreditCardName());
        pro_cnum.setText(profile.getCreditCardNumber());
        pro_cexp.setText(profile.getCreditCardExp());



    }


}




















//
//        SQLiteDatabase db = openOrCreateDatabase("HotelManagement.db", MODE_PRIVATE, null);
//        Cursor cursor = db.rawQuery("select name from sqlite_master WHERE type = 'table' AND name = 'system_user'", null);
//
//        if(cursor.getCount() > 0)
//        {
//            String query = "select * from system_user where username = '" + user + "' ";
//            cursor = db.rawQuery(query,null);
//            if(cursor.getCount() == 0)
//            {
//                return;
//            }
//
//            StringBuffer buffer = new StringBuffer();
//            while(cursor.moveToNext())
//            {
//                buffer.append("Username : " + cursor.getString(1) + "\n");
//                buffer.append("Password : " + cursor.getString(2) + "\n");
//                buffer.append("First Name : " + cursor.getString(3) + "\n");
//                buffer.append("Last Name : " + cursor.getString(4) + "\n");
//            }
//
//            Toast.makeText(this,buffer.toString(), Toast.LENGTH_SHORT).show();
//        }


