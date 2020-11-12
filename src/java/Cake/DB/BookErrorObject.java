/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cake.DB;

import java.io.Serializable;

/**
 *
 * @author tatha
 */
public class BookErrorObject implements Serializable{
    private String bookIDError, bookTitleError, bookQuantityError, bookPriceError, bookStatusError;

    public String getBookIDError() {
        return bookIDError;
    }

    public void setBookIDError(String bookIDError) {
        this.bookIDError = bookIDError;
    }

    public String getBookTitleError() {
        return bookTitleError;
    }

    public void setBookTitleError(String bookTitleError) {
        this.bookTitleError = bookTitleError;
    }

    public String getBookQuantityError() {
        return bookQuantityError;
    }

    public void setBookQuantityError(String bookQuantityError) {
        this.bookQuantityError = bookQuantityError;
    }

    public String getBookPriceError() {
        return bookPriceError;
    }

    public void setBookPriceError(String bookPriceError) {
        this.bookPriceError = bookPriceError;
    }

    public String getBookStatusError() {
        return bookStatusError;
    }

    public void setBookStatusError(String bookStatusError) {
        this.bookStatusError = bookStatusError;
    }
    
    
}
