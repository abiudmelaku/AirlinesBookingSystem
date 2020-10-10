package com.AirlinesLauncher;

import Administrators.Admin;
import DatabaseAccess.DataAccess;
import DatabaseAccess.IDataAccess;
import FlightAttendants.CheckIn;
import FlightAttendants.Pay;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.Controller;
import sample.Main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.InputMismatchException;
import java.util.Scanner;
public class SystemLaunch  implements Runnable{
    IDataAccess DA = new DataAccess();
    IStreams IS = new Streams();

    boolean threadrunning = false;
    public void  starter(){
        threadrunning = true;
        Thread thread1 = new Thread(this);
        thread1.start();
    }
    @Override
    public void run() {

        while(threadrunning){
            try {
                menu();
            }catch (IOException e){
                System.out.println("ERR : " + e);
            }catch (ClassNotFoundException e){
                System.out.println("ERR : " + e);
            }


        }
//        System.out.println("Thred Done!!!");

    }
    public   void menu() throws  IOException, ClassNotFoundException{
        try {

            System.out.println("\n");
            Scanner scan = new Scanner(System.in);
            menuChoice();
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    Admin admin = new Admin();
//                    admin.admin();
                    break;
                case 2:
                    System.out.println("_________________________________________Destinations_________________________________________");
                    System.out.println(IS.readAndWriteString(DA.display()));
                    System.out.println("_________________________________________     ,,     _________________________________________");
                        break;

                case 3:
                    Pay p = new Pay();
                    p.payForAFlight();
                    break;
                case 4:
                    CheckIn checkIn = new CheckIn();
                    checkIn.book();
                    break;
                case 5:

                    System.out.println("Good bye And See you Again soon !!!  =(");
                    threadrunning = false;
                    return;

                default:
                    System.out.println("Wrong input!!! Please enter a correct input ");
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Please enter the correct form of response");

        }

        menu();

    }
    public void menuChoice(){
        System.out.println("==============================================");
        System.out.println(" WELCOME TO ETHIOPIAN AIRLINES BOOKING SYSTEM ");
        System.out.println("==============================================");
        System.out.println("Press 1 if you are Admin");
        System.out.println("Press 2 to see flight Destinations");
        System.out.println("Press 3 to Pay for a flight ");
        System.out.println("Press 4 to book(Check-In) a flight ");
        System.out.println("Press 5 to Exit the System");

    }


}
