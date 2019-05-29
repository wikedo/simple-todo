package todo.service

import todo.model.TaskApi

interface TasksService {
    fun getTaskById(id: Long): TaskApi.Out.Task?

    fun listAllTasks(): List<TaskApi.Out.Task>

    fun createTask(task: TaskApi.In.NewTask): Int?

    fun updateTask(id: Long): TaskApi.Out.Task?

    fun deleteTask(id: Long): Boolean
}