/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cuongnp.controller;

import cuongnp.registration.RegistrationDAO;
import cuongnp.registration.RegistrationDTO;
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
//dang dung o controller
@WebServlet(name = "SearchLastNameServlet", urlPatterns = {"/SearchLastNameServlet"})
public class SearchLastNameServlet extends HttpServlet {

//    private final String SEARCH_PAGE = "search.html";
  private final String SEARCH_PAGE = "search.jsp";
    
    private final String SEARCH_RESULT = "search.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //1. getall user's information
        String searchValue = request.getParameter("txtSearchValue"); //gia tri tim kiem
        String url = SEARCH_PAGE;
        try {
            if (!searchValue.trim().isEmpty()) {
                //2. Controller calls meothd of Model
                //2.1 New DAO object
                RegistrationDAO dao = new RegistrationDAO();
                //2.2 call method of DAO object 
                dao.searchLastName(searchValue); // ko tra tri
                //3. Process
                List<RegistrationDTO> result = dao.getAccounts();
                
                //dua result vao trang jsp. dat vao vung nho trung gian (o container) Scope va co thang toi lay
                //trang dong vi gia tri tim kiem khac nhau thi se ra ket qua khac nhau.
                //dung request scope, bang para va atribute. 
                //dung parameter vi chi can doc
                //request parameter ko duoc chon . vi tu client den server va minh dang o server. --> nen phai attribue
                //dang chua 2 para txtSearchname, btAction va 1 attribute  SEARCH_RESULT
                //
                url = SEARCH_RESULT;
                request.setAttribute("SEARCH_RESULT", result);
                

            }
//phai catch boi vi 1 so phuong thuc class khong duoc chinh sua vi no la signature
        } catch (SQLException ex){
            log ("SQL: " + ex.getMessage());
        }catch (ClassNotFoundException ex){
            log ("ClassNotFoundException "+ ex.getMessage());
        } finally {
            //minh phai giu lai para de hien thi gia tri tim kiem, tranh co che stateless.
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
            //
        }
    }
//di den view 
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
