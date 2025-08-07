package kg.attractor.demo.service;

import jakarta.validation.Valid;
import kg.attractor.demo.dto.UserDto;
import kg.attractor.demo.model.User;


import java.util.List;

public interface UserService {
    void register(UserDto userDto);

    String login(@Valid UserDto user);

    List<User> getUsers();

    User getUserById(int id);

    List<User> findByName(String username);

    User createUser(UserDto user);

    User save(User user);

}
