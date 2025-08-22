
package kg.attractor.demo.controller;

import jakarta.validation.Valid;
import kg.attractor.demo.dto.UserDto;
import kg.attractor.demo.dto.VacancyDto;
import kg.attractor.demo.model.User;
import kg.attractor.demo.model.Vacancy;
import kg.attractor.demo.service.ImageService;
import kg.attractor.demo.service.UserService;
import kg.attractor.demo.service.impl.ResumeServiceImpl;
import kg.attractor.demo.service.impl.VacancyServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/profile")
@RequiredArgsConstructor
public class ProfileController {
    private final UserService userService;
    private final ResumeServiceImpl  resumeService;
    private final VacancyServiceImpl vacancyService;
    private final ImageService imageService;

    @GetMapping
    public String showProfile(Model model, Principal principal) {
        String email = principal.getName();
        User user = userService.getByEmail(email);
        model.addAttribute("user", user);
        return "profile";
    }

    @GetMapping("/profile-resume")
    public String showResume(Model model) {
        model.addAttribute("resumes", resumeService.getAllResumes());
        return "profile";
    }

    @GetMapping("/profile-vacancy")
    public String showVacancies(int id ,Model model) {
        model.addAttribute("vacancies", vacancyService.getAllVacancies());
        return "profile";
    }

    @GetMapping("/edit")
    public String editProfileForm(Model model, Principal principal) {
        String email = principal.getName();
        User user = userService.getByEmail(email);
        model.addAttribute("user", user);
        return "profile-edit";
    }

    @PostMapping("/edit")
    public String updateProfile(@Valid UserDto userDto, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            userService.save(userDto);
            model.addAttribute("users", userDto);
            return "redirect:/";
        }
        model.addAttribute("usersDto", userDto);
        return "profile-edit";
    }

    @PostMapping("/photo")
    public String uploadPhoto(@Valid UserDto userDto, BindingResult bindingResult, Model model, @RequestParam("avatarFile") MultipartFile avatarFile) {
        if (bindingResult.hasErrors()) {
            return "profile-edit";
        }
        if (avatarFile.isEmpty()) {
            String file = imageService.saveUploadedFile(avatarFile, "avatars");
        }
        userService.save(userDto);
        return "redirect:/profile";
    }


}
