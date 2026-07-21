import java.util.Scanner;

public class Welcome {
	public static void main(String[] args){
		Scanner sc = new Scanner (System.in);
		System.out.print ("Enter your first name: ");
		String Fname = sc.nextLine();
		
		System.out.print ("Enter your last name: ");
		String Lname = sc.nextLine();

		System.out.print ("Welcome to the second year " + Fname + " " + Lname);
	}
}


