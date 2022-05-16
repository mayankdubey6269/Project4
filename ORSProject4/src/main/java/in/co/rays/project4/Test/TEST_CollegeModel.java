package in.co.rays.project4.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.project4.bean.CollegeBean;
import in.co.rays.project4.exception.ApplicationException;
import in.co.rays.project4.exception.DuplicateRecordException;
import in.co.rays.project4.model.CollegeModel;
import in.co.rays.project4.util.DataValidator;
/**
 * College Model Test classes
 *
 * @author Mayank Dubey
 
 */
public class TEST_CollegeModel {
	  /**
     * Model object to test
     */
    public static CollegeModel model = new CollegeModel();

    /**
     * Main method to call test methods.
   
     */
    public static void main(String[] args) throws DuplicateRecordException {
       //  testAdd();
         testDelete();
      //   testUpdate();
      //  testFindByName();
       //  testFindByPK();
      //   testSearch();
      //testList();
    	//findByCity();

    	String sy="Shubh";
   boolean ss= 	DataValidator.isPassword(sy);
    System.out.println(ss);
    
    }

    /**
     * Tests add a College
    
     */
    public static void testAdd() throws DuplicateRecordException {

        try {
            CollegeBean bean = new CollegeBean();
      
            bean.setName("Bansal Institute of Science and Technology ");
            bean.setAddress("Kokta, Anandnagar, ");
            bean.setState("mp");
            bean.setCity("@bhopal.");
            bean.setPhoneNo("088784 68786");
            bean.setCreatedBy("admin");
            bean.setModifiedBy("admin");
            bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
			bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
            long pk = model.add(bean);
            System.out.println("Test add succ");
//            CollegeBean addedBean = model.findByPK(pk);
//            if (addedBean == null) {
//                System.out.println("Test add fail");
//            }
        } catch (ApplicationException e) {
            e.printStackTrace();
        }

    }


    
    /**
     * Tests delete a College
     */
    public static void testDelete() {

        try {
            CollegeBean bean = new CollegeBean();
            long pk = 22;
            bean.setId(pk);
            model.delete(bean);
            System.out.println("Test Delete succ");
            CollegeBean deletedBean = model.findByPK(pk);
            if (deletedBean != null) {
                System.out.println("Test Delete fail");
            }
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
    }

    
    
    /**
     * Tests update a College
     */
    public static void testUpdate() {

        try {
            CollegeBean bean = model.findByPK(11);
            bean.setName("Truba Group of Institutes ");
            bean.setAddress("Karond Bypass Rd, Gandhi Nagar");
            bean.setState("mp");
            bean.setCity("@bhopal.");
            bean.setPhoneNo("0755 273 4691");
            bean.setCreatedBy("admin");
            bean.setModifiedBy("admin");
            bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
			bean.setModifiedDatetime(new Timestamp(new Date().getTime()));;
            model.update(bean);
            System.out.println("Test Update succ");
            CollegeBean updateBean = model.findByPK(2);
            if (!"aarush".equals(updateBean.getName())) {
                System.out.println("Test Update fail");
            }
        } catch (ApplicationException e) {
            e.printStackTrace();
        } catch (DuplicateRecordException e) {
            e.printStackTrace();
        }

    }

    
    
    /**
     * Tests find a College by Name.
     */

   public static void testFindByName() {

        try {
            CollegeBean bean = model.findByName("SIRT");
            if (bean == null) {
                System.out.println("Test Find By Name fail");
            }
            System.out.println(bean.getId());
            System.out.println(bean.getName());
            System.out.println(bean.getAddress());
            System.out.println(bean.getState());
            System.out.println(bean.getCity());
            System.out.println(bean.getPhoneNo());
            System.out.println(bean.getCreatedBy());
            System.out.println(bean.getCreatedDatetime());
            System.out.println(bean.getModifiedBy());
            System.out.println(bean.getModifiedDatetime());
        } catch (ApplicationException e) {
            e.printStackTrace();
        }

    }
   public static void findByCity() {

       try {
           CollegeBean bean = model.findByCity("indore");
           if (bean == null) {
               System.out.println("Test Find By City fail");
           }
           System.out.println(bean.getId());
           System.out.println(bean.getName());
           System.out.println(bean.getAddress());
           System.out.println(bean.getState());
           System.out.println(bean.getCity());
           System.out.println(bean.getPhoneNo());
           System.out.println(bean.getCreatedBy());
           System.out.println(bean.getCreatedDatetime());
           System.out.println(bean.getModifiedBy());
           System.out.println(bean.getModifiedDatetime());
       } catch (ApplicationException e) {
           e.printStackTrace();
       }

   }


/**
 * Tests find a College by PK.
 */
     public static void testFindByPK() {
    try {
        CollegeBean bean = new CollegeBean();
        long pk = 10;
        bean = model.findByPK(pk);
        if (bean == null) {
            System.out.println("Test Find By PK fail");
        }
        System.out.println(bean.getId());
        System.out.println(bean.getName());
        System.out.println(bean.getAddress());
        System.out.println(bean.getState());
        System.out.println(bean.getCity());
        System.out.println(bean.getPhoneNo());
        System.out.println(bean.getCreatedBy());
        System.out.println(bean.getCreatedDatetime());
        System.out.println(bean.getModifiedBy());
        System.out.println(bean.getModifiedDatetime());
    } catch (ApplicationException e) {
        e.printStackTrace();
    }

}
    
    
    /**
     * Tests search a College by Name
     */

    public static void testSearch() {
        try {
            CollegeBean bean = new CollegeBean();
            List list = new ArrayList();
            bean.setName("SIRT ");
             //bean.setAddress("indore");
            list = model.search(bean, 1, 100);
            if (list.size() < 0) {
                System.out.println("Test Search fail");
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                bean = (CollegeBean) it.next();
                System.out.println(bean.getId());
                System.out.println(bean.getName());
                System.out.println(bean.getAddress());
                System.out.println(bean.getState());
                System.out.println(bean.getCity());
                System.out.println(bean.getPhoneNo());
                System.out.println(bean.getCreatedBy());
                System.out.println(bean.getCreatedDatetime());
                System.out.println(bean.getModifiedBy());
                System.out.println(bean.getModifiedDatetime());
            }
        } catch (ApplicationException e) {
            e.printStackTrace();

        }
    }

    
    /**
     * Tests get List a College.
     */
    public static void testList() {

        try {
            CollegeBean bean = new CollegeBean();
            List list = new ArrayList();
            list = model.list(1, 100);
            if (list.size() < 0) {
                System.out.println("Test list fail");
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                bean = (CollegeBean) it.next();
                System.out.println(bean.getId());
                System.out.println(bean.getName());
                System.out.println(bean.getAddress());
                System.out.println(bean.getState());
                System.out.println(bean.getCity());
                System.out.println(bean.getPhoneNo());
                System.out.println(bean.getCreatedBy());
                System.out.println(bean.getCreatedDatetime());
                System.out.println(bean.getModifiedBy());
                System.out.println(bean.getModifiedDatetime());
            }

        } catch (ApplicationException e) {
            e.printStackTrace();
        }
    }

}

    

