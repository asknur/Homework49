package kg.attractor.demo.service;

import kg.attractor.demo.dto.ResumeDto;
import kg.attractor.demo.model.Resume;

import java.util.List;

public interface ResumeService {
    Resume createResume(ResumeDto resumeDto);

    Resume save(ResumeDto resume);

    Resume getById(int id);

    void deleteById(int id);

    List<Resume> findAll();

    List<Resume> findByCatId(long categoryId);

    List<Resume> getByCategory(long categoryId);

    List<Resume> getByApplicant(long applicantId);
}
