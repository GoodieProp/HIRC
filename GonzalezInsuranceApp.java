import java.util.Scanner;
import java.util.ArrayList;


/**
 * @author xavie
 *
 */
public class GonzalezInsuranceApp {

	public static void printStars(int howMany) { // And another one :DDDDD
		String stars = "";
		for (int i = 0; i < howMany; i++) {
			stars = stars + "*";
		}
		System.out.println(stars);
	}
	
	
	public static void printWelcome() {
		printStars(45);
		System.out.println("	  INSURANCE SCORE CARD");
		System.out.println("  This app scores a potential customer\r\n" + 
				"  on various health attributes: blood\r\n" + 
				"  pressure, age, height, weight, and\r\n" + 
				"  family history of disease. It writes\r\n" + 
				"  each member's insurance grade to a\r\n" + 
				"  JSON file so that they can be easily\r\n" + 
				"  shared on a web-based data exchange.\r\n");
		printStars(45);
	}
	
	public static void showMenu() {
		
		System.out.println("Here are your choices: ");
		System.out.println("	1. List members");
		System.out.println("	2. Add a new member");
		System.out.println("	3. Save members");
		System.out.println("	4. Load members");
		System.out.println("	5. Assess members");
		System.out.println("	6. Save assessments as JSON");
		System.out.println("	7. Exit");
		System.out.print("Please enter your choice: ");
		
		
	}
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int choice;
		
		
		printWelcome();
		
		System.out.print("Enter name of member file: ");
		String fn = sc.next();
		
		
		
		do {
			showMenu();
			choice = sc.nextInt();
			
			if (choice == 1) {
				
			} else if (choice == 2) {
				
			} else if (choice == 3) {
				
			} else if (choice == 4) {
				
			} else if (choice == 5) {
				
			} else if (choice == 6) {
				
			} else if (choice == 7) {
				System.out.println("   INSURANCE SCORE CARD");
				System.out.println("	Thank You!");
			}
			
			
		} while (choice != 7);
		

	}

}
