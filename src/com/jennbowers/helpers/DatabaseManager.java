package com.jennbowers.helpers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by jenniferbowers on 7/26/17.
 */
public class DatabaseManager {
    Statement statement;

    public DatabaseManager(Connection connection) throws SQLException {
        this.statement = connection.createStatement();
    }

    public void createAccountTable() throws SQLException {
        statement.executeUpdate("CREATE TABLE account (id INTEGER PRIMARY KEY, transactionAmount STRING, user STRING)");

    }

    public void dropAccountTable() throws SQLException {
        statement.executeUpdate("DROP TABLE IF EXISTS account");
    }
}
