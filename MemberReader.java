import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author xavie
 *
 */
public class MemberReader {
	
		public static Member parseMembers(String member) {
			
			String firstname;
			String lastname;
			int age;
			int height;
			int weight; 
			int bp_syst;
			int bp_dias;
			String cancer;
			String diabetes;
			String alzheimers;
			String parts[] = member.split("\t");
			
			firstname = parts[0];
			lastname = parts[1];
			age = Integer.parseInt(parts[2]);
			height = Integer.parseInt(parts[3]);
			weight = Integer.parseInt(parts[4]);
			bp_syst = Integer.parseInt(parts[5]);
			bp_dias = Integer.parseInt(parts[6]);
			cancer = parts[7];
			diabetes = parts[8];
			alzheimers = parts[9];
			
			ArrayList<Member> members = new ArrayList<Member>();
			
			return new Member(firstname, lastname, age, height, weight, bp_syst, bp_dias, cancer, diabetes, alzheimers);
		}
	
		public static ArrayList<Member> readMembers (String fname) {
			
			try {
				/**
				 * Creates a scanner for the file and also an arraylist that goes through the constructor class
				 * Uses parseMembers to parse the info into an arraylist
				 */
				Scanner fsc = new Scanner(new File(fname));
				String line = "";
				ArrayList<Member> members = new ArrayList<Member>();
				
				while (fsc.hasNextLine()) {
					line = fsc.nextLine();
					members.add(parseMembers(fname));
				}
				
				return members;
				
			} catch (Exception ex) {
				ex.printStackTrace();
				return null;
			}	
		}
}
