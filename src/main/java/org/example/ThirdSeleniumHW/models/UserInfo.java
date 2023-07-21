package org.example.ThirdSeleniumHW.models;

public class UserInfo {
    String firstName;
    String lastName;
    String address;
    int postcode;
    String city;
    String country;
    String email;
    String phoneNumber;
    String comment;

    public UserInfo(String firstName, String lastName, String address, int postcode, String city, String country, String email, String phoneNumber, String comment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.postcode = postcode;
        this.city = city;
        this.country = country;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.comment = comment;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public int getPostcode() {
        return postcode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getComment() {
        return comment;
    }
}