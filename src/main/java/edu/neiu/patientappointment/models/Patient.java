package edu.neiu.patientappointment.models;

public class Patient {


    private String firstname;
    private String lastname;
    private String dateofbirth;
    private String dateofAppointment;
    private String physician_name;


    public Patient() {
        this.firstname = "";
        this.lastname = "";
        this.dateofbirth = "";
        this.dateofAppointment = "";
        this.physician_name = "";

}

    public Patient(String firstname, String lastname, String dateofbirth , String dateofAppointment, String physician_name){
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateofbirth = dateofbirth;
        this.dateofAppointment = dateofAppointment;
        this.physician_name = physician_name;

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getDateofAppointment() {
        return dateofAppointment;
    }

    public void setDateofAppointment(String dateofAppointment) {
        this.dateofAppointment = dateofAppointment;
    }

    public String getPhysician_name() {
        return physician_name;
    }

    public void setPhysician_name(String physician_name) {
        this.physician_name = physician_name;
    }



}
