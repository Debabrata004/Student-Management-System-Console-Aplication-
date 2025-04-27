package StudentInformation;

import java.sql.*;
import java.util.Scanner;

public class InsertData {
	@SuppressWarnings("resource")
	public static void insertData() {
		
		Scanner sc=new Scanner(System.in);
		
		String query="insert into student values (?,?,?)";
		
		String url="jdbc:mysql://localhost:3306/personal";
		String user="root";
		String pwd="1234";
		
		
		int id;
		String name;
		int roll;
		
		System.out.print("Enter Student ID : "); 
		id=sc.nextInt();sc.nextLine();
		
		System.out.print("Enter Student Name : ");
		name=sc.nextLine();
		
		System.out.print("Enter Student Roll No : ");
		roll=sc.nextInt();
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
			
			Connection con=DriverManager.getConnection(url,user,pwd);
			
			PreparedStatement ps=con.prepareStatement(query);
			
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, roll);
			
			ps.executeUpdate();
			System.out.println("\nInserted Succesfully--> <--\n");
			}
			
			catch(SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		catch(ClassNotFoundException e) {
			System.out.println("<---Driver Class Not Found--->\n");
		}
	}
}
