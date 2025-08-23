package kg.attractor.demo.service.impl;

import jakarta.persistence.EntityNotFoundException;

import kg.attractor.demo.dto.VacancyDto;
import kg.attractor.demo.exceptions.VacancyNotFoundException;
import kg.attractor.demo.interfaces.VacancyWithRespondedCount;
import kg.attractor.demo.model.Vacancy;
import kg.attractor.demo.repository.VacancyRepository;
import kg.attractor.demo.service.VacancyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
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
    public VacancyDto getById(long id) {
        log.info("Getting vacancy by id: {}", id);
        Vacancy vacancy = vacancyRepository.findById(id)
                .orElseThrow(VacancyNotFoundException::new);
        return VacancyDto.builder()
                .id(vacancy.getId())
                .name(vacancy.getName())
                .salary(vacancy.getSalary())
                .created_date(vacancy.getCreatedDate())
                .description(vacancy.getDescription())
                .is_active(true)
                .updated_time(vacancy.getUpdatedTime())
                .exp_from(vacancy.getExp_from())
                .exp_to(vacancy.getExp_to())
                .build();

    }

    @Override
    public List<VacancyDto> getByUser(long id) {
        log.info("Getting vacancy by user: {}", id);
        List<Vacancy> vacancies = vacancyRepository.findByAuthor_Id(id);
        if (vacancies == null) {
            return Collections.emptyList();
        }
        return vacancies.stream()
                .map(e -> {
                    return VacancyDto.builder()
                            .id(e.getId())
                            .name(e.getName())
                            .description(e.getDescription())
                            .salary(e.getSalary())
                            .exp_from(e.getExp_from())
                            .exp_to(e.getExp_to())
                            .is_active(e.isActive())
                            .created_date(e.getCreatedDate())
                            .updated_time(e.getUpdatedTime())
                            .build();
                })
                .toList();
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
    public List<Vacancy> getVacanciesByAuthor(long vacancyId) {
        log.info("Getting applicants for vacancy id: {}", vacancyId);
        return vacancyRepository.findByAuthor_Id((long) vacancyId);
    }

    @Override
    public List<VacancyDto> getAllSortedAndPagedVacancies(Pageable pageable){
        boolean sortByResponded =
                pageable.getSort().stream().anyMatch(o -> o.getProperty().equals("respondedCount"));
        if (sortByResponded) {
            Page<VacancyWithRespondedCount> page = vacancyRepository.findAllWithRespondedCount(pageable);
            return page.getContent().stream()
                    .map(p -> {
                        Vacancy e = p.getVacancy();
                        return VacancyDto.builder()
                                .id(e.getId())
                                .name(e.getName())
                                .description(e.getDescription())
                                .salary(e.getSalary())
                                .exp_from(e.getExp_from())
                                .exp_to(e.getExp_to())
                                .is_active(e.isActive())
                                .created_date(e.getCreatedDate())
                                .updated_time(e.getUpdatedTime())
                                .respondedCount(p.getRespondedCount())
                                .build();
                    })
                    .toList();
        } else {
            Page<Vacancy> vacancies = vacancyRepository.findAll(pageable);
            return vacancies.getContent().stream()
                    .map(e -> {
                        return VacancyDto.builder()
                                .id(e.getId())
                                .name(e.getName())
                                .description(e.getDescription())
                                .salary(e.getSalary())
                                .exp_from(e.getExp_from())
                                .exp_to(e.getExp_to())
                                .is_active(e.isActive())
                                .created_date(e.getCreatedDate())
                                .updated_time(e.getUpdatedTime())
                                .build();
                    })
                    .toList();
        }
    }
}
