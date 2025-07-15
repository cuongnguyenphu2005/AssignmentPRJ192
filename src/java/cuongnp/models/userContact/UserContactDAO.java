/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuongnp.models.userContact;

import cuongnp.util.DBHelper;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Cuong
 */
public class UserContactDAO implements Serializable {

    public boolean setContact(UserContactDTO dto)
            throws ClassNotFoundException, SQLException {
        //0. Declare
        boolean reusult = false;
        Connection con = null;
        PreparedStatement stm = null;

        try {
            //1. Connect DB
            con = DBHelper.makeConnection();
            //2. Create SQL script
            String sql = "INSERT INTO [dbo].[User_Contact] "
                    + "([username],[phone],[address]"
                    + "VALUES(?,?,?)";
            //2.1 Prepare statement
            stm = con.prepareStatement(sql);
            stm.setString(1, dto.getUsername());
            stm.setInt(2, dto.getPhone());
            stm.setString(3, dto.getAddress());
            //3. Excute
            int effRow = stm.executeUpdate();
            if (effRow > 0) {
                reusult = true;
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return reusult;
    }
    
    public int getContactId (){
        //0. Declare
        int result = -1;
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. Connect DB
            //2. Create SQL script
        } finally {
        }
        return result;
    }
}
