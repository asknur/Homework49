package kg.attractor.demo.controller;

import jakarta.validation.Valid;
import kg.attractor.demo.dto.VacancyDto;
import kg.attractor.demo.model.Vacancy;
import kg.attractor.demo.repository.VacancyRepository;
import kg.attractor.demo.service.impl.VacancyServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/vacancy")
@RequiredArgsConstructor
public class VacancyController {
    private final VacancyServiceImpl vacancyService;
    private final VacancyRepository vacancyRepository;

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
    public String createVacancy(@Valid VacancyDto vacancyDto, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            vacancyService.createVacancy(vacancyDto);
            return "redirect:/";
        }
        model.addAttribute("vacancyDto", vacancyDto);
        return "vacancy-create";
    }

    @GetMapping("/edit/{id}")
    public String editVacancy(Model model, @PathVariable int id) {
        model.addAttribute("vacancies", List.of(vacancyService.getById(id)));
        return "vacancy-edit";
    }

    @PostMapping("/edit/{id}")
    public String updateVacancy(@Valid VacancyDto vacancyDto, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            vacancyService.save(vacancyDto);
            return "redirect:/";
        }
        model.addAttribute("vacancyDto", vacancyDto);
        return "vacancy-edit";
    }

    @GetMapping("sorted")
    public Page<Vacancy> getSortedVacancies(
            @RequestParam(name = "page", defaultValue = "0") int pageNumber,
            @RequestParam(name= "size", defaultValue = "5") int pageSize){
        var sort = Sort.by(Sort.Direction.DESC, "created_date");
        var pageRequest = PageRequest.of(pageNumber, pageSize, sort);
        return vacancyRepository.findAll(pageRequest);

    }
}
