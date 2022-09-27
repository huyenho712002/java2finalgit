package Validation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import entities.Passenger;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
@SuppressWarnings("serial")
public class CheckValidation extends Exception{
  public static String regexID = "^PS\\d";
  
  public static boolean isCheckValidationID(String passengerID){
      Passenger passenger = new Passenger() {};
      return passengerID != null && passengerID.matches(regexID);
      
      
  }
 public static boolean isCheckTestDate() throws ParseException{
     // Date
     Passenger passenger = new Passenger() {};
     LocalDate testdate = LocalDate.parse(passenger.getTestDate(),
     DateTimeFormatter.ISO_LOCAL_DATE);
     LocalDate now = java.time.LocalDate.now();
     
   
     try{
         if(now.isBefore(testdate)){
             System.out.println("Test Date of Covid must be less than current date!!!");
         } 
     }catch(Exception e){
         return true;
     }
     return true;
       
 
}
}