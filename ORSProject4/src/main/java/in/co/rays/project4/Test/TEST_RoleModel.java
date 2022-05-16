package in.co.rays.project4.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import in.co.rays.project4.bean.RoleBean;
import in.co.rays.project4.exception.ApplicationException;
import in.co.rays.project4.exception.DuplicateRecordException;
import in.co.rays.project4.exception.RecordNotFoundException;
import in.co.rays.project4.model.RoleModel;
/**
 * Role Model Test classes
 *
 * @author Mayank Dubey
 */
public class TEST_RoleModel {
	  /**
     * Model object to test
     */

    public static RoleModel model = new RoleModel();

    /**
     * Main method to call test methods.
  
     */
    public static void main(String[] args) throws ParseException, ApplicationException {
         //testAdd();
      //  testDelete();
        // testUpdate();
         //testFindByPK();
         //testFindByName();
      //   testSearch();
        testList();

    }

    /**
     * Tests add a Role

     */
    public static void testAdd() throws ParseException {

        try {
            RoleBean bean = new RoleBean();
            // SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

            // bean.setId(1L);
            bean.setName("akshay");
            bean.setDescription("actor");
            long pk = 0;
			try {
				pk = model.add(bean);
			} catch (RecordNotFoundException e) {
				
				e.printStackTrace();
			}
            RoleBean addedbean = model.findByPK(pk);
            if (addedbean == null) {
                System.out.println("Test add fail");
            }
        } catch (ApplicationException e) {
            e.printStackTrace();
        } catch (DuplicateRecordException e) {
            e.printStackTrace();
        }

    }
    
    /**
     * Tests delete a Role
     */
    public static void testDelete() {

        try {
            RoleBean bean = new RoleBean();
            long pk = 5;
            bean.setId(pk);
            model.delete(bean);
            RoleBean deletedbean = model.findByPK(pk);
            if (deletedbean != null) {
                System.out.println("Test Delete fail");
            }
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Tests update a Role
     */
    public static void testUpdate() {

        try {
            RoleBean bean = model.findByPK(1);
            bean.setName("Shubham");
            bean.setDescription("Engineer");
            model.update(bean);

            RoleBean updatedbean = model.findByPK(1);
            System.out.println("Updated");
            
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Tests find a User by PK.
     */
    public static void testFindByPK() {
        try {
            RoleBean bean = new RoleBean();
            long pk = 4;
            bean = model.findByPK(pk);
            if (bean == null) {
                System.out.println("Test Find By PK fail");
            }
            System.out.println(bean.getId());
            System.out.println(bean.getName());
            System.out.println(bean.getDescription());
        } catch (ApplicationException e) {
            e.printStackTrace();
        }

    }
    /**
     * Tests find a User by Name.
     */
    public static void testFindByName() {
        RoleBean bean = new RoleBean();
		bean = model.findByName("abhi");
		if (bean == null) {
		    System.out.println("Test Find By PK fail");
		}
		System.out.println(bean.getId());
		System.out.println(bean.getName());
		System.out.println(bean.getDescription());
    }
    
    /**
     * Tests get Search

     */
    public static void testSearch() throws ApplicationException {

        RoleBean bean = new RoleBean();
		List list = new ArrayList();
		list = model.search(bean);
		if (list.size() < 0) {
		    System.out.println("Test Serach fail");
		}
		Iterator it = list.iterator();
		while (it.hasNext()) {
		    bean = (RoleBean) it.next();
		    System.out.println(bean.getId());
		    System.out.println(bean.getName());
		    System.out.println(bean.getDescription());
		}

    }
    /**
     * Tests get List.
     */
    public static void testList() {

        try {
            RoleBean bean = new RoleBean();
            List list = new ArrayList();
            list = model.list(1, 10);
            if (list.size() < 0) {
                System.out.println("Test list fail");
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                bean = (RoleBean) it.next();
                System.out.println(bean.getId());
                System.out.println(bean.getName());
                System.out.println(bean.getDescription());
            }

        } catch (ApplicationException e) {
            e.printStackTrace();
        }
    }
}
