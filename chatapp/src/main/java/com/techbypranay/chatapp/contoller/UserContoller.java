package com.techbypranay.chatapp.contoller;



import com.techbypranay.chatapp.dto.UsersDTO;
import com.techbypranay.chatapp.entity.Users;
import com.techbypranay.chatapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class UserContoller {
    @GetMapping("/display")

    public ResponseEntity<List<
            UsersDTO>> display()
    {
      return new ResponseEntity<> (userService.showAll(), HttpStatus.OK );
    }
   @Autowired
    UserService userService;
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody Users details)
    {
        return new ResponseEntity<> (userService.signUp(details), HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Users details)
    {
        return new ResponseEntity<> (userService.logIn(details), HttpStatus.OK);
    }
}
