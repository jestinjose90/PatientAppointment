package edu.neiu.patientappointment.controllers;

import edu.neiu.patientappointment.data.PatientRepository;
import edu.neiu.patientappointment.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/display")


public class ViewPatientsController {

    private PatientRepository patientrepo;

    @Autowired
    public ViewPatientsController(PatientRepository patientrepo){
        this.patientrepo = patientrepo;
    }

    @GetMapping
    public String displayPatient(Model model) {
        List<Patient> patients = (List<Patient>) this.patientrepo.findAll();
        model.addAttribute("patients",patients);
        return "display-patients";
    }
}
