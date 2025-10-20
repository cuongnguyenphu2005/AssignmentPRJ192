/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package cuongnp.controller.book;

import cuongnp.models.registration.RegistrationDTO;
import cuongnp.models.userContact.UserContactDAO;
import cuongnp.models.userContact.UserContactDTO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Cuong
 */
@WebServlet(name="CheckOutServlet", urlPatterns={"/CheckOutServlet"})
public class CheckOutServlet extends HttpServlet {
       private final String SEARCH_BOOK_PAGE = "searchBook.jsp";

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
        String url = SEARCH_BOOK_PAGE;
        //1. Get all info
        String phonePara = request.getParameter("intPhone");
        String address = request.getParameter("txtAddress");
        try {
            int phone = Integer.parseInt(phonePara);
            //2. new DAO
            HttpSession session = request.getSession();
            RegistrationDTO user = (RegistrationDTO) session.getAttribute("USER_INFO");
            String username = user.getUsername();
            UserContactDAO ucdao = new UserContactDAO();
            UserContactDTO ucdto = new UserContactDTO(username, phone, address);
            ucdao.setContact(ucdto);
            
        } catch (Exception e) {
            
        } finally {
            response.sendRedirect(url);
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
