package kg.attractor.demo.service.impl;

import kg.attractor.demo.dao.VacancyDao;
import kg.attractor.demo.model.User;
import kg.attractor.demo.model.Vacancy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class VacancyServiceImpl {
    private final VacancyDao vacancyDao;

    public Vacancy createVacancy(Vacancy vacancy) {
        log.info("Creating Vacancy: {}", vacancy);
        return vacancy;
    }

    public Vacancy save(Vacancy vacancy) {
        log.info("Saving vacancy: {}", vacancy.getName());
        return vacancy;
    }

    public Vacancy getById(int id){
        log.info("Getting vacancy by id: {}", id);
        return null;
    }

    public void deleteById(int id) {
        log.info("Deleting vacancy by id: {}", id);
        return;
    }

    public List<Vacancy> findByTrue() {
        log.info("Finding Vacancy by true");
        return null;
    }

    public List<Vacancy> findCategoryIdAndTrue(int categoryId) {
        log.info("Finding Vacancy by categoryId: {}", categoryId);
        return null;
    }

    public List<Vacancy> getRespondedVacanciesByUser(int userId) {
        log.info("Getting responded vacancies for user id: {}", userId);
        return vacancyDao.getRespondedVac(userId);
    }

    public List<Vacancy> getAllVacancies() {
        log.info("Getting all vacancies");
        return vacancyDao.getAllVac();
    }

    public List<Vacancy> getVacanciesByCategory(int categoryId) {
        log.info("Getting vacancies by category id: {}", categoryId);
        return vacancyDao.findVacanciesByCategoryId(categoryId);
    }

    public List<User> getApplicantsByVacancy(int vacancyId) {
        log.info("Getting applicants for vacancy id: {}", vacancyId);
        return vacancyDao.findApplicantsByVacancyId(vacancyId);
    }
}
