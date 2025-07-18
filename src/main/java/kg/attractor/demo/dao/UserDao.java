package kg.attractor.demo.dao;

import kg.attractor.demo.dao.mappers.UserMapper;
import kg.attractor.demo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Objects;


@Component
@RequiredArgsConstructor
public class UserDao {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final KeyHolder keyHolder = new GeneratedKeyHolder();



    public List<User> getByName(String name) {
        String sql = "select * from users\n" +
                "where NAME ilike :name;";
        return namedParameterJdbcTemplate.query(
                sql,
                new MapSqlParameterSource()
                        .addValue("name", "%" + name + "%"),
                new UserMapper()
        );
    }

    public List<User> getByPhone(String phone) {
        String sql = "select * from users\n" +
                "where phone_number ilike :phone_number;";
        return namedParameterJdbcTemplate.query(
                sql,
                new MapSqlParameterSource()
                        .addValue("phone_number", "%" + phone + "%"),
                new UserMapper()
        );
    }

    public List<User> getByEmail(String email) {
        String sql = "select * from users\n" +
                "where email ilike :email;";
        return namedParameterJdbcTemplate.query(sql,
                new MapSqlParameterSource()
                        .addValue("email", "%" + email + "%"),
                new UserMapper()
        );
    }

    public boolean existsByEmail(String email) {
        String sql = "select count(*) from users where email = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, email);
        return count > 0;
    }













}
