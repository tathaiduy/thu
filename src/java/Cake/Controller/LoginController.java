/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cake.Controller;

import Cake.Bean.CakeBean;
import Cake.Bean.UserBean;
import Cake.DAO.CakeDAO;
import Cake.DTO.RegisterDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DuyTT
 */
public class LoginController extends HttpServlet {

    private static final String ERROR = "error/error.jsp";
    private static final String SUCCESS = "CookiesController" ;
    private static final String USER = "user/welcome-user.html";
    private static final String ADMIN = "SearchBookAdminController";//"SearchCakeAdminController"

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
            Cookie[] cookies = request.getCookies();
            if (cookies.length == 1 && cookies[0].getMaxAge() == -1) {
                String username = request.getParameter("txtUsername");
                String password = request.getParameter("txtPassword");

                UserBean bean = new UserBean();
                bean.setUsername(username);
                bean.setPassword(password);

                RegisterDTO result = bean.checkLogin();
                HttpSession session = request.getSession();
                session.setAttribute("USERNAME", username);
                session.setAttribute("ROLE", result.getRole());
                session.setAttribute("FULLNAME", result.getFullname());
                if (result.getRole().equals("failed")) {
                    request.setAttribute("ERROR", "Invalid Username or Password");
                } else {

                    if (result.getRole().equals("user")) {
                        url = SUCCESS;
                    } else if (result.getRole().equals("admin")) {
                        url = SUCCESS;

                    } else {
                        request.setAttribute("ERROR", "Your Role is Invalid");
                    }
                }
            }
            else 
            {
                String username = cookies[2].getValue();
                String password = cookies[1].getValue();
                
                UserBean bean = new UserBean();
                bean.setUsername(username);
                bean.setPassword(password);

                RegisterDTO result = bean.checkLogin();
                HttpSession session = request.getSession();
                session.setAttribute("USERNAME", username);
                session.setAttribute("ROLE", result.getRole());
                session.setAttribute("FULLNAME", result.getFullname());
                if (result.getRole().equals("failed")) {
                    request.setAttribute("ERROR", "Invalid Username or Password");
                } else {

                    if (result.getRole().equals("user")) {
                        url = SUCCESS;
                    } else if (result.getRole().equals("admin")) {
                        url = SUCCESS;

                    } else {
                        request.setAttribute("ERROR", "Your Role is Invalid");
                    }
                }
            }

        } catch (Exception e) {
            log("Error at LoginController: " + e.getMessage());
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
