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
        return jdbcTemplate.queryForObject(sql, arrayOf(taskId), rowMapper);
    } catch(e: EmptyResultDataAccessException) {
        return null
    }
}