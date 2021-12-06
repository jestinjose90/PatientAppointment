package edu.neiu.patientappointment.models;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.ManyToMany;

@Entity
public class Availability {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotBlank(message = "Day is required")
    @Column( length = 100)
    private String day;
    @NotBlank(message = "Date is required")
    @Column(unique = true, length = 100)
    private String date;
    @NotBlank(message = "Time is required")
    @Column(unique = true, length = 100)
    private String time;
    @ManyToMany(mappedBy = "appointment")
     private Set<Physician> physicians = new HashSet<>();




    public Availability() {
        this.day = "";
        this.date = "";
        this.time= "";
    

    }

    public Availability(String day, String date, String time){
        this.day = day;
        this.date = date;
        this.time = time;
    

    }


    public Set<Physician> getPhysicians() {
        return physicians;
    }

    public void setPhysicians(Set<Physician> physicians) {
        this.physicians = physicians;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }




    @Override
    public String toString() {
        return  this.day + " " + this.date + " " + this.time;
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Availability))
            return false;
        Availability a = (Availability) o;
        return this.time.equals(a.time) && this.date.equals(a.date) && this.day.equals(a.day);
    }




}



