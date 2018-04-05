/**
 * This class aims to construct patient with demanded attributes
 * @author Junwei Xing
 * can be considered as a element of input
 */
public class patient {

	protected String firstName;
	protected String lastName;
	protected String birthday;
	protected int weight;
	protected int height;
	
	/**
	 * 
	 */
	public patient(String firstName, String lastName, String birthday, int weight, int height){
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthday = birthday;
		this.weight = weight;
		this.height = height;
	}
	
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getBirthday() {
        return birthday;
    }
    
    public int getWeight() {
        return weight;
    }
    
    public int getHeight() {
        return height;
    }
    
    public void setFirstName(String firstName) {
    	this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
    	this.lastName = lastName;
    }
    
    public void setBirthday(String birthday) {
    	this.birthday = birthday;
    }
    
    public void setetWeight(int weight) {
    	this.weight = weight;
    }
    
    public void setHeight(int height) {
		this.height = height;
    }
}
