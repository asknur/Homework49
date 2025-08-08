package kg.attractor.demo.controller.api;

import jakarta.validation.Valid;
import kg.attractor.demo.model.Resume;
import kg.attractor.demo.service.impl.ResumeServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("resumeProfile")
@RequestMapping("/api/resumes")
@RequiredArgsConstructor

public class ResumeController {
    private final ResumeServiceImpl resumeService;

    @PostMapping
    public ResponseEntity<Resume> createResume(@RequestBody @Valid Resume resume) {
        return new ResponseEntity<>(resumeService.save(resume), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resume> updateResume(@PathVariable int id, @RequestBody Resume resume) {
        resume.setId(id);
        return new ResponseEntity<>(resumeService.save(resume), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResume(@PathVariable int id) {
        resumeService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<Resume>> getAllResumes() {
        return new ResponseEntity<>(resumeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Resume>> getResumesByCategory(@PathVariable int categoryId) {
        return new ResponseEntity<>(resumeService.findByCatId(categoryId), HttpStatus.OK);
    }

}
