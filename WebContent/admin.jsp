<%@page import="techtonics.Database"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="./images/bg2.jpg">
<h1 style="color:green"><center>welcome admin</center></h1>

<div style="position :absolute;left:800px;height: 250px;width:300px"><center><img src="./images/atmecs logo.jpg" alt="Mountains" width="100%" height="100%"></center><h1 style="color:green"><center>TECH-TONICS</center></h1></div>
<div style="position:absolute;right:50px;top:50px"><form action="logout" method="post"><h2 style="color: gray">Click Here to Logout</h2><input type="submit" value="logout"/></form></div></br>
<div style="position:absolute;left:50px;top:50px"><form action="request" method="post"><h2 style="color: gray">Click Here to make New Entry</h2><input type="submit" value="make a new request"/></form></div><br>
<center><table border="2" style="color:blue;position:absolute;top:500px;left:550px;font-size:250%">
<%
System.out.println("hi");
/* Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/techtalk","root","root");  */
Database db=new Database();
Connection con=db.getconnection();

//System.out.println("123");
Statement stmt=con.createStatement();  
ResultSet rs=stmt.executeQuery("select * from techtalktable");  
System.out.println("123");
while(rs.next()) 
{
	%><tr>
	<td><%out.println(rs.getString(2)); %></td>
	<td><%out.println(rs.getString(3)); %></td>
	<td><%out.println(rs.getString(4)); %></td>
	<td><%out.println(rs.getString(5)); %></td>
	<td><form action="edit" method="post">
		<input type="hidden" value=<%=rs.getString(1) %>   name="id"/>
	<input type="submit"   value="edit"/>
	</form></td>
	<td><form action="delete" method="post">
		<input type="hidden" value=<%=rs.getString(1) %>   name="id"/>
	<input type="submit"   value="delete"/>
	</form></td>
	</tr><%
}

%>
</table>
</center>
<div style="position:fixed;bottom:0px;left:620px"><h2 style="color:gray;font-family: cursive;">© ATMECS TECHNOLOGIES, LANCO HILLS, HYDERABAD</h2></div>
</body>
</html>