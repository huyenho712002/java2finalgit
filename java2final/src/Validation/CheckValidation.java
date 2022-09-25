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
@SuppressWarnings("serial")
public class CheckValidation extends Exception{
  public static String regexID = "^PS\\d";
  public static boolean isCheckValidationID(String passengerID){
      return passengerID != null && passengerID.matches(regexID);
  }
 public static boolean isCheckTestDate() throws ParseException{
     // Date
     Passenger passenger = new Passenger();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String dateInString = passenger.getTestDate();
        try {
            Date date = formatter.parse(dateInString);
            System.out.println(date);
            Date now = formatter.parse("25/09/2022");
            if(date >= now){
                
           // System.out.println(formatter.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }

	}
 } 
}
