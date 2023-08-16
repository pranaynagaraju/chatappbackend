package com.techbypranay.chatapp.dto;

import com.techbypranay.chatapp.entity.Chats;
import com.techbypranay.chatapp.entity.Users;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class MessagesDTO {
    private Chats chat;
    private Users sender;
    private String content;
    private LocalDateTime timestamp;
}
