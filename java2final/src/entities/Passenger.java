package entities;

import static java.nio.file.Files.list;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;

public abstract class  Passenger  {
 private String passengerID;
    private String name;
    private String birthDay;
    private String address;
    private String phone;
    private String testDate;
    private String flightDate;
    private List<Passenger> listPassenger;

    public List<Passenger> getListPassenger() {
        return listPassenger;
    }

    public void setListPassenger(List<Passenger> listPassenger) {
        this.listPassenger = listPassenger;
    }

    public String getPassengerID() {
        return passengerID;
    }

    public String getName() {
        return name;
    }

  

    public String getBirthDay() {
        return birthDay;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getTestDate() {
        return testDate;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public void setPassengerID(String passengerID) {
        this.passengerID = passengerID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setTestDate(String testDate) {
        this.testDate = testDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }
    
    
    public Passenger(String passengerID, String name, String birthDay, String address, String phone, String testDate, String flightDate) {
        this.passengerID = passengerID;
        this.name = name;
        this.birthDay = birthDay;
        this.address = address;
        this.phone = phone;
        this.testDate = testDate;
        this.flightDate = flightDate;
    }

    public Passenger() {
    }
    
   public void ShowInfo(){
       System.out.println("Passenger ID: "+ this.passengerID+";"+"Name: "+ this.name
       +";"+"BirthDay :"+ this.birthDay+";"+"Address: "+ this.address+";"+ "Phone: "+this.phone+";"+
               "Test Date: "+ this.testDate+";"+"FlightDate: "+ this.flightDate);
   }
}
