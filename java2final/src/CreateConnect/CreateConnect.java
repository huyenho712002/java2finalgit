/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CreateConnect;

import entities.Adult;
import entities.Children;
import entities.Pregnant;
import java.sql.Connection;
import java.sql.DriverManager;
import static java.sql.DriverManager.getConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class CreateConnect {
private static final String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String dburl = "jdbc:sqlserver://localhost:1433; databaseName = FightManager;encrypt=true;trustServerCertificate=true;";
    private static final String userName = "sa";
    private static final String password = "123456";

    public static void main(String[] args)  {
       
    try {
        Connection connect=null;
        connect=createConnection(driver, dburl, userName, password);
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
               
    }
    public static Connection createConnection(String driver, String dburl, String userName,
            String password) throws SQLException {
        
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(dburl, userName, password);
            System.out.println("Connect database thành công");
        } catch (ClassNotFoundException ex) {
            System.out.println("Connect database thất bại");
            ex.printStackTrace();
        }
        return con;
    }
     
}
