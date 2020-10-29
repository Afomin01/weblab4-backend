package se.ifmo.ru.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.ifmo.ru.entities.Entry;
import se.ifmo.ru.repositories.EntryRepository;

import java.util.List;

@Service
public class EntryService {

    @Autowired
    EntryRepository entryRepository;

    public void addEntry(double x, double y, double r, long clientID){
        Entry entry = new Entry(x,y,r,clientID);

        entryRepository.save(entry);
    }

    public List<Entry> getAllEntries(){
        return entryRepository.findAll();
    }

    public void deleteAllClientEntries(long userID){
        entryRepository.deleteAllByUserID(userID);
    }
}
