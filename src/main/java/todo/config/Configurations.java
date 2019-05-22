package todo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import todo.dao.TasksDAO;
import todo.dao.TasksDAOPostgres;
import todo.service.TasksService;
import todo.service.TasksServiceImpl;

@Configuration
public class Configurations {

    @Autowired
    @Bean
    TasksService tasksService(TasksDAO tasksDAO) {
        return new TasksServiceImpl(tasksDAO);
    }

    @Bean
    TasksDAO tasksDAO() {
        return new TasksDAOPostgres();
    }
}
