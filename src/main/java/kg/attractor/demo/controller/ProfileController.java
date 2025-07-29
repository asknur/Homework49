package kg.attractor.demo.controller;


import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import kg.attractor.demo.model.User;
import kg.attractor.demo.service.impl.ProfileServiceImpl;
import kg.attractor.demo.service.impl.ResumeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
@RequiredArgsConstructor

public class ProfileController {
    private final ProfileServiceImpl profileService;
    private final JdbcTemplate jdbcTemplate;
    private final PasswordEncoder encoder;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid User user) {
        String hashedPassword = encoder.encode(user.getPassword());

        jdbcTemplate.update("INSERT INTO users(email, name, password, account_type, enabled) VALUES (?, ?, ?, ?, ?)",
                user.getEmail(), user.getName(), hashedPassword, user.getAccount_type(), true);

        jdbcTemplate.update("INSERT INTO authorities(user_id, authority) VALUES ((SELECT id FROM users WHERE email = ?), ?)",
                user.getEmail(), "FULL");

        return ResponseEntity.ok("Registered");
    }

}
