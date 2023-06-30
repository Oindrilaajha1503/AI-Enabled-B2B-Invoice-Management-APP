//package com.highradius.connection;
//
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//
//public class DatabaseConnection {
//    private static Connection conn=null;
//    
//    
//
//    public static Connection getConn() throws SQLException {
//    	try {
//    	 Class.forName("com.mysql.cj.jdbc.Driver");
//		 conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/h2h", "root", "system");
//
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return conn;
//     
//    }
//
////    public List<Invoice> getInvoices() {
////        return invoices;
////    }
////
////    public void addInvoices(Invoice invoices) {
////      this.invoices.add(invoices);
////    }
//
//}
