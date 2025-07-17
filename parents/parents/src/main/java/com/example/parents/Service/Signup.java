package com.example.parents.Service;

import com.example.parents.Model.User;
import com.example.parents.Repository.Userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;

@Service  // Use @Service instead of @Component for better semantic meaning
public class Signup {

    private final Userrepo userrepo;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public User getUserByUsername(String username) {
        return userrepo.findById(username).orElse(null);
    }



    @Autowired
    public Signup(Userrepo userrepo) {
        this.userrepo = userrepo;
    }

    public List<User> getPUser() {
        return userrepo.findAll();
    }

    public void addUser(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userrepo.save(user);
    }
}
