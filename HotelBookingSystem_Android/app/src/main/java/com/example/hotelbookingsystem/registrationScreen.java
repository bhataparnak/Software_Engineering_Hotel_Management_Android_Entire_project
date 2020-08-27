package com.example.hotelbookingsystem;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class registrationScreen extends AppCompatActivity {

    Button reg;
    EditText reg_user, reg_pwd, reg_last, reg_first, reg_cnum,reg_cname,reg_cexp ,reg_staddr,reg_city ,reg_state ,reg_zip ,reg_email ,reg_phone;
    TextView reg_success;
    Spinner reg_ctype;
    String role;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        reg = findViewById(R.id.now);
        reg_user = findViewById(R.id.reg_user);
        reg_pwd = findViewById(R.id.reg_pwd);
        reg_last = findViewById(R.id.reg_last);
        reg_first = findViewById(R.id.reg_first);
        reg_cnum = findViewById(R.id.reg_cnum);
        reg_cname = findViewById(R.id.reg_cname);
        reg_ctype = (Spinner) findViewById(R.id.reg_ctype);
        reg_cexp = findViewById(R.id.reg_cexp);
        reg_staddr = findViewById(R.id.reg_staddr);
        reg_city = findViewById(R.id.reg_city);
        reg_state = findViewById(R.id.reg_state);
        reg_zip = findViewById(R.id.reg_zip);
        reg_email = findViewById(R.id.reg_email);
        reg_phone = findViewById(R.id.reg_phone);
        reg_success = findViewById(R.id.reg_success);


        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Registration registration;

                if((reg_user.getText().toString().isEmpty()) || (reg_pwd.getText().toString().isEmpty()) || (reg_last.getText().toString().isEmpty()) || (reg_first.getText().toString().isEmpty())
                || (reg_staddr.getText().toString().isEmpty()) || (reg_city.getText().toString().isEmpty()) || (reg_state.getText().toString().isEmpty()) || (reg_zip.getText().toString().isEmpty())
                || (reg_email.getText().toString().isEmpty()) || (reg_phone.getText().toString().isEmpty()) || (reg_cname.getText().toString().isEmpty()) || (reg_cexp.getText().toString().isEmpty())
                || (reg_cnum.getText().toString().isEmpty()))
                {

                    Toast.makeText(registrationScreen.this, "Fileds cannot be empty. Please enter all fields and try again", Toast.LENGTH_SHORT).show();
                }
                else
                {


                    DBManager dbManager = new DBManager(registrationScreen.this);
                    boolean isunique = dbManager.isUnique(reg_user.getText().toString());

                    if(isunique)
                    {

                        registration = new Registration(reg_user.getText().toString(), reg_pwd.getText().toString(),reg_first.getText().toString(), reg_last.getText().toString(),reg_staddr.getText().toString(),
                                reg_city.getText().toString(), reg_state.getText().toString(), reg_zip.getText().toString(),reg_email.getText().toString(),
                                reg_phone.getText().toString(), reg_cname.getText().toString(), reg_ctype.getSelectedItem().toString(),reg_cnum.getText().toString(),
                                reg_cexp.getText().toString());

                        dbManager.addRecord(registration);
                        Toast.makeText(registrationScreen.this,"Successfully Registered",Toast.LENGTH_SHORT).show();
                        reg_user.setText("");
                        reg_pwd.setText("");
                        reg_last.setText("");
                        reg_first.setText("");
                        reg_cname.setText("");
                        reg_cnum.setText("");
                        reg_cexp.setText("");
                        reg_staddr.setText("");
                        reg_city.setText("");
                        reg_state.setText("");
                        reg_zip.setText("");
                        reg_email.setText("");
                        reg_phone.setText("");
                        startActivity(new Intent(registrationScreen.this,MainActivity.class));
                    }
                    else
                    {
                        Toast.makeText(registrationScreen.this,"Username already exists. Please enter different username",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

//        reg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Registration registration = new Registration(reg_user.getText().toString(), reg_pwd.getText().toString(), reg_last.getText().toString(), reg_first.getText().toString(), reg_cname.getText().toString(), reg_cnum.getText().toString(), reg_cexp.getText().toString(), reg_staddr.getText().toString(), reg_city.getText().toString(), reg_state.getText().toString(), reg_zip.getText().toString());
//
//
//
//                DBManager dbManager = new DBManager(registrationScreen.this);
//                dbManager.addRecord(registration);
//               Toast.makeText(registrationScreen.this,"Success",Toast.LENGTH_SHORT).show();
//            }
//        });
    }
}
