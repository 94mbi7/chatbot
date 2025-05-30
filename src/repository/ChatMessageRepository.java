package com.chatbot.spring.repository;

import com.example.chatbot.model.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
    
    // Custom query methods
    List<ChatMessage> findTop10ByOrderByCreatedAtDesc();
    
    @Query("SELECT m FROM ChatMessage m WHERE m.sender = ?1 ORDER BY m.createdAt DESC")
    List<ChatMessage> findMessagesBySender(String sender);
}