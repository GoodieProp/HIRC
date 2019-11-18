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
		ArrayList<InsuranceScore> insuranceScore = new ArrayList<InsuranceScore>();
		
		
		printWelcome();

		System.out.print("Enter name of member file: ");
		String fn = sc.next();
		ArrayList<Member> members = MemberReader.loadMembers(fn);
		System.out.printf("%s members were read.\n", members.size());

		do {
			showMenu();
			choice = sc.nextInt();
			sc.nextLine();

			if (choice == 1) {
				// don't do listMembers cause it didn't work
				// Print out the members
				System.out.println("Here are the members: \n");
				MemberWriter.writeMembersToScreen(members);
			} else if (choice == 2) {

				members.add(addMember.addMembers());

			} else if (choice == 3) {
				System.out.println("(T)ext, (B)inary, or (X)ML?: ");
				String fileFormat = sc.next();

				MemberWriter.writeMembersToFile(fileFormat, members);

			} else if (choice == 4) {

				System.out.println("(T)ext, (B)inary, or (X)ML?: ");
				String fileFormat = sc.next();

				ArrayList<Member> member = MemberReader.readMembersFromFile(fileFormat);

			} else if (choice == 5) {

				System.out.println("Here are the insurance assessments: \n");
				insuranceScore = Assessor.assessMembers(members);
				InsuranceScoreWriter.writeScoresToScreen(insuranceScore);

			} else if (choice == 6) {
				System.out.print("Enter name of JSON file: ");
				String jsonFileName = sc.nextLine();
				InsuranceScoreWriter.writeMemberAssessmentsToJSONFile(jsonFileName, insuranceScore);
				
			} else if (choice == 7) {
				System.out.println("   INSURANCE SCORE CARD");
				System.out.println("        Thank You!");
			}

		} while (choice != 7);


	}

}
