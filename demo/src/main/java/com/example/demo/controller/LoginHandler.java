package com.example.demo.controller;

import com.example.demo.database.DatabaseHandler;
import com.example.demo.model.Character;

import javax.inject.Named;
import javax.servlet.http.Cookie;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Named
public class LoginHandler {

    private static int loginCounter = 0;
    private static Connection conn = DatabaseHandler.connect();

    public static String checkIfUserAlreadyLoggedIn() {
        System.out.println("Checking cookies...");

        if (CookieController.getNameStoredInCookie() != null && CookieController.getLoggedInIndex() != -1 && CharacterController.getLoggedInUsers().size() > 0) {
            System.out.println("Cookie found");

            //DatabaseHandler.saveUserData(CharacterController.getLoggedInUsers().get(CharacterController.getLoggedInUsersCounter()).getName());
            System.out.println("Successfully logged in! Welcome " + CookieController.getNameStoredInCookie() + "!");
            RedirectHandler.setRedirectSite("view/character");

            return RedirectHandler.getRedirectSite();
        }

        System.out.println("Cookie not found!");
        return "login";
    }


        public static void login(String username, String password) {

            ResultSet resultSet;
            Statement statement;
            boolean login = false;
            try {
                statement = conn.createStatement();
                String sql = "SELECT * FROM USERS";
                resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    if (username.equals(resultSet.getString("username")) &&
                            password.equals(resultSet.getString("password"))) {

                        CookieController.setCookie("name", username, -1);
                        CookieController.setCookie("id", String.valueOf(CharacterController.getLoggedInUsersCounter()), -1);


                        System.out.println("SETTING INDEX " + CharacterController.getLoggedInUsersCounter() + " TO USERNAME: " + username);

                        Character character = new Character();
                        character.setName(username);
                        CharacterController.getLoggedInUsers().add(character);


                        System.out.println("Current logged in users");
                        for (Character character1 : CharacterController.getLoggedInUsers()) {
                            if (character1 != null)
                                System.out.println(character1.getName());
                        }
                        System.out.println(CharacterController.getLoggedInUsersCounter());


                        DatabaseHandler.saveUserData(CharacterController.getLoggedInUsers().get(CharacterController.getLoggedInUsersCounter()).getName());
                        System.out.println("Successfully logged in! Welcome " + username + "!");
                        login = true;
                        loginCounter++;
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


    public static int getLoginCounter() {
        return loginCounter;
    }
}
