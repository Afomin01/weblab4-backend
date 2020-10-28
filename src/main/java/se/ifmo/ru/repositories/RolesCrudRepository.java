package se.ifmo.ru.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.ifmo.ru.entities.Role;

@Repository
public interface RolesCrudRepository extends CrudRepository<Role, Long> {
}
