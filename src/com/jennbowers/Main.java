package com.jennbowers;

import com.jennbowers.helpers.DatabaseManager;
import com.jennbowers.model.Account;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

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

    public static void initializeAtm(DatabaseManager dbm) throws SQLException {
        System.out.println("-----------------------------------------------------------");
        System.out.println("Welcome to your personal ATM. How can I help you today?");
        System.out.println("1) Make a deposit");
        System.out.println("2) Make a withdrawl");
        System.out.println("3) See your current balance");
        System.out.println("-----------------------------------------------------------");

        Scanner scanner = new Scanner (System.in);
        int userInput = scanner.nextInt();

        switch (userInput){
            case 1:
                System.out.println("Let's make a deposit!");
                System.out.println("How much money would you like to deposit?");
                double userInputDeposit = scanner.nextDouble();
                Account newDeposit = new Account(userInputDeposit, dbm.getStatement());
                newDeposit.save();
                break;
            case 2:
                System.out.println("Let's make a withdrawl");
                System.out.println("How much money would you like to withdraw?");
                String userInputWithdrawlString = "-" + scanner.next();
                double userInputWithdrawl = Double.parseDouble(userInputWithdrawlString);
                Account newWithdrawl = new Account(userInputWithdrawl, dbm.getStatement());
                newWithdrawl.save();
                break;
            case 3:
                System.out.println("Let's check out your current balance");
                Account.calculateBalance(dbm);
                break;
            default:
                System.out.println("Please enter a valid input");
        }
        initializeAtm(dbm);
    }
}

