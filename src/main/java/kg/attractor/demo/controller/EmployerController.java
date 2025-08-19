package kg.attractor.demo.controller;

import kg.attractor.demo.service.UserService;
import kg.attractor.demo.service.impl.ResumeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employer")
@RequiredArgsConstructor
public class EmployerController {
    private final UserService userService;
    private final ResumeServiceImpl resumeService;

    @GetMapping("/resumes")
    public String resumes(Model model) {
        model.addAttribute("resumes", resumeService.getAllResumes());
        return "resume";
    }

}
