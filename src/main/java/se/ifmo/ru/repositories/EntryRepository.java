package se.ifmo.ru.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.ifmo.ru.entities.Entry;
import se.ifmo.ru.entities.User;

import java.util.List;
import java.util.Set;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Long> {
    List<Entry> findByUser(User user);
    long deleteByUser(User user);
}
