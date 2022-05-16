package in.co.rays.project4.bean;
/**
 * Marksheet JavaBean encapsulates Marksheet attributes
 *
 * @author Mayank Dubey

 *
 */

public class MarksheetBean extends BaseBean {

	private static final long serialVersionUID = 1L;
	private String rollNo;
	private long Studentid;
	private String name;
	private int Physics;
	private int chemistry;
	private int maths;

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}

	public long getStudentid() {
		return Studentid;
	}

	public void setStudentid(long studentid) {
		Studentid = studentid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhysics() {
		return Physics;
	}

	public void setPhysics(int physics) {
		Physics = physics;
	}

	public int getChemistry() {
		return chemistry;
	}

	public void setChemistry(int chemistry) {
		this.chemistry = chemistry;
	}

	public int getMaths() {
		return maths;
	}

	public void setMaths(int maths) {
		this.maths = maths;
	}

	public String getKey() {
		return id + "";
	}

	public String getValue() {
		return name;
	}

}
