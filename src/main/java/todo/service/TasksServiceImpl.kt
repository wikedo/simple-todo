package todo.service

import todo.dao.TasksDAO
import todo.model.TaskApi

class TasksServiceImpl(private val tasksDAO: TasksDAO) : TasksService {
    override fun getTaskById(id: Long): TaskApi.Out.Task? {
        return tasksDAO.getTaskById(id)
    }

    override fun listAllTasks(): List<TaskApi.Out.Task> {
        return tasksDAO.listAllTasks()
    }

    override fun createTask(task: TaskApi.In.NewTask): Int {
        return tasksDAO.createTask(task)
    }

    override fun updateTask(id: Long): TaskApi.Out.Task? {
        return tasksDAO.updateTask(id)
    }

    override fun deleteTask(id: Long): Int {
        return tasksDAO.deleteTask(id)
    }
}