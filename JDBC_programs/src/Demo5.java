// updating the data in the table.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.SQLException;

public class Demo5 {
	public static void main(String[] args) throws Exception{
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		System.out.println("Driver loaded successfully");
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024", "root", "Nayana@123");
		System.out.println("connection established successfully");
		
		String s="update student set name=? where id=?";
		PreparedStatement pstmt=con.prepareStatement(s);
		Scanner scan=new Scanner(System.in);
		
		System.out.println("enter the name:");
		String name=scan.next();      //nextLine() will generate error
		
		System.out.println("enter the id:");
		int id = scan.nextInt();
		pstmt.setString(1, name);    //whatever there in the name give it to fist placeholder
		pstmt.setInt(2, id);
		
		int rows=pstmt.executeUpdate();
		System.out.println(rows);
		
		
	}

}
