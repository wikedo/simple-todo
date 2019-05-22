package todo.dao

import todo.model.Status
import todo.model.Task

class TasksDAOPostgres: TasksDAO {
    override fun getTaskById(taskId: Long): Task {
        return Task(id = taskId, text = "this the task description", status = Status.TODO)
    }
}