package DatabaseAccess;

import Administrators.FlightCordination;
import Administrators.RequestAdmin;
import FlightAttendants.FlightPreson;

public interface IDataAccess {
    void serverConnection();
   boolean DBconnection(); // Connects to our the database
   boolean saveAdminRequest(RequestAdmin R_A); // Creates (C)
   boolean savePlaneDestination(FlightCordination F_C); // Creates (C)
   boolean saveCustomor(FlightPreson F_P); // Creates (C)
   String Check_In(String passPort_Num); // Update (U)
   String display(); // Reads(R)
    boolean verifyAdmin(String SSN, String pW); // Reads(R)
    String matchCustumerDestination(String customur_Destination); // Reads(R)
    boolean updateSeats(); // Updates(U)
//    boolean updatePayedPerson(String passPort_Num); // Updates(U)
    boolean deleteFlight(int delete_ID); // Delete(D)
    boolean checkValidateion();
//    void getData();
}
