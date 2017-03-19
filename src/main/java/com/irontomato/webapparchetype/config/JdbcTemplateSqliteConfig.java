package com.irontomato.webapparchetype.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Configuration
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = Repository.class)})
@Profile("db.sqlite")
public class JdbcTemplateSqliteConfig {

    @Bean
    public DataSource sqliteDataSource() {
        BasicDataSource ds = new BasicDataSource();
        ds.setUrl("jdbc:sqlite:webapp-archetype.db");
        ds.setDriverClassName("org.sqlite.JDBC");
        return ds;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
