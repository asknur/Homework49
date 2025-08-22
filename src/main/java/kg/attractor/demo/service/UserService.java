package kg.attractor.demo.service;

import jakarta.validation.Valid;
import kg.attractor.demo.dto.UserDto;
import kg.attractor.demo.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;


import java.util.List;

public interface UserService extends UserDetailsService {
    void register(UserDto userDto);

    String login(@Valid UserDto user);

    List<User> getUsers();

    User getUserById(int id);

    List<User> findByName(String username);

    public User getByEmail(String email);

    User createUser(UserDto user);

    User save(UserDto userDto);

}