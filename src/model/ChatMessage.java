package com.chatbot.spring.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "chat_messages")
public class ChatMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String content;
    
    @Column(nullable = false)
    private String sender;
    
    @Enumerated(EnumType.STRING)
    private MessageType type;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    // Constructors
    public ChatMessage() {
        this.createdAt = LocalDateTime.now();
    }
    
    public ChatMessage(String content, String sender, MessageType type) {
        this();
        this.content = content;
        this.sender = sender;
        this.type = type;
    }
    
    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    
    public String getSender() { return sender; }
    public void setSender(String sender) { this.sender = sender; }
    
    public MessageType getType() { return type; }
    public void setType(MessageType type) { this.type = type; }
    
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}

enum MessageType {
    CHAT, JOIN, LEAVE
}