package com.techbypranay.chatapp.dto;

import com.techbypranay.chatapp.entity.Chats;
import com.techbypranay.chatapp.entity.Users;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class MessagesDTO {
    private Long chatId;
    private int senderId;
    private String content;
    private LocalDateTime timestamp;
}
