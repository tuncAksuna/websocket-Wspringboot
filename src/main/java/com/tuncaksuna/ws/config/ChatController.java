package com.tuncaksuna.ws.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin
public class ChatController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat")
    // @SendTo("/topic") is sent everyone
    // @SendToUser to spesific user
    public void sendMessageToEndpoint(@Payload Message message) {

        System.out.println(message);
        messagingTemplate.convertAndSend("/topic", message);
    }
}
