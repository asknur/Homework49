package kg.attractor.demo.controller.api;


import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import kg.attractor.demo.dto.UserDto;
import kg.attractor.demo.model.User;
import kg.attractor.demo.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("userProfile")
@RequestMapping("/api/profile")
@RequiredArgsConstructor

public class UserController {
    private final UserServiceImpl userService;


    public List<User> getUser() {
        return userService.getUsers();
    }

    @PostMapping
    public User createUser(@Valid @RequestBody UserDto user) {
        return userService.createUser(user);
    }

    @GetMapping("/username/{name}")
    public List<User> getUserByName(@PathVariable String name) {
        return userService.findByName(name);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @GetMapping("/employer/{id}")
    public ResponseEntity<User> getEmployer(@PathVariable int id){
        User user = userService.getUserById(id);
        if ("employer".equalsIgnoreCase(user.getAccount_type())) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @GetMapping("/applicant/{id}")
    public ResponseEntity<User> getApplicant(@PathVariable int id){
        User user = userService.getUserById(id);
        if ("applicant".equalsIgnoreCase(user.getAccount_type())) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
