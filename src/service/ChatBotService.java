package com.chatbot.spring.service;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class ChatbotService {
    
    private Map<String, String[]> responses;
    private Random random;
    
    public ChatbotService() {
        this.random = new Random();
        initializeResponses();
    }
    
    private void initializeResponses() {
        responses = new HashMap<>();
        
        responses.put("hello", new String[]{
            "Hello! How can I help you today?",
            "Hi there! What's on your mind?",
            "Hey! Great to see you!"
        });
        
        responses.put("hi", new String[]{
            "Hi! How are you doing?",
            "Hello! What can I do for you?",
            "Hey there! How's your day going?"
        });
        
        responses.put("who are you", new String[]{
            "I'm a chatbot created with Spring Boot!",
            "I'm your friendly chatbot assistant!",
            "I'm here to chat and help you out!"
        });
        
        responses.put("how are you", new String[]{
            "I'm doing great, thanks for asking!",
            "I'm fantastic! How about you?",
            "All good here! How can I help you?"
        });
        
        responses.put("default", new String[]{
            "That's interesting! Tell me more.",
            "I see! What else would you like to discuss?",
            "Thanks for sharing! Anything else on your mind?",
            "I understand. Is there anything specific I can help with?"
        });
    }
    
    public String generateResponse(String userMessage) {
        String message = userMessage.toLowerCase().trim();
        
        for (String key : responses.keySet()) {
            if (message.contains(key)) {
                String[] possibleResponses = responses.get(key);
                return possibleResponses[random.nextInt(possibleResponses.length)];
            }
        }
        
        if (message.contains("help")) {
            return "I'm here to help! You can ask me questions or just chat with me.";
        }
        
        if (message.contains("bye") || message.contains("goodbye")) {
            return "Goodbye! It was nice chatting with you!";
        }
        
        if (message.contains("thank")) {
            return "You're very welcome! Happy to help!";
        }
        
        String[] defaultResponses = responses.get("default");
        return defaultResponses[random.nextInt(defaultResponses.length)];
    }
}