/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cake.Bean;

import Cake.DAO.BookDAO;
import Cake.DTO.BookDTO;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author DuyTT
 */
public class BookBean implements Serializable{
    private String search, bookID;
   
    private BookDAO dao = null;
    private BookDTO dto;

    public BookBean() {
        dao = new BookDAO();
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public BookDAO getDao() {
        return dao;
    }

    public void setDao(BookDAO dao) {
        this.dao = dao;
    }

    public BookDTO getDto() {
        return dto;
    }

    public void setDto(BookDTO dto) {
        this.dto = dto;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }
    
    
    public List<BookDTO> findByLikeBookName() throws Exception
    {
        return dao.findByLikeBookName(search);
    }
    public List<BookDTO> findByLikeBookTitleUser() throws Exception
    {
        return dao.findByLikeBookTitleUser(search);
    }
    
    public List<BookDTO> getBookQuantity() throws Exception
    {
        return dao.getBookQuantity(search);
    }
    
    public boolean UpdateQuantityAfterBuying() throws Exception
    {
        return dao.UpdateQuantityAfterBuying(dto);
    }
    
    public BookDTO findByMyPrimaryBookID() throws Exception {
        return dao.findByMyPrimaryBookID(search);
    }
    
    public boolean update() throws Exception
    {
        return dao.update(dto);
    }
    public boolean delete() throws Exception
    {
        return dao.delete(bookID);
    }
    public boolean insert(BookDTO dto) throws Exception {
        return dao.insert(dto);
    }
}
