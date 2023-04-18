package com.kkb.solutionoftasks.controllers;

import com.kkb.solutionoftasks.models.Tasks;
import com.kkb.solutionoftasks.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.BlockingQueue;

@RestController
@RequestMapping("tasks")
public class TasksController {

    private final TaskService taskService;

    public TasksController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List getAllTaskById() {
        return taskService.getAllTask();
    }

    @PostMapping("/addOneTaskToQueue")
    public void addTask(@RequestBody Tasks task) {
        taskService.addOneTaskToQueue(task);
    }

    @GetMapping("/getQueueTasks")
    public BlockingQueue<Tasks> getTaskFromQueue() {
        return taskService.getTaskFromQueue();
    }

    @GetMapping("/saveTasksToDB")
    public void saveTasksToDB() {
        taskService.saveTasksToDB();
    }

    @GetMapping("/getShortTaskFromDB")
    public List<Tasks> getShortTaskFromDB(){
        return taskService.getShortTaskFromDB();
    }

    @GetMapping("/getTaskById/{id}")
    public List<Tasks> getTaskById(@PathVariable("id") int id){
        return taskService.getTaskById(id);
    }

    @PostMapping("/updateTaskForId/{id}")
    public void updateTaskForId(@PathVariable("id") int id, @RequestBody Tasks task) {
        taskService.updateTaskForId(id, task);
    }

    @PostMapping("/appointTaskToPerformer/{id}")
    public void appointTaskToPerformer(@PathVariable("id") int id, @RequestBody int performer) {
        taskService.appointTaskToPerformer(id, performer);
    }

}
