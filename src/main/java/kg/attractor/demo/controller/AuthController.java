package kg.attractor.demo.controller;

import kg.attractor.demo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    @GetMapping("/register")
    public String register(Model model) {
        return "auth/register";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "auth/login";
    }



}
