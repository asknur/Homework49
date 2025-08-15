package kg.attractor.demo.repository;

import kg.attractor.demo.model.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long> {
    Optional<Resume> findById(Long id);
    List<Resume> findAllResumes();
    List<Resume> findByCategory_id(Long id);
    List<Resume> findByCategory(Long categoryId);
    List<Resume> findByApplicant_Id(Long applicantId);


}
