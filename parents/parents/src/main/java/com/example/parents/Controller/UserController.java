package com.example.parents.Controller;

import com.example.parents.Model.User;
import com.example.parents.Service.JWTService;
import com.example.parents.Service.Signup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:5175")
@RestController
public class UserController {

    @Autowired
    private Signup signup;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    JWTService jwtService;

    @PostMapping("/signin")
    public ResponseEntity<String> addUser(@RequestBody User user) {
        signup.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String,String>> login(@RequestBody User loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );

            User user = signup.getUserByUsername(loginRequest.getUsername());
            if (user == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(Map.of("error", "User not found"));
            }

            // ✅ Get actual role
            String role = user.getRole();

            // ✅ Generate JWT with correct role
            String jwt = jwtService.generateToken(user.getUsername(), role);

            return ResponseEntity.ok(Map.of("token", jwt));


        } catch (AuthenticationException e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Invalid username or password"));
        }
    }
}
