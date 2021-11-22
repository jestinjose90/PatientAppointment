package edu.neiu.patientappointment.models;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Patient {



    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotBlank(message = "First name is required")
    private String firstname;
    @NotBlank(message = "Last name is required")
    private String lastname;
    @NotBlank(message = "DateofBirth is required")
    private String dateofbirth;
    @NotBlank(message = "Email is required")
    @Column(unique = true, length = 100)
    @Email(message = "Must be a valid email address")
    private String email;
    @NotBlank(message = "Phone number is required")
    @NumberFormat
    private String phone;


    public Patient() {
        this.firstname = "";
        this.lastname = "";
        this.dateofbirth = "";
        this.email= "";
        this.phone = "";

}

    public Patient(String firstname, String lastname, String dateofbirth , String email, String phone){
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateofbirth = dateofbirth;
        this.email = email;
        this.phone= phone;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return  this.firstname + " " + this.lastname;
    }
}
