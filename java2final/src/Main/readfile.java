package Main;

import java.io.BufferedReader;
import java.io.FileReader;
import entities.Children;
import entities.Adult;
import entities.Passenger;
import entities.Pregnant;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import CreateConnect.CreateConnect;
import static Main.readfile.readFile;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.Vector;
import CreateConnect.CreateConnect;
/**
 *
 * @author ADMIN
 */
public class readfile {
    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String dburl = "jdbc:sqlserver://localhost:1433;databaseName = FightManager;encrypt=true;trustServerCertificate=true;";
    private static String userName = "sa";
    private static String password = "123456";
     
    public static void main(String[] args) throws FileNotFoundException {
           List<Passenger> listPass = new ArrayList<Passenger>();
           listPass = readFile();
          
        for(Passenger list :listPass){
            if( list instanceof Adult){
                insertAdult((Adult)list);
                 
                ((Adult)list).ShowInfo();
            }
            if(list instanceof Children){
                insertChildren(((Children)list));
                ((Children)list).ShowInfo();
            }
            if(list instanceof Pregnant){
                insertPregnant(((Pregnant)list));
               ((Pregnant)list).ShowInfo();
            }
            
        }
     
        
    }
   

    public static  List<Passenger> readFile() throws FileNotFoundException{
        List<Passenger> listPassenger = new ArrayList<Passenger>();
        String path = "D:\\New folder2\\Java2-final\\File\\PassengerFile.txt";
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while ((line = br.readLine()) != null) {
                String[] passengerArrray = line.split(",");
                Passenger passenger = new Passenger() {};
                //Check this passenger is Adult
                if (passengerArrray[0].equals("1")) {
          
                   passenger = new Adult();
                    ((Adult) passenger).setJob(passengerArrray[8]);         
                }
                
                //Check this passenger is Children
                if (passengerArrray[0].equals("2")) {
                  passenger = new Children();
                    ((Children) passenger).setSchool(passengerArrray[9]);
                    ((Children) passenger).setGrade(passengerArrray[10]);
       
                }
                //Check this passenger is Pregnant
                if (passengerArrray[0].equals("3")) {
                   passenger = new Pregnant();
                    ((Pregnant) passenger).setGestationalAge(passengerArrray[11]);
                    ((Pregnant) passenger).setPretermBirth(passengerArrray[12]);
                }
                
                passenger.setPassengerID(passengerArrray[1]);
                passenger.setName(passengerArrray[2]);
                passenger.setBirthDay(passengerArrray[3]);
                passenger.setAddress(passengerArrray[4]);
                passenger.setPhone(passengerArrray[5]);
                passenger.setTestDate(passengerArrray[6]);
                passenger.setFlightDate(passengerArrray[7]);
                listPassenger.add(passenger);
                
               
             
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            
        }
        return listPassenger;
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
            if(pregnant.getPretermBirth().equals("Yes")){
                 preparedStatement.setString(9,"1");
            }else {
                 preparedStatement.setString(9,"0");
            }
           
            preparedStatement.executeUpdate();
            System.out.println("Insert thành công record vào table Passenger!!");
        } catch (SQLException ex) {
            System.out.println("Insert thất bại record vào table Candidate!!");
            ex.printStackTrace();
        }
    }
   
//    private static Connection createConnection(String driver, String dburl, String userName, String password) {
//        createConnection(driver, dburl, userName, password);
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
           






