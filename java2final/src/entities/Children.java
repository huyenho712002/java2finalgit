package entities;

import entities.Passenger;
public class Children extends Passenger {

    public Children(String school, String grade, String passengerID, String name, String birthDay, String address, String phone, String testDate, String flightDate) {
        super(passengerID, name, birthDay, address, phone, testDate, flightDate);
        this.school = school;
        this.grade = grade;
    }

    public Children() {
    }

    public Children(String school, String grade) {
        this.school = school;
        this.grade = grade;
    }
    private String school;
    private String grade;

    public String getSchool() {
        return school;
    }

    public String getGrade() {
        return grade;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    @Override
    //phương thức ShowInfo để biểu diễn thông tin, và override lại phương thức cha(Passenger)
    public void ShowInfo(){
        super.ShowInfo();
        System.out.println("School: "+this.school+";"+"Grade: "+this.grade);
    }
}
