import java.util.ArrayList;

/**
 * 
 */

/**
 * @author xavie
 *
 */
public class Assessor {

	public static ArrayList<InsuranceScore> assessMembers(ArrayList<Member> members) {
		
		ArrayList<InsuranceScore> assessMember = new ArrayList<InsuranceScore>();
		for (Member mem : members) {
			assessMember.add(assessMembers(mem));
		}
		return assessMember;
	}

	public static InsuranceScore assessMembers(Member mem) {

		String firstname = mem.getFirstname();
		String lastname = mem.getLastname();
		
		int points = 0;
		String verdict;


		points += memberAgeScore(mem);
		points += memberBMIScore(mem);
		points += memberBloodPressureScore(mem);
		points += memberFamilyDiseaseScore(mem);

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
	
	public static int memberBloodPressureScore(Member mem) {
		int bp_syst = mem.getBp_syst();
		int bp_dias = mem.getBp_dias();
		int points = 0;
		
		
		if (bp_syst < 120 && bp_dias < 80) {
			points = 0;
		} else if (bp_syst > 120 && bp_syst <= 129 && bp_dias < 80) {
			points = 15;
		} else if (bp_syst > 130 || bp_syst <= 139 && bp_dias > 80 && bp_dias <= 89) {
			points = 30;
		}
		else if (bp_syst > 140 || bp_syst <= 180 && bp_dias > 90 && bp_dias <= 120) {
			points = 75;
		}
		else if (bp_syst > 180 && bp_dias > 120 || bp_syst > 180 || bp_dias > 120) {
			points = 100;
		}
		return points;
	}
	
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
