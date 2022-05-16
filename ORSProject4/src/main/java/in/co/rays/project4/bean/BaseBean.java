package in.co.rays.project4.bean;

import java.io.Serializable;
import java.sql.Timestamp;



/**
 * Parent class of all Beans in application. It contains generic attributes.
 *
 * @author Mayank Dubey

 */
public abstract class BaseBean implements DropdownlistBean,Serializable,Comparable<BaseBean>  {

	
	  /**
     * Non Business primary key
     */
		protected long id;
		  /**
	     * Contains USER ID who created this database record
	     */
		private String createdBy;
		/**
	     * Contains USER ID who modified this database record
	     */
		private String modifiedBy;
		  /**
	     * Contains Created Timestamp of database record
	     */
		private Timestamp createdDatetime;
		 /**
	     * Contains Modified Timestamp of database record
	     */
		private Timestamp modifiedDatetime;

	    /**
	     * accessor
	     */
		public long getId() {
			
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getCreatedBy() {
			return createdBy;
		}
		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}
		public String getModifiedBy() {
			return modifiedBy;
		}
		public void setModifiedBy(String modifiedBy) {
			this.modifiedBy = modifiedBy;
		}
		public Timestamp getCreatedDatetime() {
			return createdDatetime;
		}
		public void setCreatedDatetime(Timestamp createdDatetime) {
			this.createdDatetime = createdDatetime;
		}
		public Timestamp getModifiedDatetime() {
			return modifiedDatetime;
		}
		public void setModifiedDatetime(Timestamp modifiedDatetime) {
			this.modifiedDatetime = modifiedDatetime;
		}
		
		public int compareTo(BaseBean next) {
			// TODO Auto-generated method stub
			return getValue().compareTo(next.getValue());
		}
		
}
