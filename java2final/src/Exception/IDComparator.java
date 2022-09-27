/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exception;

import entities.Passenger;
import java.util.Comparator;
import Main.readfile;

/**
 *
 * @author ADMIN
 */
public class IDComparator implements Comparator<Passenger>{
    public int compare(Passenger o1, Passenger o2) {
               return o2.getPassengerID().compareTo(o1.getPassengerID());
               //To change body of generated methods, choose Tools | Templates.
            }

}
