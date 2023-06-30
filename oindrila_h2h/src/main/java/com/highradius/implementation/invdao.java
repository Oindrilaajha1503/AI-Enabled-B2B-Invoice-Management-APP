package com.highradius.implementation;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.highradius.model.invoicee;
import com.mysql.cj.xdevapi.PreparableStatement;

@SuppressWarnings("unused")
public class invdao {
	private Connection conn;
	
	public invdao(Connection conn) {
		super();
		this.conn=conn;
	}
	
	public boolean add(invoicee inv) {
		boolean f = false;
		try {
			String sql = "insert into h2h_oap(Sl_no,CUSTOMER_ORDER_ID,SALES_ORG,DISTRIBUTION_CHANNEL,DIVISION,RELEASED_CREDIT_VALUE,PURCHASE_ORDER_TYPE,COMPANY_CODE,ORDER_CREATION_DATE,ORDER_CREATION_TIME,CREDIT_CONTROL_AREA,SOLD_TO_PARTY,ORDER_AMOUNT,REQUESTED_DELIVERY_DATE,ORDER_CURRENCY,CREDIT_STATUS,CUSTOMER_NUMBER,AMOUNT_IN_USD,UNIQUE_CUST_ID) values (0,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, inv.getCustomer_order_id());
			ps.setString(2, inv.getSales_org());
			ps.setString(3, inv.getDistribution_channel());
			ps.setString(4, inv.getDivision());
			ps.setString(5, inv.getReleased_credit_value());
			ps.setString(6, inv.getPurchase_order_type());
			ps.setString(7, inv.getCompany_code());
			ps.setString(8, inv.getOrder_creation_date());
			ps.setString(9, inv.getOrder_creation_time());
			ps.setString(10, inv.getCredit_control_area());
			ps.setString(11, inv.getSold_to_party());
			ps.setString(12, inv.getOrder_amount());
			ps.setString(13, inv.getRequested_delivery_date());
			ps.setString(14, inv.getOrder_currency());
			ps.setString(15, inv.getCredit_status());
			ps.setString(16, inv.getCustomer_number());
			ps.setString(17, inv.getAmount_in_usd());
			ps.setString(18, inv.getUnique_cust_id());
			
		
			
			int i = ps.executeUpdate();
			if (i==1) {
				f=true;
			}
		   
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public List<invoicee> get20Invoice(){
		List<invoicee> list = new ArrayList<invoicee>();
		invoicee inv = null;
		try {
		
			String sql = "select * from h2h_oap limit 6";
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	public invoicee getInvoiceById(String slno) {
		
		invoicee inv = null;
		try {
		
			String sql = "select * from h2h_oap where Sl_no = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, slno);
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
									
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return inv;
	}
	
	
	public boolean edit(invoicee inv) {
	    boolean f = false;
	    try {
	        String sql = "update h2h_oap set CUSTOMER_ORDER_ID=? ,SALES_ORG=? ,DISTRIBUTION_CHANNEL=?,COMPANY_CODE=?,ORDER_CURRENCY=?,AMOUNT_IN_USD=?,ORDER_CREATION_DATE=? where Sl_no=?";

	        PreparedStatement ps = conn.prepareStatement(sql);

	        ps.setString(1, inv.getCustomer_order_id());
	        ps.setString(2, inv.getSales_org());
	        ps.setString(3, inv.getDistribution_channel());
	        ps.setString(4, inv.getCompany_code());
	        ps.setString(5, inv.getOrder_currency());
	        ps.setString(6, inv.getAmount_in_usd());
	        ps.setString(7, inv.getOrder_creation_date());
	        ps.setString(8, inv.getslno());

	        int i = ps.executeUpdate();
	        if (i==1) {
	            f=true;
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return f;
	}

	
	
	
	
	
	
	
	public boolean delete(String id) {
		System.out.println(id);
		boolean f =false;
		try {
			String sql = "delete from h2h_oap where Sl_no = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			int i = ps.executeUpdate();
			if (i==1) {
				f=true;
				System.out.println("deleted");				
			}else {
				System.out.println("error");
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return f;
	}

}
