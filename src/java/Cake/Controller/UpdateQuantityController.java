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
public class UpdateQuantityController extends HttpServlet {

    private static final String ERROR = "error/error.jsp";
    private static final String SUCCESS = "user/thankyou.jsp";
    private static final String OUTOFSTOCK = "user/wrong.jsp" ;

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
            String[] bookID = request.getParameterValues("txtBookID");
            String[] bookQuantity = request.getParameterValues("txtBookQuantity");
            BookDTO dto = null;
            for (int i = 0; i < bookID.length; i++) {
                BookBean bean = new BookBean();
                bean.setSearch(bookID[i]);
                List<BookDTO> result = bean.getBookQuantity();
                dto = new BookDTO();
                dto = result.get(0);
                String id = dto.getBookID();
                int quantity = dto.getBookQuantity();
                quantity = quantity - Integer.parseInt(bookQuantity[i]);
                String status = "Available";
                if (quantity == 0) {
                    status = "N/A";
                    dto = new BookDTO(id, quantity, status);
                    bean = new BookBean();
                    bean.setDto(dto);
                    if (bean.UpdateQuantityAfterBuying()) {
                        url = SUCCESS;
                    } else {
                        request.setAttribute("ERROR", "Cant Submit Your Bill");
                    }
                    if (url == SUCCESS) {
                        request.setAttribute("THANKYOU", "Your Bill Is Paied");
                    }
                    
                } else if (quantity < 0) {
                    request.setAttribute("WRONG", "This Product has " + dto.getBookQuantity() + " left");
                    url = OUTOFSTOCK;
                } else {
                    dto = new BookDTO(id, quantity, status);
                    bean = new BookBean();
                    bean.setDto(dto);
                    if (bean.UpdateQuantityAfterBuying()) {
                        url = SUCCESS;
                    } else {
                        request.setAttribute("ERROR", "Cant Submit Your Bill");
                    }
                    if (url == SUCCESS) {
                        request.setAttribute("THANKYOU", "Your Bill Is Paied");
                    }
                }

            }

        } catch (Exception e) {
            log("Error at UpdateQuantityController: " + e.getMessage());
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
