/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cake.Controller;

import Cake.Bean.BookBean;
import Cake.Bean.CakeBean;
import Cake.DTO.BookDTO;
import Cake.DTO.CakeDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DuyTT
 */
public class SearchCakeAdminController extends HttpServlet {
private static final String ERROR = "error/error.jsp";
private static final String INDEXADMIN = "admin/index.jsp";
private static final String CAKEPRODUCLISTADMIN = "admin/cake-product-list.jsp";
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
            if(search == null)
            {
                search = "";
            }
            CakeBean bean = new CakeBean();
            
            bean.setSearch(search);
            List<CakeDTO> result = bean.findByLikeCakeName();
            if(result.size() == 0)
            {
                url = ERROR;
                request.setAttribute("ERROR", "Cant Find The Product Has name: "+ search);
            }
            else
            {
            request.setAttribute("INFOCAKEADMIN", result);
            
            //String namePage = request.getParameter("txtHidden");
            String productList = request.getParameter("txtProductList");
            if(productList == null)
            {
                url = INDEXADMIN;
            }
            else if(productList.contains("index.jsp"))
            {
                url = INDEXADMIN;
            }
            if(productList.contains("cake-product-list.jsp"))
            {
                url = CAKEPRODUCLISTADMIN;
            }
            if(productList.contains("cake-insert.jsp"))
            {
                url = CAKEPRODUCLISTADMIN;
            }
            }
        } catch (Exception e) {
            log("Error at SearchCakeAdminController: " + e.getMessage());
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
