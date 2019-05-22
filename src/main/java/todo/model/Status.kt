package todo.model

enum class Status(val statusCode: Short) {
    TODO(0),
    DONE(1),
    BLOCKED(2),
    POSTPONED(3),
    CANCELLED(4)
}