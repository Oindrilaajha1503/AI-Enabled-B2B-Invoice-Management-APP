package com.highradius.servlets;

import com.highradius.connection.DbConnect;
import com.highradius.implementation.invdao;
import com.highradius.model.invoicee;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {

    private static final long serialVersionUID = 4674127683867288331L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setAccessControlHeaders(resp);
        resp.setStatus(HttpServletResponse.SC_OK);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        setAccessControlHeaders(resp);
        String slno = req.getParameter("slno");
        String customerOrderId = req.getParameter("customerOrderId");
        String salesOrg = req.getParameter("salesOrg");
        String distributionChannel = req.getParameter("distributionChannel");
        String customerNumber = req.getParameter("customerNumber");
        String companyCode = req.getParameter("companyCode");
        String orderCurrency = req.getParameter("orderCurrency");
        String amountInUSD = req.getParameter("amountInUsd");
        String orderCreationDate = req.getParameter("orderCreationDate");

        invoicee invoice = new invoicee();
        invoice.setslno(slno);
        invoice.setCustomer_order_id(customerOrderId);
        invoice.setSales_org(salesOrg);
        invoice.setDistribution_channel(distributionChannel);
        invoice.setCustomer_number(customerNumber);
        invoice.setCompany_code(companyCode);
        invoice.setOrder_currency(orderCurrency);
        invoice.setAmount_in_usd(amountInUSD);
        invoice.setOrder_creation_date(orderCreationDate);

        try {
            invdao dao = new invdao(DbConnect.getConn());
            boolean isUpdated = dao.edit(invoice);

            if (isUpdated) {
                resp.setStatus(HttpServletResponse.SC_OK); // return 200
                resp.getWriter().write("EDITED SUCCESSFULLY"); // write a success message in the response body
                System.out.println("Data edited successfully");
            } else {
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST); // return 400
                resp.getWriter().write("UNSUCCESSFUL"); // write an error message in the response body
                System.out.println("Error occurred while editing data");
            }        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println(invoice);
    }

    private void setAccessControlHeaders(HttpServletResponse resp) {
        resp.setHeader("Access-Control-Allow-Origin", "http://localhost:3000");
        resp.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
    }
}
