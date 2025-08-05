package kg.attractor.demo.service.impl;

import jakarta.validation.Valid;
import kg.attractor.demo.dto.UserDto;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl {
    public String login(@Valid UserDto user) {
        return "Login successfully";
    }
}
