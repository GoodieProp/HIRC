/**
 * This class represents a constructor that saves in member information once they are assessed.
 * @author Xavier Gonzalez
 */
public class InsuranceScore {
	
	// Initialized Variables
	private String firstname;
	private String lastname;
	private String name;
	private int score;
	private String verdict;
	
	/**
	 * 
	 * @return
	 */
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
	 * This function returns the score of the member.
	 * @return The score of the member.
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * This function sets the value of the score of the member.
	 * @param score The value to set the score of the member.
	 */
	public void setScore(int score) {
		this.score = score;
	}
	
	/**
	 * This function returns the verdict of the member.
	 * @return The verdict of the member.
	 */
	public String getVerdict() {
		return verdict;
	}
	
	/**
	 * This function sets the verdict of the member.
	 * @param verdict The value to set the verdict of the member.
	 */
	public void setVerdict(String verdict) {
		this.verdict = verdict;
	}
	
	/**
	 * This function sets the value of the constructor variables.
	 * @param fn the firstname of the member.
	 * @param ln the lastname of the member
	 * @param score the score of the member.
	 * @param verdict the verdict of the member.
	 */
	public InsuranceScore(String fn, String ln, int score, String verdict) {
		setFirstname(fn);
		setLastname(ln);
		setScore(score);
		setVerdict(verdict);
		setName(ln + ", " + fn); // Used for the toString format
	}
	
	/**
	 * This function returns the full name of the member.
	 * @return the name of the member.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This function sets the full name of the member.
	 * @param name the full name of the member.
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * This function is used print the member assessment to the screen.
	 * @return formatted member assessments.
	 */
	public String toStringToScreen() {
		 return String.format(
				  "Name:%20s\n"
		 		+ "Score:%19d\n"
		 		+ "Verdict:%17s\n\n"
		 		, name, score, verdict);
	}
}
