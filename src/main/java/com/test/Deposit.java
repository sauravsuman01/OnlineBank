package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Deposit")
public class Deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		HttpSession http = request.getSession();
		int x = (int) http.getAttribute("custid");
		
		User user = new User();
		
		int amount = Integer.parseInt(request.getParameter("deposit"));
		try {
			Connection con = UserDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select balance from banking where custid = ?");
			ps.setInt(1, x);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				user.setBalance(rs.getInt(1));
			}
			
			int total = amount + user.getBalance();
			int z = UserDao.update(total, x);
			
			if(z>0) {
				RequestDispatcher rd = request.getRequestDispatcher("Deposit.html");
				rd.include(request, response);
				pw.println("Deposit Success");
			}
		}
			
			catch(Exception e) {
			e.printStackTrace();
		}
	}

}
