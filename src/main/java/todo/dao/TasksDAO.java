package todo.dao;

import todo.model.Task;

public interface TasksDAO {
    Task getTaskById(Long taskId);
}
