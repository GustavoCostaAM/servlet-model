package com.ScaneIA.DAO;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class SuperDAO {
    private final String JDBC_URL;
    private final String JDBC_USER;
    private final String JDBC_USER_PASS_WORD;

    //builder
    public SuperDAO() {
        Dotenv dotenv = Dotenv.load();

        //access to .env variables
        this.JDBC_URL = dotenv.get("JDBC_URL");
        this.JDBC_USER = dotenv.get("JDBC_USER");
        this.JDBC_USER_PASS_WORD = dotenv.get("JDBC_USER_PASS_WORD");
    }

    //get connection
    public Connection getConnection() throws SQLException, ClassNotFoundException{
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_USER_PASS_WORD);
    }
}
