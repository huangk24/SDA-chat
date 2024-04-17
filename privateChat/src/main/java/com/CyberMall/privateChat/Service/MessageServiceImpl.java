package com.CyberMall.privateChat.Service;

import com.CyberMall.privateChat.Model.Message;
import com.CyberMall.privateChat.Factory.MessageFactory;
import com.CyberMall.privateChat.Repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepo messageRepo;
    @Autowired
    private MessageFactory messageFactory;



    @Override
    public Message createMessage(Integer senderId, Integer receiverId, String message) {
        Message messageObject;
        //System.out.println("The message type is: " + messageType);
        //if ("text".equalsIgnoreCase(messageType)) {
        //    System.out.println("The text message type is: " + messageType);
            messageObject = messageFactory.createTextMessage(senderId, receiverId, message);
        //} else if ("image".equalsIgnoreCase(messageType)) {
        //    System.out.println("The image message type is: " + messageType);
        //    messageObject = messageFactory.createImageMessage(senderId, receiverId, message, messageType);
        //} else {
        //    throw new IllegalArgumentException("Unsupported message type: " + messageType);
        //}
        return messageRepo.save(messageObject);
    }

    @Override
    public Message createMessage(Integer senderId, Integer receiverId, String message, String messageType) {
        return null;
    }


    @Override
    public List<Message> getAllMessages() {
        return messageRepo.findAll();
    }

    @Override
    public List<Message> getMessagesBySenderAndReceiver(Integer senderId, Integer receiverId) {
        List<Message> messagesFromSenderToReceiver = messageRepo.findBySenderIdAndReceiverId(senderId, receiverId);
        List<Message> messagesFromReceiverToSender = messageRepo.findBySenderIdAndReceiverId(receiverId, senderId);

        List<Message> allMessages = new ArrayList<>();
        allMessages.addAll(messagesFromSenderToReceiver);
        allMessages.addAll(messagesFromReceiverToSender);

        return allMessages;
    }
}