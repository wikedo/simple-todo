package todo.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import todo.Status;
import todo.TaskApi;

import static org.assertj.core.api.Assertions.assertThat;

public class TasksDAOTest {

    @Autowired
    TasksDAO tasksDao;

    @Test
    public void insertTask_withValidPayload_shouldSucceed() {

        TaskApi.In.NewTask newTask = new TaskApi.In.NewTask("New Task Description");
        Long id = tasksDao.createTask(newTask);

        assertThat(id).isNotNull();

        TaskApi.Out.Task task = tasksDao.getTaskById(id);

        assertThat(task.getText()).isEqualTo(newTask.getText());
        assertThat(task.getStatus()).isEqualTo(Status.TODO.getStatusCode());
    }

    @Test
    public void updateTask_withValidPayload_shouldSucceed() {
        // in
    }

    @Test
    public void updateTask_withInvalidStatus_shouldFail() {

    }

    @Test
    public void deleteTask_withValidPayload_shouldSucceed() {

    }

    @Test
    public void getById_withExistentEntry_shouldReturnEntry() {

    }

    @Test
    public void getById_withNonExistentEntry_shouldReturnNull() {

    }
}
