package com.techbypranay.chatapp.service;

import com.techbypranay.chatapp.dto.MessagesDTO;
import java.util.List;

public interface MessageService {
    public void send(MessagesDTO messagesDTO);
    public List<MessagesDTO> recieve();
}
