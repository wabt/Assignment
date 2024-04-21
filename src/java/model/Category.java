/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Category {
    private int categoryID;
    private String categoryName;
    private String category_img;

    public Category() {
    }

    public Category(String categoryName, String category_img) {
        this.categoryName = categoryName;
        this.category_img = category_img;
    }

    public Category(int categoryID, String categoryName, String category_img) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.category_img = category_img;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategory_img() {
        return category_img;
    }

    public void setCategory_img(String category_img) {
        this.category_img = category_img;
    }
    
}
