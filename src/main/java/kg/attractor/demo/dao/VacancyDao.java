package kg.attractor.demo.dao;

import kg.attractor.demo.model.User;
import kg.attractor.demo.model.Vacancy;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class VacancyDao {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final KeyHolder keyHolder = new GeneratedKeyHolder();


    public List<Vacancy> getById(int id) {
        String sql = "select * from vacancies where id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Vacancy.class), id);
    }

    public List<Vacancy> getRespondedVac(int userId) {
        String sql = """
        select * from responded_applicants ra
        join resumes r on ra.resume_id = r.id
        join vacancies v on ra.vacancy_id = v.id
        where r.applicant_id = ?
        """;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Vacancy.class), userId);
    }

    public List<Vacancy> getAllVac() {
        String sql = "select * from vacancies";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Vacancy.class));
    }

    public List<Vacancy> findVacanciesByCategoryId(int categoryId) {
        String sql = "select * from vacancies where category_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Vacancy.class), categoryId);
    }

    public List<User> findApplicantsByVacancyId(int vacancyId) {
        String sql = """
        select u.* from responded_applicants ra
        join resumes r on ra.resume_id = r.id
        join users u on r.applicant_id = u.id
        where ra.vacancy_id = ?
        """;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class), vacancyId);
    }


}
