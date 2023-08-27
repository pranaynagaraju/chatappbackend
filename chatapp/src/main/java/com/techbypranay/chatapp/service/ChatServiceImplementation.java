package com.techbypranay.chatapp.service;


import com.techbypranay.chatapp.dto.ChatsDTO;
import com.techbypranay.chatapp.dto.MessagesDTO;
import com.techbypranay.chatapp.entity.Chats;
import com.techbypranay.chatapp.entity.Messages;
import com.techbypranay.chatapp.repository.ChatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatServiceImplementation implements ChatService {

    @Autowired
    private ChatsRepository chatsRepository;

    @Override
    public void saveChat(Chats chat) {
        chatsRepository.save(chat);
    }

    @Override
    public List<ChatsDTO> showChats() {
        List<ChatsDTO> ChatsDTOList = new ArrayList<>();
        List<Chats> chatsList = chatsRepository.findAll();

        for (Chats chat : chatsList) {
            ChatsDTO chatsDTO = new ChatsDTO();
            chatsDTO.setChatId(chat.getChatId());
            chatsDTO.setParticipants(chat.getParticipants());
            chatsDTO.setUpdatedAt(chat.getUpdatedAt());
            chatsDTO.setCreatedAt(chat.getCreatedAt());
            ChatsDTOList.add(chatsDTO);
        }

        return ChatsDTOList;
    }
}
