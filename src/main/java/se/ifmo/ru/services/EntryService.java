package se.ifmo.ru.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.ifmo.ru.entities.Entry;
import se.ifmo.ru.entities.User;
import se.ifmo.ru.repositories.EntryRepository;

import java.util.List;

@Service
public class EntryService {

    @Autowired
    EntryRepository entryRepository;

    public void addEntry(double x, double y, double r, User user){
        Entry entry = new Entry(x, y, r, user);

        entryRepository.save(entry);
    }

    public List<Entry> getUserEntries(User user){
        return entryRepository.findByUser(user);
    }

    @Transactional
    public void deleteUserEntries(User user) {
        entryRepository.deleteByUser(user);
    }
}
