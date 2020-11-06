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
    void login() {
    }

    @PostMapping("/signup")
    ResponseEntity<String> signUp(@RequestBody UserDTO userDTO) {
        if(!userService.doesUserExist(userDTO.getUsername())) {
            if(userDTO.getPassword().length()<5)
                return new ResponseEntity<>("Password must be at least 5 symbols long", HttpStatus.UNPROCESSABLE_ENTITY);
            else if(userDTO.getUsername().length()<5)
                return new ResponseEntity<>("Login must be at least 5 symbols long", HttpStatus.UNPROCESSABLE_ENTITY);
            else if(userDTO.getUsername().matches("[^a-z[0-9]]"))
                return new ResponseEntity<>("Login can contain only latin symbols and digits", HttpStatus.UNPROCESSABLE_ENTITY);

            User user = new User(userDTO.getUsername(), userDTO.getPassword());
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            if(userService.addUser(user)!=null)
                return new ResponseEntity<>("Registered", HttpStatus.CREATED);
            else
                return new ResponseEntity<>("User was not created", HttpStatus.I_AM_A_TEAPOT);

        }else return new ResponseEntity<>("This username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
