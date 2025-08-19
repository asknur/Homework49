package kg.attractor.demo.controller;


import kg.attractor.demo.service.impl.VacancyServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
@RequiredArgsConstructor
public class MainController {
    private final VacancyServiceImpl vacancyService;

    @GetMapping
    public String showMainPage(Model model) {
        model.addAttribute("vacancylist", vacancyService.getAllVacancies());
        return "main";
    }

}


