<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customers</title>
<style>
h1{
background-color: #f3812a;
}
*{
background-color: #ffccb3;	
}
.table{
margin-top: 50px;
margin-left: 817px;
}
.EditBtn{
margin-left:880px;
margin-top:25px;
}
</style>
</head>
<body>
<h1 align="center">Your Profile Details</h1>
<%
Connection con = null;
HttpSession http= request.getSession();
try{
	int n =(Integer)http.getAttribute("custid");
	Class.forName("com.mysql.cj.jdbc.Driver");  
    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/perfios", "root", "password");
    PreparedStatement ps = con.prepareStatement("select * from banking where custid=?");
    ps.setInt(1,n);
    
    ResultSet rs = ps.executeQuery();

    while(rs.next()){
    %>
    <div class="table">
    <table>
                    <tbody>
                    
                     <tr>
                            <td><label class="small mb-1" >First Name </label></td>
                            <td>:</td>
                            <td><%=rs.getString(2)%></td>
                        </tr>
                        
                        <tr>
                            <td><label class="small mb-1" >Last Name</label></td>
                            <td>:</td>
                            <td><%=rs.getString(3)%></td>
                            
                        </tr>
                        <tr>
                            <td><label class="small mb-1" >Phone</label></td>
                            <td>:</td>
                            <td><%=rs.getString(4)%></td>
                        	
                        </tr>
                        <tr>
                            <td><label class="small mb-1" >PAN</label></td>
                            <td>:</td>
                            <td><%=rs.getString(5)%></td>
                        	
                        </tr>
                        <tr>
                            <td><label class="small mb-1" >Account Number</label></td>
                            <td>:</td>
                            <td><%=rs.getString(10)%></td>
                        	
                        </tr>
                        <tr>
                            <td><label class="small mb-1" >Customer Id</label></td>
                            <td>:</td>
                            <td><%=rs.getString(11)%></td>
                        </tr>
                        <tr>
                            <td><label class="small mb-1" >Account Type</label></td>
                            <td>:</td>
                            <td><%=rs.getString(9)%></td>
                        	
                        </tr>
                        <tr>
                            <td><label class="small mb-1" >Balance</label></td>
                            <td>:</td>
                            <td><%=rs.getString(13)%></td>
                        	
                        </tr>
        
                        
                        
                    </tbody>
                	</table>
                	</div>
                	<div class="EditBtn">
                	<a href="UpdateForm.html"><input type="submit" value="Edit your Profile"></a></div>
    <%} %>
    <%
    rs.close();
    con.close();
}catch(Exception e){
	out.println("Unable to connect to database");
}
%>



</body>
</html>