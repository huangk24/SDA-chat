package com.CyberMall.privateChat.Repository;

import com.CyberMall.privateChat.Model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface MessageRepo extends MongoRepository<Message, Integer> {
    List<Message> findBySenderIdAndReceiverId(Integer senderId, Integer receiverId);

}
