package se.ifmo.ru.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.ifmo.ru.entities.Entry;
import se.ifmo.ru.entities.User;
import se.ifmo.ru.repositories.EntryRepository;
import se.ifmo.ru.repositories.UserRepository;

import java.util.Collection;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntryRepository entryRepository;

    @GetMapping("/users")
    Collection<User> getUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/entries")
    Collection<Entry> getEntries(){
        return entryRepository.findAll();
    }

    @DeleteMapping("/users/{id}")
    void deleteUserById(@PathVariable long id){
        entryRepository.deleteByUser(userRepository.getOne(id));
        userRepository.deleteById(id);
    }

    @DeleteMapping("/entries/{id}")
    void deleteEntryById(@PathVariable long id){
        entryRepository.deleteById(id);
    }
}
