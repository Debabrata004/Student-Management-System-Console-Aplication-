package StudentInformation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateData {
	
	public static void updateData() {
		String url="jdbc:mysql://localhost:3306/personal";
		String user="root";
		String pwd="1234";
		
		System.out.print("which student data will you upadate please give the student roll no : ");
		Scanner sc=new Scanner(System.in);
		int roll=sc.nextInt();
		sc.nextLine();
		
		String query="";
		
		System.out.print("Whatever you change please write that by those name like : name : id : roll : ");
		String identity=sc.nextLine();
		
		try {	
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
				Connection con=DriverManager.getConnection(url,user,pwd);
				
				if(identity.equals("name")) {
					System.out.print("Give the Updated Name : ");
					String name=sc.nextLine();
					query="update student set sname = ? where sroll="+roll+"";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, name);
					
					int count=ps.executeUpdate();
					
					if(count>0)
						System.out.println("\nUpdated The Name <--|-->\n");
					else
						System.out.println("\nCan't Be Updated The Name <--|-->\n");
					
				}
				
				else if(identity.equals("roll")) {
					System.out.print("Give the Updated Roll Number : ");
					int new_Roll=sc.nextInt();
					query="update student set sroll = ? where sroll="+roll+"";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setInt(1, new_Roll);
					
					int count=ps.executeUpdate();
					
					if(count>0)
						System.out.println("\nUpdated The Roll Number <--|-->\n");
					else
						System.out.println("\nCan't Be Updated The Roll Number <--|-->\n");
				}
				
				else if(identity.equals("id")) {
					
					System.out.print("Give the Updated Id : ");
					int new_id=sc.nextInt();
					query="update student set sid = ? where sroll="+roll+"";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setInt(1, new_id);
					
					int count=ps.executeUpdate();
					
					if(count>0)
						System.out.println("\nUpdated The Id <--|-->\n");
					else
						System.out.println("\nCan't Be Updated The Id <--|-->\n");
				}
				
				else {
					System.out.println("Can You Want To Change The Roll & Name : Y / y");
					String auth=sc.next();
					if(auth.equals("y") || auth.equals("Y")) {
					System.out.print("Give the Updated Name : ");
					String name=sc.nextLine();
					
					System.out.print("Give the Updated Roll Number : ");
					int new_Roll=sc.nextInt();
					
					query="update student sname = ?, sroll = ? where sroll="+roll+"";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, name);
					ps.setInt(2, new_Roll);
					
					int count=ps.executeUpdate();
					
					if(count>0)
						System.out.println("\nUpdated Successfullt <--|-->\n");
					else
						System.out.println("\nCan't Be Updated The Successfully <--|-->\n");
					}
					else
					{
						return ;
					}
				}
				
				
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