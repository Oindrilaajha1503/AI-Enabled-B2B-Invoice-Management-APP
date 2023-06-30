<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.highradius.model.invoicee" %>
<%@ page import="com.highradius.implementation.invdao" %>
<%@ page import="com.highradius.connection.DbConnect" %>
<%@ page import="com.google.gson.Gson" %>

<%
// Retrieve invoice data
invdao dao = new invdao(DbConnect.getConn());
List<invoicee> invoiceList = dao.get20Invoice();

// Convert invoice data to JSON
Gson gson = new Gson();
String jsonInvoiceList = gson.toJson(invoiceList);
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Invoice Data</title>
    <%@include file="bootstrap.jsp"%>
    <style>
        pre {
           
            overflow: auto;
            background-color: #f7f7f7;
            padding: 10px;
        }
    </style>
</head>
<body>
    <%@include file="navbar.jsp" %>
    
    <div class="container ">
        <h1>Invoice Data</h1>
        
        <h3>JSON Data:</h3>
       <%= jsonInvoiceList %>
        
        <hr>
        
       
    </div>
</body>
</html>
