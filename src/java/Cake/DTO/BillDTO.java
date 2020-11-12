/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cake.DTO;

import java.io.Serializable;

/**
 *
 * @author tatha
 */
public class BillDTO implements Serializable{
    private String fullname, cakeID, billID, cakeName, totalPrice, username, quantity, date;

    public BillDTO() {
    }
    
    public BillDTO(String fullname, String cakeID, String billID, String quantity, String totalPrice) {
        this.fullname = fullname;
        this.cakeID = cakeID;
        this.billID = billID;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }
    
    public BillDTO(String billID, String totalPrice, String date, String username) {
        this.billID = billID;
        this.totalPrice = totalPrice;
        this.date = date;
        this.username = username;
    }

        public BillDTO(String cakeID, String billID, String quantity) {
        this.cakeID = cakeID;
        this.billID = billID;
        this.quantity = quantity;
    }
    
    
    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getCakeID() {
        return cakeID;
    }

    public void setCakeID(String cakeID) {
        this.cakeID = cakeID;
    }

    public String getBillID() {
        return billID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    public String getCakeName() {
        return cakeName;
    }

    public void setCakeName(String cakeName) {
        this.cakeName = cakeName;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    
    
}
