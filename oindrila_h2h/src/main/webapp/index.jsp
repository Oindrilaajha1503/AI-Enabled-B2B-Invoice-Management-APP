<%@page import="com.highradius.model.invoicee"%>
<%@page import="java.util.List"%>
<%@page import="com.highradius.implementation.invdao"%>
<%@page import="com.highradius.connection.DbConnect"%>
<%@page import="java.sql.Connection"%>
<%@ page isErrorPage="true" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>CRUD Operations</title>
    <%@include file="bootstrap.jsp"%>
 <style>
 table td{
  text-align: center;
  vertical-align: middle;
 }
 </style>
</head>
<body>
   <%@include file="navbar.jsp" %>
   <%
   Connection connn = DbConnect.getConn();
   out.print(connn);
   %>

 <div class='box-content p-5' style = "overflow-x: scroll;">
    <table class="table">
  <thead>
    <tr>
    
  <th scope="col">SL.NO</th>
      <th scope="col">CUSTOMER_ORDER_ID</th>
      <th scope="col">SALES_ORG</th>
      <th scope="col">DISTRIBUTION_CHANNEL</th>
      <th scope="col">DIVISION</th>
      <th scope="col">RELEASED_CREDIT_VALUE</th>
      <th scope="col">PURCHASE_ORDER_TYPE</th>
  	  <th scope="col">COMPANY_CODE</th>
  	  <th scope="col">ORDER_CREATION_DATE</th>
  	  <th scope="col">ORDER_CREATION_TIME</th>
      <th scope="col">CREDIT_CONTROL_AREA</th>
      <th scope="col">SOLD_TO_PARTY</th>
      <th scope="col">ORDER_AMOUNT</th>
<th scope="col">REQUESTED_DELIVERY_DATE</th>
   	  <th scope="col">ORDER_CURRENCY</th>
 	  <th scope="col">CREDIT_STATUS</th>
      <th scope="col">CUSTOMER_NUMBER</th>
 	  <th scope="col">AMOUNT_IN_USD</th>
 	  <th scope="col">UNIQUE_CUST_ID</th>
 	  <th scope="col">ACTION</th>
    </tr>
  </thead>
  <tbody>
  <%
  invdao dao = new invdao(DbConnect.getConn());
  List<invoicee> list = dao.get20Invoice();
  for(invoicee inv : list){
	  %>
	 <tr>
	  <td><%=inv.getslno() %></td>
      <td><%=inv.getCustomer_order_id() %></td>
      <td><%=inv.getSales_org() %></td>
      <td><%=inv.getDistribution_channel() %></td>
      <td><%=inv.getDivision() %></td>
      <td><%=inv.getReleased_credit_value() %></td>
      <td><%=inv.getPurchase_order_type() %></td>
      <td><%=inv.getCompany_code() %></td>
      <td><%=inv.getOrder_creation_date() %></td>
      <td><%=inv.getOrder_creation_time() %></td>
      <td><%=inv.getCredit_control_area() %></td>
      <td><%=inv.getSold_to_party() %></td>
      <td><%=inv.getOrder_amount() %></td>
      <td><%=inv.getRequested_delivery_date() %></td>
      <td><%=inv.getOrder_currency() %></td>
      <td><%=inv.getCredit_status() %></td>
      <td><%=inv.getCustomer_number() %></td>
      <td><%=inv.getAmount_in_usd() %></td>
      <td><%=inv.getUnique_cust_id() %></td>
      <td><a href="edit.jsp?slno= <%=inv.getslno() %>" class="btn btn-sm btn-primary">Edit</a>
      <a href="delete?slno= <%=inv.getslno() %>" class="btn btn-sm btn-danger">Delete</a>
      </td>
    
    </tr>
	  
	  <%
  }
  
  %>
    
   
  </tbody>
</table>
</div>
  
</body>
</html>

