package com.highradius.servlets;

 import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.highradius.connection.DbConnect;
import com.highradius.implementation.invdao;


@WebServlet("/delete")
public class delete extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5994472927284660281L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String sln = request.getParameter("slno");
       try {
			invdao dao = new invdao(DbConnect.getConn());
			HttpSession session = request.getSession();
			boolean f = dao.delete(sln);	
			if (f) {
				System.out.println(sln);
				session.setAttribute("succMSG","Deleted SUCCESSFULLY");
//				response.sendRedirect("index.jsp");
				System.out.println("data deleted");
			}
			else {
				session.setAttribute("erroMSG"," UNSUCCESSFULL");
				response.sendRedirect("index.jsp");
				System.out.println("error");
				System.out.println(sln);
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
    
    }
}
