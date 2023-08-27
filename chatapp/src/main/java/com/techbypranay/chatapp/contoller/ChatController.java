package com.techbypranay.chatapp.contoller;


import com.techbypranay.chatapp.dto.ChatsDTO;
import com.techbypranay.chatapp.entity.Chats;
import com.techbypranay.chatapp.service.ChatServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chats")
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST})
public class ChatController {
    @Autowired
    private ChatServiceImplementation chatServiceImplementation;

    @PostMapping("/save")
    public void saveChat(@RequestBody Chats chat)
    {
        chatServiceImplementation.saveChat(chat);
    }
    @GetMapping("/show")
    public List<ChatsDTO> showChat()
    {
        try {
           return chatServiceImplementation.showChats();
        }
        catch (Exception E)
        {
            return null;
        }

    }


}
