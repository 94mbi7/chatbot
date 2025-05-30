package com.chatbot.spring.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ChatbotServiceTest {
    
    private ChatbotService chatbotService = new ChatbotService();
    
    @Test
    void testGreetingResponse() {
        String response = chatbotService.generateResponse("hello");
        assertNotNull(response);
        assertTrue(response.length() > 0);
    }
    
    @Test
    void testDefaultResponse() {
        String response = chatbotService.generateResponse("random text");
        assertNotNull(response);
        assertTrue(response.length() > 0);
    }
}