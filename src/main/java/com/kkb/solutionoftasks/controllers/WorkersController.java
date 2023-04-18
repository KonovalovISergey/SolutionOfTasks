package com.kkb.solutionoftasks.controllers;

import com.kkb.solutionoftasks.component.WorkersDAO;
import com.kkb.solutionoftasks.models.Workers;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("workers")
public class WorkersController {

    private final WorkersDAO workersDAO;

    public WorkersController(WorkersDAO workersDAO) {
        this.workersDAO = workersDAO;
    }

    @GetMapping
    public List getAllWorkerById() {
        return workersDAO.read();
    }

    @PostMapping("/create")
    public void createWorker(Workers worker) {
        workersDAO.create(worker);
    }

    @PostMapping("/update/{id}")
    public void updateWorkerById(Workers worker, @PathVariable("id") int id) {
        workersDAO.update(worker, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteWorkerById(@PathVariable("id") int id) {
        workersDAO.delete(id);
    }

}
