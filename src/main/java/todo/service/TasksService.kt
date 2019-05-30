package todo.service

import todo.TaskApi

interface TasksService {
    fun getTaskById(id: Long): TaskApi.Out.Task?

    fun listAllTasks(): List<TaskApi.Out.Task>

    fun createTask(task: TaskApi.In.NewTask): Int?

    fun updateTask(taskId: Long, task: TaskApi.In.UpdatedTask): Int

    fun deleteTask(id: Long): Int
}