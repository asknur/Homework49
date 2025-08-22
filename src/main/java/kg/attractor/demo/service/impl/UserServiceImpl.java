package kg.attractor.demo.service.impl;


import kg.attractor.demo.dto.UserDto;
import kg.attractor.demo.exceptions.UserNotFoundException;
import kg.attractor.demo.model.User;
import kg.attractor.demo.repository.UserRepository;
import kg.attractor.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    //    private final UserDao userDao;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;



    @Override
    public void register(UserDto userDto) {
        log.info("Registering user: {}", userDto);
        User user = User.builder()
                .name(userDto.getName())
                .email(userDto.getEmail())
                .password(encoder.encode(userDto.getPassword()))
                .build();
        userRepository.save(user);
    }

    @Override
    public String login(UserDto user) {
        log.info("Logging user: {}", user);
        User foundUser = userRepository.findByEmail(user.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!encoder.matches(user.getPassword(), foundUser.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        return "Logged in successfully";
    }

    @Override
    public List<User> getUsers() {
        log.info("Getting users");
        return userRepository.findAll();
    }

    @Override
    public User getUserById(int id) {
        log.info("Getting user by id: {}", id);
        return userRepository.findById((long)id)
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public List<User> findByName(String name) {
        log.info("Finding user by name: {}", name);
        return userRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public User getByEmail(String email) {
        log.info("Finding user by email: {}", email);
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
    }


    @Override
    public User createUser(UserDto user) {
        log.info("Creating user: {}", user);
        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(encoder.encode(user.getPassword()));
        return userRepository.save(newUser);
    }

    @Override
    public User save(UserDto userDto) {
        log.info("Saving user: {}", userDto);
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(encoder.encode(userDto.getPassword()));
        return userRepository.save(user);
    }

}