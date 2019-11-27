package com.example.demo.database;


import com.example.demo.controller.CharacterController;
import com.example.demo.controller.CookieController;
import com.example.demo.controller.MarketController;
import com.example.demo.controller.QuestController;
import com.example.demo.model.Character;
import com.example.demo.model.Item;
import com.example.demo.model.Quest;
import com.example.demo.view.LoginView;
import org.springframework.aop.scope.ScopedObject;

import javax.annotation.ManagedBean;
import javax.inject.Named;
import java.sql.*;
import java.util.ArrayList;

@Named
public class DatabaseHandler {

    private static final String DB_USERNAME = "3TPwwoisvN";
    private static final String DB_DBNAME = "3TPwwoisvN";
    private static final String DB_PASSWORD = "8vHjTGL9Kc";
    private static final String DB_SERVERNAME = "remotemysql.com";
    private static final Integer DB_PORT = 3306;
    private static Statement statement = null;
    private static Connection connection = connect();



    private static String username;
    private static String password;
    private static String redirectSite;

    public static String redirect() {
        System.out.println("Redirecting to " + redirectSite + "....");
        return redirectSite;
    }


    public static Connection connect() {
        Connection conn = null;


        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Couldn't find Driver class...");
        }

        //System.out.println("Trying to connect to the database...");
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + DB_SERVERNAME + "/" + DB_DBNAME, DB_USERNAME, DB_PASSWORD);
            //System.out.println("Successfully connected to the database..");
            return conn;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to the database...");
            return null;
        }
    }

    public static void insertBasicDataIntoNewUser(Connection conn, String username) {
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Couldn't create a new statement to insert basic date into a new user's table.");
            e.printStackTrace();
        }

        String sql = "INSERT INTO CHARACTERS VALUES(" +
                "'" + username + "'," +
                "'null'," +
                "'null'," +
                "'100'," +
                "'40'," +
                "'0'," +
                "'10'," +
                "'10'," +
                "'10'," +
                "'10'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'4'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0'," +
                "'0', " +
                "'-1', " +
                "'-1', " +
                "'-1'," +
                "'-1')";


        try {
            statement.executeUpdate(sql);
            System.out.println("Successfully inserted basic data into + " + username);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong with inserting basic data into " + username);
        }
    }



    public static void createUsersTable(Connection conn) {


        System.out.println("Trying to create new USERS table..");
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Something went wrong while creating the statement for making a new USERS table.");
        }

        String sql = "CREATE TABLE IF NOT EXISTS USERS (" +
                "username VARCHAR(15) PRIMARY KEY NOT NULL," +
                "password VARCHAR(20) NOT NULL" +
                ")";

        try {
            statement.executeUpdate(sql);
            System.out.println("Succesfully created new USERS table");
        } catch (SQLException e) {
            System.out.println("User already exists!");
        }
    }

    public static void createCharactersTable(Connection conn) {
        System.out.println("Trying to create new CHARACTERS table...");
        try {
            statement = conn.createStatement();
            String sql =  "CREATE TABLE IF NOT EXISTS CHARACTERS (" +
                    "name VARCHAR(15) PRIMARY KEY NOT NULL DEFAULT " + "'" + username + "'"+ ","+
                    "race VARCHAR(30) NOT NULL," +
                    "img VARCHAR(100) NOT NULL," +
                    "energy INT NOT NULL," +
                    "exp INT NOT NULL DEFAULT 0," +
                    "cash INT NOT NULL DEFAULT 0, " +
                    "str INT NOT NULL DEFAULT 10," +
                    "intel INT NOT NULL DEFAULT 10," +
                    "con INT NOT NULL DEFAULT 10," +
                    "dex INT NOT NULL DEFAULT 10," +
                    "helmet INT," +
                    "gloves INT," +
                    "boots INT," +
                    "outfit INT," +
                    "weapon INT," +
                    "jewellery2 INT," +
                    "jewellery1 INT," +
                    "inv1 INT," +
                    "inv2 INT," +
                    "inv3 INT," +
                    "inv4 INT," +
                    "inv5 INT," +
                    "inv6 INT," +
                    "inv7 INT," +
                    "inv8 INT," +
                    "is_working INT, " +
                    "work_end INT, " +
                    "quest_id INT, " +
                    "quest_reward INT)";

            statement.executeUpdate(sql);
            System.out.println("Successfully created CHARACTER table");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong while creating a new CHARACTER table");
        }

    }

    public static void updateUser(String username, String whatToUpdate, Object newValue) {

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("UPDATE CHARACTERS SET " + whatToUpdate + " = " + newValue + " WHERE name = ?");
            //statement.setString(1, whatToUpdate);
            //statement.setObject(2, newValue);
            statement.setString(1, username);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong while trying to create statement to update the user..");
        }

        System.out.println("Trying to update CHARACTERS TABLE " + whatToUpdate + " field to " + newValue + " WHERE USERNAME IS " + username);
        try {
            statement.executeUpdate();
            System.out.println("Successfully updated CHARACHERS TABLE " + whatToUpdate + " field to " + newValue + " WHERE USERNAME IS " + username);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't update CHARACTERS TABLE " + whatToUpdate + " field to " + newValue + " WHERE USERNAME IS " + username);
        }


    }

    public static void dropTable(Connection conn, String tableName) {
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Something wente wrong while creating a statement to drop the table");
        }

        String sql = "DROP TABLE " + tableName;
        try {
            statement.executeUpdate(sql);
            System.out.println("Successfully dropped table " + tableName);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong whle dropping table " + tableName);
        }


    }

    public static void saveUserData(String username) {
        Connection conn = DatabaseHandler.connect();
        ResultSet resultSet;
        PreparedStatement statement;
        try {
            statement = conn.prepareStatement("SELECT * FROM CHARACTERS WHERE name = ?");
            statement.setString(1, username);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println("Setting index " + CharacterController.getLoggedInUsersCounter() + " to " + resultSet.getString("name"));
                CharacterController.getLoggedInUsers().get(CharacterController.getLoggedInUsersCounter()).setName(resultSet.getString("name"));
                CharacterController.getLoggedInUsers().get(CharacterController.getLoggedInUsersCounter()).setRace(resultSet.getString("race"));
                CharacterController.getLoggedInUsers().get(CharacterController.getLoggedInUsersCounter()).setImg(resultSet.getString("img"));
                CharacterController.getLoggedInUsers().get(CharacterController.getLoggedInUsersCounter()).setExp(resultSet.getInt("exp"));
                CharacterController.getLoggedInUsers().get(CharacterController.getLoggedInUsersCounter()).setCash(resultSet.getInt("cash"));
                CharacterController.getLoggedInUsers().get(CharacterController.getLoggedInUsersCounter()).setStr(resultSet.getInt("str"));
                CharacterController.getLoggedInUsers().get(CharacterController.getLoggedInUsersCounter()).setIntel(resultSet.getInt("intel"));
                CharacterController.getLoggedInUsers().get(CharacterController.getLoggedInUsersCounter()).setCon(resultSet.getInt("con"));
                CharacterController.getLoggedInUsers().get(CharacterController.getLoggedInUsersCounter()).setDex(resultSet.getInt("dex"));
                CharacterController.getLoggedInUsers().get(CharacterController.getLoggedInUsersCounter()).setHelmet(resultSet.getInt("helmet"));
                CharacterController.getLoggedInUsers().get(CharacterController.getLoggedInUsersCounter()).setGloves(resultSet.getInt("gloves"));
                CharacterController.getLoggedInUsers().get(CharacterController.getLoggedInUsersCounter()).setJew2(resultSet.getInt("jewellery2"));
                CharacterController.getLoggedInUsers().get(CharacterController.getLoggedInUsersCounter()).setOutfit(resultSet.getInt("outfit"));
                CharacterController.getLoggedInUsers().get(CharacterController.getLoggedInUsersCounter()).setWeapon(resultSet.getInt("weapon"));
                CharacterController.getLoggedInUsers().get(CharacterController.getLoggedInUsersCounter()).setJew1(resultSet.getInt("jewellery1"));
                CharacterController.getLoggedInUsers().get(CharacterController.getLoggedInUsersCounter()).setInv1(resultSet.getInt("inv1"));
                CharacterController.getLoggedInUsers().get(CharacterController.getLoggedInUsersCounter()).setInv2(resultSet.getInt("inv2"));
                CharacterController.getLoggedInUsers().get(CharacterController.getLoggedInUsersCounter()).setInv3(resultSet.getInt("inv3"));
                CharacterController.getLoggedInUsers().get(CharacterController.getLoggedInUsersCounter()).setInv4(resultSet.getInt("inv4"));
                CharacterController.getLoggedInUsers().get(CharacterController.getLoggedInUsersCounter()).setInv5(resultSet.getInt("inv5"));
                CharacterController.getLoggedInUsers().get(CharacterController.getLoggedInUsersCounter()).setInv6(resultSet.getInt("inv6"));
                CharacterController.getLoggedInUsers().get(CharacterController.getLoggedInUsersCounter()).setInv7(resultSet.getInt("inv7"));
                CharacterController.getLoggedInUsers().get(CharacterController.getLoggedInUsersCounter()).setInv8(resultSet.getInt("inv8"));
                CharacterController.getLoggedInUsers().get(CharacterController.getLoggedInUsersCounter()).setWork_end(resultSet.getLong("work_end"));
                CharacterController.getLoggedInUsers().get(CharacterController.getLoggedInUsersCounter()).setWorking(resultSet.getInt("is_working"));
                CharacterController.getLoggedInUsers().get(CharacterController.getLoggedInUsersCounter()).setQuestId(resultSet.getInt("quest_id"));
                CharacterController.getLoggedInUsers().get(CharacterController.getLoggedInUsersCounter()).setQuestReward(resultSet.getInt("quest_reward"));
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }

        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Character character = CharacterController.getLoggedInUsers().get(CharacterController.getLoggedInUsersCounter());
        QuestController.randomizeQuests(character);
        MarketController.randomizeMarketItems(character);


    }

    public static void deleteAllUserTable(Connection connection) {
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Something went wrong while creating a statement to get the users");
        }

        String sql = "SELECT * FROM USERS";
        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("Something went wrong while executing SELECT * FROM USERS query");
            e.printStackTrace();
        }

        try {
            while (resultSet.next()) {
                dropTable(connection, resultSet.getString("username"));
            }
        } catch (SQLException e) {
            System.out.println("Something went wrong while dropping user table");
            e.printStackTrace();
        }
    }

    public static ArrayList<Quest> getAllQuestsFromDatabase() {
        ArrayList<Quest> quests = new ArrayList<Quest>();
        Connection connection = connect();
        try {
            statement = connection.createStatement();
            String sql = "SELECT * FROM QUESTS";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                quests.add(new Quest(resultSet.getInt("id"), resultSet.getString("description")));
            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return quests;
    }

    public static ArrayList<Item> getAllItemsFromDatabase() {
        ArrayList<Item> items = new ArrayList<>();
        Connection connection = connect();
        try {
            statement = connection.createStatement();
            String sql = "SELECT * FROM items";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                items.add(new Item(
                   resultSet.getInt("item_id"),
                   resultSet.getString("name"),
                   resultSet.getInt("strength"),
                   resultSet.getInt("intelligence"),
                   resultSet.getInt("dexterity"),
                   resultSet.getInt("constitution"),
                   resultSet.getInt("item_type"),
                   resultSet.getInt("price")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return items;
    }


    public static void main(String[] args) {
        Connection connection = connect();
        deleteAllUserTable(connection);
        dropTable(connection, "USERS");
        dropTable(connection, "CHARACTERS");
        createUsersTable(connection);
        createCharactersTable(connection);



    }


}

