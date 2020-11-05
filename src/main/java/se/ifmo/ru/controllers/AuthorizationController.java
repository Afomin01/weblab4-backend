package se.ifmo.ru.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import se.ifmo.ru.DTO.UserDTO;
import se.ifmo.ru.entities.User;
import se.ifmo.ru.services.UserService;

@RestController
@RequestMapping("/authorization")
public class AuthorizationController {
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/signin")
    public void login() {
    }

    @PostMapping("/signup")
    ResponseEntity<String> signUp(@RequestBody UserDTO userDTO) {
        if(!userService.doesUserExist(userDTO.getUsername())) {
            User user = new User(userDTO.getUsername(), userDTO.getPassword());
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userService.addUser(user);
            return new ResponseEntity<>("Registered", HttpStatus.CREATED);
        }else return new ResponseEntity<>("This username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
