import java.util.Scanner;
import java.util.ArrayList;

/**
 * This class represents the Insurance Score Calculator
 * You can list the members of a file, add a new member, save a new member, load in new members, assess the members, and you can save the assessments to a JSON file
 * @author Xavier Gonzalez
 *
 */

public class GonzalezInsuranceApp {

	/**
	 * This function prints out the stars with the welcome message
	 * @param howMany the value in which how many stars will be printed out
	 */
	public static void printStars(int howMany) { 
		String stars = "";
		for (int i = 0; i < howMany; i++) {
			stars = stars + "*";
		}
		System.out.println(stars);
	}

	/**
	 * This function prints out a welcome message for the user.
	 */
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

	/**
	 * This function shows the user a menu with options to choose during the program.
	 */
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

		// Variables
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
		ArrayList<InsuranceScore> insuranceScore = new ArrayList<InsuranceScore>();
		
		// prints welcome message
		printWelcome();

		// Asks user for the name of the member file
		System.out.print("Enter name of member file: ");
		String fn = sc.next();
		// Member file is read and added to the members arraylist
		ArrayList<Member> members = MemberReader.loadMembers(fn);
		System.out.printf("%s members were read.\n", members.size());

		// do-while loop until user chooses to exit
		do {
			showMenu();
			choice = sc.nextInt();
			sc.nextLine();

			if (choice == 1) {
				// Print out the members
				System.out.println("Here are the members: \n");
				MemberWriter.writeMembersToScreen(members);
			} else if (choice == 2) {
				// Adds new members from the addMembers class to the arraylist
				members.add(addMember.addMembers());

			} else if (choice == 3) {
				// Saves file to either Text, Binary, or XML
				System.out.println("(T)ext, (B)inary, or (X)ML?: ");
				String fileFormat = sc.next();
				
				MemberWriter.writeMembersToFile(fileFormat, members);

			} else if (choice == 4) {
				// Reads in file from either Text, Binary, or XML
				System.out.println("(T)ext, (B)inary, or (X)ML?: ");
				String fileFormat = sc.next();

				ArrayList<Member> member = MemberReader.readMembersFromFile(fileFormat);

			} else if (choice == 5) {
				// Asseses the members from the member arraylist
				System.out.println("Here are the insurance assessments: \n");
				insuranceScore = Assessor.assessMembers(members);
				InsuranceScoreWriter.writeScoresToScreen(insuranceScore);

			} else if (choice == 6) {
				// Saves the assessments to a JSON file
				System.out.print("Enter name of JSON file: ");
				String jsonFileName = sc.nextLine();
				InsuranceScoreWriter.writeMemberAssessmentsToJSONFile(jsonFileName, insuranceScore);
				
			} else if (choice == 7) {
				// Exit message
				System.out.println("   INSURANCE SCORE CARD");
				System.out.println("        Thank You!");
			}
		} while (choice != 7);
	}
}
