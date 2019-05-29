package todo.dao

import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.JdbcTemplate
import todo.model.Status
import todo.model.TaskApi
import java.sql.ResultSet

val rowMapper: (ResultSet, Int) -> TaskApi.Out.Task = { rs, i ->
    TaskApi.Out.Task(
        rs.getLong("id"),
        rs.getString("text"),
        Status.getById(rs.getInt("status"))
    )
}

fun getTaskById(jdbcTemplate: JdbcTemplate, taskId: Long): TaskApi.Out.Task? {

    val sql = """
        SELECT id, text, status
        FROM tasks
        WHERE id = ?
    """
    try {
        return jdbcTemplate.queryForObject(sql, arrayOf(taskId), rowMapper)
    } catch(e: EmptyResultDataAccessException) {
        return null
    }
}

fun listAllTasks(jdbcTemplate: JdbcTemplate): List<TaskApi.Out.Task> {

    val sql = """
        SELECT id, text, status
        FROM tasks
    """

    return jdbcTemplate.query(sql, rowMapper)
}

fun createTask(jdbcTemplate: JdbcTemplate, task: TaskApi.In.NewTask): Int {

    val sql = """
        INSERT
        INTO tasks (id, text, status)
        VALUES (nextval('id_seq'), ?, ?)
    """

    return jdbcTemplate.update(sql, task.text, Status.TODO.statusCode)
}