import java.util.Scanner;
import java.util.ArrayList;


/**
 * @author xavie
 *
 */
public class GonzalezInsuranceApp {

	// Stars for visual effect
	public static void printStars(int howMany) { // And another one :DDDDD
		String stars = "";
		for (int i = 0; i < howMany; i++) {
			stars = stars + "*";
		}
		System.out.println(stars);
	}
	
	// Welcome Message for the User
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
		
		//Options for the user
		System.out.println("\nHere are your choices: ");
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
		
		//User inputs when choice is 2
		String firstnameN;
		String lastnameN;
		int ageN;
		int heightN;
		int weightN;
		int bp_sys;
		int bp_dias;
		String cancerN;
		String diabetesN;
		String alzheimersN;
		
		printWelcome();
		
		System.out.print("Enter name of member file: ");
		String fn = sc.next();
		ArrayList<Member> members = MemberReader.readMembers(fn);
		
		//c:/tempP/insurance.txt
		
		do {
			showMenu();
			choice = sc.nextInt();
			
			if (choice == 1) {
				System.out.println("Here are the members: \n");
				for (Member mems: members) {
					System.out.println(mems);
				}
			} else if (choice == 2) {
				
				System.out.println("Enter first and last name: ");
				firstnameN = sc.next();
				lastnameN = sc.next();
				
				
				
				System.out.println("Enter age: ");
				ageN = sc.nextInt();
				
				System.out.println("Enter height in inches: ");
				heightN = sc.nextInt();
				
				System.out.println("Enter weight in pounds: ");
				weightN = sc.nextInt();
				
				System.out.println("Enter blood pressure (sys and dia): ");
				bp_sys = Integer.parseInt(sc.next());
				bp_dias = Integer.parseInt(sc.next());
				
				System.out.println("Has a family member had ...");
				sc.nextLine();
				System.out.println("Cancer?: ");
				cancerN = sc.nextLine();
				
				System.out.println("Diabetes?: ");
				diabetesN = sc.nextLine();
				
				System.out.println("Alzheimers?: ");
				alzheimersN = sc.nextLine();
				
				Member mem = new Member(firstnameN, lastnameN, ageN, heightN, weightN, bp_sys, bp_dias, cancerN, diabetesN, alzheimersN);
				
				members.add(mem);
				
				
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
