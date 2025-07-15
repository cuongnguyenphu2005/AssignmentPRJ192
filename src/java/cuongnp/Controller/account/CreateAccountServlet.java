/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cuongnp.controller.account;

import cuongnp.models.registration.RegistrationCreateError;
import cuongnp.models.registration.RegistrationDAO;
import cuongnp.models.registration.RegistrationDTO;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 *
 * @author Cuong
 */
@WebServlet(name = "CreateAccountServlet", urlPatterns = {"/CreateAccountServlet"})
public class CreateAccountServlet extends HttpServlet {

    private final String ERROR_PAGE = "createNewAccount.jsp";
    private final String LOGIN_PAGE = "login.html";

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
        //1. Get all user's information
        String username = request.getParameter("txtUsername");
        String password = request.getParameter("txtPassword");
        String confirm = request.getParameter("txtConfirm");
        String fullname = request.getParameter("txtFullname");

        RegistrationCreateError errors = new RegistrationCreateError();
        boolean foundErr = false; //flag chan error
        String url = ERROR_PAGE;
        try {
            //1. Verify user's errors
            if (username.trim().length() < 6
                    || username.trim().length() > 12) {
                foundErr = true;
                errors.setUsernameLengthErr(
                        "Username is required typing from 6 to 12 characters!");
            }
            if (password.trim().length() < 8
                    || password.trim().length() > 20) {
                foundErr = true;
                errors.setPasswordLengthErr(
                        "Password is required typing from 8 to 20 characters!");
            } else if (!confirm.trim().equals(password.trim())) {
                foundErr = true;
                errors.setConfirmNotMatched(
                        "Confirm must match password!");
            }
            if (fullname.trim().length() < 2
                    || fullname.trim().length() > 40) {
                foundErr = true;
                errors.setFullnameLengthErr(
                        "Full name is required typing from 2 to 40 characters!");
            }
            if (foundErr) { //bat o front end 
                request.setAttribute("CREATE_ERROR", errors);
            } else { //no error
                //2. Controller calls method of Model

                //2.1 New DAO Object
                RegistrationDAO dao = new RegistrationDAO();

                //2.2 Call methods of DAO Object
                RegistrationDTO account = new RegistrationDTO(
                        username, password, fullname, false);
                boolean result = dao.createAccount(account);
                //3. Process
                if (result) {
                    url = LOGIN_PAGE;
                }
            }
        } catch (SQLException ex) {
            String msg = ex.getMessage();
            log("SQL: " + ex.getMessage());
            if (msg.contains("duplicate")) {
                errors.setUsernameIsExisted(username + " is EXISTED");
                //la error cua servlet object
                request.setAttribute("CREATE_ERROR", errors);
            }
        } catch (ClassNotFoundException ex) {
            log("Class Not Found: " + ex.getMessage());
        } finally {
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
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
