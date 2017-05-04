package techtonics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	static Connection con;
	public Database()
	{
		
	}
	public Connection getconnection()
	{
		if(con==null)
		{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/techtalk","root","root"); 
			//return con;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return con;
		}
		else
		{
			return con;
		}
	}

}
