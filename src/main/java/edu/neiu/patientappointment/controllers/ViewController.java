package edu.neiu.patientappointment.controllers;

import edu.neiu.patientappointment.data.AvailabilityRepository;
import edu.neiu.patientappointment.data.PatientRepository;
import edu.neiu.patientappointment.models.Availability;
import edu.neiu.patientappointment.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/display")
public class ViewController {
    private PatientRepository patientRepo;




    @Autowired
    public  ViewController(PatientRepository patientRepo){

        this.patientRepo = patientRepo;


    }

    @GetMapping
    public String ViewPatient(Model model) {
        List<Patient> patients = (List<Patient>) this.patientRepo.findAll();
        model.addAttribute("patients",patients);
        return "User-displayPatients";
    }


}
