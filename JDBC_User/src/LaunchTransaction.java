import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class LaunchTransaction {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024","root","Nayana@123");
		
		Scanner sc=new Scanner(System.in);
		
		con.setAutoCommit(false);
		String s1="insert into student values(?,?,?,?,?)";
		PreparedStatement pstmt1 = con.prepareStatement(s1);
		System.out.println("enter id:");
		int id=sc.nextInt();
		System.out.println("enter the name:");
		String name=sc.next();
		System.out.println("enter marks1:");
		int marks1=sc.nextInt();
		System.out.println("enter marks2:");
		int marks2=sc.nextInt();
		System.out.println("enter marks3:");
		int marks3=sc.nextInt();
		
		pstmt1.setInt(1, id);
		pstmt1.setString(2, name);
		pstmt1.setInt(3, marks1);
		pstmt1.setInt(4, marks2);
		pstmt1.setInt(5, marks3);
		
		String s2="insert into student values(?,?,?,?,?)";
		PreparedStatement pstmt2 = con.prepareStatement(s2);
		System.out.println("enter id:");
		int id2=sc.nextInt();
		System.out.println("enter the name:");
		String name2=sc.next();
		System.out.println("enter marks1:");
		int marks12=sc.nextInt();
		System.out.println("enter marks2:");
		int marks22=sc.nextInt();
		System.out.println("enter marks3:");
		int marks32=sc.nextInt();
		
		pstmt1.setInt(1, id2);
		pstmt1.setString(2, name2);
		pstmt1.setInt(3, marks12);
		pstmt1.setInt(4, marks22);
		pstmt1.setInt(5, marks32);
		
		pstmt2.executeQuery();
		
		con.commit();
	}

}
