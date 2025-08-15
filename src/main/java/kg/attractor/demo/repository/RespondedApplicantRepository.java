package kg.attractor.demo.repository;

import kg.attractor.demo.model.RespondedApplicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespondedApplicantRepository extends JpaRepository<RespondedApplicant, String> {
}
