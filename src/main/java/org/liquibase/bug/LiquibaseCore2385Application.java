package org.liquibase.bug;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@SpringBootApplication
public class LiquibaseCore2385Application {
    @Value("classpath:liquibase/${db.liquibaseChangelogFile:db-master-changelog.xml}")
    String changelog;


    @Bean
    public SpringLiquibase liquibase(){
        SpringLiquibase springLiquibase = new SpringLiquibase();
        springLiquibase.setDataSource(myDatasource());
        springLiquibase.setChangeLog(changelog);
        return springLiquibase;
    }


    @Bean(name = "datasource")
    public DataSource myDatasource() {
        EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
        final EmbeddedDatabase database = embeddedDatabaseBuilder.setType(EmbeddedDatabaseType.H2).build();

        return database;
    }
    public static void main(String[] args) {
        SpringApplication.run(LiquibaseCore2385Application.class, args);
    }
}
