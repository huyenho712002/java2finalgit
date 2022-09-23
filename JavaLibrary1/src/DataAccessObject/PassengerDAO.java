/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entities.Passenger;
import ConnectDB.ConnectDB;
import entities.Adult;

public class PassengerDAO {

    public PassengerDAO(Adult adult) {
       
        try{
            // Bước 1: tạo kết nối đến CSDL
			Connection con = ConnectDB.createConnection();
			
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
			 pr.executeUpdate();
			
			// Bước 4:
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có dòng bị thay đổi!");
			
			// Bước 5:
//			C.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
        }
    

 
    public int update(Passenger t) {
    int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = ConnectDB.createConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "UPDATE Passenger "+
					 " SET " +
					 ", name=?"+
					 " WHERE passengerID=?";
			
			PreparedStatement pr = con.prepareStatement(sql);
			pr.setString(1, t.getPassengerID());
			pr.setString(2, t.getName());
			pr.setString(3, t.getBirthDay());
                        pr.setString(4, t.getAddress());
                        pr.setString(5, t.getPhone());
                        pr.setString(6, t.getTestDate());
                        pr.setString(7, t.getFlightDate());
			// Bước 3: thực thi câu lệnh SQL

			System.out.println(sql);
			ketQua = pr.executeUpdate();
			
			// Bước 4:
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			// Bước 5:
//			ConnectDB.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

   
    public int delete(Passenger t) {
     int ketQua = 0;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = ConnectDB.createConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "DELETE from Passenger "+
					 " WHERE passengerID=?";
			
			PreparedStatement pr = con.prepareStatement(sql);
			pr.setString(1, t.getPassengerID());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ketQua = pr.executeUpdate();
			
			// Bước 4:
			System.out.println("Bạn đã thực thi: "+ sql);
			System.out.println("Có "+ ketQua+" dòng bị thay đổi!");
			
			// Bước 5:
//			ConnectDB.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ketQua;
	}

    
    public ArrayList<Passenger> selectAll() {
    ArrayList<Passenger> ketQua = new ArrayList<Passenger>();
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = ConnectDB.createConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM Passenger";
			PreparedStatement pr = con.prepareStatement(sql);
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = pr.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String passengerID = rs.getString("passengerID");
				String name = rs.getString("name");
				String birthDay = rs.getString("birthDay");
                                String address = rs.getString("address");
                                String phone = rs.getString("phone");
                                String testDate = rs.getString("testDate");
                                String flightDate = rs.getString("flightDate");
				
				Passenger passenger = new Passenger(passengerID, name, birthDay, address, phone, testDate, flightDate);
				ketQua.add(passenger);
			}
			
			// Bước 5:
//			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

 
    public Passenger selectById(Passenger t) {
    Passenger ketQua = null;
		try {
			// Bước 1: tạo kết nối đến CSDL
			Connection con = ConnectDB.createConnection();
			
			// Bước 2: tạo ra đối tượng statement
			String sql = "SELECT * FROM Passenger where passengerID=?";
			PreparedStatement pr = con.prepareStatement(sql);
			pr.setString(1, t.getPassengerID());
			
			// Bước 3: thực thi câu lệnh SQL
			System.out.println(sql);
			ResultSet rs = pr.executeQuery();
			
			// Bước 4:
			while(rs.next()) {
				String passengerID = rs.getString("passengerID");
				String name = rs.getString("name");
				String birthDay = rs.getString("birthDay");
                                String address = rs.getString("address");
                                String phone = rs.getString("phone");
                                String testDate = rs.getString("testDate");
                                String flightDate = rs.getString("flightDate");
				
				ketQua = new Passenger(passengerID, name, birthDay, address, phone, testDate, flightDate);
				
			}
			
			// Bước 5:
//			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketQua;
	}

    public ArrayList<Passenger> selectByCondition(String condition) {
       ArrayList<Passenger> ketQua = new ArrayList<Passenger>();
	
		return ketQua;
	}
}
