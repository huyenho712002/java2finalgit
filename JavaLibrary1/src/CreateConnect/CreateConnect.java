/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CreateConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class CreateConnect {
private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String dburl = "jdbc:sqlserver://localhost:1433; database = FlighteManager;"
            + "trustServerCertificate=true";
    private static String userName = "sa";
    private static String password = "123456";

    public static void main(String[] args) throws SQLException {
        System.out.println("SOUT");
        Connection connect=createConnection(driver, dburl, userName, password);
    }

    public static Connection createConnection(String driver, String dbURL, String userName,
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
