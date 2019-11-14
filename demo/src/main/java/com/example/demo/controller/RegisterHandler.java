package com.example.demo.controller;

import com.example.demo.database.DatabaseHandler;

import javax.inject.Named;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Named
public class RegisterHandler {
    public static void register(String username, String password1, String password2) {
        Connection conn = DatabaseHandler.connect();
        Statement statement = null;
        boolean register = false;

        if (password1.equals(password2)) {
            try {
                statement = conn.createStatement();
                System.out.println("Updating USERS...");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Something went wrong while creating statement to update USERS..");
            }
            try {
                String sql = "INSERT INTO USERS VALUES (" + "'" + username + "'" + ", " + "'" + password1 + "'" + ")";
                statement.executeUpdate(sql);
                System.out.println("Successfully registered! Welcome + " + username);
                System.out.println("Creating new " + username + " table...");
                DatabaseHandler.createNewUser(conn, username);

                RedirectHandler.setRedirectSite("view/character");
                CookieController.setCookie("name", username, -1);
                DatabaseHandler.saveUserData(username);
                register = true;


            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Couldn't add new user to USERS...");
            }
        } else {
            System.out.println("Passwords don't match.");
        }

        if(!register) {
            RedirectHandler.setRedirectSite("register");
        }

    }

}
