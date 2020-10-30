package com.yuriysurzhikov.gidassistant.controllers.user;

import com.yuriysurzhikov.gidassistant.model.client.UserFromClient;
import com.yuriysurzhikov.gidassistant.utils.tasks.TaskCallbacks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserFromClient user) {
        userService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
