package techtonics;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class delete
 */
@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete() {
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
int num=Integer.parseInt(request.getParameter("id"));
		
try{  
	
	System.out.println("hi");
	
	 Database db=new Database();
	 Connection con=db.getconnection();

	Statement stmt=con.createStatement();  
	stmt.executeUpdate("delete from techtalktable  WHERE no='"+num+"'");

		
			request.getRequestDispatcher("admin.jsp").forward(request, response);
			
		
	con.close();  
	}
catch(Exception e){ System.out.println(e);} 
	   
        
        
        
        
        
        
	}

}
