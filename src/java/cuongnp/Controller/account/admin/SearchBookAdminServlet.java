/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package cuongnp.controller.account.admin;

import cuongnp.models.book.BookDAO;
import cuongnp.models.book.BookDTO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Cuong
 */
@WebServlet(name="SearchBookAdminServlet", urlPatterns={"/SearchBookAdminServlet"})
public class SearchBookAdminServlet extends HttpServlet {
    private final String SEARCH_RESULT_PAGE = "manageBook.jsp";
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = SEARCH_RESULT_PAGE;
        //1. Get all user info
        String searchValue = request.getParameter("txtSearchBookManage");
        try {
            if (!searchValue.trim().isEmpty()) {
                //2. Call DAO
                BookDAO dao = new BookDAO();
                //2.1 Call method from DAO
                dao.searchBook(searchValue);
                List<BookDTO> result = dao.getBookItem();
                //3. Process
                request.setAttribute("BOOK_SEARCH_ADMIN_RESULT", result);
            }
        } catch (SQLException ex) {
            log("SQLException: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            log("ClassNotFoundException: " + ex.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
