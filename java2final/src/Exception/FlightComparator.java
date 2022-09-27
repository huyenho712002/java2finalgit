/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;
import java.util.*;
import entities.Passenger;
import Main.readfile;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FlightComparator implements Comparator<Passenger> {
    
	public int compare(Passenger s1, Passenger s2) {
            LocalDate s3 = LocalDate.parse(s1.getTestDate(),
     DateTimeFormatter.ISO_LOCAL_DATE);
            LocalDate s4 = LocalDate.parse(s2.getTestDate(),
     DateTimeFormatter.ISO_LOCAL_DATE);
            
                if(s3.isBefore(s4) ){
                    return s3.compareTo(s4);
                }
            return 0;
        	
	
        }	
}


