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

@WebServlet("/Withdraw")
public class Withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		HttpSession http = request.getSession();
		int x = (int) http.getAttribute("custid");
		
		PrintWriter pw = response.getWriter();
		
		User user = new User();
		
		int amount = Integer.parseInt(request.getParameter("withdraw"));
		try {
			Connection con = UserDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select balance from banking where custid = ?");
			ps.setInt(1, x);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				user.setBalance(rs.getInt(1));
			}
			
			int total = user.getBalance()-amount;
			int z = UserDao.update(total, x);
			
			if(z>0) {
				RequestDispatcher rd = request.getRequestDispatcher("Withdraw.html");
				rd.include(request, response);
				pw.println("Withdraw Success");
			}
		}
			
			catch(Exception e) {
			e.printStackTrace();
		}

	}

}
