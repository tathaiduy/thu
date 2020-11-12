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
public class MainAdminController extends HttpServlet {
private static final String ERROR = "error/error.jsp";
private static final String EDITCAKEADMIN = "EditCakeAdminController";
private static final String DELETECAKEADMIN = "DeleteCakeAdminController";
private static final String EDITUSERADMIN = "EditUserAdminController";
private static final String DELETEUSERADMIN = "DeleteUserAdminController";
private static final String INSERTUSERPAGE = "admin/user-insert.jsp";
private static final String INSERTCAKEPAGE = "admin/cake-insert.jsp";
private static final String VIEWDATATABLEADMIN = "SearchDataTableUserController";
private static final String SEARCHCAKEINDEXPAGE = "SearchCakeAdminController" ;
private static final String UPDATECAKEADMIN = "UpdateCakeAdminController";
private static final String SEARCHUSERPAGE = "SearchUserAdminController" ;
private static final String  UPDATEUSERADMIN = "UpdateUserAdminController";
private static final String INSERTUSERADMIN = "InsertUserAdminController" ;
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
        try
        {
            String action = request.getParameter("action");
            if(action.equals("View Details Cake"))
            {
                url = EDITCAKEADMIN;
            }
            else if(action.equals("Delete Cake Admin"))
            {
                url = DELETECAKEADMIN;
            }
            else if(action.equals("View Details User"))
            {
                url = EDITUSERADMIN;
            }
            else if(action.equals("Delete User Admin"))
            {
                url = DELETEUSERADMIN;
            }
            else if(action.equals("user-insert.jsp"))
            {
                url = INSERTUSERPAGE;
            }
            else if(action.equals("cake-insert.jsp"))
            {
                url = INSERTCAKEPAGE;
            }
            else if(action.equals("data-table.jsp"))
            {
                url = VIEWDATATABLEADMIN;
            }
            else if(action.equals("Search Index Page"))
            {
                url = SEARCHCAKEINDEXPAGE;
            }
            else if(action.equals("Update Cake"))
            {
                url = UPDATECAKEADMIN;
            }
            else if(action.equals("Search User Page"))
            {
                url = SEARCHUSERPAGE;
            }
            else if(action.equals("Update User"))
            {
                url = UPDATEUSERADMIN;
            }
            else if(action.equals("Insert User Admin"))
            {
                url = INSERTUSERADMIN;
            }
            else
            {
                request.setAttribute("ERROR", "Invalid Action");
            }
        }
        catch(Exception e)
        {
            log("Error at MainAdminController: "+e.getMessage());
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
