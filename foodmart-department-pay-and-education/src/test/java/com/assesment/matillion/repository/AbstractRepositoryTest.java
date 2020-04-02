package com.assesment.matillion.repository;

import javax.sql.DataSource;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.TestPropertySource;

@TestPropertySource("/test.properties")
public class AbstractRepositoryTest {

	@Spy
	DatabaseConfig databaseConfig;
	
	@Value("${spring.datasource.url}")
	private String url;
	
	@Value("${spring.datasource.username}")
	private String username;
	
	@Value("${spring.datasource.password}")
	private String password;
	
	@Value("${spring.datasource.classname}")
	private String classname;
	
	@Bean
    @Profile("test")
    DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(databaseConfig.getClassname());
        dataSource.setUrl(databaseConfig.getUrl());
        dataSource.setUsername(databaseConfig.getUsername());
        dataSource.setPassword(databaseConfig.getPassword());
 
        return dataSource;
    }
	
    @BeforeEach
    public void initMocks() {
        MockitoAnnotations.initMocks(this);

        databaseConfig.setPassword(password);
        databaseConfig.setUrl(url);
        databaseConfig.setUsername(username);
        databaseConfig.setClassname(classname);
    }
}
