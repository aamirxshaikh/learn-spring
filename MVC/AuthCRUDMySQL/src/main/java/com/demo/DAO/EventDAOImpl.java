package com.demo.DAO;

import com.demo.Model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EventDAOImpl implements EventDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Event> getEvents() {
        return jdbcTemplate.query("SELECT * FROM events", new RowMapper<Event>() {
            @Override
            public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Event(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("details"),
                        rs.getString("location")
                );
            }
        });
    }
}
