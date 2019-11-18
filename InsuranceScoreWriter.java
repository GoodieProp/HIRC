import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
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
public class InsuranceScoreWriter {

	
	public static boolean writeMemberAssessmentsToJSONFile(String fn, ArrayList<InsuranceScore> is) {
		
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fn)));
			// create a JSON object for each member
			JSONObject memObj;
			JSONArray array = new JSONArray();
			for (InsuranceScore iScore : is) {
				
				memObj = new JSONObject();
				memObj.put("Name", iScore.getName());
				memObj.put("Score", iScore.getScore());
				memObj.put("Verdict", iScore.getVerdict());
				
				array.add(memObj);
			}
			JSONObject outer = new JSONObject();
			outer.put("Member Insurance Scores", array);
			pw.println(outer.toJSONString());
			pw.close();
			
			System.out.println("\nThe scores were written successfully.");
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	public static void writeScoresToScreen(ArrayList<InsuranceScore> is) {
		for (InsuranceScore score : is) {
			System.out.println(score.toStringToScreen());
		}
	}
}
