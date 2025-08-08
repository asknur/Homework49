package kg.attractor.demo.controller;

import kg.attractor.demo.model.User;
import kg.attractor.demo.service.UserService;
import kg.attractor.demo.service.impl.ResumeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {
    private final UserService userService;
    private final ResumeServiceImpl  resumeService;

    @GetMapping
    public String showProfile(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "profile";
    }

    @GetMapping("/edit")
    public String editProfileForm(Model model, User user) {
        model.addAttribute("users", userService.getByEmail(user.getEmail()));
        return "profile-edit";
    }

    @PostMapping("/edit")
    public String updateProfile(@ModelAttribute("users") User user) {
        userService.save(user);
        return "redirect:/profile";
    }
}
