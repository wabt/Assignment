/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Address {
    private int addressID;
    private int userID;
    private String addressLine;
    private String city;
    private String country;

    public Address() {
    }

    public Address(int userID, String addressLine, String city, String country) {
        this.userID = userID;
        this.addressLine = addressLine;
        this.city = city;
        this.country = country;
    }
    

    public Address(int addressID, int userID, String addressLine, String city, String country) {
        this.addressID = addressID;
        this.userID = userID;
        this.addressLine = addressLine;
        this.city = city;
        this.country = country;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
}
