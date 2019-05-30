package todo.dao

import org.springframework.jdbc.core.JdbcTemplate
import todo.TaskApi

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

    override fun updateTask(taskId: Long, task: TaskApi.In.UpdatedTask): Int {
        return updateTask(jdbcTemplate, taskId, task)
    }

    override fun deleteTask(taskId: Long): Int {
        return deleteTask(jdbcTemplate, taskId)
    }

}