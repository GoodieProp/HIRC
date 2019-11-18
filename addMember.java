import java.util.Scanner;

/**
 * 
 */

/**
 * @author xavie
 *
 */
public class addMember {

	public static Member addMembers () {
		/**
		 * 2nd choice is to add a new member
		 */

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

		try {
			Scanner sc = new Scanner(System.in);

			// First and last name
			System.out.println("Enter first and last name: ");
			firstnameN = sc.next();
			lastnameN = sc.next();

			// Age
			System.out.println("Enter age: ");
			ageN = sc.nextInt();

			// Height
			System.out.println("Enter height in inches: ");
			heightN = sc.nextInt();

			// Weight
			System.out.println("Enter weight in pounds: ");
			weightN = sc.nextInt();

			// Blood Pressure
			System.out.println("Enter blood pressure (sys and dia): ");
			bp_sys = Integer.parseInt(sc.next());
			bp_dias = Integer.parseInt(sc.next());

			System.out.println("Has a family member had ... (Answer with 'y' or 'n')");
			sc.nextLine(); // sucks out the end of line marker

			// Cancer
			System.out.println("Cancer?: ");
			cancerN = sc.nextLine().toLowerCase();

			// Diabetes
			System.out.println("Diabetes?: ");
			diabetesN = sc.nextLine().toLowerCase();

			// Alzheimers
			System.out.println("Alzheimers?: ");
			alzheimersN = sc.nextLine().toLowerCase();
			
			System.out.println("\nThe new member has been added.");
			return new Member(firstnameN, lastnameN, ageN, heightN, weightN, bp_sys, bp_dias, cancerN, diabetesN, alzheimersN);
		} catch (Exception ex) {
			System.out.println("Something went wrong.");
			return null;
		}

		//members.add(mem);
	}

}
