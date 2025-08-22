package kg.attractor.demo.controller;


import kg.attractor.demo.model.User;
import kg.attractor.demo.service.ResumeService;
import kg.attractor.demo.service.UserService;
import kg.attractor.demo.service.impl.VacancyServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("")
@RequiredArgsConstructor
public class MainController {
    private final VacancyServiceImpl vacancyService;
    private final ResumeService resumeService;
    private final UserService userService;

    @GetMapping
    public String showMainPage(Model model, Principal principal) {
        if (principal != null) {
            String email = principal.getName();
            User user = userService.getByEmail(email);
            model.addAttribute("user", user);
        }

        model.addAttribute("vacancylist", vacancyService.getAllVacancies());
        model.addAttribute("resumelist", resumeService.getAllResumes());
        return "main";
    }

    @GetMapping("sorted-vacancies")
    public String getSortedVacancies(Pageable pageable, Model model) {
        model.addAttribute("vacancylist", vacancyService.getAllSortedAndPagedVacancies(pageable));
        return "main";
    }

    @GetMapping("sorted-resumes")
    public String getSortedResumes(Pageable pageable, Model model) {
        model.addAttribute("resumelist", resumeService.getAllSortedAndPagedVacancies(pageable));
        return "main";
    }


}


