import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
// import org.json.simple.*; add later

/**
 * 
 */

/**
 * @author xavie
 *
 */
public class MemberWriter {
	
	public static void writeMembers (String fileFormat, ArrayList<Member> members) {
		
		Scanner sc = new Scanner(System.in);
		
		if (fileFormat.equals("T")) {
			System.out.println("Enter name of output file: ");
			String outputFileText = sc.next();
			writeMemberstoTextFile(outputFileText, members);
			
		} else if (fileFormat.equals("B")) {
			System.out.println("Enter name of output file: ");
			String outputFileBinary = sc.next();
			writeMemberstoTextFile(outputFileBinary, members);
			
		} else if (fileFormat.equals("X")) {
			System.out.println("Enter name of output file: ");
			String outputFileXML = sc.next();
			writeMemberstoTextFile(outputFileXML, members);
			
		} else {
			System.out.println("You must type in either 'T' for Text, 'B' for Binary, or 'X' for XML. "
					+ "Please try again.");
		}
		
	}
	
	public static boolean writeMemberstoTextFile(String fname, ArrayList<Member> members) {
		
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fname)));
			for (Member mem : members) {
				pw.println(mem);
			}
			pw.close();
			System.out.println("Members were written succesfully.");
			return true;
			
			
		} catch (Exception ex) {
			System.out.println("You done fucked up..");
			return false;
		}
		
	}
	
	public static boolean writeMemberstoBinaryFile(String fname, ArrayList<Member> members) {
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fname));
			oos.writeObject(members);
			oos.close();
			
			System.out.println("Members were written succesfully.");
			return true;
			
		} catch (Exception ex) {
			System.out.println("You done fucked up..");
			return false;
		}
		
	}
	
	public static boolean writeMembersToXMLFile(String fname, ArrayList<Member> members) {
		
		try {
			XMLEncoder enc = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fname)));
			enc.writeObject(members);
			enc.close();
			
			System.out.println("Members were written succesfully.");
			return true;
			
		} catch (Exception ex) {
			System.out.println("You done fucked up..");
			return false;
		}
		
	}
}
