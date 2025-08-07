package kg.attractor.demo.controller;

import jakarta.validation.Valid;
import kg.attractor.demo.dto.UserDto;
import kg.attractor.demo.service.UserService;
import kg.attractor.demo.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserServiceImpl userService;
    private final PasswordEncoder encoder;
    private final JdbcTemplate jdbcTemplate;



    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid UserDto user) {
        String log = userService.login(user);
        return ResponseEntity.ok(log);
    }
}
