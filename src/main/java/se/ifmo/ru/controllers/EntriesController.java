package se.ifmo.ru.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.ifmo.ru.DTO.EntryDTO;
import se.ifmo.ru.entities.Entry;
import se.ifmo.ru.entities.User;
import se.ifmo.ru.repositories.EntryRepository;
import se.ifmo.ru.services.UserService;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.Collection;

@RestController
@RequestMapping("/entries")
public class EntriesController {

    @Autowired
    private UserService userService;

    @Autowired
    private EntryRepository entryRepository;

    @GetMapping
    Collection<Entry> getUserEntries(Principal principal) {
        User user = userService.getUserByName(principal.getName());
        return entryRepository.findByUser(user);
    }

    @GetMapping("/{id}")
    Entry getEntryById(@PathVariable long id){
        return entryRepository.getOne(id);
    }

    @PostMapping
    Entry addEntry(@RequestBody EntryDTO entryDTO, Principal principal) {
        User user = userService.getUserByName(principal.getName());

        Entry entry = new Entry(entryDTO.getX(), entryDTO.getY(), entryDTO.getR(), user);

        return entryRepository.save(entry);
    }


    @DeleteMapping
    void deleteUserEntries(Principal principal){
        User user = userService.getUserByName(principal.getName());

        entryRepository.deleteByUser(user);
    }

}
