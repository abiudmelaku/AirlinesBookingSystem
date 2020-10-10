package Validation;

import java.util.Date;

public interface Ivalidation {
    boolean Validate_Email(String email);
    boolean Validate_Name(String name);
    boolean Validate_Date(String flightDate);
    boolean Validate_Time(String flightTime);
}
