import java.util.ArrayList;

/**
 * 
 */

/**
 * This class represents how a member is assessed.
 * @author Xavier Gonzalez
 *
 */
public class Assessor {

	/**
	 * This function takes in the members information and sends to the assessMembers function.
	 * Once members are assessed they are added to an arraylist and returned.
	 * @param members The arraylist consisting of member objects.
	 * @return An arraylist consisting of member insurance score objects.
	 */
	public static ArrayList<InsuranceScore> assessMembers(ArrayList<Member> members) {
		
		ArrayList<InsuranceScore> assessMember = new ArrayList<InsuranceScore>();
		for (Member mem : members) {
			assessMember.add(assessMembers(mem));
		}
		return assessMember;
	}

	/**
	 * This function takes in a member object and assesses it through the respective functions.
	 * @param mem A member object.
	 * @return A member insurance score object
	 */
	public static InsuranceScore assessMembers(Member mem) {

		String firstname = mem.getFirstname();
		String lastname = mem.getLastname();
		
		int points = 0;
		String verdict;

		// Points added each time after a function.
		points += memberAgeScore(mem);
		points += memberBMIScore(mem);
		points += memberBloodPressureScore(mem);
		points += memberFamilyDiseaseScore(mem);

		// Verdict
		if (points <= 20) {
			verdict = "low risk";
		} else if (points <= 50) {
			verdict = "moderate risk";
		} else if (points <= 75) {
			verdict = "high risk";
		} else {
			verdict = "uninsurable";
		}
		return new InsuranceScore(firstname, lastname, points, verdict);
	}

	/**
	 * This function returns a score depending of the age of the member.
	 * @param mem A member object
	 * @return The points depending on the age.
	 */
	public static int memberAgeScore(Member mem) {

		int points = 0;
		
		if (mem.getAge() < 30) {
			points += 0;
		} else if (mem.getAge() < 45) {
			points += 10;
		} else if (mem.getAge() < 60) {
			points += 20;
		} else {
			points += 30;
		}
		return points;
	}

	/**
	 * This function returns a score depending on the BMI of the member.
	 * @param mem A member object
	 * @return Points depending on the BMI of the member.
	 */
	public static int memberBMIScore(Member mem) {
		
		double height = mem.getHeight() * 0.0254;
		double weight = mem.getWeight() * 0.453592;
		int points = 0;
		
		double bmi = weight/(height*height);
		
		if (bmi > 18.5 && bmi <= 24.9) { //normal
			points = 0;
		} else if (bmi > 25.0 && bmi <= 29.9) { // overweight
			points = 30;
		} else {
			points = 75;
		}
		return points;
	}
	
	/**
	 * This function returns points depending on the blood pressure of the member.
	 * @param mem A member object.
	 * @return Points depending on the blood pressure of the member.
	 */
	public static int memberBloodPressureScore(Member mem) {
		int bp_syst = mem.getBp_syst();
		int bp_dias = mem.getBp_dias();
		int points = 0;
		
		
		if (bp_syst < 120 && bp_dias < 80) { // normal
			points = 0;
		} else if (bp_syst > 120 && bp_syst <= 129 && bp_dias < 80) { // elevated
			points = 15;
		} else if (bp_syst > 130 || bp_syst <= 139 && bp_dias > 80 && bp_dias <= 89) { // hypertension - stage 1
			points = 30;
		}
		else if (bp_syst > 140 || bp_syst <= 180 && bp_dias > 90 && bp_dias <= 120) { // hypertension - stage 2
			points = 75;
		}
		else if (bp_syst > 180 && bp_dias > 120 || bp_syst > 180 || bp_dias > 120) { // hypertensive crisis
			points = 100;
		}
		return points;
	}
	
	/**
	 * This function returns points depending on the family disease the member has.
	 * @param mem A member object.
	 * @return Points depending on the family disease the member has.
	 */
	public static int memberFamilyDiseaseScore(Member mem) {
		
		String cancer = mem.getCancer();
		String diabetes = mem.getDiabetes();
		String alz = mem.getAlzheimers();
		int points = 0;
		
		if (cancer.equals("y")) {
			points += 10;
		}
		
		if (diabetes.equals("y")) {
			points += 10;
		}
		
		if (alz.equals("y")) {
			points += 10;
		}
		
		return points;
	}
}
