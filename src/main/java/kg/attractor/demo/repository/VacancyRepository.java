package kg.attractor.demo.repository;

import kg.attractor.demo.interfaces.VacancyWithRespondedCount;
import kg.attractor.demo.model.Vacancy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
    List<Vacancy> findByCategoryId(Long categoryId);
    List<Vacancy> findByIsActiveTrue();
    List<Vacancy> findByCategoryIdAndIsActiveTrue(Long categoryId);
    List<Vacancy> findRespondedVacanciesByAuthor_Id(Long userId);
    Page<Vacancy> findAll(Pageable pageable);
    List<Vacancy> findByAuthor_Id(Long id);

    @Query(
            value = """
        select v as vacancy, count(ra) as respondedCount
        from Vacancy v
        left join RespondedApplicant ra on ra.vacancy = v
        group by v
      """, countQuery = "select count(v) from Vacancy v"
    )
    Page<VacancyWithRespondedCount> findAllWithRespondedCount(Pageable pageable);
}
