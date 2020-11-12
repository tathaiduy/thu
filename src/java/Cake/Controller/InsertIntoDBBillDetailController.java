/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cake.Controller;

import Cake.Bean.BillBean;
import Cake.DTO.BillDTO;
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
public class InsertIntoDBBillDetailController extends HttpServlet {

    private static final String ERROR = "error/error.jsp";
    private static final String SUCCESS = "user/thankyou.jsp";

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

            BillBean bean = new BillBean();
            bean.setSearch("");
            List<BillDTO> oderList = bean.getBillNumber();
            int numberBill = oderList.size();
            String orderID = "O" + numberBill;

            String[] cakeQuantity = request.getParameterValues("txtCakeQuantity");
            String[] cakeID = request.getParameterValues("txtCakeID");

            for (int i = 0; i < cakeID.length; i++) {
                bean = new BillBean();
                BillDTO dto = new BillDTO(cakeID[i], orderID, cakeQuantity[i]);
                bean.setDto(dto);
                if (bean.InsertBillDetailTable()) {
                    url = SUCCESS;
                } else {
                    request.setAttribute("ERROR", "Cant submit your Bill");
                }
            }

        } catch (Exception e) {
            log("Error at InsertIntoDBBillDetailController: " + e.getMessage());
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
