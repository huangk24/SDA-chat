package com.CyberMall.privateChat.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

import java.util.Date;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ImageMessage implements Message {

    public static final String SEQUENCE_NAME = "message_sequence";

    @Id
    private String messageId;
    private Integer senderId;
    private Integer receiverId;
    private String messageType;
    private String content;
    @Getter
    private Date timestamp;

    // Constructors
    public ImageMessage(Integer senderId, Integer receiverId, String content, String messageType) {
        this.senderId = senderId;
        this.receiverId = receiverId;
        this.messageType = messageType;
        this.content = content;
        this.timestamp = new Date();
    }

    // Message interface methods
    @Override
    public String getContent() {
        return content;
    }

    @Override
    public String getType() {
        return messageType;
    }
}
