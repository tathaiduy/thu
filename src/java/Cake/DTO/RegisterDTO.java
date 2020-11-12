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
public class RegisterDTO implements Serializable{
    private String username, password, fullname, email, phonenumber, role, dateOfBirth;

    public RegisterDTO() {
    }

    public RegisterDTO(String username, String role) {
        this.username = username;
        this.role = role;
    }
    
    
    public RegisterDTO(String fullname, String role, String username) {
        this.fullname = fullname;
        this.role = role;
        this.username =username;
    }
    
    
    public RegisterDTO  (String username, String password, String fullname, String role) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.role = role;
    }

    public RegisterDTO(String username, String password, String role, String fullname, String email) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.role = role;
        this.email = email;
        
    }
    public RegisterDTO(String username, String role, String fullname, String email, String phonenumber, String dateOfBirth) {
        this.username = username;
        this.role = role;
        this.fullname = fullname;
        this.email = email;
        this.phonenumber = phonenumber;
        this.dateOfBirth = dateOfBirth;
    }

    public RegisterDTO(String username, String password, String fullname, String email, String phonenumber, String role, String dateOfBirth) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
        this.email = email;
        this.phonenumber = phonenumber;
        this.role = role;
        this.dateOfBirth = dateOfBirth;
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

    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    
    
}
