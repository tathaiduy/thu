/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cake.DTO;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author DuyTT
 */
public class CartDTO implements Serializable{
    private String customerName;
    private HashMap<String, CakeDTO> cart;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomername(String customerName) {
        this.customerName = customerName;
    }

    public HashMap<String, CakeDTO> getCart() {
        return cart;
    }

    public CartDTO() {
        this.customerName = "Guest";
        this.cart = new HashMap<>();
    }

    public CartDTO(String customerName) {
        this.customerName = customerName;
        this.cart = new HashMap<>();
    }
    
    public void addToCart(CakeDTO dto) throws Exception
    {
        if(this.cart.containsKey(dto.getCakeID()))
        {
            int quantity = this.cart.get(dto.getCakeID()).getCakeQuantity() +dto.getCakeQuantity();
            dto.setCakeQuantity(quantity);
        }
        this.cart.put(dto.getCakeID(), dto);
    }
    
    public int getTotal()
    {
        int result = 0;
        for(CakeDTO dto: this.cart.values())
        {
            result += dto.getCakePrice() * dto.getCakeQuantity();
        }
        return result;
    }
    
    public void remove(String id) throws Exception
    {
        if(this.cart.containsKey(id))
        {
            this.cart.remove(id);
        }
    }
    public void update(String id, int quantity) throws Exception 
    {
        if(this.cart.containsKey(id))
        {
            this.cart.get(id).setCakeQuantity(quantity);
        }
    }
}
