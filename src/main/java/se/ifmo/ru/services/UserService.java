package se.ifmo.ru.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import se.ifmo.ru.entities.User;
import se.ifmo.ru.repositories.UsersCrudRepository;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UsersCrudRepository usersCrudRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersCrudRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }
}
