package kg.attractor.demo.service.impl;

import kg.attractor.demo.dao.ResumeDao;
import kg.attractor.demo.dto.ResumeDto;
import kg.attractor.demo.model.Resume;
import kg.attractor.demo.service.ResumeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class ResumeServiceImpl implements ResumeService {
    private final ResumeDao resumeDao;

    @Override
    public Resume createResume(ResumeDto resume) {
        Resume newResume = new Resume();
        resume.setName(resume.getName());
        resume.setSalary(resume.getSalary());
        resume.setCreated_date(resume.getCreated_date());
        resume.setUpdate_time(resume.getUpdate_time());
        return newResume;
    }

    @Override
    public Resume save(ResumeDto resume) {
        log.info("Saving resume: {}", resume.getName());
        return null;
    }

    @Override
    public Resume getById(int id){
        log.info("Getting vacancy by id: {}", id);
        return null;
    }

    @Override
    public void deleteById(int id) {
        log.info("Deleting resume with id: {}", id);
        return;
    }

    @Override
    public List<Resume> findAll() {
        log.info("Getting all resumes");
        return resumeDao.getAllResumes();
    }

    @Override
    public List<Resume> findByCatId(int categoryId) {
        log.info("Getting resumes by category id: {}", categoryId);
        return null;
    }

    @Override
    public List<Resume> getByCategory(int categoryId) {
        log.info("Getting resumes by category id: {}", categoryId);
        return resumeDao.getResumesByCatId(categoryId);
    }

    @Override
    public List<Resume> getByApplicant(int applicantId) {
        log.info("Getting resumes by applicant id: {}", applicantId);
        return resumeDao.getResumesByApplicantId(applicantId);
    }

}
