/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuongnp.models.book;

import cuongnp.util.DBHelper;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cuong
 */
public class BookDAO implements Serializable {

    public void setBookItem(List<BookDTO> bookItem) {
        this.bookItem = bookItem;
    }
    private List<BookDTO> bookItem;

    public List<BookDTO> getBookItem() {
        return bookItem;
    }

    public void searchBook(String searchValue)
            throws SQLException, ClassNotFoundException {
        //0. Declera
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            //1. Connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Prepare SQL query script
                String sql = "SELECT  b.book_id,book_name,[author],[category],[publish_year],price "
                        + "FROM [PRJSE1819].[dbo].[Book] b "
                        + "JOIN Book_Storage bs ON bs.book_id = b.book_id "
                        + "WHERE book_name LIKE ? AND bs.status = 1";
                //2.1 Prepare statement
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                //2.2 Query SQL
                rs = stm.executeQuery();
                //3. Take data from ResultSet
                while (rs.next()) {
                    String book_id = rs.getString("book_id");
                    String book_name = rs.getString("book_name");
                    String author = rs.getString("author");
                    String category = rs.getString("category");
                    int publish_year = rs.getInt("publish_year");
                    int price = rs.getInt("price");
                    

                    BookDTO dto = new BookDTO(book_id, book_name, author, category, publish_year,price);
                    if (this.bookItem == null) {
                        this.bookItem = new ArrayList<>();
                    }
                    this.bookItem.add(dto);
                }
            }

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public void addToCart(String book_id, int quantity)
            throws SQLException, ClassNotFoundException {
        //0.Declare
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Prepare SQL query script
                String sql = "SELECT book_name,price "
                        + "FROM [dbo].[Book] b "
                        + "JOIN Book_Storage bs ON bs.book_id = b.book_id "
                        + "WHERE b.book_id = ? AND status = 1";
                //2.1 Prepare statement
                stm = con.prepareStatement(sql);
                stm.setString(1, book_id);
                //2.2 Query SQL
                rs = stm.executeQuery();
                //3. Take data from ResultSet
                while (rs.next()) {
                    String book_name = rs.getString("book_name");
                    int price = rs.getInt("price");
                    int totalPrice = price * quantity;
                    BookDTO dto = new BookDTO(book_id, book_name, price, quantity, totalPrice);
                    if (this.bookItem == null) {
                        this.bookItem = new ArrayList<>();
                    }
                    this.bookItem.add(dto);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public BookDTO takeBookDetail(String book_id)
            throws SQLException, ClassNotFoundException {
        //0. Declera
        BookDTO result = null;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Connect DB
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Prepare SQL query script
                String sql = "SELECT b.book_id,[book_name],[author],[category],[publisher]"
                        + ",[publish_year],[price],[description],[image_url] "
                        + "FROM [dbo].[Book] b "
                        + "JOIN Book_Storage bs ON bs.book_id = b.book_id "
                        + "WHERE b.book_id = ? AND status = 1";
                //2.1 Prepare statement
                stm = con.prepareStatement(sql);
                stm.setString(1, book_id);
                //2.2 Query SQL
                rs = stm.executeQuery();
                //3. Take data from ResultSet
                while (rs.next()) {
                    String book_name = rs.getString("book_name");
                    String author = rs.getString("author");
                    String category = rs.getString("category");
                    String publisher = rs.getString("publisher");
                    int publish_year = rs.getInt("publish_year");
                    int price = rs.getInt("price");
                    String description = rs.getString("description");
                    String image_url = rs.getString("image_url");
                    result = new BookDTO(book_id, book_name, author, category,
                            publisher, publish_year, price, description, image_url);

                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }

}
