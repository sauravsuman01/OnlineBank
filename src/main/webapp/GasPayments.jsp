<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<script>

</script>
<meta charset="UTF-8">
<title>Payments</title>
<style>
h1{
background-color: #f3812a;
}
*{
background-color: #ffccb3;
}

.back{
margin: 11px 866px;
}
</style>
</head>
<body>
<br>
<h1 align="center">Gas Payment</h1><br><br>
<%
Connection con = null;
try{
	HttpSession http = request.getSession();
	int x = (int) http.getAttribute("custid");

	Class.forName("com.mysql.cj.jdbc.Driver");  
    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/perfios", "root", "password");
    PreparedStatement ps = con.prepareStatement("select * from gas, banking where gas.acc = banking.acc and custid=?;");
    ps.setInt(1,x);
    ResultSet rs = ps.executeQuery();
    
//    PreparedStatement ps1 = con.prepareStatement("select * from banking");
 //   ResultSet rs1 = ps1.executeQuery();

    %>
    <form action="PayGas" method="get">
    <table align="center" cellpadding="15" border="1" style="background-color: ffffcc;">
    <tr>
    <th>First Name</th>  
    <th>Last Name</th>
	 <th>Account No.</th>
    <th>Amount Due</th> 
    </tr>
   <%
    while(rs.next()){
    %> 
    <tr>
   <td style= "color: black;"><%=rs.getString(4) %></td>
    <td><%=rs.getString(5) %></td>
    <td><%=rs.getInt(1) %></td>
    <td id="balance"><%=rs.getInt(2) %></td>
    <td><input type="submit" name="pay_btn" value="Pay Now" onClick="validPay()"></td>
    </tr>
    <%} %>
    <%
    rs.close();
    con.close();
}catch(Exception e){
	out.println("Unable to connect to database");
}
%>
    </table>
</form>
<div class="back">
      <a href="LoggedIn.jsp"><button style = "font-size:15px;border-radius:25px" class="btn btn-lg btn-primary btn-block" type="submit">Back</button></a>
  </div>

</body>
</html>