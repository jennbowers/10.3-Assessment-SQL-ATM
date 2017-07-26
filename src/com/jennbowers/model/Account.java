package com.jennbowers.model;

import com.jennbowers.helpers.DatabaseManager;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jenniferbowers on 7/26/17.
 */
public class Account {
    private int id;
    private double transactionAmount;
    private Statement statement;

//    constructor
    public Account(double transactionAmount, Statement statement) {
        this.transactionAmount = transactionAmount;
        this.statement = statement;
    }

//    overloaded constructor
    public Account(double transactionAmount, Statement statement, int id) {
        this(transactionAmount, statement);
        this.id = id;
    }

    public void save() throws SQLException{
        String formattedSql = String.format("INSERT INTO account (transactionAmount) VALUES (%s)", transactionAmount);
        statement.executeUpdate(formattedSql);
    }

    public static List<Account> findAll(DatabaseManager dbm) throws SQLException{
        ResultSet rs = dbm.findAll("account");
        List<Account> tempCollection = new ArrayList<>();
        Statement tempStatement = dbm.getStatement();

        while(rs.next()) {
            double transactionAmount = rs.getDouble("transactionAmount");
            Account tempAccount = new Account(transactionAmount, tempStatement, rs.getInt("id"));
            tempCollection.add(tempAccount);
        }
        return tempCollection;
    }

    @Override
    public String toString() {
        return "Account{" +
                "transactionAmount=" + transactionAmount +
                '}';
    }
}
