/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cuongnp.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import cuongnp.registration.RegistrationDAO;
import cuongnp.registration.RegistrationDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import static org.apache.tomcat.jni.User.username;

/**
 *
 * @author Cuong
 */
public class LoginServlet extends HttpServlet {

    private final String ADMIN_HOME_PAGE = "adminhome.html";
    private final String INVALID_PAGE = "invalid.html";
    private final String SEARCH_PAGE = "search.jsp";

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
        PrintWriter out = response.getWriter(); // Phai lay ra vi de trong try la finally
//        RegistrationDTO result = dao.checkLogin(username, password);

        //1. get all user info (parameter)
        String button = request.getParameter("btAction");
        String url = INVALID_PAGE;
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        try {
            
            //de nhan dang nut gi
            //qua login.html copy qua o value
                //de user voi pass trong day de tiet kiem dung luong
                

                //2. Controller calls methods
                //2.1 New DAO Object
                RegistrationDAO dao = new RegistrationDAO();
                //kiem tra xem co san chua, co r thi xai, chua co thi tao
                //2.2  call method of DAO object
                RegistrationDTO result = dao.checkLogin(username, password);
//                if (result) {
//                    url = ADMIN_HOME_PAGE;
//                } else {
//                    result = dao.checkLogin(username, password);
//                    if (result) {
//                        
//                    }
//                }
    if (result != null){
        HttpSession session = request.getSession(); // phai tao nen phai true
        session.setAttribute("USER_INFO", result);
        url = SEARCH_PAGE;
        
        
    }
                //3.  Process result

            //user clicked Login button, format F lai
            
        } catch (SQLException ex) {
            log("LoginServlet_SQLException: " + ex.getMessage());
            response.sendRedirect(INVALID_PAGE);
        } catch (ClassNotFoundException ex) {
            log("LoginServlet_ClassNotFoundException: " + ex.getMessage());
            response.sendRedirect(INVALID_PAGE);
        } finally {// de het loi
//            response.sendRedirect(url); //lo url
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward (request,response);
            out.close();
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
