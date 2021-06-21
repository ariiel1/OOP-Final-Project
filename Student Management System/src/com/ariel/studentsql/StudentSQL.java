package com.ariel.studentsql;

//imports
import java.sql.Connection;
import java.sql.DriverManager;


public class StudentSQL {
    
    //Connecting to database
    static Connection con;
    
    public static Connection getConnection() throws Exception{
        if(con == null){
            Class.forName("com.mysql.jdbc.Driver");
            //getConnection(url, username (default), password (default))
            con = DriverManager.getConnection("jdbc:mysql://localhost/oop", "root", "");
        }
        return con;
    }
   
}
