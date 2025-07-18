package kg.attractor.demo.service.impl;

import kg.attractor.demo.dao.VacancyDao;
import kg.attractor.demo.model.User;
import kg.attractor.demo.model.Vacancy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class VacancyServiceImpl {
    private final VacancyDao vacancyDao;

    public Vacancy save(Vacancy vacancy) {
        return vacancy;
    }

    public void deleteById(int id) {
        return;
    }

    public List<Vacancy> findByTrue() {
        return null;
    }

    public List<Vacancy> findCategoryIdAndTrue(int categoryId) {
        return null;
    }

    public List<Vacancy> getRespondedVacanciesByUser(int userId) {
        return vacancyDao.getRespondedVac(userId);
    }

    public List<Vacancy> getAllVacancies() {
        return vacancyDao.getAllVac();
    }

    public List<Vacancy> getVacanciesByCategory(int categoryId) {
        return vacancyDao.findVacanciesByCategoryId(categoryId);
    }

    public List<User> getApplicantsByVacancy(int vacancyId) {
        return vacancyDao.findApplicantsByVacancyId(vacancyId);
    }
}
