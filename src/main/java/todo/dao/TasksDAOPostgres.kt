package todo.dao

import org.springframework.jdbc.core.JdbcTemplate
import todo.model.TaskApi

class TasksDAOPostgres(val jdbcTemplate: JdbcTemplate): TasksDAO {
    override fun getTaskById(taskId: Long): TaskApi.Out.Task? {
        return getTaskById(jdbcTemplate, taskId)
    }

    override fun listAllTasks(): List<TaskApi.Out.Task> {
        return listAllTasks(jdbcTemplate)
    }

    override fun createTask(task: TaskApi.In.NewTask): Int {
        return createTask(jdbcTemplate, task)
    }

    override fun updateTask(taskId: Long?): TaskApi.Out.Task? {
        return null
    }

    override fun deleteTask(taskId: Long): Int {
        return deleteTask(jdbcTemplate, taskId)
    }

}