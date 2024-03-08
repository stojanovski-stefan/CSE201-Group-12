package com.example.demo;

/*
 * This is a handler method for HTTP request toward login.
 * Display login.
 * Process login submission after checking authentication.
 * @author Kimberly Hamilton
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;


@Controller
public class LoginController {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
    @Autowired
    public LoginController(UserRepository userRepository, 
            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    
    //Display login
    @GetMapping("/login")
    public String showLogin(@RequestParam(required = false)
    String error, Model model) {
        if (error != null) {
            model.addAttribute("Error", "Invalid username or password."
                    + "Please try again.");    
        }
        //Return name of HTML template (login.html)
        return "login";
    }
    
    //Process login submission
    @PostMapping("/login")
    public String processLogin(@RequestParam String username, 
            @RequestParam String password) {
        
        //Check if user exists
        User user = userRepository.findByUsername(username);
        if (user == null || !passwordEncoder.matches(password,
                user.getPassword())) {
            //User not found or password incorrect
            return "redirect:/login?error";
        }
    
    //User authenticated successful, redirect to main page
    return "redirect:/main";
    
    }
}
