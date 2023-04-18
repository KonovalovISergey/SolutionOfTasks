package com.kkb.solutionoftasks.component;

import com.kkb.solutionoftasks.models.Tasks;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FullTaskRowMapper implements RowMapper<Tasks> {

    @Override
    public Tasks mapRow(ResultSet rs, int rowNum) throws SQLException {
        Tasks task = new Tasks();
        task.setTask_id(rs.getInt("task_id"));
        task.setTitle(rs.getString("title"));
        task.setDescription(rs.getString("description"));
        task.setTime(rs.getDate("time"));
        task.setStatus(rs.getString("status"));
        task.setPerformer(rs.getInt("performer"));
        return task;
    }
}
