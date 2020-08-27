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

public class reservation_summary_manager_Activity extends AppCompatActivity {

    SQLiteDatabase sqLiteDatabaseObj;
    EditText EditTextDate;
    Button ButtonLogOut, ButtonHome, ButtonListView;
    RadioGroup RadioGroupRoomType;
    RadioButton RadioButtonStandard, RadioButtonDeluxe, RadioButtonSuite;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation_summary_manager_);


        ButtonLogOut = (Button)findViewById(R.id.button_logout);
        ButtonHome = (Button) findViewById(R.id.button_home);
        ButtonListView = (Button) findViewById(R.id.buttonListView);
        EditTextDate = (EditText)findViewById(R.id.editTextDate);
        RadioGroupRoomType = (RadioGroup) findViewById(R.id.radioGroup);
        RadioButtonStandard = (RadioButton) findViewById(R.id.radioButtonStandard);
        RadioButtonDeluxe = (RadioButton) findViewById(R.id.radioButtonDeluxe);
        RadioButtonSuite = (RadioButton) findViewById(R.id.radioButtonSuite);

        ButtonListView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date = EditTextDate.getText().toString();
                String roomType = "";
                int selectedRadioButtonId = RadioGroupRoomType.getCheckedRadioButtonId();
                switch (selectedRadioButtonId) {
                    case R.id.radioButtonStandard:
                        roomType = "Standard";
                        break;
                    case R.id.radioButtonDeluxe:
                        roomType = "Deluxe";
                        break;
                    case R.id.radioButtonSuite:
                        roomType = "Suite";
                        break;
                }
                if(roomType.isEmpty() || date.isEmpty()) {      // add default date and default room type

                    Toast.makeText(reservation_summary_manager_Activity.this,"Please fill the reservation date!", Toast.LENGTH_LONG).show();
                    return;
                }

                Intent intent = new Intent(reservation_summary_manager_Activity.this, List_of_Reservations_Activity.class);
                intent.putExtra("date", date);
                intent.putExtra("roomType", roomType);
                startActivity(intent);
            }
        });


        ButtonLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(reservation_summary_manager_Activity.this, MainActivity.class));
            }
        });

        ButtonHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(reservation_summary_manager_Activity.this, managerHomescreen.class));
            }
        });

    }

}