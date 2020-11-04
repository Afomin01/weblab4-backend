package se.ifmo.ru.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.ifmo.ru.entities.Entry;
import se.ifmo.ru.entities.User;
import se.ifmo.ru.services.EntryService;
import se.ifmo.ru.services.UserService;

import java.security.Principal;
import java.util.Collection;

@RestController
@RequestMapping("/entries")
public class EntriesController {

    @Autowired
    private EntryService entryService;
    @Autowired
    private UserService userService;

    @GetMapping
    public Collection<Entry> getUserEntries(Principal principal) {
        User user = userService.getByUsername(principal.getName());
        return entryService.getUserEntries(user);
    }

    @PostMapping
    public String addEntry(@RequestParam("x") double x, @RequestParam("y") double y, @RequestParam("r") double r,
                         Principal principal) {
        User user = userService.getByUsername(principal.getName());

        entryService.addEntry(x, y, r, user);
        return "successfully added";
    }

    @DeleteMapping
    public String deleteUserEntries(Principal principal){
        User user = userService.getByUsername(principal.getName());

        entryService.deleteUserEntries(user);
        return "successfully removed";
    }

}
