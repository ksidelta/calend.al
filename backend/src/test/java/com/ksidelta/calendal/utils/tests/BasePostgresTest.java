package com.ksidelta.calendal.utils.tests;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Primary;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import javax.sql.DataSource;

@Testcontainers
@SpringBootTest
@Import(BasePostgresTest.Conf.class)
public class BasePostgresTest {
    @Container
    private static PostgreSQLContainer postgresqlContainer =
            new PostgreSQLContainer(DockerImageName.parse("postgres").withTag("14.2"))
                    .withDatabaseName("db")
                    .withUsername("a")
                    .withPassword("b");

    @TestConfiguration
    static class Conf {
        @Bean
        @Primary
        public DataSource dataSource() {
            return DataSourceBuilder.create()
                    .url(postgresqlContainer.getJdbcUrl())
                    .username(postgresqlContainer.getUsername())
                    .password(postgresqlContainer.getPassword())
                    .build();
        }
    }
}
