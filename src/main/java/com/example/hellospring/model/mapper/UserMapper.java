package com.example.hellospring.model.mapper;

import com.example.hellospring.entity.User;
import com.example.hellospring.model.dto.UserDTO;

public class UserMapper {
    public static UserDTO userDTO (User user) {
        UserDTO tmp = new UserDTO();
        tmp.setUserName(user.getUserName());
        tmp.setPassword(user.getPassword());
        return tmp;
    }
}
