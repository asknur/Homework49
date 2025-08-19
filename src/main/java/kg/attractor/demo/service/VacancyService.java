package kg.attractor.demo.service;

import kg.attractor.demo.dto.VacancyDto;
import kg.attractor.demo.model.User;
import kg.attractor.demo.model.Vacancy;

import java.util.List;

public interface VacancyService {
    Vacancy createVacancy(VacancyDto vacancyDto);

    Vacancy save(VacancyDto vacancyDto);

    Vacancy getById(int id);

    void deleteById(int id);

    List<Vacancy> findByTrue();

    List<Vacancy> findCategoryIdAndIsActiveTrue(int categoryId);

    List<Vacancy> getRespondedVacanciesByUser(int userId);

    List<Vacancy> getAllVacancies();

    List<Vacancy> getVacanciesByCategory(int categoryId);

    List<User> getApplicantsByVacancy(int vacancyId);
}
