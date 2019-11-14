package com.example.demo.database;


import com.example.demo.model.Character;
import com.example.demo.view.LoginView;
import org.springframework.aop.scope.ScopedObject;

import javax.annotation.ManagedBean;
import javax.inject.Named;
import java.sql.*;

@Named
public class DatabaseHandler {

    private static final String DB_USERNAME = "3TPwwoisvN";
    private static final String DB_DBNAME = "3TPwwoisvN";
    private static final String DB_PASSWORD = "8vHjTGL9Kc";
    private static final String DB_SERVERNAME = "remotemysql.com";
    private static final Integer DB_PORT = 3306;
    private static Statement statement = null;

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

        System.out.println("Trying to connect to the database...");
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + DB_SERVERNAME + "/" + DB_DBNAME, DB_USERNAME, DB_PASSWORD);
            System.out.println("Successfully connected to the database..");
            return conn;
        } catch (SQLException e) {
            System.out.println("Couldn't connect to the database...");
            return null;
        }
    }

    private static void insertBasicDataIntoNewUser(Connection conn, String username) {
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Couldn't create a new statement to insert basic date into a new user's table.");
            e.printStackTrace();
        }

        String sql = "INSERT INTO " + username + " VALUES(" +
                "'" + username + "'," +
                "'null'," +
                "'null'," +
                "'100'," +
                "'0'," +
                "'0'," +
                "'10'," +
                "'10'," +
                "'10'," +
                "'10'," +
                "'-1'," +
                "'-1'," +
                "'-1'," +
                "'-1'," +
                "'-1'," +
                "'-1'," +
                "'-1'," +
                "'-1'," +
                "'-1'," +
                "'-1'," +
                "'-1'," +
                "'-1'," +
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

    public static void createNewUser(Connection conn, String username) {
        try {
            statement = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong while creating statement to make a new USER table");
        }
        String sql = "CREATE TABLE IF NOT EXISTS " + username + "(" +
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
                "jewellery INT," +
                "inv1 INT," +
                "inv2 INT," +
                "inv3 INT," +
                "inv4 INT," +
                "inv5 INT," +
                "inv6 INT," +
                "inv7 INT," +
                "inv8 INT)";

        try {
            statement.executeUpdate(sql);
            System.out.println("Succesfully created new " + username + " table");
            insertBasicDataIntoNewUser(conn, username);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't create new " + username + " table. Check if " + username + " table already exists or not!");
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

    public static void updateUser(String username, String whatToUpdate, Object newValue) {
        Connection connection = connect();

        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong while trying to create statement to update the user..");
        }

        String sql = "UPDATE " + username + " SET " + whatToUpdate + " = " + newValue;
        System.out.println("Trying to update " + username + " TABLE's " + whatToUpdate + " field to " + newValue);
        try {
            statement.executeUpdate(sql);
            System.out.println("Successfully updated " + username + " TABLE's " + whatToUpdate + " field to " + newValue);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Couldn't update " + username + " TABLE's " + whatToUpdate + " field to " + newValue);
        }

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
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
        Statement statement;
        try {
            statement = conn.createStatement();
            String sql = "SELECT * FROM " + username;
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Character.setName(resultSet.getString("name"));
                Character.setRace(resultSet.getString("race"));
                Character.setImg(resultSet.getString("img"));
                Character.setExp(resultSet.getInt("exp"));
                Character.setCash(resultSet.getInt("cash"));
                Character.setStr(resultSet.getInt("str"));
                Character.setIntel(resultSet.getInt("intel"));
                Character.setCon(resultSet.getInt("con"));
                Character.setDex(resultSet.getInt("dex"));
                Character.setHelmet(resultSet.getInt("helmet"));
                Character.setGloves(resultSet.getInt("gloves"));
                Character.setBoots(resultSet.getInt("boots"));
                Character.setOutfit(resultSet.getInt("outfit"));
                Character.setWeapon(resultSet.getInt("weapon"));
                Character.setJewellry(resultSet.getInt("jewellery"));
                Character.setInv1(resultSet.getInt("inv1"));
                Character.setInv2(resultSet.getInt("inv2"));
                Character.setInv3(resultSet.getInt("inv3"));
                Character.setInv4(resultSet.getInt("inv4"));
                Character.setInv5(resultSet.getInt("inv5"));
                Character.setInv6(resultSet.getInt("inv6"));
                Character.setInv7(resultSet.getInt("inv7"));
                Character.setInv8(resultSet.getInt("inv8"));
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        Connection connection = connect();
        createUsersTable(connection);



    }


}

