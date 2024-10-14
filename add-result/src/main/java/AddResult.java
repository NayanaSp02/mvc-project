

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddResult extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		//request.getParameter("id")---->gives me the id in the string format and we are coverting string to int type by using parsreInt()
		
		String name=request.getParameter("name");
		//name is required in the string format . therefore we are not converting it into an int type.
		
		int marks1=Integer.parseInt(request.getParameter("marks1"));
		int marks2=Integer.parseInt(request.getParameter("marks2"));
		int marks3=Integer.parseInt(request.getParameter("marks3"));
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024","root","Nayana@123");
			
			String s="insert into student values(?,?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(s);
			
			pstmt.setInt(1, id);
			pstmt.setString(2, name);
			pstmt.setInt(3, marks1);
			pstmt.setInt(4, marks2);
			pstmt.setInt(5, marks3);
			
			int row=pstmt.executeUpdate();
			
			PrintWriter out=response.getWriter();
			
			if(row==0) {
				out.println("student data not added...");
			}
			else {
				out.println("student data added successfully");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
