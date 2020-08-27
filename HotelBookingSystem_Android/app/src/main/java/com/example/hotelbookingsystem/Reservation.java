package com.example.hotelbookingsystem;

public class Reservation {

    private String booking_id;
    private String hotel_name;
    private String hotel_location;
    private String room_type;
    private String number_of_rooms;
    private String number_of_nights;
    private String number_of_adults;
    private String number_of_children;
    private String check_in_date;
    private String check_out_date;
    private String price_per_night;
    private String tax;
    private String total_price;
    private String billed_price;
    private String billing_address;
    private String first_name;
    private String last_name;
    private String reservation_date;
    private String username;
    private String roomNumber;
    private String status;

    public Reservation(String booking_id, String hotel_name, String hotel_location, String number_of_rooms, String number_of_nights, String number_of_adults, String number_of_children, String check_in_date, String check_out_date, String tax, String billed_price, String billing_address, String first_name, String last_name) {
        this.booking_id = booking_id;
        this.hotel_name = hotel_name;
        this.hotel_location = hotel_location;
        this.number_of_rooms = number_of_rooms;
        this.number_of_nights = number_of_nights;
        this.number_of_adults = number_of_adults;
        this.number_of_children = number_of_children;
        this.check_in_date = check_in_date;
        this.check_out_date = check_out_date;
        this.tax = tax;
        this.billed_price = billed_price;
        this.billing_address = billing_address;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Reservation(String billing_address) {
        this.billing_address = billing_address;
    }

    public Reservation(String booking_id, String hotel_name, String number_of_rooms, String number_of_nights, String number_of_adults, String check_in_date, String check_out_date, String total_price) {
        this.booking_id = booking_id;
        this.hotel_name = hotel_name;
        this.number_of_rooms = number_of_rooms;
        this.number_of_nights = number_of_nights;
        this.number_of_adults = number_of_adults;
        this.check_in_date = check_in_date;
        this.check_out_date = check_out_date;
        this.total_price = total_price;
    }

    public Reservation(String booking_id, String hotel_name, String hotel_location, String room_type, String number_of_rooms, String number_of_nights, String number_of_adults, String number_of_children, String check_in_date, String check_out_date, String price_per_night, String total_price) {
        this.booking_id = booking_id;
        this.hotel_name = hotel_name;
        this.hotel_location = hotel_location;
        this.room_type = room_type;
        this.number_of_rooms = number_of_rooms;
        this.number_of_nights = number_of_nights;
        this.number_of_adults = number_of_adults;
        this.number_of_children = number_of_children;
        this.check_in_date = check_in_date;
        this.check_out_date = check_out_date;
        this.price_per_night = price_per_night;
        this.total_price = total_price;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Reservation(String hotel_name, String hotel_location, String room_type, String number_of_rooms, String number_of_nights, String number_of_adults, String number_of_children, String check_in_date, String check_out_date, String price_per_night, String tax, String total_price, String billed_price, String billing_address, String first_name, String last_name, String reservation_date, String username, String roomNumber, String status) {
        this.hotel_name = hotel_name;
        this.hotel_location = hotel_location;
        this.room_type = room_type;
        this.number_of_rooms = number_of_rooms;
        this.number_of_nights = number_of_nights;
        this.number_of_adults = number_of_adults;
        this.number_of_children = number_of_children;
        this.check_in_date = check_in_date;
        this.check_out_date = check_out_date;
        this.price_per_night = price_per_night;
        this.tax = tax;
        this.total_price = total_price;
        this.billed_price = billed_price;
        this.billing_address = billing_address;
        this.first_name = first_name;
        this.last_name = last_name;
        this.reservation_date = reservation_date;
        this.username = username;
        this.roomNumber = roomNumber;
        this.status = status;
    }

    public Reservation() {
    }

    public Reservation(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Reservation(String hotel_name, String hotel_location, String room_type, String number_of_nights) {
        this.hotel_name = hotel_name;
        this.hotel_location = hotel_location;
        this.room_type = room_type;
        this.number_of_nights = number_of_nights;
    }

    public Reservation(String booking_id, String hotel_name, String hotel_location, String room_type, String number_of_rooms, String number_of_nights, String number_of_adults, String number_of_children, String check_in_date, String check_out_date, String price_per_night, String total_price, String billed_price) {
        this.booking_id = booking_id;
        this.hotel_name = hotel_name;
        this.hotel_location = hotel_location;
        this.room_type = room_type;
        this.number_of_rooms = number_of_rooms;
        this.number_of_nights = number_of_nights;
        this.number_of_adults = number_of_adults;
        this.number_of_children = number_of_children;
        this.check_in_date = check_in_date;
        this.check_out_date = check_out_date;
        this.price_per_night = price_per_night;
        this.total_price = total_price;
        this.billed_price = billed_price;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "booking_id='" + booking_id + '\'' +
                ", hotel_name='" + hotel_name + '\'' +
                ", hotel_location='" + hotel_location + '\'' +
                ", room_type='" + room_type + '\'' +
                ", number_of_rooms='" + number_of_rooms + '\'' +
                ", number_of_nights='" + number_of_nights + '\'' +
                ", number_of_adults='" + number_of_adults + '\'' +
                ", number_of_children='" + number_of_children + '\'' +
                ", check_in_date='" + check_in_date + '\'' +
                ", check_out_date='" + check_out_date + '\'' +
                ", price_per_night='" + price_per_night + '\'' +
                ", tax='" + tax + '\'' +
                ", total_price='" + total_price + '\'' +
                ", billed_price='" + billed_price + '\'' +
                ", billing_address='" + billing_address + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", reservation_date='" + reservation_date + '\'' +
                '}';
    }


    public String getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(String booking_id) {
        this.booking_id = booking_id;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getHotel_location() {
        return hotel_location;
    }

    public void setHotel_location(String hotel_location) {
        this.hotel_location = hotel_location;
    }

    public String getRoom_type() {
        return room_type;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public String getNumber_of_rooms() {
        return number_of_rooms;
    }

    public void setNumber_of_rooms(String number_of_rooms) {
        this.number_of_rooms = number_of_rooms;
    }

    public String getNumber_of_nights() {
        return number_of_nights;
    }

    public void setNumber_of_nights(String number_of_nights) {
        this.number_of_nights = number_of_nights;
    }

    public String getNumber_of_adults() {
        return number_of_adults;
    }

    public void setNumber_of_adults(String number_of_adults) {
        this.number_of_adults = number_of_adults;
    }

    public String getNumber_of_children() {
        return number_of_children;
    }

    public void setNumber_of_children(String number_of_children) {
        this.number_of_children = number_of_children;
    }

    public String getCheck_in_date() {
        return check_in_date;
    }

    public void setCheck_in_date(String check_in_date) {
        this.check_in_date = check_in_date;
    }

    public String getCheck_out_date() {
        return check_out_date;
    }

    public void setCheck_out_date(String check_out_date) {
        this.check_out_date = check_out_date;
    }

    public String getPrice_per_night() {
        return price_per_night;
    }

    public void setPrice_per_night(String price_per_night) {
        this.price_per_night = price_per_night;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }

    public String getBilled_price() {
        return billed_price;
    }

    public void setBilled_price(String billed_price) {
        this.billed_price = billed_price;
    }

    public String getBilling_address() {
        return billing_address;
    }

    public void setBilling_address(String billing_address) {
        this.billing_address = billing_address;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getReservation_date() {
        return reservation_date;
    }

    public void setReservation_date(String reservation_date) {
        this.reservation_date = reservation_date;
    }
}
