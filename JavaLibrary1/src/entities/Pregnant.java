package entities;
public class Pregnant extends Passenger {
    private String gestationalAge;
    private String pretermBirth;

    public Pregnant(String gestationalAge, String pretermBirth, String passengerID, String name, String birthDay, String address, String phone, String testDate, String flightDate) {
        super(passengerID, name, birthDay, address, phone, testDate, flightDate);
        this.gestationalAge = gestationalAge;
        this.pretermBirth = pretermBirth;
    }

    public Pregnant(String gestationalAge, String pretermBirth) {
        this.gestationalAge = gestationalAge;
        this.pretermBirth = pretermBirth;
    }

    public String getGestationalAge() {
        return gestationalAge;
    }

    public String getPretermBirth() {
        return pretermBirth;
    }

    public Pregnant() {
    }

    public void setGestationalAge(String gestationalAge) {
        this.gestationalAge = gestationalAge;
    }

    public void setPretermBirth(String pretermBirth) {
        this.pretermBirth = pretermBirth;
    }
    @Override
    public void ShowInfo(){
        super.ShowInfo();
        System.out.println("GestationalAge: "+ this.gestationalAge+";"+"PretermBirth: "+ this.pretermBirth);
        
    }
}
