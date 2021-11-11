package edu.neiu.patientappointment.models;

public class Patient {


    private String firstname;
    private String lastname;
    private String dateofbirth;
    private String address;
    private String insuranceprovider;
    private String physician_name;
    private String purpose;

    public Patient(String firstname, String lastname, String dateofbirth , String address, String insuranceprovider, String physician_name, String purpose) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateofbirth = dateofbirth;
        this.address = address;
        this.insuranceprovider = insuranceprovider;
        this.physician_name = physician_name;
        this.purpose = purpose;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getInsuranceprovider() {
        return insuranceprovider;
    }

    public void setInsuranceprovider(String insuranceprovider) {
        this.insuranceprovider = insuranceprovider;
    }

    public String getPhysician_name() {
        return physician_name;
    }

    public void setPhysician_name(String physician_name) {
        this.physician_name = physician_name;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

}
