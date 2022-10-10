package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/perfios", "root", "password");  
        }catch(Exception e){
        	e.printStackTrace();
        }  
        return con;  
	}
	
	public static int save(User u){  
        int status=0;  
        try{              

            Connection con=UserDao.getConnection();  
            System.out.println("UserDao function called");
            PreparedStatement ps=con.prepareStatement("insert into banking(initial,first_name,last_name,phone,pan,address,occ,income,type,acc,custid,pass,balance) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, u.getInitial());   
            ps.setString(2, u.getFirst_name());
            ps.setString(3, u.getLast_name());
            ps.setString(4, u.getPhone());
            ps.setString(5, u.getPan());
            ps.setString(6, u.getAddress());
            ps.setString(7, u.getOcc());
            ps.setString(8, u.getIncome());
            ps.setString(9, u.getType());
            ps.setInt(10, u.getAccno());
            ps.setInt(11, u.getCustid());
            ps.setString(12, u.getPass());
            ps.setInt(13, u.getBalance());
            
            System.out.println(u.getFirst_name());
            System.out.println(u.getLast_name());
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){
        	e.printStackTrace();
        	}  
          
        return status;  
    }  
	public static ResultSet validate(int n, String p) {
		ResultSet rs = null;
		try {
			Connection con=UserDao.getConnection(); 
			PreparedStatement ps = con.prepareStatement("select * from banking where custid = ? and pass = ?");
			ps.setInt(1, n);
			ps.setString(2, p);
			
			rs = ps.executeQuery();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return rs;
		
	}
	
	public static int update(int amount, int custid) {
		int status = 0;
		try {
			Connection con = UserDao.getConnection();
			PreparedStatement ps = con.prepareStatement("update banking set balance = ? where custid = ?");
			ps.setInt(1, amount);
			ps.setInt(2, custid);
			
			status = ps.executeUpdate();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static int new_update(int amount, int acc) {
		int status = 0;
		try {
			Connection con = UserDao.getConnection();
			PreparedStatement ps = con.prepareStatement("update banking set balance = ? where acc = ?");
			ps.setInt(1, amount);
			ps.setInt(2, acc);
			
			status = ps.executeUpdate();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static boolean validate_admin(int n, String p) {
		boolean status = false;
		try {
			Connection con=UserDao.getConnection(); 
			PreparedStatement ps = con.prepareStatement("select * from admin where adminid = ? and adminpass = ?");
			ps.setInt(1, n);
			ps.setString(2, p);
			
			ResultSet rs = ps.executeQuery();
            status = rs.next();
            con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
		
	}
	
	public static int delete(int acc) {
		int status = 0;
		try {
			Connection con = UserDao.getConnection();
			PreparedStatement ps = con.prepareStatement("delete from banking where acc=?");
			ps.setInt(1, acc);
			status = ps.executeUpdate();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static int updateDue(int amount, int acc) {
		int status = 0;
		try {
			Connection con = UserDao.getConnection();
			PreparedStatement ps = con.prepareStatement("update payments set due = ? where acc = ?");
			ps.setInt(1, amount);
			ps.setInt(2, acc);
			
			status = ps.executeUpdate();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static int updateDueGas(int amount, int acc) {
		int status = 0;
		try {
			Connection con = UserDao.getConnection();
			PreparedStatement ps = con.prepareStatement("update gas set due = ? where acc = ?");
			ps.setInt(1, amount);
			ps.setInt(2, acc);
			
			status = ps.executeUpdate();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static int updateProfile(User user, int custid) {
		int status=0;  
        try{  
            Connection con=UserDao.getConnection();  
            PreparedStatement ps=con.prepareStatement(  
                         "update banking set phone = ?,pan = ?,address = ? where custid = ?");  
            ps.setString(1,user.getPhone());  
            ps.setString(2,user.getPan()); 
            ps.setString(3,user.getAddress());  
            ps.setInt(4, user.getCustid());
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){
        	ex.printStackTrace();
        	}  
          
        return status;  
	}
	
	
}
