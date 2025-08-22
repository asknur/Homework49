package kg.attractor.demo.controller;

import jakarta.validation.Valid;
import kg.attractor.demo.dto.ResumeDto;
import kg.attractor.demo.model.User;
import kg.attractor.demo.service.UserService;
import kg.attractor.demo.service.impl.ResumeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/resume")
@RequiredArgsConstructor

public class ResumeController {
    private final ResumeServiceImpl resumeService;
    private final UserService userService;

    @GetMapping
    public String listResume(Model model) {
        model.addAttribute("resumes", resumeService.getAllResumes());
        return "resume";
    }

    @GetMapping("{resumeId}")
    public String getResume(@PathVariable int resumeId, Model model) {
        model.addAttribute("resumes", resumeService.getById(resumeId));
        return "resume";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("resumeDto", new ResumeDto());
        return "resume-create";
    }

    @PostMapping("/create")
    public String createResume(@Valid ResumeDto resumeDto, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            resumeService.createResume(resumeDto);
            return "redirect:/";
        }
        model.addAttribute("resumeDto",  resumeDto);
        return "resume-create";

    }

    @GetMapping("/edit/{id}")
    public String editForm(Model model, @PathVariable int id) {
        model.addAttribute("resumes", List.of(resumeService.getById(id)));
        return "resume-edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@Valid ResumeDto resumeDto, BindingResult bindingResult, Model model, @PathVariable String id) {
        if (!bindingResult.hasErrors()) {
            resumeService.save(resumeDto);
            return "redirect:/";
        }
        model.addAttribute("resumeDto",  resumeDto);
        return "resume-edit";
    }

    @GetMapping("sorted")
    public String getSortedResumes(Pageable pageable, Model model) {
        model.addAttribute("resumes", resumeService.getAllSortedAndPagedVacancies(pageable));
        return "resume";
    }

}
