package kg.attractor.demo.dao.mappers;

import kg.attractor.demo.model.Resume;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResumeMapper implements RowMapper<Resume> {
    @Override
    public Resume mapRow(ResultSet rs, int rowNum) throws SQLException {
        Resume r = new Resume();
        r.setId(rs.getInt("id"));
        r.setApplicant_id(rs.getInt("applicant_id"));
        r.setName(rs.getString("name"));
        r.setCategory_id(rs.getInt("category_id"));
        r.setSalary(rs.getFloat("salary"));
        r.set_active(rs.getBoolean("is_active"));
        r.setCreated_date(rs.getTimestamp("created_date").toLocalDateTime());
        r.setUpdate_time(rs.getTimestamp("update_time").toLocalDateTime());
        return r;
    }
}
