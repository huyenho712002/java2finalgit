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
import ConnectDB.ConnectDB;
/**
 *
 * @author ADMIN
 */
public class readfile {
    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String dburl = "jdbc:sqlserver://localhost:1433; database = FlightManager;encrypt=true;trustServerCertificate=true";
    private static String userName = "sa";
    private static String password = "123456";
     
    public static void main(String[] args) {
           List<Passenger> listPassenger = new ArrayList<>();
           listPassenger = readFile();
        for(Passenger listpassenger :listPassenger){
            if( listPassenger instanceof Adult){
                ((Adult)listPassenger).ShowInfo();
            }
            if(listPassenger instanceof Children){
                ((Children)listPassenger).ShowInfo();
            }
            if(listPassenger instanceof Pregnant){
                ((Pregnant)listPassenger).ShowInfo();
            }
            
        }
    }
    /**
     *
     */
    public void readFile(){
            try {
      //Tạo một FileReader
      FileReader file = new FileReader("D:\\New folder2\\Java2-final\\File\\PassengerFile.txt");
      //Tạo một BufferedReader
      BufferedReader bw = new BufferedReader(file);
      //Đọc các ký tự và lưu vào array
      String line;
      while((line = bw.readLine())!= null){
          String[] passengerArray = line.split(",", 13);
          Passenger passenger = null;
          //check this passenger is Adult
          
          if(passengerArray[0].equals("1")){
              passenger = new Adult();
              insertAdult((Adult) passenger);
              ((Adult) passenger).setJob((passengerArray[8]));
              
          }
          //check this passenger is children
          if(passengerArray[7].equals("2")){
              passenger = new Children();
              ((Children)passenger).setSchool(passengerArray[9]);
              ((Children)passenger).setGrade(passengerArray[10]);
          }
          //check this passenger is pregnant
          if(passengerArray[7].equals("3")){
              passenger = new Pregnant();
              ((Pregnant)passenger).setGestationalAge(passengerArray[11]);
              ((Pregnant)passenger).setPretermBirth(passengerArray[12]);
              
          }
  
          
          System.out.println(line);
      }
  
    }
    catch(Exception e) {
      System.err.println(e.getStackTrace());
    }   
      
    }
}   

     
    
           






