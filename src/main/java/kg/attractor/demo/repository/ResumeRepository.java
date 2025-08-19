package kg.attractor.demo.repository;

import kg.attractor.demo.model.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long> {
    List<Resume> findByCategory_id(Long categoryId);
    List<Resume> findByApplicantId(Long applicantId);
    @Query("select r from Resume r where r.isActive = true")
    List<Resume> findActiveResumes();


}
