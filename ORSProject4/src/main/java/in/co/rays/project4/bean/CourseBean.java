package in.co.rays.project4.bean;

/**
 * Course JavaBean encapsulates Course attributes
 *
 * @author Mayank Dubey
 *
 * 
 */

public class CourseBean extends BaseBean {

	private String Course_Name;
	private String Discription;
	private String Duration;

	public String getCourse_Name() {
		return Course_Name;
	}

	public void setCourse_Name(String course_Name) {
		Course_Name = course_Name;
	}

	public String getDiscription() {
		return Discription;
	}

	public void setDiscription(String discription) {
		Discription = discription;
	}

	public String getDuration() {
		return Duration;
	}

	public void setDuration(String duration) {
		Duration = duration;
	}

	public String getKey() {
		// TODO Auto-generated method stub
		return id + "";
	}

	public String getValue() {
		// TODO Auto-generated method stub
		return Course_Name;
	}

}
