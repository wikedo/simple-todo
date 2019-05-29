package todo.model

interface TaskApi {

    interface In {

        data class NewTask(val text: String)
    }
    interface Out {

        data class Task(val id: Long, val text: String, val status: Status)
    }

}
