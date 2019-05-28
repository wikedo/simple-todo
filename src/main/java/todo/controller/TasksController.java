package todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public ResponseEntity listAllTasks() {
        return null;
    }

    @RequestMapping(path = "/list", method = RequestMethod.POST)
    public ResponseEntity createTask() {
        return null;
    }

    @RequestMapping(path = "/{taskId}", method = RequestMethod.PUT)
    public ResponseEntity updateTask(@PathVariable("taskId") Long id) {
        return null;
    }

    @RequestMapping(path = "/{taskId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteTask(@PathVariable("taskId") Long id) {
        return null;
    }
}
