/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cake.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tatha
 */
public class MainUserController extends HttpServlet {
private static final String ERROR = "error/error.jsp";
private static final String WELCOMEUSERPAGE = "user/welcome-user.html";
private static final String ABOUTUSERPAGE = "user/about-user.html" ;
private static final String CHECKOUTUSERPAGE = "user/checkout-user.jsp" ;
private static final String CONTACTUSERPAGE = "user/contact.html" ;

private static final String LOGOUTUSERPAGE  = "LogOutController";
private static final String CAKEUSERPAGE = "SearchCakeUserController" ;
private static final String ADDCAKEUSER = "AddCakeUserController" ;//AddCakeUserController
private static final String DELETECAKEUSER = "DeleteCakeUserController" ;
private static final String UPDATECAKEUSER = "UpdateCakeUserController" ;
private static final String SUBMITBILLUSER = "InsertIntoDBBillOrderController"; //OrderTable Sql
    
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
            String action = request.getParameter("action");
            if(action.equals("user/welcome-user.html"))
            {
                url = WELCOMEUSERPAGE;
            }
            else if(action.equals("About"))
            {
                url = ABOUTUSERPAGE;
            }
            else if(action.equals("Cake"))
            {
                url = CAKEUSERPAGE;
            }
            else if(action.equals("Add To Cart"))
            {
                url = ADDCAKEUSER;
            }
            else if(action.equals("X"))
            {
                url = DELETECAKEUSER;
            }
            else if(action.equals("Update"))
            {
                url = UPDATECAKEUSER;
            }
            else if(action.equals("Checkout"))
            {
                url = CHECKOUTUSERPAGE;
            }
            else if(action.equals("Place Order"))
            {
                url = SUBMITBILLUSER;
            }
            else if(action.equals("Contact"))
            {
               url = CONTACTUSERPAGE;
            }
            else if(action.equals("LogOut"))
            {
                url = LOGOUTUSERPAGE;   
            }
            
            else
            {
                request.setAttribute("ERROR", "Invalid Action");
            }
        }
        catch(Exception e)
        {
            log("Error at MainUserController"+ e.getMessage());
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
