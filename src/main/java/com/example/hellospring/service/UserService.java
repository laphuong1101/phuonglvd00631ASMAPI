package com.example.hellospring.service;

import com.example.hellospring.entity.Credential;
import com.example.hellospring.entity.User;
import com.example.hellospring.model.dto.UserDTO;
import com.example.hellospring.model.mapper.UserMapper;
import com.example.hellospring.repository.CredentialRepository;
import com.example.hellospring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CredentialRepository credentialRepository;


//    @Autowired
//    private PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    // save
    public UserDTO save (User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        UserDTO rs = UserMapper.userDTO(user);
        return rs;
    }

    // register
    public UserDTO register (String username, String password, int role) {
        User user = new User(username, bCryptPasswordEncoder.encode(password), role);
        userRepository.save(user);
        return null;
    }

    // login
    public Credential login(String username, String password) {
        Optional<User> userOptional = userRepository.findByUserName(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (bCryptPasswordEncoder.matches(password, user.getPassword())) {
                Credential credential = new Credential(user);
                credentialRepository.save(credential);
            }
        }
        return null;
    }
}
