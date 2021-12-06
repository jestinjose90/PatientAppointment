package edu.neiu.patientappointment.controllers;

import edu.neiu.patientappointment.data.AvailabilityRepository;
import edu.neiu.patientappointment.data.PatientRepository;
import edu.neiu.patientappointment.data.PhysicianRepository;
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
@RequestMapping("/addPhysician")
public class AddPhysicianController {

    private PhysicianRepository physicianRepo;
    private AvailabilityRepository availableRepo;


    @Autowired
    public AddPhysicianController(PhysicianRepository physicianRepo, AvailabilityRepository availableRepo){
        this.physicianRepo = physicianRepo;
        this.availableRepo = availableRepo;

    }

    @GetMapping
    public  String addPhysician(Model model) {
        List<Availability> physician_schedule = (List<Availability>)this.availableRepo.findAll();
        model.addAttribute("physician_available", physician_schedule);
        model.addAttribute("physician", new Physician());
        return "add-physician";
    }

    @GetMapping("/view")
    public String ViewPhysician(Model model) {
        List<Physician> physicians = (List<Physician>) this.physicianRepo.findAll();
        model.addAttribute("physicians",physicians);
        return "display-physician";
    }

    @GetMapping("/view/{id}")
    public String updatePhysician(@PathVariable Long id, Model model) {
        Physician physician = this.physicianRepo.findById(id).get();
        model.addAttribute("physician", physician);
        return "update-physician";
    }

    @GetMapping("/delete/{id}")
    public String deletePhysician(@PathVariable Long id) {
        this.physicianRepo.deleteById(id);
        return "redirect:/addPhysician/view";
    }


    @PostMapping
    public  String handlePhysicianData(@Valid @ModelAttribute("physician") Physician physician, Errors errors ) {
        if(errors.hasErrors())
            return "add-physician";

        try {
            this.physicianRepo.save(physician);
        }catch (DataIntegrityViolationException e) {
            errors.rejectValue("email","Invalid Email", "Email not available");
            return "add-physician";
        }

        return "redirect:/addPhysician/view";
    }

    @PostMapping("/edit/{id}")
    public  String updatePhysicianData(@PathVariable long id,@Valid @ModelAttribute("physician") Physician physician, Errors errors ) {
        if(errors.hasErrors())
            return "add-physician";
        Physician eachPhysician = this.physicianRepo.findById(id).get();
        updateEachPhysician(eachPhysician, physician);
            this.physicianRepo.save(physician);


        return "redirect:/addPhysician/view";
    }

    private  void updateEachPhysician(Physician physician, Physician update) {
        physician.setFirstname(update.getFirstname());
        physician.setLastname(update.getLastname());
        physician.setSpeciality(update.getSpeciality());
        physician.setEmail(update.getEmail());
        physician.setPhone(update.getPhone());
    }

}
