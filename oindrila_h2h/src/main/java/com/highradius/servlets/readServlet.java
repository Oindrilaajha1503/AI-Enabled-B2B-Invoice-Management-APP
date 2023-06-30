package com.highradius.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.highradius.model.invoicee;



public class readServlet extends HttpServlet {


    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public readServlet() {
        super();
  
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setHeader("Access-Control-Allow-Origin", "*"); // Allow requests from any origin
	     response.setHeader("Access-Control-Allow-Methods", "GET"); // Allow only GET requests
	     response.setHeader("Access-Control-Allow-Headers", "Content-Type"); // Allow only Content-Type header
		PrintWriter out = response.getWriter();
		List<invoicee> list = new ArrayList<invoicee>();
		invoicee inv = null;
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oap_h2h", "root", "Disa@1503");
		
			String sql = "select * from h2h_oap limit 10000 ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				inv = new invoicee();
				inv.setslno(rs.getString(1));
				inv.setCustomer_order_id(rs.getString(2));
				inv.setSales_org(rs.getString(3));
				inv.setDistribution_channel(rs.getString(4));
				inv.setDivision(rs.getString(5));
				inv.setReleased_credit_value(rs.getString(6));
				inv.setPurchase_order_type(rs.getString(7));
				inv.setCompany_code(rs.getString(8));
				inv.setOrder_creation_date(rs.getString(9));
				inv.setOrder_creation_time(rs.getString(10));
				inv.setCredit_control_area(rs.getString(11));
				inv.setSold_to_party(rs.getString(12));
				inv.setOrder_amount(rs.getString(13));
				inv.setRequested_delivery_date(rs.getString(14));
				inv.setOrder_currency(rs.getString(15));
				inv.setCredit_status(rs.getString(16));
				inv.setCustomer_number(rs.getString(17));
				inv.setAmount_in_usd(rs.getString(18));
				inv.setUnique_cust_id(rs.getString(19));
				list.add(inv);
				
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        System.out.println("yay checking3");
		String json = new Gson().toJson(list);
		out.print(json);
		 out.flush();
		
		
 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}

