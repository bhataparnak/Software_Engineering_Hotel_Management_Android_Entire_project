package com.example.hotelbookingsystem;

import android.content.SharedPreferences;

import org.w3c.dom.ls.LSOutput;

public class Profile {


    private String username;
    private String password;
    private String role;
    private String lastName;
    private String firstName;
    private String creditCardName;
    private String creditCardNumber;
    private String creditCardExp;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String email;
    private String phone;
    private String creditCardType;

    public Profile()
    {}


    //For admin view selected guest/manager
    public Profile(String username, String password, String role, String lastName, String firstName, String streetAddress, String city, String state, String zipCode, String email, String phone) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.lastName = lastName;
        this.firstName = firstName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.email = email;
        this.phone = phone;
    }

    public Profile(String role, String lastName, String firstName){
        this.role = role;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Profile(String username, String role, String lastName, String firstName) {
        this.username = username;
        this.role = role;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Profile(String username, String password, String creditCardName, String creditCardNumber, String creditCardExp, String streetAddress, String city, String state, String zipCode, String email, String phone, String creditCardType) {
        this.username = username;
        this.password = password;
        this.creditCardName = creditCardName;
        this.creditCardNumber = creditCardNumber;
        this.creditCardExp = creditCardExp;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.email = email;
        this.phone = phone;
        this.creditCardType = creditCardType;
    }

    //For Admin
    public Profile(String username, String password, String role, String lastName, String firstName, String creditCardName, String creditCardNumber, String creditCardExp, String streetAddress, String city, String state, String zipCode, String email, String phone, String creditCardType) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.lastName = lastName;
        this.firstName = firstName;
        this.creditCardName = creditCardName;
        this.creditCardNumber = creditCardNumber;
        this.creditCardExp = creditCardExp;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.email = email;
        this.phone = phone;
        this.creditCardType = creditCardType;
    }

    //For User
    public Profile(String username, String password, String lastName, String firstName, String creditCardName, String creditCardNumber, String creditCardExp, String streetAddress, String city, String state, String zipCode, String email, String phone, String creditCardType) {
        this.username = username;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.creditCardName = creditCardName;
        this.creditCardNumber = creditCardNumber;
        this.creditCardExp = creditCardExp;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.email = email;
        this.phone = phone;
        this.creditCardType = creditCardType;
    }

    //For Manager
    public Profile(String username, String password, String lastName, String firstName, String streetAddress, String city, String state, String zipCode, String email, String phone) {
        this.username = username;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.email = email;
        this.phone = phone;
    }

    



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCreditCardName() {
        return creditCardName;
    }

    public void setCreditCardName(String creditCardName) {
        this.creditCardName = creditCardName;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardExp() {
        return creditCardExp;
    }

    public void setCreditCardExp(String creditCardExp) {
        this.creditCardExp = creditCardExp;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardType(String creditCardType) {
        this.creditCardType = creditCardType;
    }
}


