package ConnectDB;


import entities.Adult;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ConnectDB {
    
    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String dburl = "jdbc:sqlserver://localhost:1433; database = FlightManager;encrypt=true;trustServerCertificate=true";
    private static String userName = "sa";
    private static String password = "123456";


        

    

    public static Connection createConnection() throws SQLException {
        createConnection(driver, dburl, userName, password);
        Connection con = null;
        try {
            //tạo kết nối đến CSDL
            Class.forName(driver);
            con = DriverManager.getConnection(dburl, userName, password);
            System.out.println("Connect database thành công");
        } catch (ClassNotFoundException ex) {
            System.out.println("Connect database thất bại");
            ex.printStackTrace();
        }
        return con;
    }

    private static void insertAdult(Adult adult) {
       Connection con = null;
        try{
            // Bước 1: tạo kết nối đến CSDL
			con = createConnection(driver, dburl, userName, password);
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "INSERT INTO Passenger (passengerID, name, birthDay, address, phone, testDate, flightDate, job) "+
					" VALUES (?,?,?,?,?,?,?,?)";
			
			PreparedStatement pr = con.prepareStatement(sql);
			pr.setString(1, adult.getPassengerID());
			pr.setString(2, adult.getName());
			pr.setString(3, adult.getBirthDay());
                        pr.setString(4, adult.getAddress());
                        pr.setString(5, adult.getPhone());
                        pr.setString(6, adult.getTestDate());
                        pr.setString(7, adult.getFlightDate());
                        pr.setString(8, adult.getJob());
			
			// Bước 3: thực thi câu lệnh SQL
			pr.execute();
			
			// Bước 4:
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+" dòng bị thay đổi!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
        }

   

   
        
    }
   	

