/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cake.DAO;

import Cake.DB.MyConnection;
import Cake.DTO.BookDTO;
import Cake.DTO.CakeDTO;
import Cake.DTO.RegisterDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DuyTT
 */
public class BookDAO implements Serializable{
    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;
    
    public void closeConnection() throws Exception
    {
        if(conn != null)
        {
            conn.close();
        }
        if(preStm != null)
        {
            preStm.close();
        }
        if(rs != null)
        {
            rs.close();
        }
    }
    
    public List<BookDTO> findByLikeBookName(String search) throws Exception
    {
        List<BookDTO> result = null;
        String bookID, bookTitle, bookPrice,bookStatus;
                int bookQuantity ;
        BookDTO dto = null;
        try {
            String sql = "Select BookID, BookTitle, BookQuantity, BookPrice,BookStatus From BookRegistration Where BookTitle LIKE ?";
            conn = MyConnection.getMyConnection2();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                bookID = rs.getString("BookID");
                bookTitle = rs.getString("BookTitle");
                bookQuantity = rs.getInt("BookQuantity");
                bookPrice = rs.getString("BookPrice");
                bookStatus = rs.getString("BookStatus");
                dto = new BookDTO(bookID, bookTitle, bookQuantity, bookPrice, bookStatus);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }

        return result;
    }
    
    public List<BookDTO> findByLikeBookTitleUser(String search) throws Exception
    {
        List<BookDTO> result = null;
        String bookID, bookTitle, bookPrice,bookStatus;
        int bookQuantity ;
        BookDTO dto = null;
        try {
            String sql = "Select BookID, BookTitle, BookQuantity, BookPrice,BookStatus From BookRegistration Where BookTitle LIKE ?";
            conn = MyConnection.getMyConnection2();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                bookID = rs.getString("BookID");
                bookTitle = rs.getString("BookTitle");
                bookQuantity = rs.getInt("BookQuantity");
                bookPrice = rs.getString("BookPrice");
                bookStatus = rs.getString("BookStatus");
                dto = new BookDTO(bookID, bookTitle, bookQuantity, bookPrice, bookStatus);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }

        return result;
    }
    
    public List<BookDTO> getBookQuantity(String key) throws Exception
    {
        List<BookDTO> result = null;
        String bookID;
        BookDTO dto = null;
        int bookQuantity;
        try
        {
            String sql = "Select BookID, BookQuantity from BookRegistration where BookID LIKE ?";
            conn = MyConnection.getMyConnection2();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%"+key+"%");
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while(rs.next())
            {
                bookID = rs.getString("BookID");
                bookQuantity = rs.getInt("BookQuantity");
                dto = new BookDTO(bookID, bookQuantity);
                result.add(dto);
            }
        }
        finally
        {
            closeConnection();
        }
        return result;
    }
    
    public boolean UpdateQuantityAfterBuying(BookDTO dto) throws Exception
    {
        boolean check = false;
        try
        {
            String sql = "Update BookRegistration set BookQuantity = ?, BookStatus = ? where BookID = ?";
            conn = MyConnection.getMyConnection2();
            preStm = conn.prepareStatement(sql);
            preStm.setInt(1, dto.getBookQuantity());
            preStm.setString(2, dto.getBookStatus());
            preStm.setString(3, dto.getBookID());
           
            check = preStm.executeUpdate()> 0;
        }    
        finally
        {
            closeConnection();
        }
        return check;   
    }
    
    public BookDTO findByMyPrimaryBookID(String key) throws Exception {
        BookDTO cakeDTO = null;
        //BookDTO bookDTO = null;
        try {
            //String sql = "Select CakeName, CakePrice, CakeID, CakePicture from CakeMenu where CakeID = ?";
            String sql = "Select BookID, BookTitle, BookQuantity, BookPrice, BookStatus From BookRegistration Where BookID = ?";
            //conn = MyConnection.getMyConnection2();
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, key);
            rs = preStm.executeQuery();
            if (rs.next()) {
                /*String bookTitle = rs.getString("BookTitle");
                int bookQuantity = rs.getInt("BookQuantity");
                String bookID = rs.getString("BookID");
                String bookPrice= rs.getString("BookPrice");
                String bookStatus = rs.getString("BookStatus");
                bookDTO = new BookDTO(bookID, bookTitle, bookQuantity, bookPrice, bookStatus);*/
                
                String cakeName = rs.getString("CakeName");
                int cakePrice = rs.getInt("CakePrice");
                String cakeID = rs.getString("CakeID");
                String cakePicture = rs.getString("CakePicture");
                cakeDTO =new BookDTO();
            }

        } finally {
            closeConnection();
        }
        return cakeDTO;
        //return bookDTO;
    }
    
    public boolean update(BookDTO dto) throws Exception
    {
        boolean check = false;
        try
        {
            String sql = "Update BookRegistration set BookTitle = ?, BookPrice = ? where BookID = ?";
            conn = MyConnection.getMyConnection2();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getBookTitle());
            preStm.setString(2, dto.getBookPrice());
            preStm.setString(3, dto.getBookID());
            check = preStm.executeUpdate()> 0;
        }    
        finally
        {
            closeConnection();
        }
        return check;   
    }
    public boolean delete(String id) throws Exception
    {
        boolean check = false;
        try
        {
            String sql = "Delete from BookRegistration where BookID = ?";
            conn = MyConnection.getMyConnection2();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            check = preStm.executeUpdate() > 0;
        }
        finally
        {
            closeConnection();
        }
        return check;
    }
    
    public boolean insert(BookDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert into BookRegistration (BookID, BookTitle, BookPrice, BookQuantity, BookStatus) "
                    + "values(?,?,?,?,?)";
            conn = MyConnection.getMyConnection2();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getBookID());
            preStm.setString(2, dto.getBookTitle());
            preStm.setString(3, dto.getBookPrice());
            preStm.setInt(4, dto.getBookQuantity());
            preStm.setString(5, dto.getBookStatus());
            //preStm.setString(5, dto.getEmail());
            //preStm.setString(6, dto.getPhonenumber());
            check = preStm.executeUpdate() > 0;

        } finally {
            closeConnection();

        }
        return check;
    }
}
