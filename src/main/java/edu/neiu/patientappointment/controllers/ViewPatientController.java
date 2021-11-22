package edu.neiu.patientappointment.controllers;

import edu.neiu.patientappointment.data.PatientRepository;
import edu.neiu.patientappointment.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequestMapping("/view")
public class ViewPatientController {


    private PatientRepository patientRepo;

    @Autowired
    public  ViewPatientController(PatientRepository patientRepo){
        this.patientRepo = patientRepo;
    }

    @GetMapping
    public String displayPatient(Model model) {
        List<Patient> patients = (List<Patient>) this.patientRepo.findAll();
        model.addAttribute("patients",patients);
        return "display-patients";
    }
}
