/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuongnp.registration;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cuongnp.util.DBHelper;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cuong
 */
// implement de truy cap Data
//dang dung o Model
//cac dieu phai luu y:
//cac doi tuong khai bao va khoi tao = null
// dong cac doi tuong lai = moi cach
// roi moi thuc hien xu ly
public class RegistrationDAO implements Serializable {

    private List<RegistrationDTO> accounts;

    public List<RegistrationDTO> getAccounts() {
        return accounts;
    }

    //cung cap cac method
//    public boolean checkLogin(String username, String password)
//            throws SQLException, ClassNotFoundException {
    public RegistrationDTO checkLogin(String username, String password)
            throws SQLException, ClassNotFoundException {
        //tuan thu luat thiet ke, 1 input , 1 output
//        boolean result = false;
        RegistrationDTO result = null;

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        //khai bao dau tien thi dong cuoi cung
        try {//se bi loi SQL. 

            //phai check connection khac null
            //kiem tra connection mo chua:
            //viet thu vien tao 1 lan xai nhieu lan, vi moi class khac deu xai
            //cac class heople
            // 1.model connect database
            con = DBHelper.makeConnection(); //Goi them loi do goi DBHelper

            //moi menh de cua SQL phai duoc viet tren 1 dong
            // phai chen them 1 khoang trang truoc khi xuong dong
            if (con != null) {
                // 2. model query DB;
                //2.1 tao cac cau lenh SQL Create 
                String sql = "Select lastname, isAdmin "
                        + "From Registration "
                        + "Where username = ? "
                        + "and password = ?"; //bi loi syntax from need
                // phai xuong database copy, neu ko sai thi objectnotfound

                //2.2 Create Statement Object la buoc de nap cau lenh voa ben trong Project (to khoi (to den ))
                stm = con.prepareStatement(sql); // doi tuong connection nen phai check null
                stm.setString(1, username);     //vi tri dau cham hoi 
                stm.setString(2, password);
                //co bao nhieu tham so (?) thi phai set het bay nhieu

                //2.3 Excute Query 
                //
                rs = stm.executeQuery();

                //3. Model gets date from ResultSet, then Model sets data to properties of Model
                //
                if (rs.next()) {//
//                    result = true;
                    String lastname = rs.getString("lastname");
                    boolean role = rs.getBoolean("isAdmin");
                    result = new RegistrationDTO(username, null, lastname, role);
                }
            }//connection is an available

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
        //
    }

    public void searchLastName(String searchValue) throws SQLException, ClassNotFoundException {

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            //1. Model connect DataBase
            con = DBHelper.makeConnection();
            if (con != null) {
                //2. Model Query DataBase
                //2.1. Create SQL String
                //khi viet cau lenh SQL thi moi cau lenh phai duoc viet treb 1 dong, moi
                //khi xuong dong phai chen them 1 khoang trang truoc khi xuong dong
                String sql = "Select username, password, lastname, isAdmin "
                        + "From Registration "
                        + "Where lastname Like ?";

                //2.2. Create Statement Object
                //co bao nhieu dua cham hoi la set het bay nhieu
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                //2.3. Excute Query
                rs = stm.executeQuery();

                //3. Model get data from...., then sets data to properties of Model
                while (rs.next()) {
                    String username = rs.getString("username");
                    String password = rs.getString("password");
                    String lastname = rs.getString("lastname");
                    boolean role = rs.getBoolean("isAdmin");

                    RegistrationDTO dto = new RegistrationDTO(username, password, lastname, role);
                    //set
                    if (this.accounts == null) {
                        this.accounts = new ArrayList<>();
                    }//end account are not exits
                    this.accounts.add(dto);

                }//traverse each row in table
            }//connection is an available
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

    public boolean deleteAccount(String username)
            throws SQLException, ClassNotFoundException {
        //tuan thu luat thiet ke, 1 input , 1 output
        boolean result = false;

        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        //khai bao dau tien thi dong cuoi cung
        try {//se bi loi SQL. 

            //phai check connection khac null
            //kiem tra connection mo chua:
            //viet thu vien tao 1 lan xai nhieu lan, vi moi class khac deu xai
            //cac class heople
            // 1.model connect database
            con = DBHelper.makeConnection(); //Goi them loi do goi DBHelper

            //moi menh de cua SQL phai duoc viet tren 1 dong
            // phai chen them 1 khoang trang truoc khi xuong dong
            if (con != null) {
                // 2. model query DB;
                //2.1 tao cac cau lenh SQL Create 
                String sql = "DELETE FROM Registration "
                        + "WHERE username = ? "; //bi loi syntax from need
                // phai xuong database copy, neu ko sai thi objectnotfound

                //2.2 Create Statement Object la buoc de nap cau lenh voa ben trong Project (to khoi (to den ))
                stm = con.prepareStatement(sql); // doi tuong connection nen phai check null
                stm.setString(1, username);
                //co bao nhieu tham so (?) thi phai set het bay nhieu

                //2.3 Excute Query 
                int effectRow = stm.executeUpdate();

                //3. Check effectRow
                //then model sets data to properties of Model
                if (effectRow > 0) {
                    result = true;
                } //ket qua tra ve ko bao gio la am, 0 thi khong hop le

            }//connection is an available

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
        return result; //tra ve kieu int, so dong hieu luc 
    }
}
    
