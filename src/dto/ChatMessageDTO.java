package com.chatbot.spring.dto;

import com.example.chatbot.model.MessageType;

public class ChatMessageDTO {
    private String content;
    private String sender;
    private MessageType type;
    
    // Constructors
    public ChatMessageDTO() {}
    
    public ChatMessageDTO(String content, String sender, MessageType type) {
        this.content = content;
        this.sender = sender;
        this.type = type;
    }
    
    // Getters and Setters
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    
    public String getSender() { return sender; }
    public void setSender(String sender) { this.sender = sender; }
    
    public MessageType getType() { return type; }
    public void setType(MessageType type) { this.type = type; }
}