package com.softgroup.database;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by alex on 16.02.17.
 */

@Component
public class DataBase {

    protected Connection conn;

    @Autowired
    public UsersDataBase users;

    @Autowired
    public ContactsDataBase contacts;

    @PostConstruct
    public void init() {
        try {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUser("root");
            dataSource.setPassword("1024");
            dataSource.setServerName("localhost");
            dataSource.setDatabaseName("chat_database");
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
