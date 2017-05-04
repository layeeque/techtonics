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
<div style="position :absolute;left:100px;height: 300px;width:100%"><img src="./images/atmecs logo.jpg" alt="Mountains" width="300px" height="300px"><h1 style="color:green"><center>TECH-TONICS</center></h1></div>
<%

HttpSession ses=request.getSession(false);  
int n=(int)ses.getAttribute("num");
/* Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/techtalk","root","root");  */
Database db=new Database();
Connection con=db.getconnection();

//System.out.println("123");
Statement stmt=con.createStatement();  
ResultSet rs=stmt.executeQuery("select * from techtalktable where no='"+n+"'");  
System.out.println("123");
while(rs.next()) 
{
	%><center><h1>EARLIER TECH-TALK</h1><br><tr>
	<td>DATE&nbsp;&nbsp;&nbsp;&nbsp;</td><td><%out.println(rs.getString(2)); %></td><br><br>
	<td>TITLE&nbsp;&nbsp;&nbsp;&nbsp;</td><td><%out.println(rs.getString(3)); %></td><br><br>
	<td>DESCRIPTION&nbsp;&nbsp;&nbsp;&nbsp;</td><td><%out.println(rs.getString(4)); %></td><br><br>
	<td>PRESENTER&nbsp;&nbsp;&nbsp;&nbsp;</td><td><%out.println(rs.getString(5)); %></td><br><br>
	</tr><br><br><br><br></center><%
}
%>
<center><h1>MODIFY THE TECH-TALK</h1>
<table>
<form action="requestedit" method="post">

<tr><td>DATE</td><td><input type="date" name=date></td></tr>
<tr><td>TITLE</td><td><input type="text" name=title></td></tr>
<tr><td>DESCRIPTION</td><td><input type="text" name=description></td></tr>
<tr><td>PRESENTER</td><td><input type="text" name=presenter></td></tr>
<tr><input type="submit" value="submit"></br><br><br></tr>

<!-- DATE<input type="date" name=date></br><br><br>
TITLE<input type="text" name=title></br><br><br>
DESCRIPTION<input type="text" name=description></br><br><br>
PRESENTER<input type="text" name=presenter></br><br><br> -->

</form>
</table></center>
<div style="position:fixed;bottom:0px;left:620px"><h2 style="color:gray;font-family: cursive;">© ATMECS TECHNOLOGIES, LANCO HILLS, HYDERABAD</h2></div>

</body>
</html>