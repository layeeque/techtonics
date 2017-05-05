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
 * Servlet implementation class requestedit
 */
@WebServlet("/requestedit")
public class requestedit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public requestedit() {
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
		HttpSession session=request.getSession(false);  
        int n=(int)session.getAttribute("num"); 
		
		
		String date=request.getParameter("date");
		String title=request.getParameter("title");
		String description=request.getParameter("description");
		String presenter=request.getParameter("presenter");
		//String password=request.getParameter("password");
		try{  
			
			System.out.println("hi");
		
			 Database db=new Database();
			 Connection con=db.getconnection();
			//System.out.println("123");
			Statement stmt=con.createStatement();  
			stmt.executeUpdate("UPDATE techtalktable SET date='"+date+"' WHERE no='"+n+"'");
			stmt.executeUpdate("UPDATE techtalktable SET title='"+title+"' WHERE no='"+n+"'");
			stmt.executeUpdate("UPDATE techtalktable SET description='"+description+"' WHERE no='"+n+"'");
			stmt.executeUpdate("UPDATE techtalktable SET presenter='"+presenter+"' WHERE no='"+n+"'");
				
					request.getRequestDispatcher("admin.jsp").forward(request, response);
					
				
			 
			}
		catch(Exception e){ System.out.println(e);} 

	}

}
