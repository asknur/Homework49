package kg.attractor.demo.service.impl;

import kg.attractor.demo.dao.ResumeDao;
import kg.attractor.demo.model.Resume;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ResumeServiceImpl {
    private final List<Resume> resumes;
    private final ResumeDao resumeDao;

    public Resume save(Resume resume) {
        return null;
    }

    public void deleteById(int id) {
        return;
    }

    public List<Resume> findAll() {
        return resumes;
    }

    public List<Resume> findByCatId(int categoryId) {
        return null;
    }

    public List<Resume> getByCategory(int categoryId) {
        return resumeDao.getResumesByCatId(categoryId);
    }

    public List<Resume> getByApplicant(int applicantId) {
        return resumeDao.getResumesByApplicantId(applicantId);
    }

}
