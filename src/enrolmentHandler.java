import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * This class processes the input into the expected output.
 * @author Junwei Xing
 * there are several functions which convert the data into specific information.
 */

public class enrolmentHandler {
	protected ArrayList<patient> input; //input arraylist
	protected ArrayList<record> output = new ArrayList<record>(); //output arraylist
	
	//transform the month abbreviations into corresponding numbers
	final String [] converter = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
	
	//main function allocates the attributes of patient into the target attributes of record.
	protected ArrayList<record> myProcess (ArrayList<patient> input){
		this.input = input;
		
		String _uniqueID;
		int _age;
		int _weight;
		int _height;
		String _patientGroup;
		String _treatment;
		
		for(patient eachInput:input){
		
		_uniqueID = handleID(eachInput.firstName, eachInput.lastName);
		_age = handleAge(eachInput.birthday);
		_weight = eachInput.weight;
		_height = eachInput.height;
		_patientGroup = handleGroup(_weight,_height);
		_treatment = handleTreatment(_patientGroup);
		
		//get the result and encapsulate it as a record.
		record forInstance = new record(_uniqueID, _age, _weight, _height, _patientGroup, _treatment);
		output.add(forInstance);
		}
		return output;
	}
	
	//based on firstname, lastname and number of occurrence, generating a uniqueID.
	private String handleID(String firstName, String lastName){
		String prefix = String.valueOf(firstName.charAt(0))+String.valueOf(lastName.charAt(0));
		int counter = 1;
		
		//same prefix
		for(record eachOutput:output){
			if (prefix.equals(eachOutput.uniqueID.substring(0, 2))){
				counter++;
			}
		}
		
		String xixi = String.format("%03d", counter); //keep the number with the format 000
		
		return prefix+xixi; // combination
	}
	
	//calculate the age from nowtime and birthday.
	private int handleAge(String birthday){
		 Date now = new Date();
		 SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy/MM/dd");
		 String [] nowDate = dateFormatter.format(now).split("/");
		 String [] birthDate = birthday.split(" ");
		 int forMonth = 0;
		 
		 //find out the corresponding number.
		 for(int i = 0; i < converter.length; i++){
			 if(birthDate[1].equals(converter[i])){
				 forMonth = i + 1;
			 }
		 }
		 
		 //calculation
		 int years = Integer.valueOf(nowDate[0])-Integer.valueOf(birthDate[2]);
		 int months = Integer.valueOf(nowDate[1])-forMonth;
		 int days = Integer.valueOf(nowDate[2])-Integer.valueOf(birthDate[0]);

		 //before the birthday
		 if(months < 0 || (months==0 && days < 0)){
			 years--;
		 }
		 
		 return years;
	}
	
	//divide this patient into a group based on weight and height
	private String handleGroup(int weight, int height){
		
		if(weight > 100 && height > 180){
			return "Group 1";
		}else if (weight <= 100 && height > 180){
			return "Group 2";
		}else if (weight > 100 && height <= 180){
			return "Group 3";
		}else{
			return "Group 4";
		}
	}
	
	//based on how many people in this group, equally dividing this patient into treatment A or treatment B.
	private String handleTreatment(String patientGroup){
		int counter2 = 1;
		
		//counting
		for(record eachOutput:output){
			if (patientGroup.equals(eachOutput.patientGroup)){
				counter2++;
			}
		}
		
		if(counter2%2 == 1){
			return "Treatment A";
		}else{
			return "Treatment B";
		}
	}
}
