package todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import todo.model.Task;
import todo.service.TasksService;

import javax.validation.constraints.Null;

@RestController
public class TasksController {
    private final TasksService tasksService;

    @Autowired
    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @RequestMapping(path = "/{taskId}", method = RequestMethod.GET)
    public ResponseEntity getTaskById(@PathVariable("taskId") Long id) {
        return ResponseEntity.ok(tasksService.getTaskById(id));
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ResponseEntity listAllTasks() {
        return ResponseEntity.ok(tasksService.listAllTasks());
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponseEntity createTask(@RequestBody Task task) {
        return ResponseEntity.ok(tasksService.createTask());
    }

    @RequestMapping(path = "/{taskId}", method = RequestMethod.PUT)
    public ResponseEntity updateTask(@PathVariable("taskId") Long id) {
        return ResponseEntity.ok(tasksService.updateTask(id));
    }

    @RequestMapping(path = "/{taskId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteTask(@PathVariable("taskId") Long id) {
        return ResponseEntity.ok(tasksService.deleteTask(id));
    }
}
