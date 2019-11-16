import java.io.Serializable;

/**
 * @author xavie
 *
 */
public class Member implements Serializable {

	// Initialized variables for members
	private String firstname;
	private String lastname;
	private int age;
	private int height;
	private int weight;
	private int bp_syst;
	private int bp_dias;
	private String cancer;
	private String diabetes;
	private String alzheimers;

	// Setters and Getters for each variable
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getBp_syst() {
		return bp_syst;
	}
	public void setBp_syst(int bp_syst) {
		this.bp_syst = bp_syst;
	}
	public int getBp_dias() {
		return bp_dias;
	}
	public void setBp_dias(int bp_dias) {
		this.bp_dias = bp_dias;
	}
	public String getCancer() {
		return cancer;
	}
	public void setCancer(String cancer) {
		this.cancer = cancer;
	}
	public String getDiabetes() {
		return diabetes;
	}
	public void setDiabetes(String diabetes) {
		this.diabetes = diabetes;
	}
	public String getAlzheimers() {
		return alzheimers;
	}
	public void setAlzheimers(String alzheimers) {
		this.alzheimers = alzheimers;
	}


	// Constructor to add new members
	public Member(String firstname, String lastname, int age, int height, int weight, 
			int bp_syst, int bp_dias, String cancer, String diabetes,String alzheimers) {
		setFirstname(firstname);
		setLastname(lastname);
		setAge(age);
		setHeight(height);
		setWeight(weight);
		setBp_syst(bp_syst);
		setBp_dias(bp_dias);
		setCancer(cancer);
		setDiabetes(diabetes);
		setAlzheimers(alzheimers);
	}

	public Member() { // for xml serialization
		firstname = "";
		lastname = "";
		age = 0;
		height = 0;
		weight = 0;
		bp_syst = 0;
		bp_dias = 0;
		cancer = "";
		diabetes = "";
		alzheimers = "";

	}

	// Formatted toString to print to screen
	public String toStringToScreen() {
		return String.format("%s, %s\n"
				+ "Age		%d\n"
				+ "Height		%d in\n"
				+ "Weight		%d lbs\n"
				+ "BP Syst		%d\n"
				+ "BP Dias		%d\n"
				+ "Cancer		%s\n"
				+ "Diabetes	%s\n"
				+ "Alzheimers	%s\n"
				+ "-----------------------", 
				lastname, firstname, age, height, weight, bp_syst, bp_dias, cancer, diabetes, alzheimers);
	}

	// Formatted toString to print to file
	public String toStringFile() {
		return String.format("%s	%s	%s	%s	%s	%s	%s	%s	%s	%s", firstname, lastname, age, height, weight, bp_syst, bp_dias, cancer, diabetes, alzheimers);
	}

}
