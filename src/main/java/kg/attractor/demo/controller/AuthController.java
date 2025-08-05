package kg.attractor.demo.controller;

import jakarta.validation.Valid;
import kg.attractor.demo.dto.UserDto;
import kg.attractor.demo.model.User;
import kg.attractor.demo.service.UserService;
import kg.attractor.demo.service.impl.AuthServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;
    private final AuthServiceImpl authService;
    private final PasswordEncoder encoder;
    private final JdbcTemplate jdbcTemplate;

    @PostMapping("/register")
    public ResponseEntity<String> register(@io.swagger.v3.oas.annotations.parameters.RequestBody @Valid User user) {
        String hashedPassword = encoder.encode(user.getPassword());

        jdbcTemplate.update("INSERT INTO users(email, name, password, account_type, enabled) VALUES (?, ?, ?, ?, ?)",
                user.getEmail(), user.getName(), hashedPassword, user.getAccount_type(), true);

        jdbcTemplate.update("INSERT INTO authorities(user_id, authority) VALUES ((SELECT id FROM users WHERE email = ?), ?)",
                user.getEmail(), "FULL");

        return ResponseEntity.ok("Registered");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid UserDto user) {
        String log = authService.login(user);
        return ResponseEntity.ok(log);
    }
}
