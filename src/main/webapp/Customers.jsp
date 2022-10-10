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
</style>
</head>
<body>
<h1 align="center">Customer Details</h1>
<%
Connection con = null;
try{
	Class.forName("com.mysql.cj.jdbc.Driver");  
    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/perfios", "root", "password");
    PreparedStatement ps = con.prepareStatement("select * from banking");
    ResultSet rs = ps.executeQuery();

    %>
    <table id="customer_table" align="center" cellpadding="15" border="1" style="background-color: ffffcc;">
    <tr>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Account No.</th>
    <th>Balance</th>
    <th>Phone</th>
    <th>Pan</th>
    <th>Type</th>
    </tr>
    <%
    while(rs.next()){
    %>
    <tr>
   <td style= "color: black;"><%=rs.getString(2) %></td>
    <td><%=rs.getString(3) %></td>
    <td><%=rs.getInt(10) %></td>
    <td><%=rs.getInt(13) %></td>
    <td><%=rs.getString(4) %></td>
    <td><%=rs.getString(5) %></td>
    <td><%=rs.getString(9) %></td>
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
    
    <script type="text/javascript" src="https://unpkg.com/xlsx@0.15.1/dist/xlsx.full.min.js"></script>
<script type="text/javascript">
    function ExportToExcel(type, fn, dl) {
        var elt = document.getElementById('customer_table');
        var wb = XLSX.utils.table_to_book(elt, { sheet: "sheet1" });
        return dl ?
            XLSX.write(wb, { bookType: type, bookSST: true, type: 'base64' }):
              XLSX.writeFile(wb, fn || ('Details.' + (type || 'xlsx')));
    }
</script>

<button class="btn" onclick="ExportToExcel('xlsx')">DOWNLOAD</button>


</body>
</html>