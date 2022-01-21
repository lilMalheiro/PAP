package Model;

import java.io.*;
import java.sql.*;
import java.util.Properties;

public class MySQLConnection {

    private Properties p;
    private Connection connection;

    public MySQLConnection() {
        setConnection();
    }

    private void setConnection() {
        p = new Properties();
        try{
            InputStream input = new FileInputStream("mydbconnection.properties");
            p.load(input);
            connection = DriverManager.getConnection
                    (p.getProperty("url"),p.getProperty("username"),p.getProperty("password"));
            System.out.println("Ligado à BD.");
        } catch (IOException | SQLException e) {
            e.printStackTrace();
            System.out.println("ocorreu um problema...");
        }

    }


    public ResultSet querySELECT (String sql) {
        try{
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }




}