package edu.neiu.patientappointment.security;

import edu.neiu.patientappointment.data.UserRepository;
import edu.neiu.patientappointment.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class AdminDataLoader implements CommandLineRunner {
    private UserRepository userRepo;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AdminDataLoader(UserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
       //User admin1 = new User("jsw123@gmail.com","john",passwordEncoder.encode("pass"),"John",
             //  "Orlando");
       //admin1.setRoles(Set.of(User.Role.ROLE_ADMIN));
       //admin1.setEnabled(true);
       // userRepo.save(admin1);


       // User admin2 = new User("bmc123@gmail.com","Bill",passwordEncoder.encode("password"),"Bill", "Arnold");
        //admin2.setRoles(Set.of(User.Role.ROLE_ADMIN));
        //admin2.setEnabled(true);
       // userRepo.save(admin2);


    }
}
