package edu.neiu.patientappointment.controllers;

import edu.neiu.patientappointment.data.PatientRepository;
import edu.neiu.patientappointment.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping("/view/{id}")
    public String showPatient(@PathVariable Long id, Model model) {
        Patient patient = this.patientRepo.findById(id).get();
        model.addAttribute("patient", patient);
        return "view-patient";
    }

    @GetMapping("/delete/{id}")
    public String deletePatient(@PathVariable Long id) {
        this.patientRepo.deleteById(id);
        return "redirect:/view";
    }




    @PostMapping
    public  String handlePatientForm(@Valid @ModelAttribute("patient") Patient patient, Errors errors ) {
        if(errors.hasErrors())
            return "add-patient";

        try {
            this.patientRepo.save(patient);
        }catch (DataIntegrityViolationException e) {
            errors.rejectValue("email","Invalid Email", "Email not available");
            return "add-patient";
        }

        return "redirect:/view";
    }

}
