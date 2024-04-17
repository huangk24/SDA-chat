package com.CyberMall.privateChat.Repository;

import com.CyberMall.privateChat.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User,Integer> {

    User findByUserId(Integer userId);
    User findByUsername(String username);

}
