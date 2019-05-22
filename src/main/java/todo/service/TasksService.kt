package todo.service

import todo.model.Task

interface TasksService {
    fun getTaskById(id: Long): Task
}