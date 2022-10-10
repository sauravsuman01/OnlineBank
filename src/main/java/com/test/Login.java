package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();  
		    HttpSession http = request.getSession();
		    
		    System.out.println("==============Login servlet called=================");
		          

		    int n=Integer.parseInt(request.getParameter("custid"));  
		    String p=request.getParameter("password");
		    
		    System.out.println(p);
		    
		    http.setAttribute("custid", n);
		    ResultSet rs = UserDao.validate(n, p);
		    try {
				if(rs.next()){  
					String firstname= rs.getString("first_name");
					http.setAttribute("custid", n);
					http.setAttribute("fname", firstname);
				    RequestDispatcher rd=request.getRequestDispatcher("LoggedIn.jsp");  
				    rd.forward(request,response);  
				}  
				else{  
				    out.print("Sorry username or password error");  
				    RequestDispatcher rd=request.getRequestDispatcher("Login.html");  
				    rd.include(request,response);  
				}
			} catch (SQLException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
		          
		    out.close();  
    }
}