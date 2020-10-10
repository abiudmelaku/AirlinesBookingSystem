package FlightAttendants;

public class FlightPreson {
    private String full_name;
    private String destination;
    private String passport_Num;
    private String email;
    public void FlightPreson(String full_name,String destination ,
                             String passport_Num, String email){
        this.full_name = full_name;
        this.destination = destination;
        this.passport_Num = passport_Num;
        this.email = email;
    }
    public String getFull_name() {
        return full_name;
    }

    public String getDestination() {
        return destination;
    }

    public String getEmail() {
        return email;
    }

    public String getPassport_Num() {
        return passport_Num;
    }
}
