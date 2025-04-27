package StudentInformation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteData {
	public static void deleteData() {
		String url="jdbc:mysql://localhost:3306/personal";
		String user="root";
		String pwd="1234";
		
		System.out.print("Give The Student Roll No : ");
		@SuppressWarnings("resource")
		int roll=new Scanner(System.in).nextInt();
		
		String query="delete from student where sroll = ?";
		
		try {	
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
				Connection con=DriverManager.getConnection(url,user,pwd);
				
				PreparedStatement ps=con.prepareStatement(query);
				ps.setInt(1, roll);
				int count=ps.executeUpdate();
				
				if(count>0)
					System.out.println("\nDelete The Data <--|-->\n");
				else
					System.out.println("\nCan't Be Delete The Data <--|-->\n");
			}
			catch(SQLException e) {
				System.out.println("Connection Failed!\n");
			}
		}
		catch(ClassNotFoundException e) {
			System.out.println("Driver Class Can't be Fined!\n");
		}
	}
}
