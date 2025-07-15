package kg.attractor.demo.service;

import ch.qos.logback.core.util.FileUtil;
import kg.attractor.demo.model.Resume;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeService {
    private final List<Resume> resumes;

    public ResumeService(List<Resume> resumes) {
        this.resumes = resumes;
    }

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
}
