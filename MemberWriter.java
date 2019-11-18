import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.simple.*; 

/**
 * 
 */

/**
 * @author xavie
 *
 */
public class MemberWriter {

	public static void writeMembersToScreen(ArrayList<Member> members) {
		for (Member mem : members) {
			System.out.println(mem.toStringToScreen());
		}
	}

	public static void writeMembersToFile (String fileFormat, ArrayList<Member> members) {

		Scanner sc = new Scanner(System.in);

		if (fileFormat.equals("T")) {
			System.out.print("Enter name of output file: ");
			String outputFileText = sc.nextLine();
			writeMembersToTextFile(outputFileText, members);

		} else if (fileFormat.equals("B")) {
			System.out.print("Enter name of output file: ");
			String outputFileBinary = sc.nextLine();
			writeMembersToBinaryFile(outputFileBinary, members);

		} else if (fileFormat.equals("X")) {
			System.out.print("Enter name of output file: ");
			String outputFileXML = sc.nextLine();
			writeMembersToXMLFile(outputFileXML, members);

		} else {
			System.out.println("You must type in either 'T' for Text, 'B' for Binary, or 'X' for XML. "
					+ "Please try again.");
		}

	}

	public static boolean writeMembersToTextFile(String fname, ArrayList<Member> members) {

		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fname)));
			for (Member mem : members) {
				pw.println(mem.toStringFile());
			}
			pw.close();
			System.out.println("Members were written succesfully.");
			return true;

		} catch (Exception ex) {
			System.out.println("Something went wrong.");
			return false;
		}

	}

	public static boolean writeMembersToBinaryFile(String fname, ArrayList<Member> members) {

		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fname));
			oos.writeObject(members);
			oos.close();

			System.out.println("Members were written succesfully.");
			return true;

		} catch (Exception ex) {
			System.out.println("Something went wrong.");
			return false;
		}	
	}

	public static boolean writeMembersToXMLFile(String fname,
			ArrayList<Member> members) {
		try {
			XMLEncoder enc = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fname)));
			enc.writeObject(members);
			enc.close();

			System.out.println("Members were written succesfully.");
			return true;
		} catch (Exception ex) {
			System.out.println("Something went wrong.");
			return false;
		}
	}
}
