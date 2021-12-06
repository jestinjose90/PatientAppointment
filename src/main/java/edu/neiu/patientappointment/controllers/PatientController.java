package edu.neiu.patientappointment.controllers;

import edu.neiu.patientappointment.data.AvailabilityRepository;
import edu.neiu.patientappointment.data.PatientRepository;
import edu.neiu.patientappointment.models.Availability;
import edu.neiu.patientappointment.models.Patient;
import edu.neiu.patientappointment.models.Physician;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/addPatient")
public class PatientController {

    private PatientRepository patientRepo;
    private AvailabilityRepository availableRepo;




    @Autowired
    public  PatientController(PatientRepository patientRepo , AvailabilityRepository availableRepo){
        this.patientRepo = patientRepo;
        this.availableRepo = availableRepo;




    }

    @GetMapping
    public  String addPatient(Model model) {
        List<Availability> schedule = (List<Availability>)this.availableRepo.findAll();
        model.addAttribute("available", schedule);
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

        return "redirect:/display";
    }


    @PostMapping("/edit/{id}")
    public  String updatePatientData(@PathVariable long id, @Valid @ModelAttribute("patient") Patient patient, Errors errors ) {
        if(errors.hasErrors())
            return "add-patient";
        Patient eachPatient = this.patientRepo.findById(id).get();
        updateEachPatient(eachPatient, patient);
        this.patientRepo.save(patient);


        return "redirect:/view";
    }

    private void updateEachPatient(Patient patient , Patient update) {
        patient.setFirstname(update.getFirstname());
        patient.setLastname(update.getLastname());
        patient.setDateofbirth(update.getDateofbirth());
        patient.setEmail(update.getEmail());
        patient.setPhone(update.getPhone());
    }

}
