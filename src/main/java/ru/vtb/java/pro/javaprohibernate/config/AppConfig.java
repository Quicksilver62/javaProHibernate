package ru.vtb.java.pro.javaprohibernate.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/users");
        config.setUsername("admin");
        config.setPassword("password");
        config.setDriverClassName("org.postgresql.Driver");

        return new HikariDataSource(config);
    }
}
