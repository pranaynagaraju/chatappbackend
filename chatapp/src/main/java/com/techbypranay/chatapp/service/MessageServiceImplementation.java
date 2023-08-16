package com.techbypranay.chatapp.service;

import com.techbypranay.chatapp.dto.MessagesDTO;
import com.techbypranay.chatapp.entity.Messages;
import com.techbypranay.chatapp.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MessageServiceImplementation implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void send(MessagesDTO messagesDTO) {
        Messages messages = new Messages(); // Create a new entity instance
        messages.setChat(messagesDTO.getChat());
        messages.setSender(messagesDTO.getSender());
        messages.setContent(messagesDTO.getContent());
        messages.setTimestamp(messagesDTO.getTimestamp());
        messageRepository.save(messages);
    }

    @Override
    public List<MessagesDTO> recieve() {
        List<MessagesDTO> messagesDTOList = new ArrayList<>();
        List<Messages> messagesList = messageRepository.findAll();

        for (Messages message : messagesList) {
            MessagesDTO messageDTO = new MessagesDTO();
            messageDTO.setChat(message.getChat());
            messageDTO.setSender(message.getSender());
            messageDTO.setContent(message.getContent());
            messageDTO.setTimestamp(message.getTimestamp());
            messagesDTOList.add(messageDTO);
        }

        return messagesDTOList;
    }
}
