package todo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import todo.model.TaskApi;
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

    @RequestMapping(path = "/", method = RequestMethod.POST, headers = {"Content-type=application/json"})
    public ResponseEntity createTask(@RequestBody TaskApi.In.NewTask task) {
        return ResponseEntity.ok(tasksService.createTask(task));
    }

    @RequestMapping(path = "/{taskId}", method = RequestMethod.PUT, headers = {"Content-type=application/json"})
    public ResponseEntity updateTask(@PathVariable("taskId") Long id,
                                     @RequestBody TaskApi.In.UpdatedTask task) {
        return ResponseEntity.ok(tasksService.updateTask(id, task));
    }

    @RequestMapping(path = "/{taskId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteTask(@PathVariable("taskId") Long id) {
        return ResponseEntity.ok(tasksService.deleteTask(id));
    }
}
