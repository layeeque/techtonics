package techtonics;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginverify
 */
@WebServlet("/loginverify")
public class loginverify extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginverify() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("email");
		String password=request.getParameter("password");
	
		try{  
			if(email.equals("admin@atmecs.com") && password.equals("atmecs"))
			{
				request.getRequestDispatcher("admin.jsp").forward(request, response);
			}
			
			System.out.println("hi");
		
			 Database db=new Database();
			 Connection con=db.getconnection();
		
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from user_details where email='"+email+"'");  
			System.out.println("123");
			while(rs.next()) 
			{
				if(email.equals(rs.getString(1)) && password.equals(rs.getString(2))) 
				{
				    HttpSession session=request.getSession();  
			        session.setAttribute("name",email); 
					request.getRequestDispatcher("techtalk.jsp").forward(request, response);
					
				
				}
			}
				
					request.getRequestDispatcher("loginentry.jsp").forward(request, response);
					
				
			
			}
		catch(Exception e){ System.out.println(e);}  
	
	}

	private RequestDispatcher getRequestDispatcher(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	}


