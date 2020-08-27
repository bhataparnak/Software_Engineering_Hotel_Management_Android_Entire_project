package com.example.hotelbookingsystem;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBManager extends SQLiteOpenHelper {



    public static final String dbname = "HotelManagement.db";
    public static final String System_users = "system_user";
    public static final String Username = "username";
    public static final String Password = "password";
    public static final String LastName = "lastName";
    public static final String FirstName = "firstName";
    public static final String NameOnCard = "creditCardname";
    public static final String Ccnumber = "creditCardNumber";
    public static final String Ccexpiry = "creditCardExpiry";
    public static final String StreetAddress = "streetAddress";
    public static final String City = "city";
    public static final String State = "state";
    public static final String Zipcode = "zipcode";
    public static final String Email = "email";
    public static final String Phone = "phone";
    public static final String Cctype = "creditCardType";

//    Reservation Table Details

    public static final String Reservations = "reservations";
    public static final String Booking_id = "booking_id";
    public static final String Hotel_name = "hotel_name";
    public static final String Hotel_location = "hotel_location";
    public static final String Room_type = "room_type";
    public static final String Number_of_rooms = "number_of_rooms";
    public static final String Number_of_nights = "number_of_nights";
    public static final String Number_of_adults = "number_of_adults";
    public static final String Number_of_chiledren = "number_of_children";
    public static final String Check_in_date = "check_in_date";
    public static final String Check_out_date = "check_out_date";
    public static final String Price_per_night = "price_per_night";
    public static final String Tax = "tax";
    public static final String Total_price = "total_price";
    public static final String Billed_price = "billed_price";
    public static final String Billing_address = "billing_address";
    public static final String First_name = "first_name";
    public static final String Last_name = "last_name";
    public static final String Reservation_date = "reservation_date";
   public static final String User = "Username";
   public static final String RN = "RoomNumber";
   public static final String Status = "status";

    //Hotel Table

    public static final String HotelDetails = "hotels";
    public static final String HName = "hotelName";
    public static final String HLoc = "hotelLocation";
    public static final String HManager = "hotelManager";
    public static final String RType = "roomType";
    public static final String NRooms = "numberOfRooms";
//    public static final String RStatus = "roomStatus";
    public static final String RPNight = "pricePerNight";


    //Room Tabele

    public static final String RoomDetails = "rooms";
    public static final String RNUM = "RoomNumber";
    public static final String RBeds = "numberOfBeds";
    public static final String RFacilities = "roomFacilities";
    public static final String RStatus = "roomStatus";
    public static final String NRDate = "nextReservationDate";
    public static final String NREndDate = "nextReservationEndDate";



//    public static final String NRDate = "nextReservationStartDate"; //Next Reservation Date
//    public static final String NREDate = "nextReservationEndDate";

    public DBManager( Context context) {
        super(context,dbname , null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry = "CREATE TABLE IF NOT EXISTS " + System_users + "(id INTEGER PRIMARY KEY AUTOINCREMENT ," + Username + " text unique," + Password + " text, " + FirstName + " text, " + LastName + " text, " + StreetAddress + " text, " + City + " text, " + State + " text, " + Zipcode + " text, " + Email + " text ," + Phone +" text , " + NameOnCard + " text, "+ Cctype + " text, " + Ccnumber + " text," +
                Ccexpiry + " text)";
        db.execSQL(qry);

        db.execSQL("alter table " + System_users + " add column Role TEXT DEFAULT 'Guest' ");
        db.execSQL(qry);

        String qry1 = "CREATE TABLE IF NOT EXISTS " + Reservations + "("+Booking_id+"INTEGER PRIMARY KEY AUTOINCREMENT ," + Hotel_name + " text, " + Hotel_location + " text, " + Room_type + " text, " + Number_of_rooms + " text, " + Number_of_nights + " text, " + Number_of_adults + " text, " + Number_of_chiledren + " text, " + Check_in_date + " text ," + Check_out_date +" text , " + Price_per_night + " text, "+ Tax + " text, " + Total_price + " text," +
                Billed_price + " text, " + Billing_address + " text, " + First_name + " text, " + Last_name + " text, " + Reservation_date + " text)";

        db.execSQL(qry1);

        db.execSQL("alter table "+ Reservations + " add column Username TEXT ");
        db.execSQL(qry1);

        String qry2 = "CREATE TABLE IF NOT EXISTS " + HotelDetails + "(id INTEGER PRIMARY KEY AUTOINCREMENT ," + HName + " text, " + HLoc + " text, " + RType + " text, " + HManager + " text, " + NRooms + " text, " + RPNight + " text)";
        db.execSQL(qry2);

        String qry3 = "CREATE TABLE IF NOT EXISTS " + RoomDetails + "("+RNUM+"INTEGER PRIMARY KEY AUTOINCREMENT  ," + HName + " text, " + HLoc + " text, " + RType + " text, " + HManager + " text, " + NRooms + " text, " + RPNight + " text,  " + RBeds + " text, " + RFacilities + " text,  " + RStatus + " text, " + NRDate + " text, " + NREndDate + " text)";
        db.execSQL(qry3);
    }

    //    CREATE TABLE IF NOT EXISTS
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + System_users );
        db.execSQL(" DROP TABLE IF EXISTS " + Reservations );
        db.execSQL(" DROP TABLE IF EXISTS " + HotelDetails );
        db.execSQL(" DROP TABLE IF EXISTS " + RoomDetails );

        onCreate(db);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }



    @SuppressLint("Recycle")
    public boolean isUnique(String user)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String qry = "select * from system_user where username = '" + user + "' ";

        Cursor cursor = db.rawQuery(qry, null);

        if(cursor.getCount() > 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public String addRecord(Registration registration)

    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();


        cv.put(Username, registration.getUsername());
        cv.put(Password, registration.getPassword());
        cv.put(FirstName, registration.getFirstName());
        cv.put(LastName, registration.getLastName());
        cv.put(StreetAddress, registration.getStreetAddress());
        cv.put(City, registration.getCity());
        cv.put(State, registration.getState());
        cv.put(Zipcode, registration.getZipCode());
        cv.put(Email, registration.getEmail());
        cv.put(Phone, registration.getPhone());
        cv.put(NameOnCard, registration.getCreditCardName());
        cv.put(Cctype, registration.getCreditCardType());
        cv.put(Ccnumber, registration.getCreditCardNumber());
        cv.put(Ccexpiry, registration.getCreditCardExp());


        long insert = db.insert(System_users, null, cv);

        if(insert == -1)

            return "failed";
        else
            return "Account Created Successfully";


    }

    public Profile viewProfileDetails(String un, String role)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String qry =  "select * from system_user where username = '" + un + "' ";

        Cursor cursor = db.rawQuery(qry, null);

        if(cursor!= null)
        {
           cursor.moveToFirst();
        }



        Profile profile = new Profile(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),
                cursor.getString(6),cursor.getString(7),cursor.getString(8),cursor.getString(9),cursor.getString(10),cursor.getString(11),
                cursor.getString(12),cursor.getString(13),cursor.getString(14),cursor.getString(15));



            profile.setUsername(cursor.getString(1));

            profile.setPassword(cursor.getString(2));
            profile.setFirstName(cursor.getString(3));
            profile.setLastName(cursor.getString(4));
            profile.setStreetAddress(cursor.getString(5));
            profile.setCity(cursor.getString(6));
            profile.setState(cursor.getString(7));

            profile.setZipCode(cursor.getString(8));
            profile.setEmail(cursor.getString(9));
            profile.setPhone(cursor.getString(10));
            profile.setCreditCardName(cursor.getString(11));
            profile.setCreditCardType(cursor.getString(12));
            profile.setCreditCardNumber(cursor.getString(13));
            profile.setCreditCardExp(cursor.getString(14));




//        profile = new Profile(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),
//                cursor.getString(6),cursor.getString(7),cursor.getString(8),cursor.getString(9),cursor.getString(10));
        if(role == "Manager")
        {

            profile.setUsername(cursor.getString(1));

            profile.setPassword(cursor.getString(2));
            profile.setFirstName(cursor.getString(3));
            profile.setLastName(cursor.getString(4));
            profile.setStreetAddress(cursor.getString(5));
            profile.setCity(cursor.getString(6));
            profile.setState(cursor.getString(7));

            profile.setZipCode(cursor.getString(8));
            profile.setEmail(cursor.getString(9));
            profile.setPhone(cursor.getString(10));

            cursor.close();
            db.close();

        }

        if(role == "Admin")
        {
            Profile profile1 = new Profile(cursor.getString(1),cursor.getString(2),cursor.getString(15),cursor.getString(4),cursor.getString(3),cursor.getString(5),cursor.getString(6),
                    cursor.getString(7),cursor.getString(8),cursor.getString(9),cursor.getString(10));

            profile1.setUsername(cursor.getString(1));

            profile1.setPassword(cursor.getString(2));
            profile1.setFirstName(cursor.getString(3));
            profile1.setLastName(cursor.getString(4));
            profile1.setStreetAddress(cursor.getString(5));
            profile1.setCity(cursor.getString(6));
            profile1.setState(cursor.getString(7));

            profile1.setZipCode(cursor.getString(8));
            profile1.setEmail(cursor.getString(9));
            profile1.setPhone(cursor.getString(10));
            profile1.setRole(cursor.getString(15));

            cursor.close();
            db.close();
        }

        return profile;

    }

    public boolean updateProfile(Profile profile,String user, String role, Reservation reservation)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        ContentValues cv1 = new ContentValues();


            cv.put(Password,profile.getPassword());
            cv.put(LastName,profile.getLastName());
            cv.put(FirstName,profile.getFirstName());
            cv.put(NameOnCard,profile.getCreditCardName());
            cv.put(StreetAddress,profile.getStreetAddress());
            cv.put(City,profile.getCity());
            cv.put(State,profile.getState());
            cv.put(Zipcode,profile.getZipCode());
            cv.put(Email,profile.getEmail());
            cv.put(Phone,profile.getPhone());
            cv1.put(First_name,reservation.getFirst_name());
            cv1.put(Last_name,reservation.getLast_name());
            db.update(System_users,cv,"username = ?", new String[] {user});
            db.update(Reservations,cv1,"Username = ?", new String[] {user});







        return true;
    }

    public boolean updateManagerProfile(Profile profile, String user)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
//        Reservation reservation = new Reservation(First_name,Last_name);



        cv.put(Password,profile.getPassword());
        cv.put(LastName,profile.getLastName());
        cv.put(FirstName,profile.getFirstName());
        cv.put(StreetAddress,profile.getStreetAddress());
        cv.put(City,profile.getCity());
        cv.put(State,profile.getState());
        cv.put(Zipcode,profile.getZipCode());
        cv.put(Email,profile.getEmail());
        cv.put(Phone,profile.getPhone());
        db.update(System_users,cv,"username = ?", new String[] {user});
        return true;

    }

    public Cursor getEveryone(String name)
    {
//        List<String> returnList = new ArrayList<String>();

        SQLiteDatabase db = this.getWritableDatabase();

        String qry =  "select * from system_user where lastName = '" + name + "' ";

        System.out.println("Last name is : " + qry);

        Cursor cursor = db.rawQuery(qry, null);

//        System.out.println(cursor);
//
//        if(cursor.moveToFirst())
//        {
//            do
//            {
//                //Profile pro = new Profile(cursor.getString(5),cursor.getString(4),cursor.getString(15));
//                returnList.add(  "\n"+ "Last Name : " + cursor.getString(4) + "\n" + "First Name : " + cursor.getString(3) + "\n" + "Role : " + cursor.getString(15) + "\n\n" );
////                returnList.add("First Name : " + cursor.getString(4));
////                returnList.add("Role : " + cursor.getString(15));
//
//            }while(cursor.moveToNext());
//
//        }




        //moveToFirst returns a boolean value

        /*
        * First name = 4
        * Lastname = 5
        * Role = 15
        *
        * */


        return cursor;



    }

    public ArrayList<Profile> getAllUsers(String abc)
    {
        ArrayList<Profile> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String qry = "select * from system_user where lastName = '" + abc + "' ";

        Cursor cursor = db.rawQuery(qry, null);
        while(cursor.moveToNext())
        {
            String fname = cursor.getString(3);
            String uname = cursor.getString(1);
            String lname = cursor.getString(4);
            String role = cursor.getString(15);
            Profile profile = new Profile(uname,role,lname,fname);

            arrayList.add(profile);
        }
        return arrayList;
    }

    public Profile adminViewUser(String user)
    {

        SQLiteDatabase db = this.getReadableDatabase();

        String qry =  "select * from system_user where username = '" + user + "' ";

        Cursor cursor = db.rawQuery(qry, null);

        if(cursor!= null)
        {
            cursor.moveToFirst();
        }

        Profile profile = new Profile(cursor.getString(1),cursor.getString(2),cursor.getString(15),cursor.getString(4),cursor.getString(3),cursor.getString(5),
                cursor.getString(6),cursor.getString(7),cursor.getString(8),cursor.getString(9),cursor.getString(10));

        profile.setUsername(cursor.getString(1));

        profile.setPassword(cursor.getString(2));
        profile.setFirstName(cursor.getString(3));
        profile.setLastName(cursor.getString(4));
        profile.setStreetAddress(cursor.getString(5));
        profile.setCity(cursor.getString(6));
        profile.setState(cursor.getString(7));

        profile.setZipCode(cursor.getString(8));
        profile.setEmail(cursor.getString(9));
        profile.setPhone(cursor.getString(10));
        profile.setRole(cursor.getString(15));

        db.close();
        cursor.close();
        return profile;


    }


    public boolean adminUpdateProfile(Profile profile, String user)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();



        cv.put(LastName,profile.getLastName());
        cv.put(FirstName,profile.getFirstName());

        cv.put(StreetAddress,profile.getStreetAddress());
        cv.put(City,profile.getCity());
        cv.put(State,profile.getState());
        cv.put(Zipcode,profile.getZipCode());
        cv.put(Email,profile.getEmail());
        cv.put(Phone,profile.getPhone());
        db.update(System_users,cv,"username = ?", new String[] {user});


        return true;
    }

    public boolean deleteUser(String user)
    {
        SQLiteDatabase db = getWritableDatabase();

        int res = db.delete(System_users,"username = ?", new String[] {user});
        if(res > 0)
        {
            return true;
        }else {
            return false;
        }
    }

    public Reservation getReservationSummaryDetails(String fn, String ln)
    {

        SQLiteDatabase db = this.getReadableDatabase();

        String query = "select * from reservations where first_name = '" + fn + "' and last_name = '" + ln + "' ";

        Cursor cursor = db.rawQuery(query, null);
        Reservation reservation = new Reservation();

        if((cursor != null) && (cursor.getCount() > 0))
        {
            cursor.moveToFirst();
            reservation = new Reservation(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(5));

            reservation.setHotel_name(cursor.getString(1));
            reservation.setHotel_location(cursor.getString(2));
            reservation.setRoom_type(cursor.getString(3));
            reservation.setNumber_of_nights(cursor.getString(5));
            cursor.close();
            db.close();
            return reservation;

        }
        else
        {
            cursor.close();
            db.close();
            return reservation;

        }

    }

    public ArrayList<Reservation> getSummDetails(String fn, String ln, String user)
    {
        ArrayList<Reservation> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String qry = "select * from reservations where first_name = '" + fn + "' and last_name = '" + ln + "' and Username = '" + user +"' and status = 'Paid' ";

        Cursor cursor = db.rawQuery(qry, null);
        while(cursor.moveToNext())
        {
            String hotelName = cursor.getString(1);
            String hotelLocation = cursor.getString(2);
            String roomType = cursor.getString(3);
            String num_of_nights = cursor.getString(5);
            Reservation reservation = new Reservation(hotelName,hotelLocation,roomType,num_of_nights);
//            Profile profile = new Profile(uname,role,lname,fname);

            arrayList.add(reservation);
        }
        return arrayList;
    }

    public ArrayList<Hotel> getRoomDetails(String roomType, int nights)
    {
        ArrayList<Hotel> arrayList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        String qry = "select * from hotels where roomType =  '" + roomType + "'  ";
        Cursor cursor = db.rawQuery(qry,null);

        if(cursor.getCount() <= 0)
        {
            Hotel hotel = new Hotel();
            arrayList.add(hotel);
            return arrayList;
        }
        else
        {
            while(cursor.moveToNext())
            {
                String hotelName = cursor.getString(1);
                String loc = cursor.getString(2);
                String rt = cursor.getString(3);
                String numOfRoom = String.valueOf(nights);
                String price = cursor.getString(6);

                Hotel hotel = new Hotel(hotelName,loc,rt,numOfRoom,price);

                arrayList.add(hotel);

            }
            return arrayList;
        }



    }

//
//    public String getStatus(int num)
//    {
//        SQLiteDatabase db = this.getReadableDatabase();
//
//        String status = "";
//
//        String qry = "select roomStatus from rooms where RoomNumber = '" + num + "' ";
//
//        Cursor cursor = db.rawQuery(qry, null);
//        cursor.moveToFirst();
//        if(cursor.getCount() > 0)
//        {
//            status = cursor.getString(cursor.getColumnIndex(roomStatus));
//        }
//
//        return status;
//    }
    public ArrayList<Room> getSingleRoomDetail(String type, String name)
    {

        ArrayList<Room> room = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        String status = "";

        String qry = "select * from rooms where hotelName = '" + name + "' and roomType = '" + type + "' and roomStatus = 'Available'";

        Cursor cursor = db.rawQuery(qry, null);

        Room room1 = new Room();

//        status = cursor.getString(cursor.getColumnIndex("roomStatus"));
//
//        System.out.println(status);
//
//        qry = "select * from rooms where hotelName = '" + name + "' ,roomType = '" + type + "' and roomStatus = '" + status + "' ";
//        cursor = db.rawQuery(qry,null);



        cursor.moveToFirst();


        int roomNumber = Integer.parseInt(cursor.getString(0));
        status = cursor.getString(9);
        System.out.println("Status is " + roomNumber + "Room num is " + status);

        do
        {


            room1 = new Room(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(7),cursor.getString(8),cursor.getString(6),cursor.getString(0),cursor.getString(9));


            room1.setHotelName(cursor.getString(1));
            room1.setHotelLocation(cursor.getString(2));
            room1.setRoomType(cursor.getString(3));
            room1.setNumberOfBeds(cursor.getString(7));
            room1.setRoomFacilities(cursor.getString(8));
            room1.setPricePerNight(cursor.getString(6));
            room1.setRoomNumber(cursor.getString(0));
            room1.setRoomStatus(cursor.getString(9));

            room.add(room1);


        }while (cursor.moveToNext());






//        data = cursor.getString(cursor.getColumnIndex("Role"));
//        room = new ArrayList<Room>();




        return room;
    }

    //AParna's Work

    public HashMap<String,String> getHotelData(String id) {
        Map<String,String> roomMap = new HashMap<>();
        Cursor res = null;
        SQLiteDatabase db = this.getReadableDatabase();
        res =  db.rawQuery( "select * from rooms where RoomNumber = ?", new String[]{id} );

        if(res.moveToNext()){
            //res.moveToFirst();
            roomMap.put("RoomNumber", res.getString(0));
            roomMap.put("roomType", res.getString(3));
            roomMap.put("pricePerNight", res.getString(6));
            roomMap.put("roomStatus", res.getString(9));
            Log.i("db room number " , roomMap.get("RoomNumber"));


        }
        res.close();
        db.close();
        return (HashMap<String,String>)roomMap;
    }

    public List<HashMap<String,String>>  getAvailableRooms(String checkInDateTime) {

        List<HashMap<String,String>> roomList = new ArrayList<HashMap<String,String>>();
        Cursor res = null;
        SQLiteDatabase db = this.getReadableDatabase();
        res =  db.rawQuery( "select RoomNumber , roomType from rooms where  roomNumber in (\n" +
                "SELECT \n" +
                "       RoomNumber\n" +
                "  FROM reservations except\n" +
                "  SELECT \n" +
                "       RoomNumber\n" +
                "  FROM reservations where DATETIME(?) between DATETIME(check_in_date) and DATETIME(check_out_date)) UNION\n" +
                "select RoomNumber , roomType from rooms where \n" +
                " RoomNumber not in (\n" +
                "SELECT \n" +
                "                       RoomNumber\n" +
                "                  FROM reservations where DATETIME(?) between DATETIME(check_in_date) and DATETIME(check_out_date)) ", new String[]{checkInDateTime,checkInDateTime} );

        while(res.moveToNext()){
            //res.moveToFirst();
            HashMap<String,String> roomMap = new HashMap<>();
            roomMap.put("RoomNumber", res.getString(0));
            roomMap.put("roomType", res.getString(1));
            roomList.add(roomMap);

            Log.i("db room number " , roomMap.get("RoomNumber"));


        }
        res.close();
        db.close();
        return roomList;
    }


    public List<HashMap<String,String>>  getAvailableRoomsByType(String checkInDateTime , String type) {

        List<HashMap<String,String>> roomList = new ArrayList<HashMap<String,String>>();
//        Cursor res = null;
        SQLiteDatabase db = this.getReadableDatabase();

        String qry = "select * from rooms where roomStatus = 'Available' and roomType = '"+type+"' ";

        Cursor cursor = db.rawQuery(qry,null);


        while(cursor.moveToNext()){
            //res.moveToFirst();
            HashMap<String,String> roomMap = new HashMap<>();
            roomMap.put("RoomNumber", cursor.getString(0));
            roomMap.put("roomType", cursor.getString(3));
            roomList.add(roomMap);

            Log.i("db room number " , roomMap.get("RoomNumber"));


        }
        cursor.close();
        db.close();
        return roomList;
    }

    public boolean addReservationafterView(Reservation reservation)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(Hotel_name,reservation.getHotel_name());
        cv.put(Hotel_location,reservation.getHotel_location());
        cv.put(Room_type,reservation.getRoom_type());
        cv.put(Number_of_rooms,reservation.getNumber_of_rooms());
        cv.put(Number_of_adults,reservation.getNumber_of_adults());
        cv.put(Number_of_nights,reservation.getNumber_of_nights());
        cv.put(Number_of_chiledren,reservation.getNumber_of_children());
        cv.put(Check_in_date,reservation.getCheck_in_date());
        cv.put(Check_out_date,reservation.getCheck_out_date());
        cv.put(Price_per_night,reservation.getPrice_per_night());
        cv.put(Tax,reservation.getTax());
        cv.put(Total_price,reservation.getTotal_price());
        cv.put(Billed_price,reservation.getBilled_price());
        cv.put(Billing_address,reservation.getBilling_address());
        cv.put(First_name,reservation.getFirst_name());
        cv.put(Last_name,reservation.getLast_name());
        cv.put(Reservation_date,reservation.getReservation_date());
        cv.put(User,reservation.getUsername());
        cv.put(RN,reservation.getRoomNumber());
        cv.put(Status, reservation.getStatus());


        long insert = db.insert(Reservations, null, cv);

        if(insert == -1)

            return false;
        else
            return true;
    }

    public String getBookingId(String hoName,String rtype,String check, String out,String adult,String child,String fn, String ln, String un)
    {
        SQLiteDatabase db = this.getReadableDatabase();

        String qry = "select booking_id from reservations where hotel_name = '" + hoName+ "' and room_type = '" + rtype + "' and check_in_date = '" + check +"' and check_out_date = '"+ out +"' and number_of_adults = '"+adult+"' and number_of_children = '"+child+"' and first_name = '"+fn+"' and last_name = '"+ln+"' and Username = '"+un+"' and status = 'Pending' ";
        Cursor cursor = db.rawQuery(qry,null);

        String book = "";
        if(cursor.getCount() != 0)
        {
            cursor.moveToFirst();



        }

        book = cursor.getString(0);

        return book;
    }

    public Reservation getReserveDetails(String id)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        String qry = "select * from reservations where booking_id = '"+id+"'";
        Cursor cursor = db.rawQuery(qry, null);
        if(cursor.getCount() != 0)
        {
            cursor.moveToFirst();
        }

        Reservation reservation = new Reservation(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),
                cursor.getString(6),cursor.getString(7),cursor.getString(8),cursor.getString(9),cursor.getString(10),cursor.getString(12));

        reservation.setBooking_id(cursor.getString(0));
        reservation.setHotel_name(cursor.getString(1));
        reservation.setHotel_location(cursor.getString(2));
        reservation.setRoom_type(cursor.getString(3));
        reservation.setNumber_of_rooms(cursor.getString(4));
        reservation.setNumber_of_nights(cursor.getString(5));
        reservation.setNumber_of_adults(cursor.getString(6));
        reservation.setNumber_of_children(cursor.getString(7));
        reservation.setCheck_in_date(cursor.getString(8));
        reservation.setCheck_out_date(cursor.getString(9));
        reservation.setPrice_per_night(cursor.getString(10));
        reservation.setTotal_price(cursor.getString(12));

        return reservation;
    }

    public ArrayList<Reservation> getPendningDetails(String fn, String ln, String user) {

        ArrayList<Reservation> arrayList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String qry = "select * from reservations where first_name = '" + fn + "' and last_name = '" + ln + "' and Username = '" + user +"' and status = 'Pending' ";

        //and status = 'Pendning'
        String bookingId = "";
        String hotelName = "";
        String numRooms = "";
        String numNights = "";
        String numAdults = "";
        String cid = "";
        String cout = "";
        String tp = "";

        Cursor cursor = db.rawQuery(qry, null);
        while(cursor.moveToNext())
        {
            bookingId = cursor.getString(0);
            hotelName = cursor.getString(1);
            numRooms = cursor.getString(4);
            numNights = cursor.getString(5);
            numAdults = cursor.getString(6);
            cid = cursor.getString(8);
            cout = cursor.getString(9);
            tp = cursor.getString(12);
            Reservation reservation = new Reservation(bookingId,hotelName,numRooms,numNights,numAdults,cid,cout,tp);
//            Profile profile = new Profile(uname,role,lname,fname);

            arrayList.add(reservation);
        }

        System.out.println(bookingId + " " + hotelName + " " + numRooms + " " + numNights + " Hi Hsraslk");
        return arrayList;

    }

    public String updateReservationStatus(String id, String abc, String hk) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();


         cv.put(Status,hk);
            cv.put(Billing_address,abc);

            db.update(Reservations,cv,"booking_id = ?", new String[] {id});

  //        cv.put(Status,"Paid");
//
//        db.update(Reservations,cv,"booking_id = ?", new String[] {id});

        return id;


    }

    public String updateResPending(String penID, String abc, String hk) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();




            cv.put(Status,hk);
            cv.put(Billing_address,abc);

            db.update(Reservations,cv,"booking_id = ?", new String[] {penID});


            return penID;


    }

    public Reservation getConfirmDetails(String bid) {

        SQLiteDatabase db = this.getReadableDatabase();

        String qry = "select * from reservations where booking_id = '"+bid+"'";

        Cursor cursor = db.rawQuery(qry, null);

        if(cursor!=null)
        {
            cursor.moveToFirst();
        }

        Reservation reservation = new Reservation(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(4),cursor.getString(5),cursor.getString(6),
                cursor.getString(7),cursor.getString(8),cursor.getString(9),cursor.getString(11),cursor.getString(13),cursor.getString(14),
                cursor.getString(15),cursor.getString(16));

        reservation.setBooking_id(cursor.getString(0));
        reservation.setHotel_name(cursor.getString(1));
        reservation.setHotel_location(cursor.getString(2));
        reservation.setNumber_of_rooms(cursor.getString(4));
        reservation.setNumber_of_nights(cursor.getString(5));
        reservation.setNumber_of_adults(cursor.getString(6));
        reservation.setNumber_of_children(cursor.getString(7));
        reservation.setCheck_in_date(cursor.getString(8));
        reservation.setCheck_out_date(cursor.getString(9));
        reservation.setTax(cursor.getString(11));
        reservation.setBilled_price(cursor.getString(13));
        reservation.setBilling_address(cursor.getString(14));
        reservation.setFirst_name(cursor.getString(15));
        reservation.setLast_name(cursor.getString(16));

        return reservation;


    }


    //Amnah's


    public boolean updateTable(String bookId, String roomType,String checkInDate,String checkOutDate,
                               String numberOfRoom, String numberOfAdults, String numberOfChildren, String numberOfNight,String totPrice) {
        SQLiteDatabase db = this.getWritableDatabase();

        String updateQuery = "UPDATE " + Reservations + " SET " +
                Room_type + " = '" + roomType + "', " +
                Check_in_date + " = '" + checkInDate + "', " +
                Check_out_date + " = '" + checkOutDate + "', " +
                Number_of_rooms + " = '" + numberOfRoom + "', " +
                Number_of_adults + " = '" + numberOfAdults + "', " +
                Number_of_chiledren+ " = '" + numberOfChildren + "', " +
                Number_of_nights + " = '" + numberOfNight + "'," +
                Total_price +"= '"+totPrice+"'" +
                " WHERE booking_id = '" + bookId + "'";
        Cursor cursor = db.rawQuery(updateQuery, null);
        cursor.moveToFirst();
        cursor.close();

        return true;
    }

    public void deleteReservation(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM " + Reservations + " WHERE  booking_id = '" + id + "'";
        Log.i("Delete Successful", "******");
        db.execSQL(query);
    }


    public boolean updateRoomDetails(String roomNumber , String roomPrice , String roomStatus , String rt)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        //Create Content Values
        ContentValues contentValues = new ContentValues();

        contentValues.put(RType,rt);
        contentValues.put(RPNight,roomPrice);
        contentValues.put(RStatus,roomStatus);


        long result = db.update(RoomDetails , contentValues , "RoomNumber =?" , new String[]{roomNumber});
        Log.i("updateRoomDetails " ,String.valueOf(result));
        if (result ==-1)
            return false;
        else
            return true;
    }

    public void updateRoomTable(String hk, String na,String cid, String cout) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

//        String qry = "select * from rooms where RoomNumber = '"+hk+"' ";
//
//        Cursor cursor = db.rawQuery(qry, null);
//
//        if(cursor!=null)
//        {
//            cursor.moveToFirst();
//        }


       // System.out.println("ROOM statu is " + hk);
        cv.put(RStatus,na);
        cv.put(NRDate,cid);
        cv.put(NREndDate,cout);
        //cv.put(RPNight,12);

        System.out.println("::::::::::::::::::::::::::::::: "+ hk + " DATE: " + cid + " CHECKOUT: " + cout + " ::::::::::::::::::::::::::::::::::::::::::::::::::");
        long result = db.update("rooms",cv, "RoomNumber = ?",new String[]{hk});
        if (result == -1)
        {
            System.out.println("NOT INSERTED");
        }
        else {
            System.out.println("INSERTED");
        }
//        }
    }
}
