package Administrators;

import DatabaseAccess.DataAccess;
import DatabaseAccess.IDataAccess;
import Validation.Ivalidation;
import Validation.Validation;
import com.AirlinesLauncher.IStreams;
import com.AirlinesLauncher.Streams;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import sample.Main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin {
    public IDataAccess DA = new DataAccess();
    public Ivalidation IV = new Validation();
    IStreams IS = new Streams();

    public boolean admin(String userName, String passWord) throws IOException {
//        try {
//            System.out.println("\n");
//            Scanner scan_1 = new Scanner(System.in);
//            adminChoice();
//            int admin_Choice = scan_1.nextInt();
//            switch (admin_Choice) {
//                case 1:
//                    Scanner scan_2 = new Scanner(System.in);
//                    System.out.print("ID : ");
//                    String SSN = scan_2.nextLine();
//                    System.out.print("Password : ");
//                    String pW = scan_2.nextLine();

            if (IS.readAndWriteBoolean(DA.verifyAdmin(userName, passWord))) {

                return true;


                /**
                 *                          C h a n g e T h e  s c e n e
                 *                          C h a n g e T h e  s c e n e
                 *                          C h a n g e T h e  s c e n e
                 *
                 * **/
//                        Planes AirPlane = new Planes();
//                        AirPlane.AirPlane();
//                        break;
            }
//            else {
//                System.out.println("Sorry wrong ID or Password Please try again");
//
//            }
//                case 2:
//                    Scanner scan_3 = new Scanner(System.in);
//                    System.out.print(" What is your ID ?  : ");
//                    String new_SSN = scan_3.nextLine();
//                    System.out.println();
//                    System.out.println("What password would you  like to use if Your request is admitted ? ");
//                    String p_W = scan_3.nextLine();
//                    System.out.print(" What is your email address: ");
//                    String email = scan_3.nextLine();
//                    RequestAdmin RA = new RequestAdmin(new_SSN, p_W, email);
//
//                    if (IV.Validate_Email(email)) {
//                        IS.readAndWriteBoolean(DA.saveAdminRequest(RA));
//                        System.out.println("You have successfully sent your Request !! Admition  or denial will be sent via email in a few days");
//                    } else {
//                        System.out.println("Wrong email Input Please  enter a valid email address");
//                    }
//                    break;
//                case 3:
//                    return false;
//                default:
//                    System.out.println("Wrong input!!! Please enter a correct input ");
//            }
//        } catch (InputMismatchException e) {
//            System.out.println("Please enter the correct form of response");
//
//        } catch (NumberFormatException e) {
//            System.out.println("Please enter a number");
//
//        }

//        admin();
            return false;
//        }
//        public void adminChoice () {
//            System.out.println("=================================================");
//            System.out.println(" H e l l o   F l i g h t   C o o r d i n a t o r ");
//            System.out.println("=================================================");
//            System.out.println("Press 1 to login");
//            System.out.println("Press 2 to request for  admin");
//            System.out.println("Press 3 to exit the admin page");
//        }


    }
}
