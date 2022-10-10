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

@WebServlet("/PayGas")
public class PayGas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession http = request.getSession();
		int x = (int) http.getAttribute("custid");
		Connection con = UserDao.getConnection();
		
		PrintWriter pw = response.getWriter();
		User user = new User();
		
		try {
			PreparedStatement ps1 = con.prepareStatement("select acc, balance from banking where custid = ?");
			ps1.setInt(1, x);
			ResultSet rs1 = ps1.executeQuery();
			while(rs1.next()) {
				user.setAccno(rs1.getInt(1));
				user.setBalance(rs1.getInt(2));
			}
			
			
			
			PreparedStatement ps = con.prepareStatement("select due from gas where acc = ?");
			ps.setInt(1,user.getAccno());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				user.setDue(rs.getInt(1));
			}
			
			int total =   user.getBalance() - user.getDue();
			UserDao.update(total, x);
			int due=0;
			int z =UserDao.updateDueGas(due, user.getAccno());
			if(z>0) {
				RequestDispatcher rd = request.getRequestDispatcher("GasPayments.jsp");
				rd.include(request, response);
				pw.println("Payment Success");
			}
		}
			
			catch(Exception e) {
			e.printStackTrace();
		}
	}

}
