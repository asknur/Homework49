package kg.attractor.demo.repository;

import kg.attractor.demo.model.Vacancy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
    List<Vacancy> findByCategoryId(Long categoryId);
    List<Vacancy> findByIsActiveTrue();
    List<Vacancy> findByCategoryIdAndIsActiveTrue(Long categoryId);
    List<Vacancy> findRespondedVacanciesByAuthor_Id(Long userId);
}
