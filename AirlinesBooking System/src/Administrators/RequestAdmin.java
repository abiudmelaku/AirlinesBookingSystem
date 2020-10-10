package Administrators;

public class RequestAdmin {
    private String SSN;
    private String PassWord;
    private String Email;
    public RequestAdmin(String SSN, String PassWord , String Email){
        this.SSN = SSN;
        this.PassWord = PassWord;
        this.Email = Email;
    }

    public String getSSN() {
        return SSN;
    }

    public String getPassWord() {
        return PassWord;
    }

    public String getEmail() {
        return Email;
    }
}
