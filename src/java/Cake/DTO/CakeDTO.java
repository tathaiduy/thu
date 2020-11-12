/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cake.DTO;

import java.io.Serializable;

/**
 *
 * @author DuyTT
 */
public class CakeDTO implements Serializable{
    private String cakeName, cakeID, cakePicture;
    private int cakePrice, cakeQuantity;
    

    public CakeDTO() {
    }

    public CakeDTO(String cakeName, String cakeID, String cakePicture, int cakePrice) {
        this.cakeName = cakeName;
        this.cakeID = cakeID;
        this.cakePicture = cakePicture;
        this.cakePrice = cakePrice;
    }
    
    public CakeDTO(String cakeName, String cakePicture, String cakeID) {
        this.cakeName = cakeName;
        this.cakePicture = cakePicture;
        this.cakeID = cakeID;
    }

    public CakeDTO(String cakeName, String cakePicture, int cakePrice) {
        this.cakeName = cakeName;
        this.cakePicture = cakePicture;
        this.cakePrice = cakePrice;
    }
    
    
    public CakeDTO(String cakeName, int cakePrice, String cakeID) {
        this.cakeName = cakeName;
        this.cakePrice = cakePrice;
        this.cakeID = cakeID;
    }
    
    
    public String getCakeName() {
        return cakeName;
    }

    public void setCakeName(String cakeName) {
        this.cakeName = cakeName;
    }

    public String getCakeID() {
        return cakeID;
    }

    public void setCakeID(String cakeID) {
        this.cakeID = cakeID;
    }

    public String getCakePicture() {
        return cakePicture;
    }

    public void setCakePicture(String cakePicture) {
        this.cakePicture = cakePicture;
    }

    public int getCakePrice() {
        return cakePrice;
    }

    public void setCakePrice(int cakePrice) {
        this.cakePrice = cakePrice;
    }

    public int getCakeQuantity() {
        return cakeQuantity;
    }

    public void setCakeQuantity(int cakeQuantity) {
        this.cakeQuantity = cakeQuantity;
    }
    
    
}
