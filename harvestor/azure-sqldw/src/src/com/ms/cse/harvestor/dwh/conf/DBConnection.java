package com.ms.cse.harvestor.dwh.conf;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBConnection {

	
//	    private static String DB_URL = "jdbc:sqlserver://gbssqlserver.database.windows.net:1433;database=gbssqldw;";
//		
//private static String DB_USER = "sqldwadmin";
//private static String DB_PASSWORD = "Password@1234";

    
    
    public static Connection getConnection(String sqlServerUri, String sqlServerUserName,String sqlServerPassword) throws SQLException {
    	DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
    	System.out.println("jdbc:sqlserver://"+sqlServerUri+";");
      Connection connection = DriverManager.getConnection("jdbc:sqlserver://"+sqlServerUri+";", sqlServerUserName,
    		  sqlServerPassword);
    	
    	
        System.err.println("The connection is successfully obtained");
        return connection;
    }
    
    
    
}