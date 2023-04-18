package com.kkb.solutionoftasks.component;

import com.kkb.solutionoftasks.models.Workers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WorkersDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public WorkersDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Workers> read() {
        return jdbcTemplate.query("SELECT * FROM workers", new BeanPropertyRowMapper<>(Workers.class));
    }

    public void create(Workers worker) {
        jdbcTemplate.update("INSERT INTO workers (worker_id, name, position, avatar) VALUES (?, ?, ?, ?)",
                worker.getWorker_id(), worker.getName(), worker.getPosition(), worker.getAvatar());
    }

    public void update(Workers worker, int id) {
        jdbcTemplate.update("UPDATE workers SET worker_id='?', name='?', position='?', avatar='?' WHERE id='?'",
                worker.getWorker_id(), worker.getName(), worker.getPosition(), worker.getAvatar(), id);
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM workers WHERE id=?", id);
    }
}
