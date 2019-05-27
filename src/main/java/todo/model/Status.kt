package todo.model

enum class Status(val statusCode: Int) {
    TODO(0),
    DONE(1),
    BLOCKED(2),
    POSTPONED(3),
    CANCELLED(4);

    companion object {
        fun getById(id: Int): Status = values()[id]
    }
}