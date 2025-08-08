package kg.attractor.demo.controller;

import kg.attractor.demo.model.Resume;
import kg.attractor.demo.service.impl.ResumeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/resume")
@RequiredArgsConstructor

public class ResumeController {
    private final ResumeServiceImpl resumeService;

    @GetMapping
    public String listResume(Model model) {
        model.addAttribute("resumes", resumeService.findAll());
        return "resume";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("resumes", new Resume());
        return "resume-create";
    }

    @PostMapping("/create")
    public String createResume(Resume resume) {
        resumeService.save(resume);
        return "redirect:/resume";
    }

    @GetMapping("/edit/{id}")
    public String editForm(Model model, @PathVariable Integer id) {
        model.addAttribute("resumes", resumeService.findAll());
        return "resume-edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(Resume resume) {
        resumeService.save(resume);
        return "redirect:/resume";
    }



}
