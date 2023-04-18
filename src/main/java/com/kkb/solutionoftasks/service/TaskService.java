package com.kkb.solutionoftasks.service;

import com.kkb.solutionoftasks.component.FullTaskRowMapper;
import com.kkb.solutionoftasks.component.ShortTaskRowMapper;
import com.kkb.solutionoftasks.models.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Service
public class TaskService {
    private final JdbcTemplate jdbcTemplate;

    private BlockingQueue<Tasks> taskQueue = new LinkedBlockingQueue<Tasks>();

    @Autowired
    public TaskService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Tasks> getAllTask() {
        return jdbcTemplate.query("SELECT * FROM tasks", new FullTaskRowMapper());
    }

    public void addOneTaskToQueue(Tasks task) {
        taskQueue.add(task);
    }

    public BlockingQueue<Tasks> getTaskFromQueue() {
        return taskQueue;
    }

    public void saveTasksToDB() {
        String sql = "INSERT INTO Tasks (task_id, title, description, time, status, performer) VALUES (?, ?, ?, ?, ?, ?)";
        Runnable runnable = () -> {
            if (taskQueue.size() >= 3)
                while (true) {
                    Tasks task = taskQueue.poll();
                    jdbcTemplate.update(sql, task.getTask_id(), task.getTitle(), task.getDescription(), task.getTime(), task.getStatus(), task.getPerformer());
                }
        };

        for (int i = 0; i < 3; i++) {
            new Thread(runnable).start();
        }
    }

    public List<Tasks> getShortTaskFromDB() {
        return jdbcTemplate.query("SELECT task_id, title, status FROM tasks", new ShortTaskRowMapper(3));
    }

    public List<Tasks> getTaskById(int id) {
        return jdbcTemplate.query("SELECT task_id, description FROM tasks WHERE task_id = ?", new Object[]{id} ,new ShortTaskRowMapper(2));
    }

    public void updateTaskForId(int id, Tasks task) {
        String sql = "UPDATE tasks SET title='?', description='?', time='?', status='?' WHERE task_id=?";
        jdbcTemplate.update(sql, task.getTitle(), task.getDescription(), task.getTime(), task.getStatus(), id);
    }

    public void appointTaskToPerformer(int id, int performer) {
        jdbcTemplate.update("UPDATE tasks SET performer='?' WHERE task_id=?", performer, id);
    }

}
