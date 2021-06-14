package com.example.hellospring.config;

import com.example.hellospring.entity.User;
import com.example.hellospring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        // lay user
        Optional<User> user = userRepository.findByUserName(userName);
        if (user.isPresent()) {
        	User u = user.get();

            UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
                    .username(u.getUserName())
                    .password(u.getPassword())
                    .roles("ADMIN", "USER")
                    .build();
            return userDetails;
        }


        return null;
    }
}
