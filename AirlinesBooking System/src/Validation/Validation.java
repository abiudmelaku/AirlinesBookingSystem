package Validation;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation implements Ivalidation {
    @Override
    public boolean Validate_Email(String email) {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/" +
                "=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
//        String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches()){
            return true;
        }
        return  false;
    }

    @Override
    public boolean Validate_Name(String name) {
//        String regex1 = "^[\\p{L} .'-]+$" ;
//          String regex = "^[A-Za-z\s]{1,}[\.]{0,1}[A-Za-z\s]{0,}$";
//        String regex3 = "^\pL+[\pL\pZ\pP]{0,}$"; //unicode
        String regex4 = "^\\p{L}+[\\p{L}\\p{Z}\\p{P}]{0,}";
        Pattern pattern = Pattern.compile(regex4);
        Matcher matcher = pattern.matcher(name);
        if(matcher.matches()){
            return true;
        }

        return  false;


    }

    @Override
    public boolean Validate_Date(String flightDate) {
        try {
//            System.out.println(java.time.LocalDate.now());
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//            LocalDate now = LocalDate.now();
            formatter.setLenient(false);//formatter.setLenient(false) will enforce strict matching.
//             Date date= formatter.parse(flightDate);
//            String currentDate = formatter.format(now);
            if (formatter.parse(flightDate).before(new Date())) {
                return false;

            }


            return true;
        } catch (ParseException e) {
//            System.out.println("Err: " + e);
        }
        return false;
    }



    @Override
    public boolean Validate_Time(String flightTime) {
        //12hour format Validator
        String regex = "(1[012]|[1-9]):[0-5][0-9](\\s)?(?i)(am|pm)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(flightTime);
        if(matcher.matches()){
            return true;
        }
        return false;
    }
}
