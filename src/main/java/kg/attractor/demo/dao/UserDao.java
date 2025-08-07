package kg.attractor.demo.dao;

import kg.attractor.demo.dao.mappers.UserMapper;
import kg.attractor.demo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.support.DataAccessUtils;
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
import java.util.Optional;


@Component
@RequiredArgsConstructor
public class UserDao {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final KeyHolder keyHolder = new GeneratedKeyHolder();


    public Optional<User> getUserById(int id) {
        String sql = "select * from USERS\n" +
                "where ID = ?;";
        return Optional.ofNullable(
                DataAccessUtils.singleResult(
                        jdbcTemplate.query(sql, new UserMapper(), id)
                )
        );
    }

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

    public List<User> getAllUsers() {
        String sql = "select * from users";
        return jdbcTemplate.query(sql, new UserMapper());
    }


    public int addUser(User user) {
        String sql = "insert into USERS (NAME, PASSWORD) values (?, ?);";
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            return ps;
        }, keyHolder);
        return Objects.requireNonNull(keyHolder.getKey()).intValue();
    }

    public void register(User user) {
        String sql = "insert into users (name, surname, age, email, password, phone_number, avatar, account_type, role_id, enabled) " +
                "values (:name, :surname, :age, :email, :password, :phone_number, :avatar, :account_type, :role_id, :enabled)";

        namedParameterJdbcTemplate.update(sql,
                new MapSqlParameterSource()
                        .addValue("name", user.getName())
                        .addValue("surname", user.getSurname())
                        .addValue("age", user.getAge())
                        .addValue("email", user.getEmail())
                        .addValue("password", user.getPassword())
                        .addValue("phone_number", user.getPhone_number())
                        .addValue("avatar", user.getAvatar())
                        .addValue("account_type", user.getAccount_type())
                        .addValue("role_id", user.getRole_id())
                        .addValue("enabled", true)
        );
    }

    public List<User> login(String name, String password) {
        String sql = "select * from users where name = ? and password = ?";
        return jdbcTemplate.query(sql, new UserMapper(),  name, password);
    }


}
