package com.techbypranay.chatapp.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "chats")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chat_id")
    private Long chatId;

    @Column(name = "chat_name")
    private String chatName;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "is_private")
    private boolean isPrivate;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private Users sender; // Assuming this represents the creator of the chat

    @OneToMany(mappedBy = "chat", cascade = CascadeType.ALL)
    private List<Messages> messages;

    // Constructors, getters, setters, etc.
}
