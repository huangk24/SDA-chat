package com.CyberMall.privateChat.Controller;

import com.CyberMall.privateChat.Model.User;
import com.CyberMall.privateChat.Repository.UserRepo;
import com.CyberMall.privateChat.Service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserRepo userRepo;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @PostMapping("/addUser")
    public void addUser(@RequestBody User user) {
        // Generate unique user ID
        int userId = sequenceGeneratorService.generateSequence(User.SEQUENCE_NAME);
        user.setUserId(userId);

        // Check if the user already exists
        User existingUser = userRepo.findByUsername(user.getUsername());
        if (existingUser != null) {
            throw new RuntimeException("User already exists");
        }
        userRepo.save(user);
    }

    @GetMapping("/users/id/{userId}")
    public User getUserByUserId(@PathVariable Integer userId) {
        return userRepo.findByUserId(userId);
    }

    @GetMapping("/users/username/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userRepo.findByUsername(username);
    }


    @PutMapping("/users/updateUsername/{userId}")
    public User updateUsername(@PathVariable Integer userId, @RequestBody String newUsername) {
        User user = userRepo.findByUserId(userId);
        if (user == null) {
            throw new RuntimeException("User not found with id: " + userId);
        }
        user.setUsername(newUsername);
        return userRepo.save(user);
    }

    @PutMapping("/users/updateUserRole/{userId}")
    public User updateUserRole(@PathVariable Integer userId, @RequestBody String newUserRole) {
        User user = userRepo.findByUserId(userId);
        if (user == null) {
            throw new RuntimeException("User not found with id: " + userId);
        }
        user.setRole(newUserRole);
        return userRepo.save(user);
    }
}
