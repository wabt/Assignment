/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Order {
    private int shopOrderID;
    private int userID;
    private int addressID;
    private float orderTotal;
    private Date orderDate;
    private String recipient;
    private String recipientPhone;

    public Order() {
    }

    public Order(int shopOrderID, int userID, int addressID, float orderTotal, Date orderDate, String recipient, String recipientPhone) {
        this.shopOrderID = shopOrderID;
        this.userID = userID;
        this.addressID = addressID;
        this.orderTotal = orderTotal;
        this.orderDate = orderDate;
        this.recipient = recipient;
        this.recipientPhone = recipientPhone;
    }

    public int getShopOrderID() {
        return shopOrderID;
    }

    public void setShopOrderID(int shopOrderID) {
        this.shopOrderID = shopOrderID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public float getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(float orderTotal) {
        this.orderTotal = orderTotal;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getRecipientPhone() {
        return recipientPhone;
    }

    public void setRecipientPhone(String recipientPhone) {
        this.recipientPhone = recipientPhone;
    }

    
}
