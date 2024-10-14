import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Demo4 {
public static void main(String[] args) throws Exception{
	DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
	System.out.println("driver loaded successfully");
	
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024","root","Nayana@123");
	System.out.println("connection established");
	
	String s = "insert into student values(?,?,?,?,?)";
	PreparedStatement pstmt = con.prepareStatement(s);
	
	Scanner scan = new Scanner(System.in);
	
	System.out.println("enter id:");
	int id = scan.nextInt();
	
	System.out.println("enter name:");
	String name = scan.next();
	
	System.out.println("enter marks1:");
	int marks1 = scan.nextInt();
	System.out.println("enter marks2:");
	int marks2 = scan.nextInt();
	System.out.println("enter marks3:");
	int marks3 = scan.nextInt();
	
	pstmt.setInt(1, id);
	pstmt.setString(2, name);
	pstmt.setInt(3, marks1);
	pstmt.setInt(4, marks2);
	pstmt.setInt(5, marks3);
	
	int rows= pstmt.executeUpdate();
	System.out.println(rows);
}
}
