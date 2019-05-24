package todo.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import todo.dao.TasksDAO;
import todo.dao.TasksDAOPostgres;
import todo.service.TasksService;
import todo.service.TasksServiceImpl;

import javax.sql.DataSource;

@Configuration
public class Configurations {

    @Autowired
    @Bean
    HikariDataSource dataSource(Environment properties) {
        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setDriverClassName(properties.getProperty("jdbc.driverClassName"));
        dataSource.setJdbcUrl(properties.getProperty("jdbc.url"));
        dataSource.setUsername(properties.getProperty("jdbc.username"));
        dataSource.setPassword(properties.getProperty("jdbc.password"));
        dataSource.setConnectionTestQuery(properties.getProperty("jdbc.connectionTestQuery"));

        return dataSource;
    }

    @Bean
    @Autowired
    JdbcTemplate jdbcTemplate(DataSource dataSource) { return new JdbcTemplate(dataSource); }

    @Autowired
    @Bean
    TasksService tasksService(TasksDAO tasksDAO) {
        return new TasksServiceImpl(tasksDAO);
    }

    @Bean
    @Autowired
    TasksDAO tasksDAO(JdbcTemplate jdbcTemplate) {
        return new TasksDAOPostgres(jdbcTemplate);
    }
}
