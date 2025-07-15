package kg.attractor.demo.service;

import kg.attractor.demo.model.Vacancy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacancyService {

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
}
