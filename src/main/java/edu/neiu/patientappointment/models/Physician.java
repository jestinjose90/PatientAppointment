package edu.neiu.patientappointment.models;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Objects;
import java.util.Set;
import javax.persistence.ManyToMany;


@Entity
public class Physician {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotBlank(message = "First name is required")
    private String firstname;
    @NotBlank(message = "Last name is required")
    private String lastname;
    @NotBlank(message = "Speciality is required")
    private String speciality;
    @NotBlank(message = "Email is required")
    @Column(unique = true, length = 100)
    @Email(message = "Must be a valid email address")
    private String email;
    @NotBlank(message = "Phone number is required")
    private String phone;

    @ManyToMany
    private Set<Availability> appointment;




    public Physician () {
        this.firstname = "";
        this.lastname = "";
        this.speciality = "";
        this.email= "";
        this.phone = "";

    }

    public Physician(String firstname, String lastname, String speciality , String email, String phone ){
        this.firstname = firstname;
        this.lastname = lastname;
        this.speciality = speciality;
        this.email = email;
        this.phone= phone;



    }




    public Set<Availability> getAppointment() {
        return appointment;
    }

    public void setAppointment(Set<Availability> appointment) {
        this.appointment = appointment;
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

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
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
        return  this.firstname + " " + this.lastname + " " + this.speciality+ " " + this.email + " "
                + this.phone;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Physician))
            return false;
     Physician p = (Physician) o;
        return this.phone.equals(p.phone) && this.appointment.equals(p.appointment) && this.email.equals(p.email)
                && this.speciality.equals(p.speciality);
    }

}
