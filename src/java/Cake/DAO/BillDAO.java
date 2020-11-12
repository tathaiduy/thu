/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cake.DAO;

import Cake.DB.MyConnection;
import Cake.DTO.BillDTO;
import Cake.DTO.BookDTO;
import Cake.DTO.RegisterDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tatha
 */
public class BillDAO implements Serializable {

    private Connection conn;
    private ResultSet rs;
    private PreparedStatement preStm;

    public void closeConnection() throws Exception {
        if (conn != null) {
            conn.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (rs != null) {
            rs.close();
        }
    }

    public List<BillDTO> getBillNumber(String key) throws Exception {
        List<BillDTO> result = null;
        String fullname, bookID, bookTitle, billID, total;
        BillDTO dto = null;
        try {
            String sql = "select BillID "
                    + "from BillOrder  "
                    + "where BillID LIKE ? ";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + key + "%");
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {

                billID = rs.getString("BillID");

                dto = new BillDTO("", "", billID, "", "");
                result.add(dto);
            }

        } finally {
            closeConnection();
        }
        return result;
    }

    public boolean InsertBillDetail(BookDTO book) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert into OrderDetail(OrderID,BookID,Quantity) values(?,?,?)";
            conn = MyConnection.getMyConnection2();
            preStm = conn.prepareStatement(sql);
            //preStm.setString(1, );
            preStm.setString(0, sql);
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean InsertBillOrderTable(BillDTO bill) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert into BillOrder(BillID,Date,TotalPrice,UserID) values(?,?,?,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, bill.getBillID());
            preStm.setString(2, bill.getDate());
            preStm.setString(3, bill.getTotalPrice());
            preStm.setString(4, bill.getUsername());
            check = preStm.executeUpdate() > 0;

        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean InsertBillDetailTable(BillDTO bill) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert into BillDetail(BillID,Quantity,CakeID) values(?,?,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, bill.getBillID());
            preStm.setInt(2, Integer.parseInt(bill.getQuantity()));
            preStm.setString(3, bill.getCakeID());
            check = preStm.executeUpdate() > 0;

        } finally {
            closeConnection();
        }
        return check;
    }

    public List<BillDTO> findBillCustomerByFullname(String key) throws Exception {
        List<BillDTO> result = null;
        BillDTO dto = null;
        try {
//            String sql = "select ur.Fullname, od.BookID, br.BookTitle, ot.OrderID, ot.Total "
//                    + "from OrderTable ot INNER JOIN UserRegistration ur ON "
//                    + "ot.UserID = ur.Username inner join OrderDetail od ON "
//                    + "ot.OrderID = od.OrderID inner join BookRegistration br ON "
//                    + "od.BookID = br.BookID "
//                    + "where ur.Fullname LIKE ? ";
            String sql = "Select bo.BillID, bd.CakeID,bd.Quantity, bo.UserID, bo.TotalPrice from BillDetail bd inner join \n" +
"								 BillOrder bo on bd.BillID = bo.BillID where bo.UserID LIKE ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + key + "%");
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                String billID = rs.getString("BillID");
                String cakeID = rs.getString("CakeID");
                String cakeQuantity = String.valueOf(rs.getInt("Quantity"));
                String fullname = rs.getString("UserID");
                String totalPrice = rs.getString("TotalPrice");
                dto = new BillDTO(fullname, cakeID, billID,cakeQuantity,totalPrice);
                result.add(dto);
            }

        } finally {
            closeConnection();
        }
        return result;
    }
    
    public HashMap getNumberOfEachBill() throws Exception{
        HashMap numBill = null;
        try
        {
            String sql = "Select BillID, Count(BillID) as NumberEachBillID from BillDetail group by BillID";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            rs = preStm.executeQuery();
            numBill = new HashMap();
            while(rs.next())
            {
                Long num = Long.valueOf(rs.getInt("NumberEachBillID")) ;
                String billID = rs.getString("BillID");
                numBill.put(billID, num);
            }
        }
        finally
        {
            closeConnection();
        }
        return numBill;
               
    }

}
