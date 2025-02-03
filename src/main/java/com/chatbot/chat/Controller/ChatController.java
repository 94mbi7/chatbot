package com.chatbot.chat.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller  
public class ChatController {

    @GetMapping("/")  // Add root mapping
    public String home() {
        return "index";  // This will look for index.html in templates folder
    }

    @PostMapping("/")
    @ResponseBody  // Add this to return raw string response
    public String processInput(@RequestParam String userInput) {
        return userInput;
    }
}