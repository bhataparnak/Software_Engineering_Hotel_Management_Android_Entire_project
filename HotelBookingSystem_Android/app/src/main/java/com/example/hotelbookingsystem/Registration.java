package com.example.hotelbookingsystem;


public class Registration {
    private String username;
    private String password;
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


    public Registration(String username, String password, String firstName, String lastName,String streetAddress, String city, String state, String zipCode,String email,String phone, String creditCardName,String creditCardType, String creditCardNumber, String creditCardExp) {
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.email = email;
        this.phone = phone;
        this.creditCardName = creditCardName;
        this.creditCardType = creditCardType;
        this.creditCardNumber = creditCardNumber;
        this.creditCardExp = creditCardExp;
    }

    public Registration() {
    }

    @Override
    public String toString() {
        return "Registration{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", creditCardName='" + creditCardName + '\'' +
                ", creditCardType='" + creditCardType + '\'' +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                ", creditCardExp='" + creditCardExp + '\'' +

                '}';
    }


    public String getUsername() {

        return username;
    }

    public void setUsername(String username)
    {
  this.username = username;



    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

            this.password = password;
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
