package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;

public class SignupControllerTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private SignupController signupController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShowSignup() {
        Model model = mock(Model.class);

        String viewName = signupController.showSignup(model);

        // Assert that the method returns the expected view name
        assertEquals("signup", viewName);

        // Assert that the model contains an attribute named "user"
        verify(model).addAttribute(eq("user"), any(User.class));
    }

    @Test
    public void testProcessSignup() {
        User user = new User();
        user.setUsername("testUser");
        user.setPassword("testPassword");

        // Mock password encoding
        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");

        String viewName = signupController.processSignup(user);

        // Assert that the user's password is encoded
        assertEquals("encodedPassword", user.getPassword());

        // Assert that the user is saved in the repository
        verify(userRepository).save(user);

        // Assert that the method redirects to the login page
        assertEquals("redirect:/login", viewName);
    }
}
