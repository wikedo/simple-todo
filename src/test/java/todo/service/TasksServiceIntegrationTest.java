package todo.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TasksServiceIntegrationTest {

    @Autowired
    TasksService tasksService;

    @Test
    public void insertTask_withValidPayload_shouldSucceed() {
        // instantiate new task fixture
        // insert instance
        // getById
        // assert that id value is valid
        // assert that tasks match
        // assert that initial state is TODO
    }

    @Test
    public void updateTask_withValidPayload_shouldSucceed() {

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
