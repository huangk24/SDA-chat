package com.CyberMall.privateChat.Controller;

import com.CyberMall.privateChat.Model.Message;
import com.CyberMall.privateChat.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping
    public Message createMessage(
            //public Map<String, Object> createMessage(
            @RequestBody Message message) {
        System.out.println(message.getSenderId());
        System.out.println(message.getReceiverId());
        System.out.println(message.getContent());
        System.out.println("The message object is: " + message.toString());
        //System.out.println("The type in message object is: " + message.getType());
        return messageService.createMessage(
                message.getSenderId(),
                message.getReceiverId(),
                message.getContent()
        );
    }

    @GetMapping
    public List<Message> getAllMessages() {
        return messageService.getAllMessages();
    }

    @GetMapping("/{senderId}/{receiverId}")
    public List<Message> getMessagesBySenderAndReceiver(
            @PathVariable Integer senderId,
            @PathVariable Integer receiverId
    ) {
        return messageService.getMessagesBySenderAndReceiver(senderId, receiverId);
    }

}
