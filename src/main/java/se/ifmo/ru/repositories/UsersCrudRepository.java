package se.ifmo.ru.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.ifmo.ru.entities.Entry;
import se.ifmo.ru.entities.User;

@Repository
public interface UsersCrudRepository extends CrudRepository<User, Long> {
}