package kg.attractor.demo.dao.mappers;

import kg.attractor.demo.model.Vacancy;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class VacancyMapper implements RowMapper<Vacancy> {

    @Override
    public Vacancy mapRow(ResultSet rs, int rowNum) throws SQLException {
        Vacancy v = new Vacancy();
        v.setName(rs.getString("name"));
        v.setDescription(rs.getString("description"));
//        v.setCategory_id(rs.getInt("category_id"));
        v.setSalary(rs.getInt("salary"));
        v.setExp_from(rs.getInt("exp_from"));
        v.setExp_to(rs.getInt("exp_to"));
//        v.set_active(rs.getBoolean("is_active"));
//        v.setAuthor_id(rs.getInt("author_id"));
        return v;
    }
}
