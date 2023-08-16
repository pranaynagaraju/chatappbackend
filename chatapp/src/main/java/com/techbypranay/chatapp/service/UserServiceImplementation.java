package com.techbypranay.chatapp.service;


import com.techbypranay.chatapp.dto.UsersDTO;
import com.techbypranay.chatapp.entity.Users;

import com.techbypranay.chatapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service

public class UserServiceImplementation implements UserService {
    @Autowired
    UserRepository userRepository;

    public List<UsersDTO> showAll() {
        List<Users> userList = userRepository.findAll();
        List<UsersDTO> userDTOList = new ArrayList<>();

        for (Users user : userList) {
            UsersDTO userDTO = new UsersDTO();
            userDTO.setUserId(user.getUserId());
            userDTO.setUserName(user.getUserName());
            userDTO.setEmail(user.getEmail());
            userDTOList.add(userDTO);
        }

        return userDTOList;
    }


    public String signUp(Users details) {
        userRepository.save(details);
        return "User Added";
    }

    public String logIn(Users details) {
        Users currentUser;
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
