package in.co.rays.project4.Test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.project4.bean.StudentBean;
import in.co.rays.project4.exception.ApplicationException;
import in.co.rays.project4.exception.DuplicateRecordException;
import in.co.rays.project4.model.StudentModel;
/**
 * Student Model Test classes
 *
 * @author Mayank Dubey
 */
public class TEST_StudentModel {
	   /**
     * Model object to test
     */

    public static StudentModel model = new StudentModel();

    /**
     * Main method to call test methods.

     */
    public static void main(String[] args) throws ParseException {
          // testAdd();
        // testDelete();
     //    testUpdate();
         //testFindByPK();
       //  testFindByEmailId();
        // testSearch();
       testList();

    }

    /**
     * Tests add a Student
   
     */
    public static void testAdd() throws ParseException {

        try {
            StudentBean bean = new StudentBean();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            // bean.setId(1L);
            bean.setFirstName("ram");
            bean.setLastName("Nayak");
           bean.setDob(sdf.parse("02/02/1994"));
            bean.setMobileNo("989300065");
            bean.setEmail("RN8@gmail.com");
            bean.setCollegeid(11);
            bean.setCollegeName("Truba Group of Institutes ");
            bean.setCreatedBy("Admin");
            bean.setModifiedBy("Admin");
            bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
            bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
            long pk = model.add(bean);
            StudentBean addedbean = model.findByPK(pk);
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
 * Tests delete a Student
 */
public static void testDelete() {

    try {
        StudentBean bean = new StudentBean();
        long pk = 2;
        bean.setId(pk);
        model.delete(bean);
        StudentBean deletedbean = model.findByPK(pk);
        if (deletedbean != null) {
            System.out.println("Test Delete fail");
        }
    } catch (ApplicationException e) {
        e.printStackTrace();
    }
}

/**
 * Tests update a Student
 
 */
public static void testUpdate() throws ParseException {
	  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


    try {
        StudentBean bean = model.findByPK(1);
        
  
       bean.setDob(sdf.parse("02/02/1994"));
       /* bean.setMobileNo("989300065");
        bean.setEmail("RN8@gmail.com");
        bean.setCollegeid(11);
        bean.setCollegeName("Truba Group of Institutes ");
        bean.setCreatedBy("Admin");
        bean.setModifiedBy("Admin");*/
        bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
        bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
        model.update(bean);

        StudentBean updatedbean = model.findByPK(3);
         
            System.out.println("Test Update ");
        
    } catch (ApplicationException e) {
        e.printStackTrace();
    } catch (DuplicateRecordException e) {
        e.printStackTrace();
    }
}

/**
 * Tests find a Student by PK.
 */
public static void testFindByPK() {
    try {
        StudentBean bean = new StudentBean();
        long pk = 3;
        bean = model.findByPK(pk);
        if (bean == null) {
            System.out.println("Test Find By PK fail");
        }
        System.out.println(bean.getId());
        System.out.println(bean.getFirstName());
        System.out.println(bean.getLastName());
        System.out.println(bean.getDob());
        System.out.println(bean.getMobileNo());
        System.out.println(bean.getEmail());
        System.out.println(bean.getCollegeid());
    } catch (ApplicationException e) {
        e.printStackTrace();
    }

}

/**
 * Tests find a Student by Emailid.
 */
public static void testFindByEmailId() {
    try {
        StudentBean bean = new StudentBean();
        bean = model.findByEmailId("ga12@gmail.com");
        if (bean != null) {
            System.out.println("Test Find By EmailId fail");
        }
        System.out.println(bean.getId());
        System.out.println(bean.getFirstName());
        System.out.println(bean.getLastName());
        System.out.println(bean.getDob());
        System.out.println(bean.getMobileNo());
        System.out.println(bean.getEmail());
        System.out.println(bean.getCollegeid());
    } catch (ApplicationException e) {
        e.printStackTrace();
    }
}

/**
 * Tests get Search
 */
public static void testSearch() {

    try {
        StudentBean bean = new StudentBean();
        List list = new ArrayList();
        bean.setFirstName("mayank");
        list = model.search(bean, 0, 10);
        if (list.size() < 0) {
            System.out.println("Test Serach fail");
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            bean = (StudentBean) it.next();
            System.out.println(bean.getId());
            System.out.println(bean.getFirstName());
            System.out.println(bean.getLastName());
            System.out.println(bean.getDob());
            System.out.println(bean.getMobileNo());
            System.out.println(bean.getEmail());
            System.out.println(bean.getCollegeid());
        }

    } catch (ApplicationException e) {
        e.printStackTrace();
    }

}

/**
 * Tests get List.
 */
public static void testList() {

    try {
        StudentBean bean = new StudentBean();
        List list = new ArrayList();
        list = model.list(1, 10);
        if (list.size() < 0) {
            System.out.println("Test list fail");
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            bean = (StudentBean) it.next();
            System.out.println(bean.getId());
            System.out.println(bean.getFirstName());
            System.out.println(bean.getLastName());
            System.out.println(bean.getDob());
            System.out.println(bean.getMobileNo());
            System.out.println(bean.getEmail());
            System.out.println(bean.getCollegeid());
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
