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
public class OrderDetail {
    private int shopOrderID;
    private int productID;
    private int quantity;
    private float price;

    public OrderDetail() {
    }

    public OrderDetail(int shopOrderID, int productID, int quantity, float price) {
        this.shopOrderID = shopOrderID;
        this.productID = productID;
        this.quantity = quantity;
        this.price = price;
    }

    public int getShopOrderID() {
        return shopOrderID;
    }

    public void setShopOrderID(int shopOrderID) {
        this.shopOrderID = shopOrderID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
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
    
    
}
