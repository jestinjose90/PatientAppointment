package edu.neiu.patientappointment.controllers;

import edu.neiu.patientappointment.data.AvailabilityRepository;
import edu.neiu.patientappointment.data.PatientRepository;
import edu.neiu.patientappointment.models.Availability;
import edu.neiu.patientappointment.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/display-availability")
public class ViewAvailabilityController {
    private AvailabilityRepository availableRepo;

    @Autowired
    public  ViewAvailabilityController(AvailabilityRepository availableRepo){

        this.availableRepo = availableRepo;
    }

    @GetMapping
    public String ViewAvailability(Model model) {
        List<Availability> availableList = (List<Availability>) this.availableRepo.findAll();
        model.addAttribute("available",availableList);
        return "display-availability";
    }

}
