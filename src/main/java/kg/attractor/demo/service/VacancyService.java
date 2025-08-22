package kg.attractor.demo.service;

import kg.attractor.demo.dto.VacancyDto;
import kg.attractor.demo.model.User;
import kg.attractor.demo.model.Vacancy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface VacancyService {
    Vacancy createVacancy(VacancyDto vacancyDto);

    Vacancy save(VacancyDto vacancyDto);

    Vacancy getById(int id);

    List<VacancyDto> getByUser(long id);

    void deleteById(int id);

    List<Vacancy> findByTrue();

    List<Vacancy> findCategoryIdAndIsActiveTrue(int categoryId);

    List<Vacancy> getRespondedVacanciesByUser(int userId);

    List<Vacancy> getAllVacancies();

    List<Vacancy> getVacanciesByCategory(int categoryId);

    List<Vacancy> getVacanciesByAuthor(long vacancyId);

    List<VacancyDto> getAllSortedAndPagedVacancies(Pageable pageable);

    default Sort getSortedMethod(String sortValue) {
        return switch (sortValue) {
            case "created_date" -> Sort.by("created_date");
            case "responded" -> Sort.by("responded");
            default -> Sort.by("name");
        };
    }
}