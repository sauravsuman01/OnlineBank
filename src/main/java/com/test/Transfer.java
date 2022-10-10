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

@WebServlet("/Transfer")
public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession http = request.getSession();
		int x = (int) http.getAttribute("custid");
		
		PrintWriter pw = response.getWriter();
		
		System.out.println("===============================");
		
		User user = new User();
		User user1 = new User();
		
		int account = Integer.parseInt(request.getParameter("account"));
		int amount = Integer.parseInt(request.getParameter("transfer"));
		try {
			Connection con = UserDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select balance from banking where custid = ?");
			ps.setInt(1, x);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				user.setBalance(rs.getInt(1));
			}
			
			int total = user.getBalance()-amount;
			UserDao.update(total, x);
			
			PreparedStatement pss = con.prepareStatement("select balance from banking where acc = ?");
			pss.setInt(1, account);
			ResultSet resultset = pss.executeQuery();
			while(resultset.next()) {
				user1.setBalance(resultset.getInt(1));
			}
			
			
			int new_total = user1.getBalance() + amount;
			int z = UserDao.new_update(new_total, account);
			
			if(z>0) {
				RequestDispatcher rd = request.getRequestDispatcher("Transfer.html");
				rd.include(request, response);
				pw.println("Transfer Success");
			}
		}
			
			catch(Exception e) {
			e.printStackTrace();
		}

	}

}
