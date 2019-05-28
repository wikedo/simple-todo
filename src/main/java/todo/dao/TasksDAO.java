package todo.dao;

import todo.model.Task;

import java.util.List;

public interface TasksDAO {
    Task getTaskById(Long taskId);

    List<Task> listAllTasks();

    Task createTask();

    Task updateTask(Long taskId);

    Boolean deleteTask(Long taskId);
}
