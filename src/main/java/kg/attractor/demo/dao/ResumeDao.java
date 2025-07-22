package kg.attractor.demo.dao;

import kg.attractor.demo.model.Resume;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ResumeDao {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final KeyHolder keyHolder = new GeneratedKeyHolder();


    public List<Resume> getResumesByCatId(int categoryId) {
        String sql = "select * from resumes where category_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Resume.class), categoryId);
    }

    public List<Resume> getResumesByApplicantId(int applicantId) {
        String sql = "select * from resumes where applicant_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Resume.class), applicantId);
    }

    public Optional<Resume> findResumeById(long id) {
        String sql = "select * from resumes where id=?";
        return Optional.ofNullable(
                DataAccessUtils.singleResult(
                        jdbcTemplate.query(
                                sql,
                                new BeanPropertyRowMapper<>(Resume.class),
                                id
                        )
                )
        );
    }

    public List<Resume> getAllResumes() {
        String sql = "select * from resumes";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Resume.class));
    }

    public Resume createResume(Resume resume) {
        String sql = """
                insert into resumes (name, category_id, applicant_id, salary, created_date)
                values (:name, :categoryId, :applicantId, :salary, :createdDate)
                """;
        KeyHolder keyHolder = new GeneratedKeyHolder();
        MapSqlParameterSource sqlParameterSource = new MapSqlParameterSource();
        sqlParameterSource.addValue("name", resume.getName());
        sqlParameterSource.addValue("category_id", resume.getCategory_id());
        sqlParameterSource.addValue("applicant_id", resume.getApplicant_id());
        sqlParameterSource.addValue("salary", resume.getSalary());
        sqlParameterSource.addValue("created_date", resume.getCreated_date());
        namedParameterJdbcTemplate.update(sql, sqlParameterSource, keyHolder);
        resume.setId(keyHolder.getKey().intValue());
        return resume;
    }

    public void updateResume(Resume resume) {
        String sql = """
                set name = ?, category_id = ?, applicant_id = ?, salary = ?, created_date = ?, update_time = ?
                where id = ?
        """;
        jdbcTemplate.update(sql,
                resume.getName(),
                resume.getCategory_id(),
                resume.getApplicant_id(),
                resume.getSalary(),
                resume.getCreated_date(),
                resume.getUpdate_time(),
                resume.getId());
    }

    public void deleteResume(long id) {
        jdbcTemplate.update("delete from resumes where id = ?", id);
    }





}
