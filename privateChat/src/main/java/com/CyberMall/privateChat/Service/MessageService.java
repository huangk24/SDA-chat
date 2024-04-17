package com.CyberMall.privateChat.Service;

import com.CyberMall.privateChat.Model.Message;

import java.util.List;

public interface MessageService {
    Message createMessage(Integer senderId, Integer receiverId, String message);

    Message createMessage(Integer senderId, Integer receiverId, String message, String messageType);

    List<Message> getAllMessages();
    List<Message> getMessagesBySenderAndReceiver(Integer senderId, Integer receiverId);
}
