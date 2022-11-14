package be.kdg.integration.plantifybackend.domain.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/*package whatever //do not write package name here */
@Configuration
public class SpringJdbcConfig {
    @Bean
    public DataSource mysqlDataSource()
    {
        DriverManagerDataSource dataSource
                = new DriverManagerDataSource();

        dataSource.setUrl(
                "jdbc:postgresql://localhost:5432/plantifyDefault");
        dataSource.setUsername("postgres");
        dataSource.setPassword("Student_1234");

        return dataSource;
    }
}