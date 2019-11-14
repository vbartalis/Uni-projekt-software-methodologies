package com.example.demo.controller;

import com.example.demo.database.DatabaseHandler;

import javax.inject.Named;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Named
public class LoginHandler {

    public static void login(String username, String password) {
        Connection conn = DatabaseHandler.connect();
        ResultSet resultSet;
        Statement statement;
        boolean login = false;
        try {
            statement = conn.createStatement();
            String sql = "SELECT * FROM USERS";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                System.out.println("Username: " + resultSet.getString("username") + " Password: " + resultSet.getString("password"));
                if (username.equals(resultSet.getString("username")) &&
                        password.equals(resultSet.getString("password"))) {

                    CookieController.setCookie("name", username, -1);
                    DatabaseHandler.saveUserData(username);
                    System.out.println("Successfully logged in! Welcome " + username + "!");
                    login = true;
                    RedirectHandler.setRedirectSite("view/character");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (!login) {
            RedirectHandler.setRedirectSite("login");
        }

    }
}
