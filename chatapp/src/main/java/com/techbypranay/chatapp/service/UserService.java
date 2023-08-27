package com.techbypranay.chatapp.service;

import com.techbypranay.chatapp.dto.UsersDTO;
import com.techbypranay.chatapp.entity.Users;

import java.util.List;

public interface UserService {
    public List<UsersDTO> showAll();
    public String signUp( Users details);
    public UsersDTO logIn( Users details);
}
