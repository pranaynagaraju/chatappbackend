package com.techbypranay.chatapp.service;


import com.techbypranay.chatapp.dto.UserDTO;
import com.techbypranay.chatapp.entity.User;

import com.techbypranay.chatapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service

public class UserServiceImplementation implements UserService {
    @Autowired
    UserRepository userRepository;

    public List<UserDTO> showAll() {
        List<User> userList = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();

        for (User user : userList) {
            UserDTO userDTO = new UserDTO();
            userDTO.setUserId(user.getUserId());
            userDTO.setUserName(user.getUserName());
            userDTO.setEmail(user.getEmail());
            userDTOList.add(userDTO);
        }

        return userDTOList;
    }


    public String signUp(User details) {
        userRepository.save(details);
        return "User Added";
    }

    public String logIn(User details) {
        User currentUser;
        try {
            currentUser= userRepository.findByUserName(details.getUserName());
        } catch (Exception e) {
            return "user not found";
        }


        if (currentUser.getPassword().equals(details.getPassword()) ) {
            return "Login Successful";
        } else {
            return "Wrong password";
        }
    }
}
