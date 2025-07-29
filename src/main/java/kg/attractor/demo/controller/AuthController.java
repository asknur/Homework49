package kg.attractor.demo.controller;

import jakarta.validation.Valid;
import kg.attractor.demo.dto.UserDto;
import kg.attractor.demo.model.User;
import kg.attractor.demo.service.UserService;
import kg.attractor.demo.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @GetMapping("username/{name}")
    public List<User> getUsersByName(@PathVariable String name) {
        return userService.findByName(name);
    }

    @PostMapping
    public User createUser(@RequestBody @Valid UserDto user) {
        return userService.createUser(user);
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody @Valid User user) {
        user.setAccount_type(user.getAccount_type());
        return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
    }

    @GetMapping("/employer/{id}")
    public ResponseEntity<User> getEmployer(@PathVariable int id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);

    }

    @GetMapping("/applicant/{id}")
    public ResponseEntity<User> getApplicant(@PathVariable int id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

}
