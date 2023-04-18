package com.kkb.solutionoftasks.component;

import com.kkb.solutionoftasks.models.Tasks;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShortTaskRowMapper implements RowMapper<Tasks> {

    private int number;

    public ShortTaskRowMapper(int number) {
        this.number = number;
    }


    @Override
    public Tasks mapRow(ResultSet rs, int rowNum) throws SQLException {
        Tasks task = new Tasks();

        if(number==3){
            task.setTask_id(rs.getInt("task_id"));
            task.setTitle(rs.getString("title"));
            task.setDescription(null);
            task.setTime(null);
            task.setStatus(rs.getString("status"));
            task.setPerformer(0);
        }

        if(number==2){
            task.setTask_id(rs.getInt("task_id"));
            task.setTitle(null);
            task.setDescription(rs.getString("description"));
            task.setTime(null);
            task.setStatus(null);
            task.setPerformer(0);
        }

        return task;
    }

}
