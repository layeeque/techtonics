package techtonics;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class signupverify
 */
@WebServlet("/signupverify")
public class signupverify extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		//String password=request.getParameter("password");
		try{  
			
			
			System.out.println("hi");
			//Class.forName("com.mysql.jdbc.Driver");  
			//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/techtalk","root","root"); 
	 Database db=new Database();
	 Connection con=db.getconnection();
			//System.out.println("123");
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from user_details");  
			System.out.println("123");
			while(rs.next()) 
			{
				if(email.equals(rs.getString(1))) 
				{
					 
					request.getRequestDispatcher("loginentry.jsp").forward(request, response);
					
				
				}
			}
			
			HttpSession session=request.getSession();  
	        session.setAttribute("name",email);
			stmt.executeUpdate("INSERT INTO user_details " + 
	                "VALUES ('"+email+"','"+password+"')");
				
					request.getRequestDispatcher("techtalk.jsp").forward(request, response);
					
				
			
			}
		catch(Exception e){ System.out.println(e);} 
	}

}
