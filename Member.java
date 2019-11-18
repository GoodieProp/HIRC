import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class represents the constructor class for the members.
 * They are added through this class.
 * @author Xavier Gonzalez
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
	private ArrayList<String> risk = new ArrayList<String>();

	/**
	 * This function returns the firstname of the member
	 * @return The firstname of the member
	 */
	public String getFirstname() {
		return firstname;
	}
	
	/**
	 * This function sets the firstname of the member.
	 * @param firstname the value to set the firstname value.
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	/**
	 * This function returns the lastname of the member.
	 * @return the lastname of the member.
	 */
	public String getLastname() {
		return lastname;
	}
	
	/**
	 * This function sets the lastname of the member.
	 * @param lastname the value to set the lastname value.
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	/**
	 * This function returns the age of the member.
	 * @return The age of the member.
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * This function sets the age of the member.
	 * @param age the value to set the age of the member.
	 */
	public void setAge(int age) {
		String ageS = Integer.toString(age);
		risk.add(ageS);
		this.age = age;
	}
	
	/**
	 * This function returns the height of the member.
	 * @return The height of the member.
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * This function sets the height of the member.
	 * @param height the value to set the height of the member.
	 */
	public void setHeight(int height) {
		String heightS = Integer.toString(height);
		risk.add(heightS);
		this.height = height;
	}
	
	/**
	 * This function returns the weight of the member.
	 * @return The weight of the member.
	 */
	public int getWeight() {
		return weight;
	}
	
	/**
	 * This function sets the weight of the member.
	 * @param weight the value to set the weight of the member
	 */
	public void setWeight(int weight) {
		String weightS = Integer.toString(weight);
		risk.add(weightS);
		this.weight = weight;
	}
	
	/**
	 * This function returns the blood pressure systolic of the member.
	 * @return The blood pressure - systolic of the member.
	 */
	public int getBp_syst() {
		return bp_syst;
	}
	
	/**
	 * This function sets the blood pressure systolic of the member.
	 * @param bp_syst the value to set the Blood Pressure Systolic.
	 */
	public void setBp_syst(int bp_syst) {
		String bp_systS = Integer.toString(bp_syst);
		risk.add(bp_systS);
		this.bp_syst = bp_syst;
	}
	
	/**
	 * This function returns the blood pressure diastolic of the member.
	 * @return The blood pressure - diastolic of the member.
	 */
	public int getBp_dias() {
		return bp_dias;
	}
	
	/**
	 * This function sets the blood pressure diastolic of the member.
	 * @param bp_dias the value to set the Blood Pressure Systolic.
	 */
	public void setBp_dias(int bp_dias) {
		String bp_diasS = Integer.toString(bp_dias);
		risk.add(bp_diasS);
		this.bp_dias = bp_dias;
	}
	
	/**
	 * This function returns the cancer status of the member.
	 * @return The cancer status of the member.
	 */
	public String getCancer() {
		return cancer;
	}
	
	/**
	 * This function sets the cancer status of the member.
	 * @param cancer The value to set the cancer status of the member.
	 */
	public void setCancer(String cancer) {
		risk.add(cancer);
		this.cancer = cancer;
	}
	
	/**
	 * This function returns the diabetes status of the member.
	 * @return The diabetes status of the member.
	 */
	public String getDiabetes() {
		return diabetes;
	}
	
	/**
	 * This function sets the diabetes status of the member.
	 * @param diabetes The value to set the diabetes status of the member.
	 */
	public void setDiabetes(String diabetes) {
		risk.add(diabetes);
		this.diabetes = diabetes;
	}
	
	/**
	 * This function returns the alzheimers status of the member.
	 * @return The alzheimers status of the member.
	 */
	public String getAlzheimers() {
		return alzheimers;
	}
	
	/**
	 * This function sets the alzheimers status of the member
	 * @param alzheimers the value to set the alzheimers status of the member.
	 */
	public void setAlzheimers(String alzheimers) {
		risk.add(alzheimers);
		this.alzheimers = alzheimers;
	}	
	
	/**
	 * This constructor sets each value to the respective variables.
	 * @param firstname the value to set the firstname of the member.
	 * @param lastname the value to set the lastname of the member.
	 * @param age the value to set the age of the member.
	 * @param height the value to set the height of the member.
	 * @param weight the value to set the weight of the member.
	 * @param bp_syst the value to set the blood pressure systolic of the member.
	 * @param bp_dias the value to set the blood pressure diastolic of the member.
	 * @param cancer the value to set the cancer status of the member.
	 * @param diabetes the value to set the diabetes status of the member.
	 * @param alzheimers the value to set the alzheimers status of the member.
	 */
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

	/**
	 * This constructor is initialized for the XML serialization when saving and loading.
	 */
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

	/**
	 * Returns information of the member in a formatted way.
	 * @return the information of the member to the screen
	 */
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

	/**
	 * This function is used to format the information of the member to a file. 
	 * @return A formatted string of a member's information.
	 */
	public String toStringFile() {
		return String.format("%s	%s	%s	%s	%s	%s	%s	%s	%s	%s", firstname, lastname, age, height, weight, bp_syst, bp_dias, cancer, diabetes, alzheimers);
	}

}
