package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  	   
	    
	    System.out.println("=================Admin Called===================");
	          

	    int n=Integer.parseInt(request.getParameter("adminid"));  
	    String p=request.getParameter("adminpass");
	    
	    if(UserDao.validate_admin(n, p)){  
	        RequestDispatcher rd=request.getRequestDispatcher("AdminLogged.html");  
	        rd.forward(request,response);  
	        System.out.println("Hello");
	    }  
	    else{  
	        out.print("Sorry username or password error");  
	        RequestDispatcher rd=request.getRequestDispatcher("Login.html");  
	        rd.include(request,response);  
	        System.out.println("World");
	    }  
	          
	    out.close();  
		
	}

}
