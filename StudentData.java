package StudentInformation;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StudentData {
	
	public static void main(String[] args){
		
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		try {
			while(true) {
				System.out.println("Press 1 For Adding Student Information : ");
				System.out.println("Press 2 For Modify Student Information : ");
				System.out.println("Press 3 For Delete Student Information : ");
				System.out.println("Press 4 For Display Student Information : ");
				System.out.println("Press 5 For Terminate Program : ");
				
				int choice=sc.nextInt();
				
				switch(choice) {
				
				case 1 -> InsertData.insertData();
				
				case 2 -> UpdateData.updateData();
				
				case 3 -> DeleteData.deleteData();
				
				case 4-> FetchData.fetchData();
				
				case 5 -> {
							System.out.println("Terminating the Program Successfully");
							System.exit(0);}
				
				default ->
					throw new IllegalArgumentException("Unexpected value: " + choice);
				}
			}
		}
		
		catch(NoSuchElementException e) {
			e.printStackTrace();
		}
		finally {
			//sc.close();
		}
	}
}