package com.crud.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static Connection con = null;
    private DBConnection(){}
    public static Connection getConnection()
    {
        if(con == null){
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "root");
            } catch (Exception ex) {
                System.out.println("exception in connection get "+ex.getMessage());
                ex.printStackTrace();
            }
        }
        return con;
    }
}
