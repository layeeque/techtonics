
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
<script>

function fun()
{
	alert("you have been registered successfully")
	}

</script>
</head>
<body  background="./images/bg2.jpg">
<%HttpSession se=request.getSession(false);%>
<h1 style="color:gray">welcome&nbsp;&nbsp;&nbsp;<%= se.getAttribute("name")%></h1><div style="position:absolute;right:50px;top:50px"><form action="logout" method="post"><h2 style="color: gray">Click Here to Logout</h2><input type="submit" value="logout"/></form>
</div>
<center><table border="2" style="color:blue;position:absolute;top:400px;left:600px;font-size:300%">
<h1 style="color:hotpink;">REGISTER FOR TECH-TALK</h1>
<%
System.out.println("hi");
/* Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/techtalk","root","root");   */
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
	<td><%out.println(rs.getString(4)); %></td>
	<td><input type="button" onclick="fun()" value="register here"/></td>
	</tr><%
}

%>
</table></center>
<div style="position:fixed;bottom:0px;left:620px"><h2 style="color:gray;font-family: cursive;">© ATMECS TECHNOLOGIES, LANCO HILLS, HYDERABAD</h2></div>
</body>
</html>