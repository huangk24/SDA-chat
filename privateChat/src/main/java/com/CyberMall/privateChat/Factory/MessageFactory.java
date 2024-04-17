package com.CyberMall.privateChat.Factory;
import com.CyberMall.privateChat.Model.Message;

public interface MessageFactory {
    Message createTextMessage(Integer senderId, Integer receiverId, String text);
    Message createImageMessage(Integer senderId, Integer receiverId, String imageUrl, String messageType);
}
