package se.ifmo.ru.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.ifmo.ru.entities.Entry;

@Repository
public interface EntriesCrudRepository extends CrudRepository<Entry, Long> {
}
