/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cake.Bean;

import Cake.DAO.UserDAO;
import Cake.DTO.RegisterDTO;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author DuyTT
 */
public class UserBean implements Serializable {

    private String username, password;
    private String search;
    private UserDAO userDAO = null;
    
    private RegisterDTO dto;

    public UserBean() {
        userDAO = new UserDAO();
    }
    
    public boolean updateUser() throws Exception 
    {
        return userDAO.updateUser(dto);
    }

     public boolean deleteUserAdmin() throws Exception
     {
         return userDAO.deleteUserAdmin(username);
     }
    
    public RegisterDTO findByMyPrimaryKeyAdmin() throws Exception
    {
        return userDAO.findByMyPrimaryKeyAdmin(username);
    }
    public List<RegisterDTO> findByLikeName() throws Exception
    {
        return userDAO.findByLikeName(search);
    }
    
    public List<RegisterDTO> findByLikeFullname() throws Exception
    {
        return userDAO.findByLikeFullname(search);
    }
            
    public List<RegisterDTO> findByLikeNameAdmin() throws Exception
    {
        return userDAO.findByLikeNameAdmin(search);
    }
    
    public RegisterDTO checkLogin() throws Exception {
        return userDAO.checkLogin(username, password);
    }

    public boolean insert() throws Exception {
        return userDAO.insert(dto);
    }
    
    public boolean insert2() throws Exception
    {
        return userDAO.insert2(dto);
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public RegisterDTO getDto() {
        return dto;
    }

    public void setDto(RegisterDTO dto) {
        this.dto = dto;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    
    
}
