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

import java.util.Vector;
import CreateConnect.CreateConnect;
import static java.nio.file.Files.list;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collections;
import static java.util.Collections.list;
import java.util.Iterator;
import java.util.Scanner;
import Exception.FlightComparator;
import Exception.IDComparator;
import java.util.Comparator;
/**
 *
 * @author ADMIN
 */
public class readfile {
    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String dburl = "jdbc:sqlserver://localhost:1433;databaseName = FightManager;encrypt=true;trustServerCertificate=true;";
    private static String userName = "sa";
    private static String password = "123456";
    private static  List<Passenger> listPassenger = new ArrayList<Passenger>();
    private static readfile readfile1 = new readfile();
    private static Passenger passenger = new Passenger() {};
    private static Adult adult = new Adult();
    private static Children children = new Children();
    private static Pregnant pregnant = new Pregnant();
     
    public static void main(String[] args) throws FileNotFoundException {
        int choose;
    Scanner sc = new Scanner(System.in);
    

    do{
            System.out.println("1. Gioi thieu thong tin khach hang");
            System.out.println("2. Cap nhat ngay khoi hanh");
            System.out.println("3. Xoa hanh khach chua test covid");
            System.out.println("Choose Menu");
            choose = Integer.parseInt(sc.nextLine());
            switch(choose){
                case 1:  readfile1.showInformation((null));
                    break;
                case 2:  readfile1.updateAdult(adult); readfile1.updateChildren(children); readfile1.updatePregnant(pregnant);
                    break;
                case 3: readfile1.deleteAdult(adult);
                        readfile1.deleteChildren(children);readfile1.deletePregnant(pregnant);
                    break; 
            }
}while(choose != 3 && choose != 2 && choose != 1 );
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
    private void showInformation(ArrayList<Passenger>listpasse) throws FileNotFoundException{
        
        
           listpasse = (ArrayList<Passenger>) readFile();
          
        for(Passenger passenger :listpasse){
            if( passenger instanceof Adult){
             
                 
                ((Adult)passenger).ShowInfo();
            }
            if(passenger instanceof Children){

                ((Children)passenger).ShowInfo();
            }
            if(passenger instanceof Pregnant){

               ((Pregnant)passenger).ShowInfo();
            }
  
    }
    }

    public static  List<Passenger> readFile() throws FileNotFoundException{
       
        String path = "D:\\New folder2\\Java2-final\\File\\PassengerFile.txt";
        String line;
        System.out.println("Read Data from file");
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
         
         System.out.println("Sorting by ID...");
                 Collections.sort(listPassenger, new IDComparator());
		for (Passenger st : listPassenger) {
//			System.out.println(st.listPassenger);
                    st.ShowInfo();

		}
                   
                
		System.out.println("sorting by flightdate...");
                Collections.sort(listPassenger, new FlightComparator());
		for (Passenger st : listPassenger) {
			
//                        System.out.println(st.listPassenger);
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
            Passenger passenger = new Passenger() {};
            String id = passenger.getPassengerID();      
            String sqlquery = "select * from Passenger where passengerid ="+id;
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sqlquery);
            if(rs == null){
                String sqlString1 = "Insert into Passenger(passengerId,name,birthDate,address,phone,testDate,flightDate,job)VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement1 = connection.prepareStatement(sqlString1);
            }else{
                System.out.println(passenger.getPassengerID());
            }
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
    
  public static void updateAdult(Adult adult) {
        Connection connection = null;
        try {
            connection = CreateConnect.createConnection(driver, dburl, userName, password);
            String sqlString = "Update into Passenger set flightDate VALUES(?) where passengerid =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
            preparedStatement.setString(1, adult.getFlightDate()); 
            preparedStatement.setString(2, adult.getPassengerID());  
//            preparedStatement.executeQuery();
            System.out.println("Update thành công record vào table Passenger!!");
        } catch (SQLException ex) {
            System.out.println("Update thất bại record vào table Passenger!!");
            ex.printStackTrace();
        }
        
    }
  public static void updateChildren(Children children) {
        Connection connection = null;
        try {
            connection = CreateConnect.createConnection(driver, dburl, userName, password);
            String sqlString = "Update into Passenger set flightDate VALUES(?) where passengerid =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
            preparedStatement.setString(1, children.getFlightDate()); 
            preparedStatement.setString(2, children.getPassengerID());
            preparedStatement.executeUpdate(sqlString);
            System.out.println("update thành công record vào table Passenger!!");
        } catch (SQLException ex) {
            System.out.println("update thất bại  vào table Passenger!!");
            ex.printStackTrace();
        }
    }
  public static void updatePregnant(Pregnant pregnant) {
        Connection connection = null;
        try {
            connection = CreateConnect.createConnection(driver, dburl, userName, password);
            String sqlString = "Update into Passenger set flightDate VALUES(?) where passengerid =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
            preparedStatement.setString(1, pregnant.getFlightDate()); 
            preparedStatement.setString(2, pregnant.getPassengerID());
            preparedStatement.executeUpdate(sqlString);
            System.out.println("update thành công record vào table Passenger!!");
        } catch (SQLException ex) {
            System.out.println("update thất bại  vào table Passenger!!");
            ex.printStackTrace();
        }
  }
  public static void deleteAdult(Adult adult){
      
        Connection connection = null;
        try {
            connection = CreateConnect.createConnection(driver, dburl, userName, password);
            if(adult.getTestDate()==null){
                String sqlString = "Delete from Passenger where passengerid =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
            preparedStatement.setString(1, adult.getPassengerID());
            preparedStatement.executeUpdate(sqlString);
            }
            System.out.println("update thành công record vào table Passenger!!");
        } catch (SQLException ex) {
            System.out.println("update thất bại  vào table Passenger!!");
            ex.printStackTrace();
        }

}
   public static void deleteChildren(Children children){
         Connection connection = null;
        try {
            connection = CreateConnect.createConnection(driver, dburl, userName, password);
            if(children.getTestDate()==null){
                String sqlString = "Delete from Passenger where passengerid =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
            preparedStatement.setString(1, children.getPassengerID());
            preparedStatement.executeUpdate(sqlString);
            }
            System.out.println("Delete thành công record vào table Passenger!!");
        } catch (SQLException ex) {
            System.out.println("Delete thất bại  vào table Passenger!!");
            ex.printStackTrace();
        }

}
    public static void deletePregnant(Pregnant pregnant){
      
        Connection connection = null;
        try {
            connection = CreateConnect.createConnection(driver, dburl, userName, password);
            if(pregnant.getTestDate()==null){
                String sqlString = "Delete from Passenger where passengerid =?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
            preparedStatement.setString(1, pregnant.getPassengerID());
            preparedStatement.executeUpdate(sqlString);
            }
            System.out.println("Delete thành công record vào table Passenger!!");
        } catch (SQLException ex) {
            System.out.println("Delete thất bại  vào table Passenger!!");
            ex.printStackTrace();
        }

}
   
  }

           






