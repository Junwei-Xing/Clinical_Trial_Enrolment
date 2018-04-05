import java.util.ArrayList;
import java.io.File;  
import java.io.InputStreamReader;  
import java.io.BufferedReader;  
import java.io.BufferedWriter;  
import java.io.FileInputStream;  
import java.io.FileWriter;  

/**
 * a interface accesses txt files and links with enrolmentHandler.
 * @author Junwei Xing
 *
 */

public class myMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
		//fetch myInput.txt as the input
		File myFile = new File("src/myInput.txt");
		InputStreamReader reader = new InputStreamReader(new FileInputStream(myFile));
		BufferedReader br = new BufferedReader(reader);
		String line = null;
		
		String [] eachPatient;
		patient my1;
		ArrayList<patient> input = new ArrayList<patient>(); 
		
		// parse myInput within an ArrayList
		while((line=br.readLine())!=null){  
        eachPatient = line.trim().split(", ");
        my1 = new patient(eachPatient[0],eachPatient[1],eachPatient[2],Integer.valueOf(eachPatient[3]),Integer.valueOf(eachPatient[4]));
        input.add(my1);
		}
		
		br.close();
		
		// send input into the process, and get the result ArrayList back.
		enrolmentHandler xixi = new enrolmentHandler();
		ArrayList<record> output = xixi.myProcess(input);
		
		
		//write down the output into myOutput.txt.
		File writename = new File("src/myOutput.txt");
        writename.createNewFile();
        BufferedWriter out = new BufferedWriter(new FileWriter(writename)); 
        for(record re1: output){
    		out.write(re1.uniqueID+", "+re1.age+", "+re1.weight+", "+re1.height+", "+re1.patientGroup+", "+re1.treatment);
    		out.newLine();
    		}
        out.flush();
        out.close();


		
		}catch (Exception e){
			e.printStackTrace();
		}

	}

}
