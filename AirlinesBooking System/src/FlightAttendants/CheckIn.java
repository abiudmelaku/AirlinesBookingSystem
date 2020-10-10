package FlightAttendants;
import DatabaseAccess.DataAccess;
import DatabaseAccess.IDataAccess;
import com.AirlinesLauncher.IStreams;
import com.AirlinesLauncher.Streams;

import java.util.Scanner;
public class CheckIn {
    IDataAccess DA = new DataAccess();
    IStreams IS = new Streams();

    public void book(){
        Scanner book_scan = new Scanner(System.in);
        System.out.println("What is your Passport Number");
        String passPort_Num = book_scan.nextLine();
        if(IS.readAndWriteString(DA.Check_In(passPort_Num)).equals("")){
            System.out.println("There is no person with this passport");

        }else{
            System.out.println(IS.readAndWriteString(DA.Check_In(passPort_Num)));
        }

    }
}
