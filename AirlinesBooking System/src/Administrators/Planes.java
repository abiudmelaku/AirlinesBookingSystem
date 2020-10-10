package Administrators;

import DatabaseAccess.DataAccess;
import DatabaseAccess.IDataAccess;
import Validation.Ivalidation;
import Validation.Validation;
import com.AirlinesLauncher.IStreams;
import com.AirlinesLauncher.Streams;
import sample.Main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Planes {

    Date date = null;
    public IDataAccess DA = new DataAccess();
    public Ivalidation IV = new Validation();
    IStreams IS = new Streams();
    public void AirPlane() {
        try {
            Scanner logedin_Admin = new Scanner(System.in);
            System.out.println("Press 1 to add a flight");
            System.out.println("Press 2 to cancel a flight");
            System.out.println("Press 3 to logout");
            int logedin_Admin_choice = logedin_Admin.nextInt();
            switch (logedin_Admin_choice) {
                case 1:
                    Scanner plane_Scan = new Scanner(System.in);
                    System.out.println("What is the Airlines Name ? ");
                    String plane_Name = plane_Scan.nextLine().toLowerCase();
                    System.out.println("Where is it's destination ? ");
                    String destination = plane_Scan.nextLine().toLowerCase();
                    System.out.println("When is the planes Departure date ? ");
                    String departure_Date = plane_Scan.nextLine();
                    System.out.println("When is the Planes Departure Time ? ");
                    String departure_Time = plane_Scan.nextLine();
                    System.out.println("What is the plans number of seats ? ");
                    int plane_Size = Integer.parseInt(plane_Scan.nextLine());
                    System.out.println("How much should a flight attendant pay to recieve a flight ?  ");
                    Double payment_amount = plane_Scan.nextDouble();
                    FlightCordination FC = new FlightCordination();
                    if(IV.Validate_Name(plane_Name) && IV.Validate_Name(destination) &&
                            IV.Validate_Date(departure_Date) && IV.Validate_Time(departure_Time)){
                        FC.FlightCordination(plane_Name, destination, departure_Date,departure_Time, payment_amount, plane_Size);
                        IS.readAndWriteBoolean(DA.savePlaneDestination(FC));
                        System.out.println("<<<<<<<<<<<<<<<<<< Plane Insertion Successfully Finished >>>>>>>>>>>>>>>>>>>>>>>");
                    }else {
                        System.out.println("Please Check your Input again seems like there is a wrong input that you have inserted");
                    }
                    break;
                case 2:
                    System.out.println(IS.readAndWriteString(DA.display())  );
                    if(IS.readAndWriteBoolean(DA.checkValidateion())){
                        Scanner delete_Scan = new Scanner(System.in);
                        System.out.println("\nEnter an ID if there is a plane. Or press any number ....? ");
                        int delete_ID = delete_Scan.nextInt();

                        if(IS.readAndWriteBoolean(DA.deleteFlight(delete_ID))){
                            System.out.println("Flight Deleted");
                        }else {
                            System.out.println("There is no flight with the specified id");
                        }
                        break;

                    }else {
                        break;
                    }

                case 3:
                    return;
                default:
                    System.out.println("Wrong input!!! Please enter the right input");

            }
        }  catch (InputMismatchException e) {
            System.out.println("Please enter the correct form of response");

        }catch (NumberFormatException e) {
            System.out.println("Wrong form of input!!! Please enter a number");
        }
        AirPlane();

    }


}
