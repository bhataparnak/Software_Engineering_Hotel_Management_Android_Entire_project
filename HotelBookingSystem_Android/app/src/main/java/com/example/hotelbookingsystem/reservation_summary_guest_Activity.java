package com.example.hotelbookingsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class reservation_summary_guest_Activity extends AppCompatActivity {

    SQLiteDatabase sqLiteDatabaseObj;
    EditText EditTextDate;
    Button ButtonLogOut, ButtonHome, ButtonListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_summary_guest_);


        ButtonLogOut = (Button)findViewById(R.id.button_logout);
        ButtonHome = (Button) findViewById(R.id.button_home);
        ButtonListView = (Button) findViewById(R.id.buttonListView);
        EditTextDate = (EditText)findViewById(R.id.editTextDate);

        Calendar c = Calendar.getInstance();
        Date today = c.getTime();

        c.add(Calendar.DAY_OF_YEAR,1);
        Date tomorrow = c.getTime();


        SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy", Locale.getDefault());
        String formattedDate = df.format(today);
        String tomDate = df.format(tomorrow);

        EditTextDate.setText(formattedDate);



        ButtonListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date = EditTextDate.getText().toString();





                if(date.isEmpty()) {    // add default date

                    Toast.makeText(reservation_summary_guest_Activity.this,"Please fill the reservation date!", Toast.LENGTH_LONG).show();
                    return;
                }

                Intent intent = new Intent(reservation_summary_guest_Activity.this, List_of_Reservations_Guest_Activity.class);
                intent.putExtra("date", date);

                startActivity(intent);
            }
        });

        ButtonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(reservation_summary_guest_Activity.this,userHomeScreen.class));
            }
        });


        ButtonLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(reservation_summary_guest_Activity.this, MainActivity.class));
            }
        });

        /*ButtonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(reservation_summary_guest_Activity.this, userHomeScreen.class));
            }
        });*/

    }

}