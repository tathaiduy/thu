/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cake.Controller;

import Cake.Bean.UserBean;
import Cake.DTO.RegisterDTO;
import Cake.DTO.UserErrorObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DuyTT
 */
public class InsertUserAdminController extends HttpServlet {
private static final String ERROR = "error/error.jsp";
private static final String SUCCESS = "SearchUserAdminController";
private static final String INVALID = "admin/user-insert.jsp";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8"); 
        String url = ERROR;
        try {
            String username = request.getParameter("txtInsertUsername");
            String fullname = request.getParameter("txtInsertPassowrd");
            String password = request.getParameter("txtInsertFullname");
            String role = request.getParameter("txtInsertRole");
            String emailAddress = request.getParameter("txtInserEmailAddress");
            String phoneNumber = request.getParameter("txtInsertPhoneNumber");
            String datetime = request.getParameter("txtInsertDateOfBirth");
            
            UserErrorObject errorObj = new UserErrorObject();
            boolean valid = true;
            if(username.length()==0)
            {
                valid = false;
                errorObj.setUsernameError("Username cant blank");
            }
            if(fullname.length() == 0)
            {
                valid =false;
                errorObj.setFullnameError("Fullname cant be blank");
            }
            if(password.length() == 0)
            {
                valid = false;
                errorObj.setPasswordError("Password cant be blank");
            }
            if(role.length() == 0)
            {
                valid = false;
                errorObj.setRoleError("Role cant be blank");
            }
            if(emailAddress.length() == 0)
            {
                valid = false;
                errorObj.setEmailAddressError("Email cant be blank");
            }
            if(!emailAddress.matches("^(.+)@(.+)$"))
            {
                valid =false;
                errorObj.setEmailAddressError("Wrong type of email version");
            }
            if(phoneNumber.length() == 0)
            {
                valid = false;
                errorObj.setPhoneNumberError("phoneNumber cant be blank");
            }
            if(phoneNumber.length() != 10)
            {
                valid = false;
                errorObj.setPhoneNumberError("Phonenumber must have 10 digit");
            }
            if(phoneNumber.matches("[a-zA-Z]"))
            {
                valid =false;
                errorObj.setPhoneNumberError("Phone number couldn't have Alphabet");
            }
            if(datetime.length() == 0)
            {
                valid = false;
                errorObj.setDateOfBirthError("Date of Birth cant be blank");
            }
            
            if(valid)
            {
                datetime = ConvertDate(datetime);
                RegisterDTO dto = new RegisterDTO(username, password, fullname, emailAddress, phoneNumber, role, datetime);
                UserBean bean = new UserBean();
                bean.setDto(dto);
                if(bean.insert2())
                {
                    url = SUCCESS;
                }
                else
                {
                    request.setAttribute("ERROR", "Insert Failed");
                    
                }
            }
            else
            {
                url = INVALID;
                request.setAttribute("INSERTINVALID", errorObj);
            }
            
        }
        catch(Exception e)
        {
            log("Errot at InsertUserAdminController: "+e.getMessage());
            if(e.getMessage().contains("duplicate"))
            {
                url = ERROR;
                request.setAttribute("ERROR","Username available");
            }
        }
        finally
        {
            request.getRequestDispatcher(url).forward(request,response);
        }
    }
    
    public static String ConvertDate(String datetime)
    {
        String[] ar;
        ar = datetime.split("[/]");
        String temp = "";
        temp = ar[0];
        ar[0] = ar[1];
        ar[1] = temp;
        String date = "";
        reverse(ar);
        for (int i = 0; i < ar.length; i++) {
            if(i < 2 )
            {
                date = date + ar[i] + "-";
            }
            else if(i == 2)
            {
                date = date + ar[i];
            }
            
        }
        return date;
       
    }
    public static void reverse(String a[]) 
    { 
        Collections.reverse(Arrays.asList(a)); 
        System.out.println(Arrays.asList(a)); 
    } 


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
