package com.example.hotelbookingsystem;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.text.InputType;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TimePicker;

public class Available_rooms extends AppCompatActivity {
    DatePickerDialog picker;
    EditText eText,sText;
    DBManager db;
    Button modify_room,navigate_home,view_available_rooms,availLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_available_rooms);
        db = new DBManager(this);
//        modify_room = (Button)findViewById(R.id.modify_room_btn);
//        modify_room.setMovementMethod(LinkMovementMethod.getInstance());
//        modify_room.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Available_rooms.this, ModifyRoom.class);
//                startActivity(intent);
//            }
//        });

        availLogout = findViewById(R.id.availLogout);

        availLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Available_rooms.this,MainActivity.class));
            }
        });
        navigate_home = (Button)findViewById(R.id.button8);
        navigate_home.setMovementMethod(LinkMovementMethod.getInstance());
        navigate_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Available_rooms.this, managerHomescreen.class);
                startActivity(intent);
            }
        });
        eText=(EditText) findViewById(R.id.date_text);
        eText.setInputType(InputType.TYPE_NULL);
        eText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(Available_rooms.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                eText.setText( (monthOfYear + 1) +  "/" + dayOfMonth + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

        sText=(EditText) findViewById(R.id.time_text);
        sText.setInputType(InputType.TYPE_NULL);
        sText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(Available_rooms.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        sText.setText(selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, false);//NO 24 hour time

                mTimePicker.show();

            }
        });

        view_available_rooms = (Button)findViewById(R.id.avl_room_search_btn);
        view_available_rooms.setMovementMethod(LinkMovementMethod.getInstance());
        view_available_rooms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent roomintent = new Intent(Searchroom.this, Searchroom.class);
                Log.i("inside oncick ","inside oncick");
                eText = (EditText)findViewById( R.id.date_text );
                sText = (EditText)findViewById( R.id.time_text );
                List<HashMap<String,String>> roomMapList;

                Spinner mySpinner = (Spinner) findViewById(R.id.room_typ);
                String roomType = mySpinner.getSelectedItem().toString();

                String checkInDate =eText. getText(). toString();
                String checkInTime = sText. getText(). toString();
                if(roomType != null && roomType.equalsIgnoreCase("All")) {
                    roomMapList = db.getAvailableRooms(checkInDate + " " + checkInTime);
                    Log.i("room type spinner " , roomType);
                }
                else
                {
                    roomMapList = db.getAvailableRoomsByType(checkInDate + " " + checkInTime , roomType);
                    Log.i("room type spinner " , roomType);
                }
                TableLayout roomTableLayout = (TableLayout) findViewById(R.id.room_table);
                for (final HashMap<String,String> map : roomMapList)
                {
                    TableRow row= new TableRow(getBaseContext());
                    TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
                    row.setLayoutParams(lp);
                    TextView roomNumber = new TextView(getBaseContext());
                    roomNumber.setText(map.get("RoomNumber"));
                    final  String rnString = roomNumber.getText().toString();
                    TextView room_Type = new TextView(getBaseContext());
                    room_Type.setText(map.get("roomType"));
                    Button modifyButton = new Button(getBaseContext());
                    modifyButton.setText("modify");
                    row.addView(roomNumber);
                    row.addView(room_Type);
                    row.addView(modifyButton);
                    roomTableLayout.addView(row);

                    // set some properties of rowTextView or something

                    modifyButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            Intent intent = new
                                    Intent(Available_rooms.this,ModifyRoom.class);
                            intent.putExtra("roomNumber",rnString);
                            intent.putExtra("roomPrice",map.get("room_price"));
                            intent.putExtra("roomType",map.get("room_type"));
                            startActivity(intent);
                        }
                    });

                }





                //startActivity(roomintent);
            }
        });

    }
}
