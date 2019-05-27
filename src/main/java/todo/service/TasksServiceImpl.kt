package todo.service

import todo.dao.TasksDAO
import todo.model.Task

class TasksServiceImpl(private val tasksDAO: TasksDAO) : TasksService {
    override fun getTaskById(id: Long): Task? {
        return tasksDAO.getTaskById(id)
    }
}