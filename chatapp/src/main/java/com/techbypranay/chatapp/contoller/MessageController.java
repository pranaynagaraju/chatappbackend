package com.techbypranay.chatapp.contoller;


import com.techbypranay.chatapp.dto.MessagesDTO;
import com.techbypranay.chatapp.service.MessageService;
import com.techbypranay.chatapp.service.MessageServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageServiceImplementation messageServiceImplementation;
    @GetMapping("/recieve")
    public List<MessagesDTO> recieve()
    {
        return  messageServiceImplementation.recieve();

    }

    @PostMapping("/send")
    public String send(@RequestBody MessagesDTO messagesDTO)
    {
         messageServiceImplementation.send(messagesDTO);
         return "Sent";

    }

}
