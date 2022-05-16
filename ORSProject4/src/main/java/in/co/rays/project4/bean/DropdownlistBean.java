package in.co.rays.project4.bean;
/**
 * DropdownList interface is implemented by Beans those are used to create drop
 * down list on HTML pages
 *
 * @author Mayank Dubey

 *
 */

public interface DropdownlistBean {
	
	 /**
     * Returns key of list element
     *
     * @return key
     */
	   public String getKey();
	    /**
	     * Returns display text of list element
	     *
	     * @return value
	     */
	   public String getValue();
	
}
