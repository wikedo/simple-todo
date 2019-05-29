package todo.dao;

import todo.model.TaskApi;

import java.util.List;

public interface TasksDAO {
    TaskApi.Out.Task getTaskById(Long taskId);

    List<TaskApi.Out.Task> listAllTasks();

    Integer createTask(TaskApi.In.NewTask task);

    TaskApi.Out.Task updateTask(Long taskId);

    Boolean deleteTask(Long taskId);
}
