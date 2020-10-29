package se.ifmo.ru.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.ifmo.ru.entities.Entry;
import se.ifmo.ru.services.EntryService;
import se.ifmo.ru.services.UserService;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/main")
public class MainPageController {

    @Autowired
    private EntryService entryService;
    @Autowired
    private UserService userService;

    @GetMapping
    public Collection<Entry> getAllEntries(){
        return entryService.getAllEntries();
    }

    @PostMapping
    public void checkAddHit(@RequestParam("x") double x, @RequestParam("y") double y, @RequestParam("r") double r, Principal principal){
        long userID = userService.getIDByUsername(principal.getName());

        if(userID!=-1) entryService.addEntry(x,y,r,userID);
        //TODO else
    }

    @DeleteMapping
    public void deleteAllEntriesByID(Principal principal){
        long userID = userService.getIDByUsername(principal.getName());

        if(userID!=-1) entryService.deleteAllClientEntries(userID);
        //TODO else
    }

}
