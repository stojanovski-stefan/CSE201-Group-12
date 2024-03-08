package com.example.demo;

/*
 * This is a handler method for HTTP request toward signup.
 * Display signup.
 * Process signup submissions.
 * Encode password.
 * @author Kimberly Hamilton
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;


@Controller
public class SignupController {
 
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
    @Autowired
    private SignupController(UserRepository userRepository, 
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    
    //Display signup
    @GetMapping("/signup")
    public String showSignup(Model model) {
        //Attributes for signup
        model.addAttribute("user", new User());
        //Return name of HTML template (signup.html)
        return "signup";
    }
    
    //Process signup submission
    @PostMapping("/signup")
    public String processSignup(@ModelAttribute User user) {
 
        //Encode password before saving user
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        
        //Save the user 
        userRepository.save(user);
        
        //Redirect to login page after completed signup
        return "redirect:/login";
    }
}