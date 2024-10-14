import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UserProject1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		System.out.println("driver loaded successfully");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/june_2024","root","Nayana@123");
		System.out.println("connection established successfully");
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter your choice: \n 1) New User(Register) \n 2) Existing User(Login)");
		int ch=sc.nextInt();
		
		String s="insert into user values(?,?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(s);
		
		if(ch==1) {
			
			System.out.println("name:");
			String name=sc.next();
			
			System.out.println("username:");
			String uname=sc.next();
			
			System.out.println("password:");
			String password=sc.next();
			
			System.out.println("confirm password:");
			String con_password=sc.next();
			
			System.out.println("email:");
			String email=sc.next();	
			
			pstmt.setString(1,name);
			pstmt.setString(2, uname);
			if(password.equals(con_password)) {
				pstmt.setString(3, password);
			}
			else {
				System.out.println("mismatched password");
			}
			pstmt.setString(4, email);
			
			int rows= pstmt.executeUpdate();
			System.out.println(rows);
			
		}
		
	}

}
