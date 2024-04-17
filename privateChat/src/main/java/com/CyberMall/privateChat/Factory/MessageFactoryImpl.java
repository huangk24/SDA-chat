package com.CyberMall.privateChat.Factory;

import com.CyberMall.privateChat.Model.Message;
import com.CyberMall.privateChat.Model.ImageMessage;
import com.CyberMall.privateChat.Model.TextMessage;
import org.springframework.stereotype.Service;

@Service
public class MessageFactoryImpl implements MessageFactory {
    @Override
    public Message createTextMessage(Integer senderId, Integer receiverId, String text) {
        return new TextMessage(senderId, receiverId, text);
    }

    @Override
    public Message createImageMessage(Integer senderId, Integer receiverId, String imageUrl, String messageType) {
        return new ImageMessage(senderId, receiverId, imageUrl, messageType);
    }
}

