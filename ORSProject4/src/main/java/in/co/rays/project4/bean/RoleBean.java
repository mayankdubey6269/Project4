package in.co.rays.project4.bean;
/**
 * Role JavaBean encapsulates Role attributes
 *
 * @author Mayank Dubey

 */

public class RoleBean extends BaseBean {
	
	public static int ADMIN =1;
	public static int STUDENT=2;
	public static int COLLEGE_SCHOOL=3;
	public static int KIOSK=4;
	private String name;
	private  String description;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getKey() {
		// TODO Auto-generated method stub
		return id+"";
	}
	public String getValue() {
		// TODO Auto-generated method stub
		return name;
	}
}
	


