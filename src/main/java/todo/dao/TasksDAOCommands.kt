package todo.dao

import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.JdbcTemplate
import todo.model.Status
import todo.model.Task
import java.sql.ResultSet

val rowMapper: (ResultSet, Int) -> Task = { rs, i ->
    Task(rs.getLong("id"),
        rs.getString("text"),
        Status.getById(rs.getInt("status")))
}

fun getTaskById(jdbcTemplate: JdbcTemplate, taskId: Long): Task? {

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

fun listAllTasks(jdbcTemplate: JdbcTemplate): List<Task> {

    val sql = """
        SELECT id, text, status
        FROM tasks
    """

    return jdbcTemplate.query(sql, rowMapper)
}

fun createTask(jdbcTemplate: JdbcTemplate, task: Task): Int {

    val sql = """
        INSERT
        INTO tasks (id, text, status)
        VALUES (nextval('id_seq'), ?, ?)
    """

    return jdbcTemplate.update(sql, task.text, Status.TODO.statusCode)
}