package kg.attractor.demo.service.impl;

import jakarta.persistence.EntityNotFoundException;

import kg.attractor.demo.dto.VacancyDto;
import kg.attractor.demo.model.User;
import kg.attractor.demo.model.Vacancy;
import kg.attractor.demo.repository.VacancyRepository;
import kg.attractor.demo.service.VacancyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class VacancyServiceImpl implements VacancyService {
    //    private final VacancyDao vacancyDao;
    private final VacancyRepository vacancyRepository;

    @Override
    public Vacancy createVacancy(VacancyDto vacancyDto) {
        log.info("Creating Vacancy: {}", vacancyDto);
        Vacancy vacancy = new Vacancy();
        vacancy.setName(vacancyDto.getName());
        vacancy.setDescription(vacancyDto.getDescription());
        vacancy.setCreatedDate(vacancyDto.getCreated_date());
        vacancy.setSalary(vacancyDto.getSalary());
        return vacancyRepository.save(vacancy);
    }

    @Override
    public Vacancy save(VacancyDto vacancyDto) {
        log.info("Saving vacancy: {}", vacancyDto.getName());
        Vacancy vacancy = new Vacancy();
        vacancy.setName(vacancyDto.getName());
        vacancy.setDescription(vacancyDto.getDescription());
        vacancy.setCreatedDate(vacancyDto.getCreated_date());
        vacancy.setSalary(vacancyDto.getSalary());
        return vacancyRepository.save(vacancy);
    }

    @Override
    public Vacancy getById(int id) {
        log.info("Getting vacancy by id: {}", id);
        return vacancyRepository.findById((long) id)
                .orElseThrow(() -> new EntityNotFoundException("Vacancy Not Found"));
    }

    @Override
    public void deleteById(int id) {
        log.info("Deleting vacancy by id: {}", id);
        vacancyRepository.deleteById((long) id);
    }

    @Override
    public List<Vacancy> findByTrue() {
        log.info("Finding Vacancy by true");
        return vacancyRepository.findByIsActiveTrue();
    }

    @Override
    public List<Vacancy> findCategoryIdAndIsActiveTrue(int categoryId) {
        log.info("Finding Vacancy by categoryId: {}", categoryId);
        return vacancyRepository.findByCategoryIdAndIsActiveTrue((long) categoryId);
    }

    @Override
    public List<Vacancy> getRespondedVacanciesByUser(int userId) {
        log.info("Getting responded vacancies for user id: {}", userId);
        return vacancyRepository.findRespondedVacanciesByAuthor_Id((long) userId);
    }

    @Override
    public List<Vacancy> getAllVacancies() {
        log.info("Getting all vacancies");
        return vacancyRepository.findAll();
    }

    @Override
    public List<Vacancy> getVacanciesByCategory(int categoryId) {
        log.info("Getting vacancies by category id: {}", categoryId);
        return vacancyRepository.findByCategoryId((long) categoryId);
    }

    @Override
    public List<User> getApplicantsByVacancy(int vacancyId) {
        log.info("Getting applicants for vacancy id: {}", vacancyId);
        return null;
    }
}
