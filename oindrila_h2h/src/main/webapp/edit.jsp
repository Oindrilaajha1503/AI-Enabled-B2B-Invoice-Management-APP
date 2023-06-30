<%@page import="com.highradius.model.invoicee"%>
<%@page import="com.highradius.connection.DbConnect"%>
<%@page import="com.highradius.implementation.invdao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit</title>
    <%@include file="bootstrap.jsp" %>
  
</head>
<body>
<%@include file="navbar.jsp"%>
    <h1>Edit</h1>
    <% 
    String slno = request.getParameter("slno");
    invdao dao = new invdao(DbConnect.getConn());
    invoicee inv = dao.getInvoiceById(slno);
    
    %>

    <form action="edit" method="post">
    
        <label for="Customer order id">Customer order id:</label>
        <input value="<%=inv.getCustomer_order_id()%>" type="number" id="Customer order id" name="Customer_order_id" required><br>

        <label for="sales org">salesOrg:</label>
        <input value="<%=inv.getSales_org()%>" type="number" id="sales org" name="sales_org" required><br>

        <label for="DISTRIBUTION_CHANNEL">DISTRIBUTION_CHANNEL:</label>
        <input value="<%=inv.getDistribution_channel()%>" type="text" id="DISTRIBUTION_CHANNEL" name="DISTRIBUTION_CHANNEL" required><br>

        <label for="DIVISION">DIVISION:</label>
        <input value="<%=inv.getDivision()%>" type="text" id="DIVISION" name="DIVISION" required><br>
        
         <label for="RELEASED_CREDIT_VALUE">RELEASED_CREDIT_VALUE:</label>
        <input value="<%=inv.getReleased_credit_value() %>" type="number" id="RELEASED_CREDIT_VALUE" name="RELEASED_CREDIT_VALUE" required><br>
        
         <label for="PURCHASE_ORDER_TYPE">PURCHASE_ORDER_TYPE:</label>
        <input value="<%=inv.getPurchase_order_type() %>" type="number" id="PURCHASE_ORDER_TYPE" name="PURCHASE_ORDER_TYPE" required><br>
        
         <label for="COMPANY_CODE">COMPANY_CODE:</label>
        <input value="<%=inv.getCompany_code() %>" type="number" id="COMPANY_CODE" name="COMPANY_CODE" required><br>
        
         <label for="ORDER_CREATION_DATE">ORDER_CREATION_DATE:</label>
        <input value="<%=inv.getOrder_creation_date() %>" type="text" id="ORDER_CREATION_DATE" name="ORDER_CREATION_DATE" required><br>
        
         <label for="ORDER_CREATION_TIME">ORDER_CREATION_TIME:</label>
        <input value="<%=inv.getOrder_creation_time() %>" type="number" id="ORDER_CREATION_TIME" name="ORDER_CREATION_TIME" required><br>
        
         <label for="CREDIT_CONTROL_AREA">CREDIT_CONTROL_AREA:</label>
        <input value="<%=inv.getCredit_control_area() %>" type="text" id="CREDIT_CONTROL_AREA" name="CREDIT_CONTROL_AREA" required><br>
        
         <label for="SOLD_TO_PARTY">SOLD_TO_PARTY:</label>
        <input value="<%=inv.getSold_to_party() %>" type="number" id="SOLD_TO_PARTY" name="SOLD_TO_PARTY" required><br>
        
         <label for="ORDER_AMOUNT">ORDER_AMOUNT:</label>
        <input value="<%=inv.getOrder_amount() %>" type="number" id="ORDER_AMOUNT" name="ORDER_AMOUNT" required><br>
        
         <label for="REQUESTED_DELIVERY_DATE">REQUESTED_DELIVERY_DATE:</label>
        <input value="<%=inv.getRequested_delivery_date()%>" type="text" id="REQUESTED_DELIVERY_DATE" name="REQUESTED_DELIVERY_DATE" required><br>
        
         <label for="ORDER_CURRENCY">ORDER_CURRENCY:</label>
        <input value="<%=inv.getOrder_currency() %>" type="text" id="ORDER_CURRENCY" name="ORDER_CURRENCY" required><br>
        
         <label for="CREDIT_STATUS">CREDIT_STATUS:</label>
        <input value="<%=inv.getCredit_status() %>" type="number" id="CREDIT_STATUS" name="CREDIT_STATUS" required><br>
        
         <label for="CUSTOMER_NUMBER">CUSTOMER_NUMBER:</label>
        <input value="<%=inv.getCustomer_number() %>" type="number" id="CUSTOMER_NUMBER" name="CUSTOMER_NUMBER" required><br>
        
         <label for="AMOUNT_IN_USD">AMOUNT_IN_USD:</label>
        <input value="<%=inv.getAmount_in_usd() %>" type="number" id="AMOUNT_IN_USD" name="AMOUNT_IN_USD" required><br>
        
         <label for="UNIQUE_CUST_ID">UNIQUE_CUST_ID:</label>
        <input value="<%=inv.getUnique_cust_id() %>" type="number" id="UNIQUE_CUST_ID" name="UNIQUE_CUST_ID" required><br>
        
        <input type="hidden" name = "slno" value=<%=inv.getslno() %>>
        
        <input type="submit" value="Edit">
    </form>

    <a href="index.jsp">Back to home</a>
</body>
</html>
