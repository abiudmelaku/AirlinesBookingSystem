package Administrators;
public   class FlightCordination {
    private int plane_ID;
    private String plane_Name;
    private String destination;
    private  String departure_Date;
    private String departure_Time;
    private int plane_Size;
    private Double payment_amount;
    public void FlightCordination(  String plane_Name , String destination
            , String departure_Date , String departure_Time, Double payment_amount , int plane_Size){
        this.plane_ID = plane_ID;
        this.plane_Name = plane_Name;
        this.destination = destination;
        this.departure_Date = departure_Date;
        this.departure_Time = departure_Time;
        this.payment_amount = payment_amount;
        this.plane_Size = plane_Size;
    }

    public int getPlane_ID() {
        return plane_ID;
    }

    public void setPlane_ID(int plane_ID) {
        this.plane_ID = plane_ID;
    }

    public String getPlane_Name() {
        return plane_Name;
    }

    public String getDestination() {
        return destination;
    }

    public String getDeparture_Date() {
        return departure_Date;
    }

    public int getPlane_Size() {
        return plane_Size;
    }


    public Double getPayment_amount() {
        return payment_amount;
    }
    public String getDeparture_Time(){ return departure_Time; }

}
