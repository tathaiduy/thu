/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cake.Controller;

import Cake.Bean.CakeBean;
import Cake.Bean.UserBean;
import Cake.DTO.RegisterDTO;
import Cake.DTO.UserErrorObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DuyTT
 */
public class RegisterUsernameController extends HttpServlet {

    private static final String SUCCESS = "success-register.jsp";
    private static final String ERROR = "error/error.jsp";
    private static final String INVALID = "register.jsp" ;
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
        UserErrorObject errorObj = new UserErrorObject();
        try {
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            String fullname = request.getParameter("txtFullname");
            String email = request.getParameter("txtEmail");
            String phoneNumber = request.getParameter("txtPhoneNumber");

            //UserErrorObject errorObj = new UserErrorObject();
            boolean valid = true;
            if (username.length() == 0) {
                valid = false;
                errorObj.setUsernameError("Username cant be blank");
            }
            if (password.length() == 0) {
                valid = false;
                errorObj.setPasswordError("Password cant be blank");
            }
            if (fullname.length() == 0) {
                valid = false;
                errorObj.setFullnameError("Fullname cant be blank");
            }
            if (Pattern.matches("^\\D{1,1000}$", email) == false) {
                valid = false;
                errorObj.setFullnameError("Fullname cant contain number");
            }
            if (email.length() == 0) {
                valid = false;
                errorObj.setEmailAddressError("Email cant be blank");
            }
            if (valid == true) {
                UserBean bean = new UserBean();
                RegisterDTO dto = new RegisterDTO(username, password, "us", fullname, email);
                bean.setDto(dto);

                if (bean.insert()) {
                    url = SUCCESS;
                } else {
                    request.setAttribute("ERROR", "Insert Failed");
                }
            }
            else
            {
                request.setAttribute("INVALIDREGISTER", errorObj);
                url = INVALID;
            }

        } catch (Exception e) {
            log("Error at RegisterUsernameController: " + e.getMessage());
            if(e.getMessage().contains("duplicate"))
            {
                url = INVALID;
                errorObj.setUsernameError("Username Duplicate");
                request.setAttribute("INVALIDREGISTER", errorObj);
            }
        } finally {
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
