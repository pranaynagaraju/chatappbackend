package com.techbypranay.chatapp.service;

import com.techbypranay.chatapp.dto.ChatsDTO;
import com.techbypranay.chatapp.entity.Chats;

import java.util.List;

public interface ChatService {

public void saveChat(Chats chats);
public List<ChatsDTO> showChats();
}
