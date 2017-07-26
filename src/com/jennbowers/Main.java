package com.jennbowers;

import com.jennbowers.helpers.DatabaseManager;
import com.jennbowers.model.Account;

import java.sql.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException{
	    Class.forName("org.sqlite.JDBC");

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:account.db")) {
            DatabaseManager dbm = new DatabaseManager(connection);

            initializeAtm(dbm);

        } catch (SQLException ex) {
            System.out.println("Something went wrong with your DB connection.");
            ex.printStackTrace();
        }
    }

    public static void initializeAtm(DatabaseManager dbm) {
        System.out.println("-----------------------------------------------------------");
        System.out.println("Welcome to your personal ATM. How can I help you today?");
        System.out.println("1) Make a deposit");
        System.out.println("2) Make a withdrawl");
        System.out.println("3) See your current balance");
        System.out.println("-----------------------------------------------------------");


    }
}

