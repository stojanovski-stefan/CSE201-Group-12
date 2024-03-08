package com.example.demo;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.LoginController;
import com.example.demo.UserRepository;

@WebMvcTest(LoginController.class)
public class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @Test
    public void testShowLogin() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/login"))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.view().name("login"));
    }
    
    @Test
    public void testProcessLogin_InvalidUsernamePassword() throws Exception {
        String username = "invaliduser";
        String password = "invalidpassword";

        when(userRepository.findByUsername(username)).thenReturn(null);

        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .param("username", username)
                .param("password", password))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/login?error"));
    }

    @Test
    public void testProcessLogin_Successful() throws Exception {
        String username = "validuser";
        String password = "validpassword";

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));

        when(userRepository.findByUsername(username)).thenReturn(user);
        when(passwordEncoder.matches(password, user.getPassword())).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.post("/login")
                .param("username", username)
                .param("password", password))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/main"));
    }

}