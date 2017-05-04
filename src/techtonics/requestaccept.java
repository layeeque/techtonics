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

/**
 * Servlet implementation class requestaccept
 */
@WebServlet("/requestaccept")
public class requestaccept extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public requestaccept() {
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
		String date=request.getParameter("date");
		String title=request.getParameter("title");
		String description=request.getParameter("description");
		String presenter=request.getParameter("presenter");
		//String password=request.getParameter("password");
		try{  
			
			System.out.println("hi");
		
			 Database db=new Database();
			 Connection con=db.getconnection();
			
			Statement stmt=con.createStatement();  
			stmt.executeUpdate("INSERT INTO techtalktable " + 
	                "VALUES (default,'"+date+"','"+title+"','"+description+"','"+presenter+"')");
				
					request.getRequestDispatcher("admin.jsp").forward(request, response);
					
				
		 
			}
		catch(Exception e){ System.out.println(e);} 
	}

}
