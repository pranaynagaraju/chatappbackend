package com.techbypranay.chatapp.service;

import com.techbypranay.chatapp.dto.MessagesDTO;
import com.techbypranay.chatapp.entity.Messages;
import com.techbypranay.chatapp.repository.ChatsRepository;
import com.techbypranay.chatapp.repository.MessageRepository;
import com.techbypranay.chatapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MessageServiceImplementation implements MessageService {

    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private ChatsRepository chatsRepository;
    @Autowired
    private UserRepository userRepository;
    @Override
    public void send(MessagesDTO messagesDTO) {
        Messages messages = new Messages(); // Create a new entity instance
        messages.setChat(chatsRepository.findById(messagesDTO.getChatId()).orElse(null));
        messages.setSender(userRepository.findById(messagesDTO.getSenderId()).orElse(null));
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
            messageDTO.setChatId(message.getChat().getChatId());
            messageDTO.setSenderId(message.getSender().getUserId());
            messageDTO.setContent(message.getContent());
            messageDTO.setTimestamp(message.getTimestamp());
            messagesDTOList.add(messageDTO);
        }

        return messagesDTOList;
    }
}
