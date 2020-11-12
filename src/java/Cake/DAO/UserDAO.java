/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cake.DAO;

import Cake.DB.MyConnection;
import Cake.DTO.RegisterDTO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author DuyTT
 */
public class UserDAO implements Serializable {

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

    public RegisterDTO checkLogin(String username, String password) throws Exception {

        String fullname, role;
        RegisterDTO dto = null;
        try {
            /*String sql = "select ur.Username, ur.Fullname, role.RoleName "
                    + "from UserRegistration ur inner join UserRole role on "
                    + "ur.RoleID = role.RoleID "
                    + "where ur.Username = ? and ur.Password = ? ";*/
            String sql = "select Username, Fullname, Role from CakeRegistration where Username = ? and Password = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, username);
            preStm.setString(2, password);
            rs = preStm.executeQuery();

            while (rs.next()) {
                fullname = rs.getString("Fullname");
                role = rs.getString("Role");
                username = rs.getString("Username");
                dto = new RegisterDTO(fullname, role, username);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public List<RegisterDTO> findByLikeName(String search) throws Exception {
        List<RegisterDTO> result = null;
        String username, fullname, role, emailAdress;

        RegisterDTO dto = null;
        try {
            String sql = "Select Username, Fullname, Role, EmailAddress from UserRegistration where Username LIKE ?";
            conn = MyConnection.getMyConnection2();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                username = rs.getString("Username");
                fullname = rs.getString("Fullname");
                role = rs.getString("Role");
                emailAdress = rs.getString("EmailAddress");
                //phoneNumber = rs.getString("PhoneNumber");
                //dateOfBirth = rs.getString("DateOfBirth");
                dto = new RegisterDTO(username, emailAdress, fullname, role);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<RegisterDTO> findByLikeNameAdmin(String search) throws Exception {
        List<RegisterDTO> result = null;
        String username, fullname, role;

        RegisterDTO dto = null;
        try {
            String sql = "Select Username, Fullname, Role from CakeRegistration where Username Like ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                username = rs.getString("Username");
                fullname = rs.getString("Fullname");
                role = rs.getString("Role");
                //emailAdress = rs.getString("EmailAddress");
                //phoneNumber = rs.getString("PhoneNumber");
                //dateOfBirth = rs.getString("DateOfBirth");
                dto = new RegisterDTO(fullname, role, username);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public List<RegisterDTO> findByLikeFullname(String search) throws Exception {
        List<RegisterDTO> result = null;
        String username, fullname, role, email, dateOfBirth, phone;

        RegisterDTO dto = null;

        try {
            String sql = "Select Username, Fullname, Role, EmailAddress, DateOfBirth, PhoneNumber from CakeRegistration where Fullname LIKE ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, "%" + search + "%");
            rs = preStm.executeQuery();
            result = new ArrayList<>();
            while (rs.next()) {
                username = rs.getString("Username");
                fullname = rs.getString("Fullname");
                role = rs.getString("Role");
                email = rs.getString("EmailAddress");
                phone = rs.getString("PhoneNumber");
                dateOfBirth = rs.getString("DateOfBirth");
                dto = new RegisterDTO(username, role, fullname, email, phone, dateOfBirth);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }

    public RegisterDTO findByMyPrimaryKeyAdmin(String key) throws Exception {
        RegisterDTO dto = null;
        try {
            String sql = "Select Username, Fullname, Role, PhoneNumber, EmailAddress, DateOfBirth from CakeRegistration where Username = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, key);
            rs = preStm.executeQuery();
            if (rs.next()) {
                String username = rs.getString("Username");
                String fullname = rs.getString("Fullname");
                String role = rs.getString("Role");
                String phoneNumber = rs.getString("PhoneNumber");
                String emailAddress = rs.getString("EmailAddress");
                String dateOfBirth = rs.getString("DateOfBirth");
                dto = new RegisterDTO(username, role, fullname, emailAddress, phoneNumber, dateOfBirth);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }

    public boolean updateUser(RegisterDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Update CakeRegistration Set Role = ? where Username = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getRole());
            preStm.setString(2, dto.getUsername());
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }

    public boolean insert(RegisterDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert into UserRegistration (Username, Password, Fullname, RoleID, Email) "
                    + "values(?,?,?,?,?)";
            conn = MyConnection.getMyConnection2();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getUsername());
            preStm.setString(2, dto.getPassword());
            preStm.setString(3, dto.getFullname());
            preStm.setString(4, "us");
            preStm.setString(5, dto.getEmail());
            //preStm.setString(5, dto.getEmail());
            //preStm.setString(6, dto.getPhonenumber());
            check = preStm.executeUpdate() > 0;

        } finally {
            closeConnection();

        }
        return check;
    }

    public boolean insert2(RegisterDTO dto) throws Exception {
        boolean check = false;
        try {
            String sql = "Insert into CakeRegistration(Username, Password, Fullname, Role, EmailAddress, DateOfBirth, PhoneNumber) "
                    + "values(?,?,?,?,?,?,?)";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, dto.getUsername());
            preStm.setString(2, dto.getPassword());
            preStm.setString(3, dto.getFullname());
            preStm.setString(4, dto.getRole());
            preStm.setString(5, dto.getEmail());
            Date date1 = Date.valueOf(dto.getDateOfBirth());
            preStm.setDate(6, date1);
            preStm.setString(7, dto.getPhonenumber());
            check = preStm.executeUpdate() > 0;

        }
        catch(Exception e)
        {
            System.out.println("ERROR: "+e.getMessage());
        }
        finally {
            closeConnection();

        }
        return check;
    }

    public boolean deleteUserAdmin(String id) throws Exception {
        boolean check = false;
        try {
            String sql = "Delete from CakeRegistration where Username = ?";
            conn = MyConnection.getMyConnection();
            preStm = conn.prepareStatement(sql);
            preStm.setString(1, id);
            check = preStm.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    public Date ConvertDate(String date){ 
        Date date1 = Date.valueOf(date);
        System.out.println("date: "+date1);
        return date1;
    }
}
