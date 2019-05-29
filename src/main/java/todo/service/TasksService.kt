package todo.service

import todo.model.Task

interface TasksService {
    fun getTaskById(id: Long): Task?

    fun listAllTasks(): List<Task>

    fun createTask(task: Task): Int?

    fun updateTask(id: Long): Task?

    fun deleteTask(id: Long): Boolean
}