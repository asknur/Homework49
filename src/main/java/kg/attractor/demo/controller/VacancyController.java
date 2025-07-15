package kg.attractor.demo.controller;

import kg.attractor.demo.model.Vacancy;
import kg.attractor.demo.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacancies")
@RequiredArgsConstructor

public class VacancyController {
    private final VacancyService vacancyService;

    @PostMapping
    public ResponseEntity<Vacancy> createVacancy(@RequestBody Vacancy vacancy) {
        return new ResponseEntity<>(vacancyService.save(vacancy), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vacancy> updateVacancy(@PathVariable int id, @RequestBody Vacancy vacancy) {
        vacancy.setId(id);
        return new ResponseEntity<>(vacancyService.save(vacancy), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVacancy(@PathVariable int id) {
        vacancyService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<Vacancy>> getAllVacancies() {
        return new ResponseEntity<>(vacancyService.findByTrue(), HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Vacancy>> getVacanciesByCategory(@PathVariable int categoryId) {
        return new ResponseEntity<>(vacancyService.findCategoryIdAndTrue(categoryId), HttpStatus.OK);
    }

    @PostMapping("/{id}/respond")
    public ResponseEntity<String> respondToVacancy(@PathVariable int id, @RequestParam int resumeId) {
        return new ResponseEntity<>("Отклик на вакансию " + id + " сохранён", HttpStatus.OK);
    }

    @GetMapping("/{id}/applicants")
    public ResponseEntity<String> getApplicants(@PathVariable int id) {
        return new ResponseEntity<>("Список соискателей на вакансию " + id, HttpStatus.OK);
    }

}
