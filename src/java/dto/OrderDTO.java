/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class OrderDTO {
    private int shopOrderID;
    private int userID;
    private int addressID;
    private float orderTotal;
    private Date orderDate;
    private String recipient;
    private String recipientPhone;
    private int quantity;
    private float price;
    private String productName;

    public OrderDTO() {
    }

    public OrderDTO(int shopOrderID, int userID, int addressID, float orderTotal, Date orderDate, String recipient, String recipientPhone, int quantity, float price, String productName) {
        this.shopOrderID = shopOrderID;
        this.userID = userID;
        this.addressID = addressID;
        this.orderTotal = orderTotal;
        this.orderDate = orderDate;
        this.recipient = recipient;
        this.recipientPhone = recipientPhone;
        this.quantity = quantity;
        this.price = price;
        this.productName = productName;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    
}
