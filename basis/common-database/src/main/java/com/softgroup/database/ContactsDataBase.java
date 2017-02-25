package com.softgroup.database;

import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by alex on 25.02.17.
 */

@Component
public class ContactsDataBase extends DataBase {
    public void addContacts(List<Map<String, Object>> contacts) {
        String query = "SELECT * FROM contacts WHERE user = '%s' AND name='%s' AND number = '%s'";
        for (Map<String, Object> contact : contacts) {
            try {
                if (!conn.createStatement()
                        .executeQuery(String.format
                                (query,
                                        contact.get("user"),
                                        contact.get("name"),
                                        contact.get("number")))
                        .next()) {
                    addContact(contact);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void addContact(Map<String, Object> contact) {
        try {
            String query = "INSERT INTO contacts (user, name, number) VALUES ('%s', '%s', '%s')";
            conn.createStatement().executeUpdate(String.format
                    (query,
                            contact.get("user"),
                            contact.get("name"),
                            contact.get("number")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeContacts(List<Map<String, Object>> contacts) {
        String query = "DELETE FROM contacts WHERE user = '%s' AND name = '%s' AND number = '%s'";
        for (Map<String, Object> contact : contacts) {
            try {
                conn.createStatement().executeUpdate(String.format
                        (query,
                                contact.get("user"),
                                contact.get("name"),
                                contact.get("number")));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
