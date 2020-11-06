package com.yuriysurzhikov.gidassistant.controllers.user;

import com.yuriysurzhikov.gidassistant.model.client.UserFromClient;
import com.yuriysurzhikov.gidassistant.model.login.LogoutSessionData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody UserFromClient user) {
        user.setServerId(userService.registerUser(user).component2());
        return login(user);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody UserFromClient user) {
        return new ResponseEntity<>(userService.loginUser(user), HttpStatus.OK);
    }

    @DeleteMapping("/logout")
    public ResponseEntity<?> logout(@RequestBody LogoutSessionData logoutData) {
        if (userService.logoutUser(logoutData))
            return new ResponseEntity<>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
