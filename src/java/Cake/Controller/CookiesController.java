/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cake.Controller;

import java.io.IOException;
import java.io.PrintWriter;
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
public class CookiesController extends HttpServlet {
    private static final String ERROR = "error/error.jsp";
    private static final String USER = "user/welcome-user.html";
    private static final String ADMIN = "SearchCakeAdminController";
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
        try{
            Cookie[] cookies = request.getCookies();
            HttpSession session = request.getSession();
            if (cookies.length == 1 && cookies[0].getMaxAge() == -1) {
                
                
                
                String username = request.getParameter("txtUsername");
                String password = request.getParameter("txtPassword");

                Cookie cookiesUsername = new Cookie("cookiesUsername", username);
                Cookie cookiesPassword = new Cookie("cookiesPassword", password);

                cookiesPassword.setMaxAge(1800);
                cookiesUsername.setMaxAge(1800);
                response.addCookie(cookiesPassword);
                response.addCookie(cookiesUsername);
                if(session.getAttribute("ROLE").equals("user"))
                {
                    url = USER;
                }
                else if(session.getAttribute("ROLE").equals("admin"))
                {
                    url = ADMIN;
                }
                else
                {
                    request.setAttribute("ERROR", "Unknow your role");
                }
            }
            else
            {
                String username = cookies[2].getValue();
                String password = cookies[1].getValue();
                
                
                Cookie cookiesUsername = new Cookie("cookiesUsername", username);
                Cookie cookiesPassword = new Cookie("cookiesPassword", password);

                cookiesPassword.setMaxAge(1800);
                cookiesUsername.setMaxAge(1800);
                response.addCookie(cookiesPassword);
                response.addCookie(cookiesUsername);
                if(session.getAttribute("ROLE").equals("user"))
                {
                    url = USER;
                }
                else if(session.getAttribute("ROLE").equals("admin"))
                {
                    url = ADMIN;
                }
                else
                {
                    request.setAttribute("ERROR", "Unknow your role");
                }
            }
        }
        catch(Exception e)
        {
            log("Error at CookiesController: "+e.getMessage());
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
