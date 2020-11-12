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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DuyTT
 */
public class UpdateUserAdminController extends HttpServlet {
private static final String ERROR = "error/error.jsp";
private static final String SUCCESS = "admin/user-single.jsp";
private static final String INVALID = "admin/user-single.jsp";
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
        RegisterDTO dto = null;
        String url = ERROR;
        try 
        {
            String username = request.getParameter("txtUpdateUsername");
            String fullname = request.getParameter("txtUpdateFullname");
            String role = request.getParameter("txtUpdateRole");
            String phoneNumber = request.getParameter("txtUpdatePhoneNumber");
            String emailAddress = request.getParameter("txtUpdateEmailAddress");
            String dateOfBirth = request.getParameter("txtUpdateDateOfBirth");
            
            
            UserErrorObject errorObject = new UserErrorObject();
            boolean valid =  true;
            if(role.length() == 0)
            {
                valid = false;
                errorObject.setRoleError("Role cant be blank");
            }
            /*if(phoneNumber.length() == 0)
            {
                valid = false;
                errorObject.setPhoneNumberError("phoneNumber cant be blank");
            }
            if(phoneNumber.length() != 10)
            {
                valid = false;
                errorObject.setPhoneNumberError("Phonenumber must have 10 digit");
            }
            if(phoneNumber.matches("[a-zA-Z]"))
            {
                valid =false;
                errorObject.setPhoneNumberError("Phone number couldn't have Alphabet");
            }*/
            /*if(!emailAddress.matches("^(.+)@(.+)$"))
            {
                valid =false;
                errorObject.setEmailAddressError("Wrong type of email version");
            }
            /*if(dateOfBirth.length() == 0)
            {
                valid = false;
                errorObject.setDateOfBirthError("Date of birth cant be blank");
            }*/
            if(valid == true)
            {
                dto = new RegisterDTO(username, role);
                RegisterDTO dtoReturn = new RegisterDTO(username, role, fullname, emailAddress, phoneNumber, dateOfBirth);
                UserBean bean = new UserBean();
                bean.setDto(dto);
                if(bean.updateUser())
                {
                    url = SUCCESS;
                    request.setAttribute("EDITUSERADMIN", dtoReturn);
                }
                else
                {
                    request.setAttribute("ERROR", "Update Failed");
                }
            }
            else
            {
                url = INVALID;
                request.setAttribute("INVALIDUPDATEUSER", errorObject);
                request.setAttribute("EDITUSERADMIN", dto);
            }
            
        }
        catch(Exception e)
        {
            log("Error at UpdateUserAdminController: "+e.getMessage());
        }
        finally
        {
            request.getRequestDispatcher(url).forward(request, response);
        }
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
