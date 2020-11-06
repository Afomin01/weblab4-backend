package se.ifmo.ru.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import se.ifmo.ru.entities.Role;
import se.ifmo.ru.entities.User;
import se.ifmo.ru.repositories.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        user.setRoles(Arrays.asList(new Role(1L, "ROLE_USER")));
        return userRepository.save(user);
    }

    public boolean doesUserExist(String username){
        return userRepository.countAllByUsername(username) != 0;
    }

    public User getUserByName(String username){
        return userRepository.findByUsername(username);
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
