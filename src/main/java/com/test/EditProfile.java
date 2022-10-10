package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/EditProfile")
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter pw=response.getWriter();  
	    HttpSession http = request.getSession();
	    
		int x = (int) http.getAttribute("custid");

        String phone=request.getParameter("phone");  
        String pan=request.getParameter("pan");  
        String address = request.getParameter("address");
        
        
         User user = new User();
         user.setPhone(phone);
         user.setPan(pan);
         user.setAddress(address);
         user.setCustid(x);
         
         int status=UserDao.updateProfile(user,x);  
         if(status>0){  
        	 pw.println("Updated");
		        RequestDispatcher rd=request.getRequestDispatcher("UpdateForm.html");  

        	 
         }else{  
             pw.println("Sorry! unable to update record");  
         }  
           
         pw.close();  
	}

}
