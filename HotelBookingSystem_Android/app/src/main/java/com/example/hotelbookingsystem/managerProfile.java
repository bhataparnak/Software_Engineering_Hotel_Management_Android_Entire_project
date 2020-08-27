package com.example.hotelbookingsystem;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class managerProfile extends AppCompatActivity {

    Button modify,home,logout;
    EditText pro_user,pro_pwd,pro_first,pro_last,pro_staddr,pro_city,pro_state,pro_zip,pro_email,pro_phone,pro_cname,pro_cnum,pro_cexp,pro_role;
    Spinner pro_ctype;
    TextView pro_name;
    SharedPreferences sharedpreferences;

    public static final String SHARED_PREF_NAME = "mypref";
    //    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedpreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
        final String user = sharedpreferences.getString(MainActivity.KEY_USERNAME,"");
        final String role = sharedpreferences.getString(MainActivity.KEY_ROLE,"");



        setContentView(R.layout.manager_profile);

        detailId();

        home = findViewById(R.id.guestViewHome);
        logout = findViewById(R.id.guestViewLogout);


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(managerProfile.this,managerHomescreen.class));
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(managerProfile.this,MainActivity.class));
            }
        });



//        Profile profile = null;

        // Getting the editable fields and buttons with ID's


        DBManager dbManager = new DBManager(managerProfile.this);
        Profile profile = dbManager.viewProfileDetails(user,role);

        //Setting the details from db to show

        setData(profile);


        //To make fields non Editable
        nonEdit();

        modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit();
                modify.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Have to save those details in DataBase

                        DBManager dbManager = new DBManager(managerProfile.this);
                        Profile profile = new Profile(pro_user.getText().toString(),pro_pwd.getText().toString(),pro_last.getText().toString(),pro_first.getText().toString(),
                                pro_staddr.getText().toString(),pro_city.getText().toString(),pro_state.getText().toString(),pro_zip.getText().toString(),pro_email.getText().toString(),pro_phone.getText().toString());

                        final boolean updateResult = dbManager.updateManagerProfile(profile,user);

                        AlertDialog.Builder builder = new AlertDialog.Builder(managerProfile.this);

                        builder.setTitle("Confirm");
                        builder.setMessage("Are you sure?");

                        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int which) {
                                // Do nothing but close the dialog
                                if(updateResult)
                                {
                                    startActivity(new Intent(managerProfile.this,managerProfile.class));
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
    }

    public void detailId()
    {
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


        modify = findViewById(R.id.pro_modify);
    }

}
