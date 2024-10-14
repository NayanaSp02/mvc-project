//delete values from the table.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Demo7 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		System.out.println("driver loaded successfully");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024","root","Nayana@123");
		System.out.println("connection established Successfully");
		
		String s="delete from student where id=?";	
		PreparedStatement pstmt=con.prepareStatement(s);
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the id:");
		int id=sc.nextInt();
		
		pstmt.setInt(1, id);
		
		int rows=pstmt.executeUpdate();
		System.out.println(rows);
	}

}
