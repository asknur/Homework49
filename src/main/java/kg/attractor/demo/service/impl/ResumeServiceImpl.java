package kg.attractor.demo.service.impl;


import kg.attractor.demo.dto.ResumeDto;
import kg.attractor.demo.model.Resume;
import kg.attractor.demo.repository.ResumeRepository;
import kg.attractor.demo.service.ResumeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class ResumeServiceImpl implements ResumeService {
//    private final ResumeDao resumeDao;

    private final ResumeRepository resumeRepository;


    @Override
    public Resume createResume(ResumeDto resume) {
        Resume newResume = new Resume();
        resume.setName(resume.getName());
        resume.setSalary(resume.getSalary());
        resume.setCreated_date(resume.getCreated_date());
        resume.setUpdate_time(resume.getUpdate_time());
        return resumeRepository.save(newResume);
    }

    @Override
    public Resume save(ResumeDto resumeDto) {
        Resume resume = new Resume();
        resume.setName(resume.getName());
        resume.setSalary(resume.getSalary());
        resume.setCreatedDate(resume.getCreatedDate());
        return resumeRepository.save(resume);
    }

    @Override
    public Resume getById(int id){
        log.info("Getting vacancy by id: {}", id);
        return resumeRepository.findById((long)id)
                .orElseThrow(() -> new RuntimeException("Resume not found"));
    }

    @Override
    public void deleteById(int id) {
        log.info("Deleting resume with id: {}", id);
        resumeRepository.deleteById((long)id);
    }

    @Override
    public List<Resume> getAllResumes() {
        log.info("Getting all resumes");
        return resumeRepository.findAll();
    }

    @Override
    public List<Resume> findByCatId(int categoryId) {
        log.info("Getting resumes by category id: {}", categoryId);
        return resumeRepository.findByCategory_id((long)categoryId);
    }

    @Override
    public List<Resume> getByCategory(int categoryId) {
        log.info("Getting resumes by category: {}", categoryId);
        return resumeRepository.findByCategory_id((long)categoryId);
    }

    @Override
    public List<Resume> getByApplicant(int applicantId) {
        log.info("Getting resumes by applicant id: {}", applicantId);
        return resumeRepository.findByApplicantId((long)applicantId);
    }

}
