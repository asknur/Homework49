package kg.attractor.demo.controller;

import kg.attractor.demo.model.Vacancy;
import kg.attractor.demo.service.impl.VacancyServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vacancy")
@RequiredArgsConstructor
public class VacancyController {
    private final VacancyServiceImpl vacancyService;

    @GetMapping
    public String listVacancies(Model model) {
        model.addAttribute("vacancies", vacancyService.getAllVacancies());
        return "vacancy";
    }

    @GetMapping("/create")
    public String createVacancy(Model model) {
        model.addAttribute("vacancies", new Vacancy());
        return "vacancy-create";
    }

    @PostMapping("/create")
    public String createVacancy(Vacancy vacancy) {
        vacancyService.createVacancy(vacancy);
        return "redirect:/vacancy";
    }

    @GetMapping("/edit/{id}")
    public String editVacancy(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("vacancies", vacancyService.getById(id));
        return "vacancy-edit";
    }

    @PostMapping("/edit/{id}")
    public String updateVacancy(Vacancy vacancy) {
        vacancyService.save(vacancy);
        return "redirect:/vacancy";
    }
}
