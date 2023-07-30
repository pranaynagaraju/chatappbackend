package com.techbypranay.chatapp.service;

import com.techbypranay.chatapp.dto.UserDTO;
import com.techbypranay.chatapp.entity.User;

import java.util.List;

public interface UserService {
    public List<UserDTO> showAll();
    public String signUp( User details);
    public String logIn( User details);
}
