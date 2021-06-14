package com.example.hellospring.service;

import com.example.hellospring.entity.User;
import com.example.hellospring.model.dto.UserDTO;
import com.example.hellospring.model.mapper.UserMapper;
import com.example.hellospring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

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
}
