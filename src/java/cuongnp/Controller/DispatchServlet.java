/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package cuongnp.controller;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Cuong
 */
@WebServlet(name = "DispatchServlet", urlPatterns = {"/DispatchServlet"})
// name tuong duong servlet-name
// urlparttend phat sinh code url-pattern (anotation)
// phai compine code. Neu da co san wdd thi se bi wdd ghi de.
//xml khi thuong xuyen thay doi
public class DispatchServlet extends HttpServlet {

    private final String LOGIN_PAGE = "login.html";

    private final String LOGIN_CONTROLLER = "LoginServlet";
    private final String SEARCH_LASTNAME_CONTROLLER = "SearchLastNameServlet";
    private final String DELETE_ACCOUNT_CONTROLLER = "DeleteAccountServlet";
    private final String REGISTER_ACCOUNT_CONTROLLER = "CreateAccountServlet";
    private final String LOGOUT_ACCOUNT_CONTROLLER = "LogOutServlet";
    private final String UPDATE_ACCOUNT_CONTROLLER = "UpdateServlet";
    private final String SEARCH_BOOK_CONTROLLER = "SearchBookServlet";
    private final String ADD_TO_CART_BOOK_CONTROLLER = "AddBookToCartServlet";
    private final String DELETE_ITEM_CART_CONTROLLER = "RemoveItemServlet";
    private final String TAKE_BOOK_DETAIL_CONTROLLER = "TakeBookDetailServlet";
    private final String SEARCH_BOOK_ADMIN_CONTROLLER = "SearchBookAdminServlet";
    private final String CHECK_OUT_CART_CONTROLLER = "CheckOutServlet";

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
        //1. Which button did user click ?
        String button = request.getParameter("btAction");
        String url = LOGIN_PAGE;
        try {

            if (button == null) {

            } else {
                switch (button) {
                    case "Login":
                        url = LOGIN_CONTROLLER;
                        break;
                    case "Search":
                        url = SEARCH_LASTNAME_CONTROLLER;
                        break;
                    case "Delete":
                        url = DELETE_ACCOUNT_CONTROLLER;
                        break;
                    case "Update":
                        url = UPDATE_ACCOUNT_CONTROLLER;
                        break;
                    case "Log out":
                        url = LOGOUT_ACCOUNT_CONTROLLER;
                        break;
                    case "Sign up":
                        url = REGISTER_ACCOUNT_CONTROLLER;
                        break;
                    case "Search book":
                        url = SEARCH_BOOK_CONTROLLER;
                        break;
                    case "Add to card":
                        url = ADD_TO_CART_BOOK_CONTROLLER;
                        break;
                    case "Remove item(s)":
                        url = DELETE_ITEM_CART_CONTROLLER;
                        break;
                    case "Take book detail":
                        url = TAKE_BOOK_DETAIL_CONTROLLER;
                        break;
                    case "Find book":
                        url = SEARCH_BOOK_ADMIN_CONTROLLER;
                        break;
                    case "Check Out":
                        url = CHECK_OUT_CART_CONTROLLER;
                        break;
                    default:
                    //do nothing
                }
            }
            //vao trong form login, dan vao name cua nut submit.
            //
            //

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
