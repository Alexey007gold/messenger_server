package com.softgroup.database;

import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * Created by alex on 25.02.17.
 */

@Component
public class UsersDataBase extends DataBase {

    public void addUser(String phoneNumber) {
        if (!hasUser(phoneNumber)) {
            try {
                String query = "INSERT INTO users VALUES ('%s')";
                conn.createStatement().executeUpdate(String.format(query, phoneNumber));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean hasUser(String phoneNumber) {
        try {
            String query = "SELECT * FROM users WHERE phone_number = '%s'";
            return conn.createStatement()
                    .executeQuery(String.format(query, phoneNumber))
                    .next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
