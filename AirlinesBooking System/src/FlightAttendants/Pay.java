package FlightAttendants;
import DatabaseAccess.DataAccess;
import DatabaseAccess.IDataAccess;
import Validation.Ivalidation;
import Validation.Validation;
import com.AirlinesLauncher.IStreams;
import com.AirlinesLauncher.Streams;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Pay{
    IDataAccess DA = new DataAccess();
    Ivalidation IV = new Validation();
    IStreams IS = new Streams();

    public void payForAFlight() {
        try{
            acceptCredentials();

        }catch (InputMismatchException e){
            System.out.println("Please enter the correct form of response");
        }catch (Exception e){
            e.printStackTrace();
        }
        payForAFlight();

    }
    public void acceptCredentials(){
        Scanner custumer_Scan = new Scanner(System.in);
        System.out.println("=============================");
        System.out.println(" H e l l o   c u s t o m e r ");
        System.out.println("=============================");
        System.out.println("What is your Full name ? ");
        String full_Name = custumer_Scan.nextLine().toLowerCase();
            System.out.println("What is your passport_Num  " + full_Name + " ?");
            String customur_PassportNum = custumer_Scan.nextLine();
            System.out.println("Where are you planning to go " + full_Name + " ?");
            String customur_Destination = custumer_Scan.nextLine().toLowerCase();
            System.out.println("What is your email " + full_Name + " ?");
            String email = custumer_Scan.nextLine();

            if(IV.Validate_Name(full_Name) && IV.Validate_Name(customur_Destination  ) && IV.Validate_Email(email)){
                FlightPreson FP = new FlightPreson();
                FP.FlightPreson(full_Name,customur_Destination,customur_PassportNum,email);
                if(IS.readAndWriteString(DA.matchCustumerDestination(customur_Destination)).contains("")){
                    System.out.println(IS.readAndWriteString(DA.matchCustumerDestination(customur_Destination)));
                    if(IS.readAndWriteBoolean(DA.updateSeats())){
                        IS.readAndWriteBoolean(DA.saveCustomor(FP));
                    }else{
                        System.out.println("Sorry but this plane is fully booked");
                    }
                    return;
                }else {
                    System.out.println("Destination not found");
                    return;
                }
            }else{
                System.out.println("Please Review your input again... It seems like there is a problem with it !!!");
            }


    }

}
