/**
 * This class aims to construct record with demanded attributes
 * @author Junwei Xing
 * can be considered as a element of output
 */
public class record {
	
	protected String uniqueID;
	protected int age;
	protected int weight;
	protected int height;
	protected String patientGroup;
	protected String treatment;

	public record(String uniqueID, int age, int weight, int height, String patientGroup, String treatment) {
		// TODO Auto-generated constructor stub
		this.uniqueID = uniqueID;
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.patientGroup = patientGroup;
		this.treatment = treatment;
	}
	
	 	public String getUniqueID() {
	        return uniqueID;
	    }
	    
	    public int getAge() {
	        return age;
	    }
	    
	    public int getWeight() {
	        return weight;
	    }
	    
	    public int getHeight() {
	        return height;
	    }
	    
	    public String getPatientGroup() {
	        return patientGroup;
	    }
	    
	    public String getTreatment() {
	        return treatment;
	    }
	    
	 	public void setUniqueID(String uniqueID) {
	 		this.uniqueID = uniqueID;;
	    }
	    
	    public void setAge(int age) {
	    	this.age = age;
	    }
	    
	    public void setWeight(int weight) {
	    	this.weight = weight;
	    }
	    
	    public void setHeight(int height) {
	    	this.height = height;
	    }
	    
	    public void setPatientGroup(String patientGroup) {
	    	this.patientGroup = patientGroup;
	    }
	    
	    public void setTreatment(String treatment) {
	    	this.treatment = treatment;
	    }
}
