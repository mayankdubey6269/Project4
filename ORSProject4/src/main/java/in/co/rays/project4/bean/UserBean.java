package in.co.rays.project4.bean;

import java.util.Date;
/**
 * User JavaBean encapsulates User attributes
 *
 * @author Mayank Dubey

 */

public class UserBean extends BaseBean {
	
		public static String Active;
		public static String INActive;
		private String firstName;
		private String lastName;
		private String login;
		private String password;
		private String confirmpassword;
		private Date dob;
	    private String mobileNo;
	    private long roleId;
		private String gender;
	
		
		
	
		public String getConfirmpassword() {
				return confirmpassword;
			}
			public void setConfirmpassword(String confirmpassword) {
				this.confirmpassword = confirmpassword;
			}
	
			
		public static String getActive() {
			return Active;
		}
		public static void setActive(String active) {
			Active = active;
		}
		public static String getINActive() {
			return INActive;
		}
		public static void setINActive(String iNActive) {
			INActive = iNActive;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getLogin() {
			return login;
		}
		public void setLogin(String login) {
			this.login = login;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public Date getDob() {
			return dob;
		}
		public void setDob(Date dob) {
			this.dob = dob;
		}
		public String getMobileNo() {
			return mobileNo;
		}
		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}
		public long getRoleId() {
			return roleId;
		}
		public void setRoleId(long roleId) {
			this.roleId = roleId;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getKey() {
			// TODO Auto-generated method stub
			return id+"";
		}
		public String getValue() {
			// TODO Auto-generated method stub
			return firstName;
		}
	
}
