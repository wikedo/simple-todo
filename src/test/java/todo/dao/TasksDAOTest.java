package todo.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import todo.Status;
import todo.TaskApi;
import todo.config.Configurations;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= Configurations.class)
@TestPropertySource(locations="classpath:application.properties")
public class TasksDAOTest {

    @Autowired
    TasksDAOPostgres tasksDao;

    @Test
    public void insertTask_withValidPayload_shouldSucceed() {

        TaskApi.In.NewTask newTask = new TaskApi.In.NewTask("New Task Description");
        Long id = tasksDao.createTask(newTask);

        assertThat(id).isNotNull();

        TaskApi.Out.Task task = tasksDao.getTaskById(id);

        assertThat(task.getText()).isEqualTo(newTask.getText());
        assertThat(task.getStatus()).isEqualTo(Status.TODO); // cos the initial state of a task should be TODO

        //after
        tasksDao.deleteTask(id);
    }

    @Test
    public void updateTask_withValidPayload_shouldSucceed() {
        TaskApi.In.NewTask newTask = new TaskApi.In.NewTask("New Task Description");
        Long id = tasksDao.createTask(newTask);

        TaskApi.In.UpdatedTask updatedTask = new TaskApi.In.UpdatedTask("Updated New Task Description", Status.CANCELLED);

        tasksDao.updateTask(id, updatedTask);

        TaskApi.Out.Task task = tasksDao.getTaskById(id);
        assertThat(task.getText()).isEqualTo(updatedTask.getText());
        assertThat(task.getStatus()).isEqualTo(updatedTask.getStatus());

        //after
        tasksDao.deleteTask(id);
    }

    @Test
    public void getById_withNonExistentEntry_shouldReturnNull() {
        assertThat(tasksDao.getTaskById(-1)).isNull();
    }
}
