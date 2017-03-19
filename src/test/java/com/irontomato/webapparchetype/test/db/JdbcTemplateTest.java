package com.irontomato.webapparchetype.test.db;

import com.irontomato.webapparchetype.test.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;

@ActiveProfiles(profiles = {"db.sqlite"})
public class JdbcTemplateTest extends TestBase {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcOperations jdbcOperations;

    @Test
    public void testConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        Assert.assertNotNull(connection);
    }

    @Test
    public void testCreateTable() throws SQLException {
        Connection connection = dataSource.getConnection();
        connection.createStatement().execute("create table users (id INTEGER PRIMARY KEY , username VARCHAR(32) UNIQUE NOT NULL , password VARCHAR(32) NOT NULL )");
        connection.close();
    }

    @Test
    public void testInsert() throws SQLException {
        loadConnction(c -> {
            try {
                c.createStatement().execute("INSERT INTO users VALUES (1,'admin','admin123')");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    private void loadConnction(Consumer<Connection> consumer) throws SQLException {
        Connection connection = dataSource.getConnection();
        consumer.accept(connection);
        connection.close();
    }

    @Test
    public void testInsertWithJdbcTemplate() {
//        jdbcOperations.update("INSERT INTO users VALUES (?,?,?)", 2, "weinaibin", "wnb123456");
        Map<String, Object> obj = jdbcOperations.queryForObject("select * from users where id = ?", (rs, num) -> {
            Map<String, Object> map = new LinkedHashMap<>();
            map.put("id", rs.getInt(1));
            map.put("username", rs.getString(2));
            map.put("password", rs.getString(3));
            return map;
        }, 1);
        obj.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
    }
}
