package com.jennbowers;

import com.jennbowers.helpers.DatabaseManager;
import com.jennbowers.model.Account;

import java.sql.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException{
	    Class.forName("org.sqlite.JDBC");

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:account.db")) {
            DatabaseManager db = new DatabaseManager(connection);
            db.dropAccountTable();
            db.createAccountTable();

            Statement statement = db.getStatement();

            Account openingAccount = new Account(0.00, statement);
            openingAccount.save();

            List<Account> results = Account.findAll(db);
            for (Account amount: results) {
                System.out.println(amount);
            }
        } catch (SQLException ex) {
            System.out.println("Something went wrong with your DB connection.");
            ex.printStackTrace();
        }
    }
}

