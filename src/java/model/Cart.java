/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Cart {

    private List<Item> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public Cart(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    private Item getItemById(int id, int userID) {
        for (Item i : items) {
            if (i.getProduct().getProductID() == id && i.getUserID() == userID) {
                return i;
            }
        }
        return null;
    }
    
    private List<Item> getItemByUserID(int userID) {
        List<Item> list = new ArrayList<>();
        for (Item i : items) {
            if (i.getUserID() == userID) {
                list.add(i);
            }
        }
        return list;
    }

    public int getQuantityById(int id, int userID) {
        return getItemById(id, userID).getQuantity();
    }

    public void addItem(Item t) {
        if (getItemById(t.getProduct().getProductID(), t.getUserID()) != null) {
            Item i = getItemById(t.getProduct().getProductID(), t.getUserID());
            i.setQuantity(t.getQuantity() + i.getQuantity());
        } else {
            items.add(t);
        }
    }

    public void removeItem(int id, int userID) {
        if (getItemById(id, userID) != null) {
            items.remove(getItemById(id, userID));
        }
    }
    
    public void removeItemByUserID(int userID) {
        List<Item> list = getItemByUserID(userID);
        for(Item i : list){
            items.remove(getItemById(i.getUserID(), userID));
        }
    }

    public float getTotalMoney() {
        float t = 0;
        for (Item i : items) {
            t += (i.getQuantity() * i.getProduct().getPrice());
        }
        return t;
    }

    private Product getProductByID(int id, List<Product> list) {
        for (Product i : list) {
            if (i.getProductID() == id) {
                return i;
            }
        }
        return null;
    }

    public Cart(String txt, List<Product> list) {
        items = new ArrayList<>();
        try {
            if (txt != null && txt.length() != 0) {
                String[] s = txt.split("z");
                for (String i : s) {
                    String[] n = i.split(":");
                    int userid_txt = Integer.parseInt(n[0]);
                    int id = Integer.parseInt(n[1]);
                    int quantity = Integer.parseInt(n[2]);
                    Product p = getProductByID(id, list);
                    Item t = new Item(p, quantity, p.getPrice(), userid_txt);
//                    if (userid == userid_txt) {
//                        addItem(t);
//                    }
                    addItem(t);
                }
            }
        } catch (NumberFormatException e) {

        }
    }

    public Cart(String txt, List<Product> list, int userid) {
        items = new ArrayList<>();
        try {
            if (txt != null && txt.length() != 0) {
                String[] s = txt.split("z");
                for (String i : s) {
                    String[] n = i.split(":");
                    int userid_txt = Integer.parseInt(n[0]);
                    int id = Integer.parseInt(n[1]);
                    int quantity = Integer.parseInt(n[2]);
                    Product p = getProductByID(id, list);
                    Item t = new Item(p, quantity, p.getPrice(), userid_txt);
                    if (userid == userid_txt) {
                        addItem(t);
                    }
                }
            }
        } catch (NumberFormatException e) {

        }
    }

}
