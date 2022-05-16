package in.co.rays.project4.Test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Date;
import in.co.rays.project4.bean.CourseBean;
import in.co.rays.project4.bean.FacultyBean;
import in.co.rays.project4.bean.StudentBean;
import in.co.rays.project4.exception.ApplicationException;
import in.co.rays.project4.exception.DuplicateRecordException;
import in.co.rays.project4.model.FacultyModel;
/**
 * Faculty Model Test classes
 *
 * @author Mayank Dubey

 *
 */
public class TEST_FacultyModel {
	
	
	  public static FacultyModel model = new FacultyModel();
	  
	  public static void main(String[] args) throws Exception {
	     //  testAdd();
		  //testDelete();
		//  testUpdate();    
	//	  testFindByPK();
		//  testFindByEmailId();  
		  //  testfindByPk();     
		  testsearch();      
	//	  testlist();      
		//  testFindByName();
		  
		  

}

	public static void testAdd() throws DuplicateRecordException, Exception  {
		
		try {
            FacultyBean bean = new FacultyBean();
            SimpleDateFormat sdf = new SimpleDateFormat("MM-DD-yyy");
      
            bean.setFirst_Name("namarta");
            bean.setLast_Name("Sisodiya");
            bean.setGender("f");
            bean.setDOJ(sdf.parse("18-08-2019"));
            bean.setQualification("BSw");
			bean.setEmail_id("nS3@gmail.com");
			bean.setMobile_No("7879821340");
			bean.setCollege_id(2);
			bean.setCollege_Name("abc");
			bean.setCourse_id(5);
			bean.setCourse_Name("xyz");
			bean.setSubject_id(4);
			bean.setSubject_Name("marketing");
            bean.setCreatedBy("Admin");
            bean.setModifiedBy("Admin");
            bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
    		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
            
            long pk = model.add(bean);
            System.out.println("Test add succ");
            FacultyBean addedBean = model.findByPk(pk);
            if (addedBean == null) {
                System.out.println("Test add fail");
            }
        } catch (ApplicationException e) {
            e.printStackTrace();
        }

    }
		
		
	
public static void testDelete() {

    try {
        FacultyBean bean = new FacultyBean();
        long pk = 3;
        bean.setId(pk);
        model.delete(bean);
        System.out.println("Test Delete succ");
        FacultyBean deletedBean = model.findByPk(pk);
        if (deletedBean != null) {
            System.out.println("Test Delete fail");
        }
    } catch (ApplicationException e) {
        e.printStackTrace();
    }
}

public static void testUpdate() throws ParseException {

    try {
        FacultyBean bean = model.findByPk(5);
        SimpleDateFormat sdf = new SimpleDateFormat("MM-DD-yyy");
        bean.setFirst_Name("deepak");
        bean.setLast_Name("Sahu");
        bean.setGender("M");
        bean.setDOJ(sdf.parse("18-08-2020"));
        bean.setQualification("BSw");
		bean.setEmail_id("Dps@gmail.com");
		bean.setMobile_No("7879821340");
		bean.setCollege_id(2);
		bean.setCollege_Name("LNCT");
		bean.setCourse_id(4);
		bean.setCourse_Name("Bachelor of Social Work");
		bean.setSubject_id(4);
		bean.setSubject_Name("humanity");
        bean.setCreatedBy("Admin");
        bean.setModifiedBy("Admin");
        bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
		bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
        model.update(bean);
        System.out.println("Test Update succ");
        FacultyBean updateBean = model.findByPk(5);
        
    } catch (ApplicationException e) {
        e.printStackTrace();
    } catch (DuplicateRecordException e) {
        e.printStackTrace();
    }
}

public static void testfindByPk() {
    try {
        FacultyBean bean = new FacultyBean();
        long pk = 2;
        bean = model.findByPk(pk);
        if (bean == null) {
            System.out.println("Test Find By PK fail");
        }
        System.out.println(bean.getId());
        System.out.println(bean.getFirst_Name());
        System.out.println(bean.getLast_Name());
        System.out.println(bean.getGender());
        System.out.println(bean.getDOJ());
        System.out.println(bean.getQualification());
        System.out.println(bean.getEmail_id());
        System.out.println(bean.getMobile_No());
        System.out.println(bean.getCollege_id());
        System.out.println(bean.getCollege_Name());
        System.out.println(bean.getCourse_id());
        System.out.println(bean.getCourse_Name());
        System.out.println(bean.getSubject_id());
        System.out.println(bean.getSubject_Name());
        System.out.println(bean.getCreatedBy());
        System.out.println(bean.getModifiedBy());
        System.out.println(bean.getCreatedDatetime());
        System.out.println(bean.getModifiedDatetime());
        
    } catch (ApplicationException e) {
        e.printStackTrace();
    }
}public static void testFindByEmailId() {
    try {
        FacultyBean bean = new FacultyBean();
        bean = model.findByEmail("kk2@gmail.com");
        if (bean != null) {
            System.out.println("Test Find By EmailId fail");
        }
        System.out.println(bean.getId());
        System.out.println(bean.getFirst_Name());
        System.out.println(bean.getLast_Name());
        System.out.println(bean.getGender());
          System.out.println(bean.getDOJ());
          System.out.println(bean.getQualification());
          System.out.println(bean.getEmail_id());
          System.out.println(bean.getMobile_No());
          System.out.println(bean.getCollege_id());
          System.out.println(bean.getCollege_Name());
          System.out.println(bean.getCourse_id());
          System.out.println(bean.getCourse_Name());
          System.out.println(bean.getSubject_id());
          System.out.println(bean.getSubject_Name());
          System.out.println(bean.getCreatedBy());
          System.out.println(bean.getModifiedBy());
          System.out.println(bean.getCreatedDatetime());
          System.out.println(bean.getModifiedDatetime());
        
    } catch (ApplicationException e) {
        e.printStackTrace();
    }
}

public static void testFindByPK() {
    try {
        FacultyBean bean = new FacultyBean();
        long pk = 2;
        bean = model.findByPk(pk);
        if (bean == null) {
            System.out.println("Test Find By PK fail");
        }
            System.out.println(bean.getId());
            System.out.println(bean.getFirst_Name());
            System.out.println(bean.getLast_Name());
            System.out.println(bean.getGender());
              System.out.println(bean.getDOJ());
              System.out.println(bean.getQualification());
              System.out.println(bean.getEmail_id());
              System.out.println(bean.getMobile_No());
              System.out.println(bean.getCollege_id());
              System.out.println(bean.getCollege_Name());
              System.out.println(bean.getCourse_id());
              System.out.println(bean.getCourse_Name());
              System.out.println(bean.getSubject_id());
              System.out.println(bean.getSubject_Name());
              System.out.println(bean.getCreatedBy());
              System.out.println(bean.getModifiedBy());
              System.out.println(bean.getCreatedDatetime());
              System.out.println(bean.getModifiedDatetime());
            
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
}
public static void testsearch() {

    try {
        FacultyBean bean = new FacultyBean();
        List list = new ArrayList();
        bean.setFirst_Name("mayank");
        System.out.println(bean.getFirst_Name());
        list = model.search(bean, 0, 0);
        if (list.size() < 0) {
            System.out.println("Test Serach fail");
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            bean = (FacultyBean) it.next();
            System.out.println(bean.getId());
            System.out.println(bean.getFirst_Name());
            System.out.println(bean.getLast_Name());
            System.out.println(bean.getGender());
            System.out.println(bean.getDOJ());
              System.out.println(bean.getQualification());
              System.out.println(bean.getEmail_id());
              System.out.println(bean.getMobile_No());
              System.out.println(bean.getCollege_id());
              System.out.println(bean.getCollege_Name());
              System.out.println(bean.getCourse_id());
              System.out.println(bean.getCourse_Name());
              System.out.println(bean.getSubject_id());
              System.out.println(bean.getSubject_Name());
              System.out.println(bean.getCreatedBy());
              System.out.println(bean.getModifiedBy());
              System.out.println(bean.getCreatedDatetime());
              System.out.println(bean.getModifiedDatetime());
        }
            
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
}

public static void testlist() {

    try {
        FacultyBean bean = new FacultyBean();
        List list = new ArrayList();
        list = model.list(1, 100);
        if (list.size() < 0) {
            System.out.println("Test list fail");
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            bean = (FacultyBean) it.next();
            
            System.out.println(bean.getId());
            System.out.println(bean.getFirst_Name());
            System.out.println(bean.getLast_Name());
            System.out.println(bean.getGender());
            System.out.println(bean.getDOJ());
              System.out.println(bean.getQualification());
              System.out.println(bean.getEmail_id());
              System.out.println(bean.getMobile_No());
              System.out.println(bean.getCollege_id());
              System.out.println(bean.getCollege_Name());
              System.out.println(bean.getCourse_id());
              System.out.println(bean.getCourse_Name());
              System.out.println(bean.getSubject_id());
              System.out.println(bean.getSubject_Name());
              System.out.println(bean.getCreatedBy());
              System.out.println(bean.getModifiedBy());
              System.out.println(bean.getCreatedDatetime());
              System.out.println(bean.getModifiedDatetime());
        }
            
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
}
public static void testFindByName() {
	try{
		FacultyBean bean=model.findByName("vedd");
		if(bean==null){
			System.out.println("Test Find By Name Fail");
		}
	   	System.out.println(bean.getId());
        System.out.println(bean.getFirst_Name());
        System.out.println(bean.getLast_Name());
        System.out.println(bean.getGender());
        System.out.println(bean.getDOJ());
          System.out.println(bean.getQualification());
          System.out.println(bean.getEmail_id());
          System.out.println(bean.getMobile_No());
          System.out.println(bean.getCollege_id());
          System.out.println(bean.getCollege_Name());
          System.out.println(bean.getCourse_id());
          System.out.println(bean.getCourse_Name());
          System.out.println(bean.getSubject_id());
          System.out.println(bean.getSubject_Name());
          System.out.println(bean.getCreatedBy());
          System.out.println(bean.getModifiedBy());
          System.out.println(bean.getCreatedDatetime());
          System.out.println(bean.getModifiedDatetime());
	}catch(ApplicationException e){
		e.printStackTrace();
	}
}
}
