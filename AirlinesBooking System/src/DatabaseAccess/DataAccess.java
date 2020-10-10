package DatabaseAccess;

import Administrators.FlightCordination;
import Administrators.RequestAdmin;
import FlightAttendants.FlightPreson;
import java.io.*;
import java.lang.reflect.Array;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class DataAccess implements IDataAccess , Serializable {
    HashMap<String,String> keyValue = new HashMap();
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement pstmt;
    private String destination_Match = "";


//    private boolean booked = false;
    boolean checkFlight = false;
    String deletingFlight = null;
    String usingPlane = null;

    @Override
    public void serverConnection() {

    }

    @Override
    public boolean DBconnection() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlines booking system","root","");
            st = con.createStatement();
            return true;


        }catch (Exception ex){
            System.out.println("Error: " + ex);
        }
        return false;
    }

    @Override
    public boolean saveAdminRequest(RequestAdmin R_A) {
        try {
            boolean idExists = false;
            DBconnection();
            String query1 = "SELECT * FROM adminaccessrequest WHERE workId = '" + R_A.getSSN() + "'";
            rs = st.executeQuery(query1);
            if(rs.next()){
                idExists = true;

            }
            if(!idExists){
                String query2 = "INSERT INTO adminaccessrequest(id,workId,password,email) VALUES(?,?,?,?)";
                pstmt = con.prepareStatement(query2);
                pstmt.setInt(1,0);
                pstmt.setString(2,R_A.getSSN());
                pstmt.setString(3,R_A.getPassWord());
                pstmt.setString(4,R_A.getEmail());
                pstmt.executeUpdate();
                /**
                 *
                 * ******************************************************
                 *****************************************************
                 * **/
                con.close();
                return true;

//                System.out.println("Inserted");

            }

        } catch (SQLException e) {
            System.out.println("Err : " + e);
        }catch (Exception e){
            System.out.println("Err : " + e);
        }

        return false;

    }

    @Override
    public boolean savePlaneDestination(FlightCordination F_C) {
        DBconnection();
        try {
            String query = "INSERT INTO planedestinations VALUES(?,?,?,?,?,?,?)";
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1,0);
            pstmt.setString(2,F_C.getPlane_Name());
            pstmt.setString(3,F_C.getDestination());
            pstmt.setString(4,F_C.getDeparture_Date());
            pstmt.setString(5,F_C.getDeparture_Time());
            pstmt.setInt(6,F_C.getPlane_Size());
            pstmt.setDouble(7,F_C.getPayment_amount());
            pstmt.executeUpdate();
            /**
             *
             *  *****************************************
             *   ****************************************
             *  **/
//            System.out.println("Inserted");
            con.close();
            return true;

        }
        catch (SQLException e){
            System.out.println("Err: " + e);
        }
        return false;


    }

    @Override
    public boolean saveCustomor(FlightPreson F_P) {
//        int counter = 0;
        boolean passportAlreadyExists = false;

        try {
            DBconnection();
            String query1 = "SELECT * FROM payedperson WHERE passportNumber = '" + F_P.getPassport_Num() + "'";   ;
//            pstmt = con.prepareStatement(query1);
//            pstmt.setString(1,F_P.getPassport_Num());
            rs = st.executeQuery(query1);
            if(rs.next()){
                passportAlreadyExists = true;
            }
            if(!passportAlreadyExists){
                String query2 = "INSERT INTO payedperson(id,name,destination,passportNumber,email,usingPlane,checkedIn) VALUES(?,?,?,?,?,?,?)";
                pstmt = con.prepareStatement(query2);
                pstmt.setInt(1,0);
                pstmt.setString(2,F_P.getFull_name());
                pstmt.setString(3,F_P.getDestination());
                pstmt.setString(4,F_P.getPassport_Num());
                pstmt.setString(5,F_P.getEmail());
                pstmt.setString(6,usingPlane);
                pstmt.setString(7,"false");
                pstmt.executeUpdate();
                con.close();
                return true;
                /**
                 *  ***********************************************
                 *   **************************************
                 *
                 * **/
//                System.out.println("Inserted");
            }
            con.close();



        } catch (SQLException e) {
            System.out.println("ERR : " + e);
        }
        return false;
    }

    @Override
    public String Check_In (String passPort_Num) {
        DBconnection();
        String CheckIn = "";

        boolean booked = false;
        try {

            String query1 = "SELECT * FROM payedperson WHERE passportNumber= '" + passPort_Num + "'";
            rs = st.executeQuery(query1);
            if(rs.next()){
                booked = true;
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String destination = rs.getString("destination");
                String passportNumber = rs.getString("passportNumber");
                CheckIn =  "" + id + "," + name + "," + destination + "," + passportNumber ;
            }
            if(booked){
                String query2 =  "update payedperson set checkedIn = 'true' where passportNumber = '" + passPort_Num + "'";
                st.executeUpdate(query2);
                con.close();
                /**
                 *  *****************************************
                 *   ****************************************
                 *
                 * **/
//                System.out.println("Updated");
            }
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return CheckIn;


    }

    @Override
    public String display() {
        String destination_Table = " ID \t\t\t Plane Name \t\t\t\t\t Destination \t\t\t\t  Departure Date  \t\t\t\t  Departure Time ";
        boolean noFlights = false;
        DBconnection();
        /**
         *  ***********************************
         *  *******************************
         *
         * **/

        try {
            String query = "SELECT * FROM planedestinations";
            rs = st.executeQuery(query);

            while(rs.next()){
                int id = rs.getInt("id");
                String airlinesName = rs.getString("airlinesName");
                String destination = rs.getString("destination");
                String departureDate = rs.getString("departureDate");
                String departureTime = rs.getString("departureTime");
                destination_Table += "\n" + id + ",\t" + airlinesName + ",\t" + destination + ",\t" + departureDate + ",\t" + departureTime;
            }

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }



        return destination_Table;

    }

    @Override
    public boolean verifyAdmin(String SSN, String pW) {
        boolean adminExists = true;
        DBconnection();
        try {
            String query = "SELECT * FROM admin WHERE username = '" + SSN + "' AND  password = '" + pW + "'" ;
            rs = st.executeQuery(query);
            if(rs.next()){
                con.close();
                return  true;
            }
//            if(!rs.next()){
//                adminExists = false;
//            }
//            if(!adminExists){
//                con.close();
//                return false;
//
//            }
//            while(rs.next()){
//                String password = rs.getString("password");
//                if(password.equals(pW)){
//                    con.close();
//                    return true;
//                }
//            }
            con.close();


        } catch (SQLException e) {
            System.err.println("ERR : " + e);
        }

        return false;
//        return adminExists;

    }

    @Override
    public String matchCustumerDestination(String customur_Destination) {
        String destination_Table = " ID \t\t\t Plane Name \t\t\t\t\t Destination \t\t\t\t  Departure Date  \t\t\t\t  Departure Time ";
        DBconnection();
        try {
            String query = "SELECT * FROM planedestinations WHERE destination LIKE '%" +customur_Destination + "%'";
            rs = st.executeQuery(query);
                while(rs.next()){
                    int id = rs.getInt("id");
                    String airlinesName = rs.getString("airlinesName");
                    String destination = rs.getString("destination");
                    String departureDate = rs.getString("departureDate");
                    String departureTime = rs.getString("departureTime");
                    destination_Table += "\n" + id + ",\t" + airlinesName + ",\t" + destination + ",\t" + departureDate + ",\t" + departureTime;

                }
                if(destination_Table.equals(" ID \t\t\t Plane Name \t\t\t\t\t Destination \t\t\t\t  Departure Date  \t\t\t\t  Departure Time ")){
                    return "There are no flights with your searched input";
                }
                con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return destination_Table;
    }
    @Override
    public boolean updateSeats() {
        DBconnection();
        try {
            int choose_Plane_ID = 0;
            Scanner chooseScan_Plane = new Scanner(System.in);
            System.out.println("Which plane  do you choose ?  (Please Enter the plane ID)? ");
            choose_Plane_ID = Integer.parseInt(chooseScan_Plane.nextLine());
            String query1 = "SELECT * FROM planedestinations WHERE id = '" + choose_Plane_ID + "'";
            rs = st.executeQuery(query1);
            if(rs.next()){
                int passengerSeats = rs.getInt("passengerSeats");
                String airlinesName = rs.getString("airlinesName") ;
                int id = rs.getInt("id");
//                System.out.println(id  + "," + passengerSeats + "," + airlinesName);
                usingPlane = airlinesName + "" + id;
                if(passengerSeats > 0){
                    int updatedPassengerSeat = passengerSeats -1;
                    String query2 = "UPDATE planedestinations SET passengerSeats = " + updatedPassengerSeat +  " WHERE id = " + id;
                    st.executeUpdate(query2);
                    con.close();
                    return true;
                }
                /**
                 *  ****************************
                 *  ****************************
                 *
                 * **/

            }
            con.close();
        }catch (NumberFormatException e){
            System.out.println("Wrong input!!! Please Enter a  number");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }
    @Override
    public boolean deleteFlight(int delete_ID) {
        DBconnection();
        boolean flightFound = false;
        boolean custumorsFound = false;

        try {
            String query1 = "SELECT * FROM planedestinations WHERE id = " + delete_ID;
            rs = st.executeQuery(query1);
            if(rs.next()){
                int id = rs.getInt("id");
                String airlinesName = rs.getString("airlinesName");
                deletingFlight = airlinesName + "" + id;
                String query4 = "DELETE FROM planedestinations WHERE id = " + id;
                st.executeUpdate(query4);
                flightFound = true;
            }else{
                con.close();
                return false;
            }
            if(flightFound){

                String query2 = "SELECT * FROM payedperson WHERE usingPlane = '" + deletingFlight + "'";
                rs = st.executeQuery(query2);
                if(rs.next()){
                    custumorsFound = true;
                    while (rs.next()){
                        String name = rs.getString("name");
                        String email = rs.getString("email");
                        keyValue.put(name,email);
                    }
                    System.out.println(keyValue.entrySet());
                }else{
                    con.close();
                    return false;
                }
                if(custumorsFound){
                    String query3 = "DELETE FROM payedperson WHERE usingPlane = '" + deletingFlight + "'";
                    st.executeUpdate(query3);
                }
            }
            con.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }

    return true;

    }

    @Override
    public boolean checkValidateion() {

        DBconnection();
        try {
            String query = "SELECT * FROM planedestinations";
            rs = st.executeQuery(query);
            if(rs.next()){
                con.close();
                return true;
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }
}
