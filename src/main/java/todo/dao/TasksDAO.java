package todo.dao;

import todo.TaskApi;

import java.util.List;

public interface TasksDAO {
    TaskApi.Out.Task getTaskById(Long taskId);

    List<TaskApi.Out.Task> listAllTasks();

    Long createTask(TaskApi.In.NewTask task);

    Integer updateTask(Long taskId, TaskApi.In.UpdatedTask task);

    Integer deleteTask(Long taskId);
}
