/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cake.DTO;

import java.util.HashMap;

/**
 *
 * @author tatha
 */
public class CartBookDTO {
    private String customerName;
    private HashMap<String, BookDTO> cart;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomername(String customerName) {
        this.customerName = customerName;
    }

    public HashMap<String, BookDTO> getCart() {
        return cart;
    }

    public CartBookDTO() {
        this.customerName = "Guest";
        this.cart = new HashMap<>();
    }

    public CartBookDTO(String customerName) {
        this.customerName = customerName;
        this.cart = new HashMap<>();
    }
    
    public void addToCart(BookDTO dto) throws Exception
    {
        if(this.cart.containsKey(dto.getBookID()))
        {
            int quantity = this.cart.get(dto.getBookID()).getBookQuantity() +dto.getBookQuantity();
            dto.setBookQuantity(quantity);
        }
        this.cart.put(dto.getBookID(), dto);
    }
    
    public int getTotal()
    {
        int result = 0;
        for(BookDTO dto: this.cart.values())
        {
            result += Integer.parseInt(dto.getBookPrice())  * dto.getBookQuantity();
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
            this.cart.get(id).setBookQuantity(quantity);
        }
    }
}
