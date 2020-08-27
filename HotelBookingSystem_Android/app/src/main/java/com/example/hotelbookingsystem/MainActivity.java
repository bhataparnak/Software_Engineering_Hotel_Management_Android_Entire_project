package com.example.hotelbookingsystem;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    Button reg,sign;
    EditText user,pwd;
    SharedPreferences sharedpreferences;
    TextView reg_success;

    public static final String SHARED_PREF_NAME = "mypref";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_ROLE = "Role";
    public static final String KEY_FIRSTNAME = "firstName";
    public static final String KEY_LASTNAME = "lastName";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            reg = findViewById(R.id.register);
            sign = findViewById(R.id.signin);
            user = findViewById(R.id.log_username);
            pwd = findViewById(R.id.log_password);
            reg_success = findViewById(R.id.reg_success);

            reg_success.setVisibility(View.GONE);

        sign.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("Recycle")
            @Override
            public void onClick(View view) {

                if (user.getText().toString().trim().length() != 0 && pwd.getText().toString().trim().length() != 0)
                {
                    SQLiteDatabase db = openOrCreateDatabase("HotelManagement.db", MODE_PRIVATE, null);
                    Cursor cursor = db.rawQuery("select name from sqlite_master WHERE type = 'table' AND name = 'system_user'", null);

                    if (cursor.getCount() > 0)
                    {
                        String query = "select * from system_user where username = '" + user.getText().toString().trim() + "' AND password = '" + pwd.getText().toString().trim() + "'  " ;
                        cursor = db.rawQuery(query,null);
                        if (cursor.getCount() <= 0)
                        {
                            Toast.makeText(getApplicationContext(), "Invalid Username and Password", Toast.LENGTH_SHORT).show();
                            user.setText("");
                            pwd.setText("");
                        }
                        else
                        {

                            String data = "USER";
                            String fn = "hhh";
                            String ln = "kkk";
                            if (cursor.moveToFirst())
                            {
                                data = cursor.getString(cursor.getColumnIndex("Role"));
                                fn = cursor.getString(cursor.getColumnIndex("firstName"));
                                ln = cursor.getString(cursor.getColumnIndex("lastName"));
                            }
                            cursor.close();

                            sharedpreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);
//
                            Editor session = sharedpreferences.edit();
                            session.putString(KEY_USERNAME, user.getText().toString().trim());
                            session.putString(KEY_ROLE,data);
                            session.putString(KEY_FIRSTNAME,fn);
                            session.putString(KEY_LASTNAME,ln);
                            session.apply();



                            if (data.equals("Manager"))
                            {
                                startActivity(new Intent(MainActivity.this,managerHomescreen.class));
                                session.commit();
                                user.setText("");
                                pwd.setText("");
                            }
                            else if (data.equals("Admin"))
                            {
                                startActivity(new Intent(MainActivity.this,adminHomeScreen.class));
                                session.commit();
                                user.setText("");
                                pwd.setText("");
                            }
                            else
                            {
                                startActivity(new Intent(MainActivity.this,userHomeScreen.class));
                                session.commit();
                                user.setText("");
                                pwd.setText("");
                            }

                        }
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                        user.setText("");
                        pwd.setText("");
                    }



                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Enter Required fields", Toast.LENGTH_SHORT).show();
                }


            }


        });

     reg.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {


             startActivity(new Intent(MainActivity.this,registrationScreen.class));

         }
     });

    }

    public void visibleField()
    {
        reg_success.setVisibility(View.VISIBLE);
    }

}