package kg.attractor.demo.service.impl;

import kg.attractor.demo.dao.ResumeDao;
import kg.attractor.demo.model.Resume;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class ResumeServiceImpl {
    private final List<Resume> resumes;
    private final ResumeDao resumeDao;


    public Resume save(Resume resume) {
        log.info("Saving resume: {}", resume.getName());
        return null;
    }

    public void deleteById(int id) {
        log.info("Deleting resume with id: {}", id);
        return;
    }

    public List<Resume> findAll() {
        log.info("Getting all resumes");
        return resumeDao.getAllResumes();
    }

    public List<Resume> findByCatId(int categoryId) {
        log.info("Getting resumes by category id: {}", categoryId);
        return null;
    }

    public List<Resume> getByCategory(int categoryId) {
        log.info("Getting resumes by category id: {}", categoryId);
        return resumeDao.getResumesByCatId(categoryId);
    }

    public List<Resume> getByApplicant(int applicantId) {
        log.info("Getting resumes by applicant id: {}", applicantId);
        return resumeDao.getResumesByApplicantId(applicantId);
    }

}
