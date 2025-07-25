package kg.attractor.demo.dao;

import kg.attractor.demo.model.Resume;
import kg.attractor.demo.model.User;
import kg.attractor.demo.model.Vacancy;
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
public class VacancyDao {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final KeyHolder keyHolder = new GeneratedKeyHolder();


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

    public List<Vacancy> getVacancyByCatId(int id) {
        String sql = "select * from vacancies where category_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Vacancy.class), id);

    }

    public List<Vacancy> getVacancyByApplicantId(int id) {
        String sql = "select * from vacancies where applicant_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Vacancy.class), id);
    }

    public Optional<Vacancy> findVacancyById(long id) {
        String sql = "select * from resumes where id=?";
        return Optional.ofNullable(
                DataAccessUtils.singleResult(
                        jdbcTemplate.query(
                                sql,
                                new BeanPropertyRowMapper<>(Vacancy.class),
                                id
                        )
                )
        );
    }

    public Vacancy createVacancy(Vacancy vacancy) {
        String sql = """
            insert into vacancies (name, description, category_id, salary, exp_from, exp_to, is_active, author_id)
            values (:name, :description, :category_id, :salary, :exp_from, :exp_to, :is_active, :author_id)
            """;
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("name", vacancy.getName());
        params.addValue("description", vacancy.getDescription());
        params.addValue("category_id", vacancy.getCategory_id());
        params.addValue("salary", vacancy.getSalary());
        params.addValue("exp_from", vacancy.getExp_from());
        params.addValue("exp_to", vacancy.getExp_to());
        params.addValue("is_active", vacancy.is_active());
        params.addValue("author_id", vacancy.getAuthor_id());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(sql, params, keyHolder);
        vacancy.setId(keyHolder.getKey().intValue());

        return vacancy;
    }

    public void updateVacancy(Vacancy vacancy) {
        String sql = """
        update vacancies set name = ?, description = ?, category_id = ?, salary = ?, 
        exp_from = ?, exp_to = ?, is_active = ?, author_id = ?
        where id = ?
    """;
        jdbcTemplate.update(sql,
                vacancy.getName(),
                vacancy.getDescription(),
                vacancy.getCategory_id(),
                vacancy.getSalary(),
                vacancy.getExp_from(),
                vacancy.getExp_to(),
                vacancy.is_active(),
                vacancy.getAuthor_id(),
                vacancy.getId());
    }

    public void deleteVacancy(int id) {
        String sql = "delete from vacancies where id = ?";
        jdbcTemplate.update(sql, id);
    }


}
