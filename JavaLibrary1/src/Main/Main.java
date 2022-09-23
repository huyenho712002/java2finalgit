package Main;
import java.util.Scanner;
import DataAccessObject.DAOinterface;
import entities.ListPassenger;
import entities.Passenger;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ADMIN
 */
public class Main {
    //tạo phươnng thưc, và menu thực hiện các chức năng
    public static void main(String[] args) {   
    int choose;
    Scanner sc = new Scanner(System.in);
    
    do{
            System.out.println("1. Gioi thieu thong tin khach hang");
            System.out.println("2. Cap nhat ngay khoi hanh");
            System.out.println("3. Xoa hanh khach chua test covid");
            System.out.println("Choose Menu");
            choose = Integer.parseInt(sc.nextLine());
            switch(choose){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
}while(choose != 3); 
    }
   //khai báo lớp
    ListPassenger listP = new ListPassenger();
    
   //hiện thị ds
  


    
    }  
}
