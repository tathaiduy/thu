/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cake.Controller;

import Cake.Bean.BookBean;
import Cake.DTO.BookDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tatha
 */
public class SearchBookAdminController extends HttpServlet {

    private static final String ERROR = "error/error.jsp";
    private static final String SUCCESS1 = "admin/index.jsp";
    private static final String SUCCESS2 = "admin/cake-product-list.jsp";

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

            String search = request.getParameter("txtSearchCakeAdmin");
            if (search == null) {
                search = "";
            }
            BookBean bean = new BookBean();

            bean.setSearch(search);
            List<BookDTO> result = bean.findByLikeBookName();
            if (result.size() == 0) {
                url = ERROR;
                request.setAttribute("ERROR", "Cant find the product has name: " + search);

            } else {
                request.setAttribute("INFOCAKEADMIN", result);
                String bookList = request.getParameter("txtProductList");
                if (bookList == null) {
                    bookList = "";
                }
                if (bookList.equals("cake-product-list.jsp")) {
                    url = SUCCESS2;
                } else {
                    url = SUCCESS1;
                }
            }

        } catch (Exception e) {
            log("Error at SearchBookAdminController: " + e.getMessage());
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
