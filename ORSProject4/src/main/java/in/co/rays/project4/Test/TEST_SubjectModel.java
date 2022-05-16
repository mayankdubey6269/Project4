package in.co.rays.project4.Test;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.project4.bean.SubjectBean;
import in.co.rays.project4.exception.ApplicationException;
import in.co.rays.project4.exception.DuplicateRecordException;
import in.co.rays.project4.model.SubjectModel;
/**
 * Subject Model Test classes
 *
 * @author Mayank Dubey

 *
 */

public class TEST_SubjectModel {

	  public static SubjectModel model = new SubjectModel();
	  
	  public static void main(String[] args) throws DuplicateRecordException {
	         testAdd();
		// testDelete();
		//  testUpdate();
		 // testFindByPK(); 
		//  testfindByName() ; 
		    
		// testsearch();  
	//	  testlist();
		  
		  

}

	public static void testAdd() throws DuplicateRecordException {
		
		try {
          SubjectBean bean = new SubjectBean();
          
          bean.setSubject_Name("designer");
          bean.setCourse_Name("Bsc");
           bean.setCourse_Id(4);
          bean.setDiscription("Interior Design..");
          bean.setCreatedBy("Admin");
          bean.setModifiedBy("Admin");
          bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
          bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
         
          long pk = model.add(bean);
          System.out.println("Test add succ");
         SubjectBean addedBean = model.findByPk(pk);
          if (addedBean == null) {
              System.out.println("Test add fail");
          }
      } catch (ApplicationException e) {
          e.printStackTrace();
      }

  }
		
		
	
public static void testDelete() {

  try {
      SubjectBean bean = new SubjectBean();
      long pk = 3;
      bean.setId(pk);
      model.delete(bean);
      System.out.println("Test Delete succ");
      SubjectBean deletedBean = model.findByPk(pk);
      if (deletedBean != null) {
          System.out.println("Test Delete fail");
      }
  } catch (ApplicationException e) {
      e.printStackTrace();
  }
}

public static void testUpdate() {

  try {
      SubjectBean bean = model.findByPk(7);
      bean.setSubject_Name("EEES");
      bean.setCourse_Name("BE/B.Tech");
       bean.setCourse_Id(1);
      bean.setDiscription("Bachelor of Technology.");
      bean.setCreatedBy("Admin");
      bean.setModifiedBy("Admin");
       bean.setCreatedDatetime(new Timestamp(new Date().getTime()));
       bean.setModifiedDatetime(new Timestamp(new Date().getTime()));
      
      model.update(bean);
      System.out.println("Test Update succ");
      SubjectBean  updateBean = model.findByPk(7);
      
  } catch (ApplicationException e) {
      e.printStackTrace();
  } catch (DuplicateRecordException e) {
      e.printStackTrace();
  }
}

public static void testfindByPk() {
  try {
    SubjectBean  bean = new SubjectBean();
      long pk = 2;
      bean = model.findByPk(pk);
      if (bean == null) {
          System.out.println("Test Find By PK fail");
      }
      
      System.out.println(bean.getSubject_Name());
      System.out.println(bean.getCourse_Name());
      System.out.println(bean.getCourse_Id());
     System.out.println(bean.getDiscription());
     System.out.println(bean.getCreatedBy());
      System.out.println(bean.getModifiedBy());
      System.out.println(bean.getCreatedDatetime());
      System.out.println(bean.getModifiedDatetime());
      
  } catch (ApplicationException e) {
      e.printStackTrace();
  }
}
public static void testfindByName() {
  try {
      SubjectBean bean = new SubjectBean();
      bean = model.findByName("PHARMACEUTICAL ANALYSIS");
      if (bean == null) {
          System.out.println("Test Find By findByName fail");
      }
      System.out.println(bean.getId());
      System.out.println(bean.getSubject_Name());
      System.out.println(bean.getCourse_Name());
      System.out.println(bean.getCourse_Id());
     System.out.println(bean.getDiscription());
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
      SubjectBean bean = new SubjectBean();
      long pk = 1;
      bean = model.findByPk(pk);
      if (bean == null) {
          System.out.println("Test Find By PK fail");
      }
        System.out.println(bean.getId());
      System.out.println(bean.getSubject_Name());
      System.out.println(bean.getCourse_Name());
      System.out.println(bean.getCourse_Id());
     System.out.println(bean.getDiscription());
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
      SubjectBean bean = new SubjectBean();
      
      
      bean.setCourse_Id(1);
      List list = new ArrayList();
      list = model.search(bean, 0,0);
      if (list.size() < 0) {
          System.out.println("Test Search fail");
      }
      Iterator it = list.iterator();
      while (it.hasNext()) {
          bean = (SubjectBean) it.next();
          System.out.println(bean.getId());
          System.out.println(bean.getSubject_Name());
          System.out.println(bean.getCourse_Name());
          System.out.println(bean.getCourse_Id());
         System.out.println(bean.getDiscription());
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
      SubjectBean bean = new SubjectBean();
      List list = new ArrayList();
      list = model.list(1, 10);
      if (list.size() < 0) {
          System.out.println("Test list fail");
      }
      Iterator it = list.iterator();
      while (it.hasNext()) {
          bean = (SubjectBean) it.next();
          
          System.out.println(bean.getId());
          System.out.println(bean.getSubject_Name());
          System.out.println(bean.getCourse_Name());
          System.out.println(bean.getCourse_Id());
         System.out.println(bean.getDiscription());
         System.out.println(bean.getCreatedBy());
          System.out.println(bean.getModifiedBy());
          System.out.println(bean.getCreatedDatetime());
          System.out.println(bean.getModifiedDatetime());
          
      }
          
      } catch (ApplicationException e) {
          e.printStackTrace();
      }
}
}




