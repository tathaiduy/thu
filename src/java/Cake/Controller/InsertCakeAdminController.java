    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cake.Controller;

import Cake.Bean.BookBean;
import Cake.Bean.CakeBean;
import Cake.DB.BookErrorObject;
import Cake.DTO.BookDTO;
import Cake.DTO.CakeDTO;
import Cake.DTO.CakeErrorObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DuyTT
 */
public class InsertCakeAdminController extends HttpServlet {
private static final String ERROR = "error/error.jsp";
private static final String SUCCES = "SearchCakeAdminController";
private static final String INVALID = "admin/cake-insert.jsp";
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
            
            String cakeName =  request.getParameter("txtInsertCakeName");
            String cakePrice = request.getParameter("txtInsertCakePrice");
            String cakePicture = request.getParameter("txtInsertCakePicture");
            
            BookErrorObject error  = new BookErrorObject();
            boolean valid = true;
            
            if(cakeName.length() == 0)
            {
                valid = false;
                error.setBookTitleError("Cake Name cant be blank");
            }
            if(cakePrice.length() == 0)
            {
                valid = false;
                error.setBookPriceError(("Cake Price cant be blank"));
            }
            if(Pattern.matches("^\\d{1,10}$", cakePrice) == false)
            {
                valid = false;
                error.setBookPriceError("Cake Price cant be character");
            }
            
            
            if(valid ==true)
            {
                
                CakeBean bean = new CakeBean();
                bean.setSearch("");
                List<CakeDTO> reuslt = bean.findByLikeCakeName();
                String cakeID;
                int listCake = reuslt.size();
                listCake = listCake+1;
                if(listCake > 9)
                {
                    cakeID = "C"+listCake;
                }
                else
                {
                    cakeID = "C0"+listCake;
                }
                
                
                
                bean = new CakeBean();
                CakeDTO dto = new CakeDTO(cakeName, cakeID, cakePicture, Integer.parseInt(cakePrice) );
                bean.setCakeDTO(dto);
                if(bean.insert())
                {
                    url = SUCCES;
                }
                else
                {
                    request.setAttribute("ERROR","Insert Failed");
                }
            }
            else 
            {
                url = INVALID;
                request.setAttribute("INSERTCAKEINVALID",error);
            }
        }catch(Exception e)
        {
            log("Error at InsertCakeAdminController: "+e.getMessage());
        }
        finally
        {
            request.getRequestDispatcher(url).forward(request,response);
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
