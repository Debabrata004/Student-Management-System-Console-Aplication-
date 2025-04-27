package StudentInformation;

import java.sql.*;

public class FetchData {
	public static void fetchData() {
		String url="jdbc:mysql://localhost:3306/personal";
		String user="root";
		String pwd="1234";
		
		String query="select *from student";
		
		try {	
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			try {
			Connection con=DriverManager.getConnection(url,user,pwd);
			
			Statement st=con.createStatement();
			
			ResultSet rs=st.executeQuery(query);
			
			System.out.println("\n+ + + + + + + + + + + + + + + + + + + + +");
			System.out.println("+ S_ID\t+ S_NAME\t+ S_ROLL\t+");
			System.out.println("+ + + + + + + + + + + + + + + + + + + + +");
			
			while(rs.next()) {
				System.out.print("|"+rs.getString("sid")+"\t|"+rs.getString("sname")+"\t\t|"+rs.getString("sroll")+"\n");
//				System.out.println("_________________________________________");
				}
			
			System.out.println("+ + + + + + + + + + + + + + + + + + + + +\n");
			
			}
			catch(Exception e) {
				System.out.println("Connection Failed\n");
			}
		}
		catch(ClassNotFoundException e) {
			System.out.println("Driver Class Not Found!\n");
		}
	}
	
}