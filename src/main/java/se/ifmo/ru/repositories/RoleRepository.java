package se.ifmo.ru.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.ifmo.ru.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
