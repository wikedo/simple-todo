package todo.dao

import org.springframework.jdbc.core.JdbcTemplate
import todo.model.Status
import todo.model.Task

class TasksDAOPostgres(val jdbcTemplate: JdbcTemplate): TasksDAO {
    override fun getTaskById(taskId: Long): Task {
        return getTaskById(jdbcTemplate, taskId);
    }
}