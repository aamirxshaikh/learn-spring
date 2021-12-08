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

    @Override
    public void addEvent(Event event) {
        String sql = "INSERT INTO events (name, details, location) VALUES " +
                "( '" + event.getName() + "' , '" +
                event.getDetails() + "' , '" +
                event.getLocation() +
                "' )";

        jdbcTemplate.update(sql);
    }

    @Override
    public Event getEvent(int id) {
        String sql = "SELECT * FROM events WHERE id = ?";

        Event event = jdbcTemplate.queryForObject(sql, new Object[] {id}, new RowMapper<Event>() {
            @Override
            public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
                return new Event(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("details"),
                        rs.getString("location")
                );
            }
        });

        return event;
    }

    @Override
    public void updateEvent(Event event) {
        String sql = "UPDATE events set name = ?, details = ?, location = ? WHERE id = ?";
        
        jdbcTemplate.update(sql, new Object[] {
                event.getName(),
                event.getDetails(), 
                event.getLocation(),
                event.getId()
        });
    }
}
