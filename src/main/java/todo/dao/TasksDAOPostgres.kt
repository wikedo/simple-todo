package todo.dao

import org.springframework.jdbc.core.JdbcTemplate
import todo.model.Task

class TasksDAOPostgres(val jdbcTemplate: JdbcTemplate): TasksDAO {
    override fun getTaskById(taskId: Long): Task? {
        return getTaskById(jdbcTemplate, taskId)
    }

    override fun listAllTasks(): List<Task> {
        return listAllTasks(jdbcTemplate)
    }

    override fun createTask(task: Task): Int {
        return createTask(jdbcTemplate, task)
    }

    override fun updateTask(taskId: Long?): Task? {
        return null
    }

    override fun deleteTask(taskId: Long?): Boolean? {
        return false
    }

}