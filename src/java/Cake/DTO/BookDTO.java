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
public class BookDTO implements Serializable{
    private String bookID, bookTitle,  bookPrice, bookStatus,orderID;
    private int bookQuantity;
    public BookDTO() {
    }

    public BookDTO(String bookID, String bookTitle, String bookPrice) {
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.bookPrice = bookPrice;
    }

    
    public BookDTO(String bookID, String bookTitle, int bookQuantity, String bookPrice, String bookStatus) {
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.bookQuantity = bookQuantity;
        this.bookPrice = bookPrice;
        this.bookStatus = bookStatus;
    }

    public BookDTO(String bookID, int bookQuantity) {
        this.bookID = bookID;
        this.bookQuantity = bookQuantity;
    }
    
    public BookDTO(String bookID, int bookQuantity, String bookStatus) {
        this.bookID = bookID;
        this.bookQuantity = bookQuantity;
        this.bookStatus = bookStatus;
    }
    

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

    public String getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(String bookPrice) {
        this.bookPrice = bookPrice;
    }

    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    
    
    
}
