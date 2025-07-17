
package com.example.parents.Service;
import com.example.parents.Model.User;
import com.example.parents.Repository.Userrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class Signin implements UserDetailsService {

    @Autowired
    private Userrepo userrepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // This will be called automatically during login
        User user = userrepo.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),                  // Username (can also be email, up to you)
                user.getPassword(),                  // Hashed password
                Collections.singleton(new SimpleGrantedAuthority(user.getRole())) // Role
        );
    }
}
