/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cake.DAO;

import Cake.DB.MyConnection;
import Cake.DTO.CakeDTO;
import Cake.DTO.RegisterDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DuyTT
 */
public class CakeDAO implements Serializable {

    private Connection conn;
    private PreparedStatement preStm;
    private ResultSet rs;

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

    
    public List<CakeDTO> findByLikeCakeName(String search) throws Exception {
        List<CakeDTO> result = null;
        String cakeName, cakePicture, cakeID;
        int cakePrice;
        CakeDTO dto = null;
        try {
            String sql = "Select CakeName, CakePrice, CakePicture, CakeID From CakeMenu Where CakeName LIKE ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                cakeName = rs.getString("CakeName");
                cakePrice = Integer.parseInt(rs.getString("CakePrice"));
                cakePicture = rs.getString("CakePicture");
                cakeID = rs.getString("CakeID");
                dto = new CakeDTO(cakeName, cakeID, cakePicture, cakePrice);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }

        return result;
    }

    public CakeDTO findByMyPrimaryCakeID(String key) throws Exception {
        CakeDTO cakeDTO = null;
        try {
            String sql = "Select CakeName, CakePrice, CakePicture, CakeID From CakeMenu Where CakeName = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, key);
            rs = preStm.executeQuery();
            if (rs.next()) {
                String cakeName = rs.getString("CakeName");
                int cakePrice = rs.getInt("CakePrice");
                String cakeID = rs.getString("CakeID");
                String cakePicture = rs.getString("CakePicture");
                cakeDTO = new CakeDTO(cakeName, cakeID, cakePicture, cakePrice);
            }
        } finally {

            closeConnection();
        }
        return cakeDTO;
    }
    
    public List<CakeDTO> searchDataCakeForDataTable(String key) throws Exception
    {
        List<CakeDTO> result = null;
        CakeDTO cakeDTO = null;
        try {
            String sql = "Select CakeName, CakeID, CakePrice from CakeMenu where CakeName LIKE ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" +key+"%");
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while(rs.next())
            {
                String cakeName = rs.getString("CakeName");
                String cakeID = rs.getString("CakeID");
                int cakePrice = rs.getInt("CakePrice");
                cakeDTO = new CakeDTO(cakeName, cakePrice, cakeID);
                result.add(cakeDTO);
            }
        } 
        finally
        {
            closeConnection();
        }
        return result;
    }

    public boolean updateCake(CakeDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Update CakeMenu Set CakeName = ?, CakePrice = ?, CakePicture = ? where CakeID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getCakeName());
            preStm.setInt(2, dto.getCakePrice());
            preStm.setString(3, dto.getCakePicture());
            preStm.setString(4, dto.getCakeID());

            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean insert(CakeDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert into CakeMenu (CakeID, CakeName, CakePrice, CakePicture) values (?,?,?,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getCakeID());
            preStm.setString(2, dto.getCakeName());
            preStm.setInt(3, dto.getCakePrice());
            preStm.setString(4, dto.getCakePicture());
            check = preStm.executeUpdate() > 0;

        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean deleteCakeAdmin(String id) throws Exception {
        boolean check = false;
        try {
            String sql = "Delete From CakeMenu where CakeID = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            check = preStm.executeUpdate() > 0;

        } finally {
            closeConnection();
        }
        return check;
    }
}
