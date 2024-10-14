import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LaunchUser {
	static {
		
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024","root","Nayana@123");
			System.out.println("connection successful");
		
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter your choice: \n 1) New User(Register) \n 2) Existing User(Login)");
		int ch=sc.nextInt();
		
		switch(ch) {
		case 1:register();
			break;
		case 2:login();
			break;
		default:
			System.out.println("invalid choice");
		}

	}

	
	static void register() throws Exception {
		// TODO Auto-generated method stub
		/*
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024","root","Nayana@123");
		*/
		connect();
		
		Scanner sc=new Scanner(System.in);
		System.out.println("name:");
		String name=sc.next();
		
		System.out.println("username:");
		String uname=sc.next();
		
		while(true) {
			String s="select * from user where uname=?";
			PreparedStatement pstmt = con.prepareStatement(s);
			pstmt.setString(1, uname);
			
			ResultSet res=pstmt.executeQuery();
			if(res.next()) {
				System.out.println("Username already exists. Please enter another username");
				uname=sc.next();
			}
			else {
				break;
			}
		}
		
		String password,con_password;
		do {
			System.out.println("password:");
			password=sc.next();
			System.out.println("confirm password:");
			con_password=sc.next();
		}while(!password.equals(con_password));
		
		System.out.println("email:");
		String email=sc.next();
		
		
		String s2 = "insert into user values(?,?,?,?)";
		PreparedStatement pstmt1 = con.prepareStatement(s2);
		pstmt1.setString(1, name);
		pstmt1.setString(2, uname);
		pstmt1.setString(3, password);
		pstmt1.setString(4, email);
		
	    pstmt1.executeUpdate();	
		
	}
	
		static void login() throws Exception{
			// TODO Auto-generated method stub
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024","root","Nayana@123");
			
			Scanner sc=new Scanner(System.in);
			
			System.out.println("enter username");
			String uname=sc.next();
			
			System.out.println("enter password:");
			String password=sc.next();
			
			String s="select * from user where uname=?";
			PreparedStatement pstmt=con.prepareStatement(s);
			pstmt.setString(1, uname);
			ResultSet res=pstmt.executeQuery();
			
			if(res.next()) {
				if(password.equals(res.getString(3))) {
					System.out.println("login successful");
				}
				else {
					System.out.println("Invalid password");
				}
			}
			else {
				System.out.println("invalid username");
			}
			
		}

}
