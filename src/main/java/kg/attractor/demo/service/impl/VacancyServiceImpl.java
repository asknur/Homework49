package kg.attractor.demo.service.impl;

import kg.attractor.demo.dao.VacancyDao;
import kg.attractor.demo.dto.VacancyDto;
import kg.attractor.demo.model.User;
import kg.attractor.demo.model.Vacancy;
import kg.attractor.demo.service.VacancyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class VacancyServiceImpl implements VacancyService {
    private final VacancyDao vacancyDao;

    @Override
    public Vacancy createVacancy(VacancyDto vacancyDto) {
        log.info("Creating Vacancy: {}", vacancyDto);
        Vacancy vacancy = new Vacancy();
        vacancy.setName(vacancyDto.getName());
        vacancy.setDescription(vacancyDto.getDescription());
        vacancy.setCreated_date(vacancyDto.getCreated_date());
        vacancy.setSalary(vacancyDto.getSalary());
        return vacancy;
    }

    @Override
    public Vacancy save(VacancyDto vacancyDto) {
        log.info("Saving vacancy: {}", vacancyDto.getName());
        return null;

    }

    @Override
    public Vacancy getById(int id){
        log.info("Getting vacancy by id: {}", id);
        return null;
    }

    @Override
    public void deleteById(int id) {
        log.info("Deleting vacancy by id: {}", id);
        return;
    }

    @Override
    public List<Vacancy> findByTrue() {
        log.info("Finding Vacancy by true");
        return null;
    }

    @Override
    public List<Vacancy> findCategoryIdAndTrue(int categoryId) {
        log.info("Finding Vacancy by categoryId: {}", categoryId);
        return null;
    }

    @Override
    public List<Vacancy> getRespondedVacanciesByUser(int userId) {
        log.info("Getting responded vacancies for user id: {}", userId);
        return vacancyDao.getRespondedVac(userId);
    }

    @Override
    public List<Vacancy> getAllVacancies() {
        log.info("Getting all vacancies");
        return vacancyDao.getAllVac();
    }

    @Override
    public List<Vacancy> getVacanciesByCategory(int categoryId) {
        log.info("Getting vacancies by category id: {}", categoryId);
        return vacancyDao.findVacanciesByCategoryId(categoryId);
    }

    @Override
    public List<User> getApplicantsByVacancy(int vacancyId) {
        log.info("Getting applicants for vacancy id: {}", vacancyId);
        return vacancyDao.findApplicantsByVacancyId(vacancyId);
    }
}
