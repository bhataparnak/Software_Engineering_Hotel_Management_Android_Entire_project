package com.example.hotelbookingsystem;

public class Hotel {

    private String hotelName;
    private String hotelLocation;
    private String hotelManager;
    private String roomType;
    private String numberOfRooms;
    private String pricePerNight;
    private String numberOfNights;

    public Hotel(String hotelName, String hotelLocation, String roomType, String numberOfRooms, String pricePerNight) {
        this.hotelName = hotelName;
        this.hotelLocation = hotelLocation;
        this.roomType = roomType;
        this.numberOfRooms = numberOfRooms;
        this.pricePerNight = pricePerNight;
    }

    public Hotel(String hotelName, String hotelLocation, String roomType, String numberOfRooms, String pricePerNight, String numberOfNights) {
        this.hotelName = hotelName;
        this.hotelLocation = hotelLocation;
        this.roomType = roomType;
        this.numberOfRooms = numberOfRooms;
        this.pricePerNight = pricePerNight;
        this.numberOfNights = numberOfNights;
    }

    public Hotel(String hotelName, String hotelLocation, String hotelManager, String roomType, String numberOfRooms, String pricePerNight, String numberOfNights) {
        this.hotelName = hotelName;
        this.hotelLocation = hotelLocation;
        this.hotelManager = hotelManager;
        this.roomType = roomType;
        this.numberOfRooms = numberOfRooms;
        this.pricePerNight = pricePerNight;
        this.numberOfNights = numberOfNights;
    }

    public Hotel() {
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "hotelName='" + hotelName + '\'' +
                ", hotelLocation='" + hotelLocation + '\'' +
                ", hotelManager='" + hotelManager + '\'' +
                ", roomType='" + roomType + '\'' +
                ", numberOfRooms='" + numberOfRooms + '\'' +
                ", pricePerNight='" + pricePerNight + '\'' +
                ", numberOfNights='" + numberOfNights + '\'' +
                '}';
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getHotelLocation() {
        return hotelLocation;
    }

    public void setHotelLocation(String hotelLocation) {
        this.hotelLocation = hotelLocation;
    }

    public String getHotelManager() {
        return hotelManager;
    }

    public void setHotelManager(String hotelManager) {
        this.hotelManager = hotelManager;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(String numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public String getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(String pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public String getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(String numberOfNights) {
        this.numberOfNights = numberOfNights;
    }
}
