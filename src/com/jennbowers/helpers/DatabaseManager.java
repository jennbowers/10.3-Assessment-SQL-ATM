package com.jennbowers.helpers;

import java.sql.Connection;
import java.sql.ResultSet;
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

    public Statement getStatement() {
        return statement;
    }

    public void createAccountTable() throws SQLException {
        statement.executeUpdate("CREATE TABLE account (id INTEGER PRIMARY KEY, transactionAmount STRING)");

    }

    public void dropAccountTable() throws SQLException {
        statement.executeUpdate("DROP TABLE IF EXISTS account");
    }

    public ResultSet findAll (String table) throws SQLException {
        String formattedSql = String.format("SELECT * FROM %s", table);
        ResultSet rs = statement.executeQuery(formattedSql);
        return rs;
    }
}
