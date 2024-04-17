package com.CyberMall.privateChat.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Date;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chat {

    public static final String SEQUENCE_NAME = "chat_sequence";

    @Id
    private String messageId;
    private Integer senderId;
    private Integer receiverId;
    private String messageType;
    private Message message;
    private Date timestamp;


    public Chat(Integer senderId, Integer receiverId, Message message) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.messageType = message.getType();
        this.message = message;
        this.timestamp = new Date();
    }

    public String getId() {
        return messageId;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public Message getMessage() { // Update the return type of getMessage to be Message
        return message;
    }

    public void setMessage(Message message) { // Update the parameter type to be Message
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "messageId='" + messageId + '\'' +
                ", senderId=" + senderId +
                ", receiverId=" + receiverId +
                ", message=" + message +
                ", timestamp=" + timestamp +
                '}';
    }
}
