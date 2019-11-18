import java.beans.XMLDecoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 */

/**
 * This class represents how files are read into the program.
 * @author Xavier Gonzalez
 *
 */
public class MemberReader {

	/**
	 * This function is used to parse the members from the initial file at the start of the program.
	 * Used to parse members from a text file
	 * @param member string value that consists the information of a member
	 * @return A member object.
	 */
	public static Member parseMembersFromInitialFile(String member) {

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


		return new Member(firstname, lastname, age, height, weight, bp_syst, bp_dias, cancer, diabetes, alzheimers);
	}

	/**
	 * This function loads the file, and uses the parseMembersFromInitialFile function to parse the members and then add them
	 * to an arraylist.
	 * Uses a while loop to separated each member by line.
	 * @param fname the file name
	 * @return An arraylist consisting of member objects.
	 */
	public static ArrayList<Member> loadMembers (String fname) {

		try {
			/*
			 * Creates a scanner for the file and also an arraylist that goes through the constructor class
			 * Uses parseMembers to parse the info into an arraylist
			 */
			Scanner fsc = new Scanner(new File(fname));
			String line = "";
			ArrayList<Member> members = new ArrayList<Member>();

			while (fsc.hasNextLine()) {
				line = fsc.nextLine();
				members.add(parseMembersFromInitialFile(line));
			}
	
			return members;

		} catch (Exception ex) {
			System.out.println("Something went wrong.");
			return null;
		}	
	}

	/**
	 * This function reads in the file name and asks the user if the file is Text, Binary, or XML.
	 * If any of the options, it will load the file in their respective function.
	 * Once read it will be add to an arraylist and return it.
	 * @param fname the file name
	 * @return An arraylist consisting of members
	 */
	public static ArrayList<Member> readMembersFromFile (String fname) {

		Scanner sc = new Scanner(System.in);
		ArrayList<Member> members = new ArrayList<Member>();

		// read from Text file
		if (fname.equals("T")) {
			System.out.println("Enter name of input file: ");
			String inputFileText = sc.next();
			members = loadMembers(inputFileText);
			System.out.printf("%s members were read.", members.size());
			return members;

			// read from Binary file	
		} else if (fname.equals("B")) {
			System.out.println("Enter name of input file: ");
			String inputFileBinary = sc.next();
			ArrayList<Member> readFromBin = readMembersFromBinary(inputFileBinary);

			return readFromBin;

			// read from XML file	
		} else if (fname.equals("X")) {
			System.out.println("Enter name of input file: ");
			String inputFileXML = sc.next();
			ArrayList<Member> readFromXML = readMembersFromXML(inputFileXML);
			return readFromXML;

		} else {
			System.out.println("You must type in either 'T' for Text, 'B' for Binary, or 'X' for XML. "
					+ "Please try again.");
			return null;
		}

	}

	/**
	 * This functions reads in a binary file, adds to an arraylist, and returns it.
	 * @param fname the file name
	 * @return An arraylist
	 */
	public static ArrayList<Member> readMembersFromBinary(String fname) {

		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fname));
			ArrayList<Member> result = (ArrayList<Member>)ois.readObject();
			ois.close();
			System.out.printf("%s members were read.", result.size());
			return result;

		} catch (Exception ex) {
			System.out.println("Something went wrong.");
			ex.printStackTrace();
			return null;
		}	

	}

	/**
	 * This functions reads in a XML file, adds to an arraylist, and returns it.
	 * @param fname the file name
	 * @return An arraylist consisting of members.
	 */
	public static ArrayList<Member> readMembersFromXML(String fname) {

		try {
			XMLDecoder dec = new XMLDecoder(new BufferedInputStream(new FileInputStream(fname)));
			ArrayList<Member> members = (ArrayList<Member>)dec.readObject();
			dec.close();
			System.out.printf("%s members were read.", members.size());
			return members;
		} catch (Exception ex) {
			System.out.println("Something went bad.\n");
			ex.printStackTrace();
			return null;
		}	

	}
}
