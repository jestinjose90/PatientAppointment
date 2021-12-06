package edu.neiu.patientappointment.controllers;

import edu.neiu.patientappointment.data.AvailabilityRepository;
import edu.neiu.patientappointment.data.PatientRepository;
import edu.neiu.patientappointment.models.Availability;
import edu.neiu.patientappointment.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/add")
public class AvailabilityController {

    private AvailabilityRepository availabilityRepo;

    @Autowired
    public  AvailabilityController(AvailabilityRepository availabilityRepo){
        this.availabilityRepo = availabilityRepo;

    }

    @GetMapping
    public  String addAvailability(Model model) {
        model.addAttribute("availability", new Availability());
        return "availability";
    }

    @GetMapping("/delete/{id}")
    public String deleteAvailability(@PathVariable Long id) {
        this.availabilityRepo.deleteById(id);
        return "redirect:/display-availability";
    }

    @PostMapping
    public  String handleAvailability(@Valid @ModelAttribute("availability") Availability available, Errors errors ) {
        if(errors.hasErrors())
            return "availability";

        try {
            this.availabilityRepo.save(available);
        }catch (DataIntegrityViolationException e) {
            errors.rejectValue("date","InvalidDate", "Date already exist");
            errors.rejectValue("time","InvalidTime", "Time already exist");
            return "availability";
        }

        return "redirect:/display-availability";
    }
}
