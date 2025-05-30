package com.chatbot.spring.service;

import com.example.chatbot.dto.ChatMessageDTO;
import com.example.chatbot.model.ChatMessage;
import com.example.chatbot.model.MessageType;
import com.example.chatbot.repository.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChatService {
    
    @Autowired
    private ChatMessageRepository messageRepository;
    
    @Autowired
    private ChatbotService chatbotService;
    
    public ChatMessageDTO saveMessage(ChatMessageDTO messageDTO) {
        ChatMessage message = new ChatMessage(
            messageDTO.getContent(),
            messageDTO.getSender(),
            messageDTO.getType()
        );
        
        ChatMessage savedMessage = messageRepository.save(message);
        
        return new ChatMessageDTO(
            savedMessage.getContent(),
            savedMessage.getSender(),
            savedMessage.getType()
        );
    }
    
    public List<ChatMessageDTO> getRecentMessages() {
        return messageRepository.findTop10ByOrderByCreatedAtDesc()
            .stream()
            .map(msg -> new ChatMessageDTO(msg.getContent(), msg.getSender(), msg.getType()))
            .collect(Collectors.toList());
    }
    
    public ChatMessageDTO processUserMessage(ChatMessageDTO userMessage) {
        saveMessage(userMessage);
        
        String botResponse = chatbotService.generateResponse(userMessage.getContent());
        
        ChatMessageDTO botMessage = new ChatMessageDTO(botResponse, "ChatBot", MessageType.CHAT);
        return saveMessage(botMessage);
    }
}