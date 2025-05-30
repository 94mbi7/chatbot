package com.chatbot.spring.controller;

import com.example.chatbot.dto.ChatMessageDTO;
import com.example.chatbot.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins = "*") 
public class ChatController {
    
    @Autowired
    private ChatService chatService;
    
    @GetMapping("/messages")
    public ResponseEntity<List<ChatMessageDTO>> getRecentMessages() {
        List<ChatMessageDTO> messages = chatService.getRecentMessages();
        return ResponseEntity.ok(messages);
    }
    
    @PostMapping("/send")
    public ResponseEntity<ChatMessageDTO> sendMessage(@RequestBody ChatMessageDTO message) {
        try {
            ChatMessageDTO botResponse = chatService.processUserMessage(message);
            return ResponseEntity.ok(botResponse);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Chatbot service is running!");
    }
}