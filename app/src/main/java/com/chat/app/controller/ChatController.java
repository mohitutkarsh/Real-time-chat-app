package com.chat.app.controller;

import com.chat.app.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ChatController {

    @MessageMapping("/sendMessage") //maps websocket message to the destination(endpoint)
    @SendTo("/topic/messages") /*return of the below message is sent to a particulat chat(endpoint)
                                    person receving message should be a subscriber of("/topic/messages")*/
    public ChatMessage sendMessage(ChatMessage message)
    {
        return message;
    }

    @GetMapping("chat")
    public String chat(){
        return "chat";
    }
}
