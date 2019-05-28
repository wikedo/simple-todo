package todo.service

import todo.dao.TasksDAO
import todo.model.Task

class TasksServiceImpl(private val tasksDAO: TasksDAO) : TasksService {
    override fun getTaskById(id: Long): Task? {
        return tasksDAO.getTaskById(id)
    }

    override fun listAllTasks(): List<Task> {
        return tasksDAO.listAllTasks()
    }

    override fun createTask(task: Task): Task? {
        return tasksDAO.createTask(task)
    }

    override fun updateTask(id: Long): Task? {
        return tasksDAO.updateTask(id)
    }

    override fun deleteTask(id: Long): Boolean {
        return tasksDAO.deleteTask(id)
    }
}