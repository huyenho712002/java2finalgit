package entities;


/**
 *
 * @author ADMIN
 */
public class Adult extends Passenger {

    public Adult(String job, String passengerID, String name, String birthDay, String address, String phone, String testDate, String flightDate) {
        super(passengerID, name, birthDay, address, phone, testDate, flightDate);
        this.job = job;
    }

    public Adult(String job) {
        this.job = job;
    }
    private String job;

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Adult() {
    }
    
    @Override
    //phương thức ShowInfo để biểu diễn thông tin
    public void ShowInfo(){
        super.ShowInfo();
        System.out.println("Your Job: "+this.job);
    }

    public String getPassengerId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
