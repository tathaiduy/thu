/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cake.Controller;

import Cake.DTO.CakeDTO;
import Cake.DTO.CartDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DuyTT
 */
public class AddCakeController extends HttpServlet {

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
        try {
            HttpSession session = request.getSession();
            CartDTO shoppingCart = (CartDTO)session.getAttribute("cart");
            String fullname = (String)session.getAttribute("FULLNAME");
            if(fullname == null)
            {
                fullname = "Guest";
            }
            if(shoppingCart == null)
            {
                shoppingCart = new CartDTO(fullname);
            }
            String cakeName  = request.getParameter("cakeName");
            int cakePrice = Integer.parseInt(request.getParameter("cakePrice"));
            String cakePicture = request.getParameter("cakePicture");
            String cakeID = request.getParameter("cakeID");
            int quantity = 1;
            
            CakeDTO cake = new CakeDTO(cakeName, cakeID, cakePicture, cakePrice);
            cake.setCakeQuantity(quantity);
            
            shoppingCart.addToCart(cake);
            session.setAttribute("cart", shoppingCart);
            
        }
        catch(Exception e)
        {
            log("Error at AddCakeController: "+e.getMessage());
        }
        finally
        {
            request.getRequestDispatcher("cart.jsp").forward(request, response);
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
