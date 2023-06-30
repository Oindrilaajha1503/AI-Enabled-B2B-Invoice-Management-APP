package com.highradius.connection;
import java.sql.*;



public class DbConnect {
 

    private static Connection conn=null;
    
 

    public static Connection getConn() throws SQLException {
    	try {
    	 Class.forName("com.mysql.cj.jdbc.Driver");
		 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oap_h2h", "root", "Disa@1503");


		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
     
    }

}
