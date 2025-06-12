/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cuongnp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Cuong
 */
//dang dung o Database
public class DBHelper {//static de khoi phai new
    // JDBC API framwork hay thu vien tao 1 lan de ket noi truy van bat ki DBMS // vi sao?
    //viet code 1 lan va xai nhieu noi 
    //duoi .sql
    public static Connection makeConnection()
    throws ClassNotFoundException, SQLException{ // loi chi xaut hien trong 2 truong hop cau lenh sai hoac duong dan sai
        //Tinh 
        //1. Nen phai Load Driver de dong
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");//mo trong thu vien va go i chang
//ctrl space ko ra thi remove         
//La 1 container, vi truy cap cap vao 1 port 1433
        //2. Create connection String to connect DB
        //jdbc:sqlserver://ip:port;databaseName=...
        String url = "jdbc:sqlserver://"
                + "localhost:1433;"
                + "databaseName=dbo.PRJSE1819";
        //phai ghi chinh xac in hoa in thuong
        //dbms ko co chuan chung, nen phai chi chinh xac DbMS minh dang xai nao
        //3. Open connection using DriverManager
        Connection con = DriverManager.getConnection(url, "sa", "12345"); //co loi va goi SQLException
        // loi xuat hien khi 1)url sai bat ki thanh phan nao 2) TCP/IP disable 3)sai password
        return con;
    }
}
