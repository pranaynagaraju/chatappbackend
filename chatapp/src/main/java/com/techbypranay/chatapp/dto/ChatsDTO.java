package com.techbypranay.chatapp.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChatsDTO {
    private Long chatId;
    private int[] participants;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
