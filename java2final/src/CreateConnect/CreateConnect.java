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
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class CreateConnect {
private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String dburl = "jdbc:sqlserver://localhost:1433; database = FlighteManager;";
    private static String userName = "sa";
    private static String password = "123456";

    public static void main(String[] args) throws SQLException {
        System.out.println("SOUT");
        Connection connect=createConnection(driver, dburl, userName, password);
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
     public static void insertAdult(Adult adult) {
        Connection connection = null;
        try {
            connection = CreateConnect.createConnection(driver, dburl, userName, password);
            String sqlString = "Insert into Passenger(passengerId,name,birthDate,address,phone,testDate,flightDate,job)VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
            preparedStatement.setString(1, adult.getPassengerID());
            preparedStatement.setString(2, adult.getName());
            preparedStatement.setString(3, adult.getBirthDay());
            preparedStatement.setString(4, adult.getAddress());
            preparedStatement.setString(5, adult.getPhone());
            preparedStatement.setString(6, adult.getTestDate());
            preparedStatement.setString(7, adult.getFlightDate());
            preparedStatement.setString(8, adult.getJob());
            preparedStatement.executeUpdate();
            System.out.println("Insert thành công record vào table Passenger!!");
        } catch (SQLException ex) {
            System.out.println("Insert thất bại record vào table Passenger!!");
            ex.printStackTrace();
        }
    }
    public static void insertChildren(Children children) {
        Connection connection = null;
        try {
            connection = CreateConnect.createConnection(driver, dburl, userName, password);
            String sqlString = "Insert into Passenger(passengerId,name,birthDate,address,phone,testDate,flightDate,school,grade)"
                    + "VALUES(?,?,?,?,?,?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
            preparedStatement.setString(1, children.getPassengerID());
            preparedStatement.setString(2, children.getName());
            preparedStatement.setString(3, children.getBirthDay());
            preparedStatement.setString(4, children.getAddress());
            preparedStatement.setString(5, children.getPhone());
            preparedStatement.setString(6, children.getTestDate());
            preparedStatement.setString(7, children.getFlightDate());
            preparedStatement.setString(8, children.getSchool());
             preparedStatement.setString(9, children.getGrade());
            preparedStatement.executeUpdate();
            System.out.println("Insert thành công record vào table Passenger!!");
        } catch (SQLException ex) {
            System.out.println("Insert thất bại  vào table Passenger!!");
            ex.printStackTrace();
        }
    }
    public static void insertPregnant(Pregnant pregnant) {
        Connection connection = null;
        try {
            connection = CreateConnect.createConnection(driver, dburl, userName, password);
            String sqlString = "Insert into Passenger(passengerId,name,birthDate,address,phone,testDate,flightDate,gestationalAge,pretermBirth)"
                    + "VALUES(?,?,?,?,?,?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
            preparedStatement.setString(1, pregnant.getPassengerID());
            preparedStatement.setString(2, pregnant.getName());
            preparedStatement.setString(3, pregnant.getBirthDay());
            preparedStatement.setString(4, pregnant.getAddress());
            preparedStatement.setString(5, pregnant.getPhone());
            preparedStatement.setString(6, pregnant.getTestDate());
            preparedStatement.setString(7, pregnant.getFlightDate());
            preparedStatement.setString(8, pregnant.getGestationalAge());
            preparedStatement.setString(9, pregnant.getPretermBirth());
            preparedStatement.executeUpdate();
            System.out.println("Insert thành công record vào table Passenger!!");
        } catch (SQLException ex) {
            System.out.println("Insert thất bại record vào table Candidate!!");
            ex.printStackTrace();
        }
    }
   
   
}
