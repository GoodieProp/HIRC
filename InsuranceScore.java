
public class InsuranceScore {
	
	private String firstname;
	private String lastname;
	private String name;
	private int score;
	private String verdict;
	
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
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getVerdict() {
		return verdict;
	}
	public void setVerdict(String verdict) {
		this.verdict = verdict;
	}
	
	public InsuranceScore(String fn, String ln, int score, String verdict) {
		setFirstname(fn);
		setLastname(ln);
		setScore(score);
		setVerdict(verdict);
		setName(ln + ", " + fn);
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String toStringToScreen() {
		 return String.format(
				  "Name:%20s\n"
		 		+ "Score:%19d\n"
		 		+ "Verdict:%17s\n\n"
		 		, name, score, verdict);
	}
}
