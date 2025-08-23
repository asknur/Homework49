package kg.attractor.demo.service;

import kg.attractor.demo.dto.ResumeDto;
import kg.attractor.demo.model.Resume;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ResumeService {
    Resume createResume(ResumeDto resumeDto);

    Resume save(ResumeDto resume);

    ResumeDto getById(long id);

    void deleteById(int id);

    List<Resume> getAllResumes();

    List<Resume> findByCatId(int categoryId);

    List<Resume> getByCategory(int categoryId);

    List<Resume> getByApplicant(int applicantId);

    List<ResumeDto> getAllSortedAndPagedVacancies(Pageable pageable);
}
