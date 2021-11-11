package edu.neiu.patientappointment.controllers;

import edu.neiu.patientappointment.models.Patient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/addPatient")
public class PatientController {
    @GetMapping
    public  String addPatient(Model model) {
        model.addAttribute("patient",new Patient());
        return "add-patient";
    }
}
