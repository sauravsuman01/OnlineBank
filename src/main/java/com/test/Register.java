package com.test;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		System.out.println("==============Register servlet called=================");
		Random rand = new Random();
		int accno = rand.nextInt(10000000);
		
		int custid = rand.nextInt(100000);
		
		PrintWriter out = response.getWriter();
		
		String initial = request.getParameter("initial");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String phone =request.getParameter("phone");
		String pan = request.getParameter("pan");
		String address = request.getParameter("address");
		int balance = Integer.parseInt(request.getParameter("balance"));
		String occupation = request.getParameter("occupation");
		String income = request.getParameter("income");
		String type = request.getParameter("type");
		String pass = request.getParameter("pass");
		String repass = request.getParameter("repass");
		
		if(pass.equals(repass)) {
			User user1 = new User();
			user1.setInitial(initial);
			user1.setFirst_name(firstname);
			user1.setLast_name(lastname);
			user1.setPhone(phone);
			user1.setPan(pan);
			user1.setAddress(address);
			user1.setBalance(balance);
			user1.setOcc(occupation);
			user1.setIncome(income);
			user1.setType(type);
			user1.setAccno(accno);
			user1.setPass(pass);
			user1.setCustid(custid);
					
			UserDao.save(user1);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("NewUser.html");
			rd.include(request, response);
			out.println("Registration Success");
		}
			
		else
			out.println("Registration Failed: Password did not match");
		
		
        }

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	}

