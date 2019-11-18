import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import org.json.simple.*; 

/**
 * 
 */

/**
 * This class represents how the members are written to a file, or to the screen.
 * Can be written to a Text, Binary, and XML file.
 * @author Xavier Gonzalez
 *
 */
public class MemberWriter {

	/**
	 * This function writes the member information to the screen.
	 * @param members the arraylist of member objects
	 */
	public static void writeMembersToScreen(ArrayList<Member> members) {
		for (Member mem : members) {
			System.out.println(mem.toStringToScreen());
		}
	}

	/**
	 * This functions shows if-statements to delegate what file type is the member's information going to be saved as.
	 * @param fileFormat the type of file.
	 * @param members the arraylist consisting of member objects.
	 */
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

	/**
	 * This functions writes the member's information to a text file.
	 * @param fname the file name
	 * @param members the arraylist consisting of member objects
	 * @return True if the file has been written, or False if there was an error.
	 */
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

	/**
	 * This function writes the member's information to a binary file.
	 * @param fname the file name
	 * @param members the arraylist consisting of member objects
	 * @return True if the file has been written, or False if there was an error.
	 */
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

	/**
	 * This function writes the member's information to an XML file.
	 * @param fname the file name
	 * @param members the arraylist consisting of member objects.
	 * @return True if the file has been written, or False if there was an error.
	 */
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
