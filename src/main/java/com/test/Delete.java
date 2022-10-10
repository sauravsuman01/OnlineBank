package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		int acc = Integer.parseInt(request.getParameter("delete"));
		int z = UserDao.delete(acc);
		
		if(z>0) {
			RequestDispatcher rd = request.getRequestDispatcher("AdminLogged.html");
			rd.include(request, response);
			pw.println("Account Deleted");
		}
	}

}
