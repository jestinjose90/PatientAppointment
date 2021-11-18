package edu.neiu.patientappointment.controllers;

import edu.neiu.patientappointment.data.PatientRepository;
import edu.neiu.patientappointment.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/addPatient")
public class PatientController {

    private PatientRepository patientRepo;
    @Autowired
    public  PatientController(PatientRepository patientRepo){
        this.patientRepo = patientRepo;
    }
    @GetMapping
    public  String addPatient(Model model) {
        model.addAttribute("patient", new Patient());
        return "add-patient";
    }



    @PostMapping
    public  String handlePatientForm(@ModelAttribute("patient") Patient patient ) {
        this.patientRepo.save(patient);
        return "redirect:/display";
    }

}
