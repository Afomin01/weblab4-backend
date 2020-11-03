package se.ifmo.ru.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import se.ifmo.ru.entities.Role;
import se.ifmo.ru.entities.User;
import se.ifmo.ru.repositories.UserRepository;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public void addUser(User user) {
        user.setRoles(Collections.singletonList(new Role(1L, "USER")));
        userRepository.save(user);
    }

    public long getIDByUsername(String username){
        User user = userRepository.findByUsername(username);
        if (user == null) {
            return -1;
        }

        return user.getId();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }
}
