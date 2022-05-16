package in.co.rays.project4.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import in.co.rays.project4.bean.UserBean;
import in.co.rays.project4.exception.ApplicationException;
import in.co.rays.project4.exception.DuplicateRecordException;
import in.co.rays.project4.exception.RecordNotFoundException;
import in.co.rays.project4.model.UserModel;
/**
 * User Model Test classes
 *
 * @author Mayank Dubey

 *
 */
public class TEST_UserModel {

    /**
     * Model object to test
     */

    public static UserModel model = new UserModel();

    /**
     * Main method to call test methods.
  
     */
    public static void main(String[] args) throws Exception {
        testAdd();
        // testDelete();
      //  testUpdate();
      //   testFindByPK();
       //  testFindByLogin();
      //   testSearch();
        // testGetRoles();
       // testList();
    	//testAuthenticate();
       //  testRegisterUser();
         //testchangePassword();
  //       testforgetPassword();
      //  testresetPassword();

    }

    /**
     * Tests add a User
   
     */
    public static void testAdd() throws ParseException,
            DuplicateRecordException {

        try {
            UserBean bean = new UserBean();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

            // bean.setId(5234L);
            bean.setFirstName("shivaffm123");
            bean.setLastName("sen");
            bean.setLogin("Ss113@gmail.com");
            bean.setPassword("pass1234");
            bean.setDob(sdf.parse("9/8/1999"));
           
            bean.setRoleId(2);
            bean.setGender("male");
            bean.setMobileNo("9098786756");
            bean.setConfirmpassword("pass1234");
            long pk = model.add(bean);
          //  UserBean addedbean = model.findByPK(pk);
            System.out.println("Test add succ");
//            if (addedbean != null) {
//                System.out.println("Test add fail");
//            }
        } catch (ApplicationException e) {
            e.printStackTrace();
        }

    }

    /**
     * Tests delete a User
     */
    public static void testDelete() {

        try {
            UserBean bean = new UserBean();
            long pk = 5;
            bean.setId(pk);
            model.delete(bean);
            System.out.println("Test Delete succ" + bean.getId());
            UserBean deletedbean = model.findByPK(pk);
            if (deletedbean == null) {
                System.out.println("Test Delete fail");
            }
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests update a User
     */
    public static void testUpdate() {

        try {
            UserBean bean = model.findByPK(9);
            bean.setFirstName("mayank");
            bean.setLastName("Sharma");
            bean.setLogin("ran0@gmail.com");
            bean.setPassword("658987");
            bean.setMobileNo("882783640");

            model.update(bean);

            UserBean updatedbean = model.findByPK(3L);
            if (!"ranjit".equals(updatedbean.getLogin())) {
                System.out.println("Test Update ");
            }
        } catch (ApplicationException e) {
            e.printStackTrace();
        } catch (DuplicateRecordException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests find a User by PK.
     */
    public static void testFindByPK() {
        try {
            UserBean bean = new UserBean();
            long pk = 1;
            bean = model.findByPK(pk);
            if (bean == null) {
                System.out.println("Test Find By PK fail");
            }
            System.out.println(bean.getId());
            System.out.println(bean.getFirstName());
            System.out.println(bean.getLastName());
            System.out.println(bean.getLogin());
            System.out.println(bean.getPassword());
            System.out.println(bean.getDob());
            System.out.println(bean.getRoleId());
            
            System.out.println(bean.getGender());
          
        } catch (ApplicationException e) {
            e.printStackTrace();
        }

    }

    /**
     * Tests find a User by Login.
     */
    public static void testFindByLogin() {
        try {
            UserBean bean = new UserBean();
            bean = model.findByLogin("Ss1@gmail.com");
            if (bean == null) {
                System.out.println("Test Find By PK fail");
            }
            System.out.println(bean.getId());
            System.out.println(bean.getFirstName());
            System.out.println(bean.getLastName());
            System.out.println(bean.getLogin());
            System.out.println(bean.getPassword());
            System.out.println(bean.getDob());
            System.out.println(bean.getRoleId());
           
            System.out.println(bean.getGender());
           
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests get Roles.
     */
    public static void testGetRoles() {

        try {
            UserBean bean = new UserBean();
            List list = new ArrayList();
            bean.setRoleId(9888);
            list = model.getRoles(bean);
            if (list.size() < 0) {
                System.out.println("Test Get Roles fail");
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                bean = (UserBean) it.next();
                System.out.println(bean.getId());
                System.out.println(bean.getFirstName());
                System.out.println(bean.getLastName());
                System.out.println(bean.getLogin());
                System.out.println(bean.getPassword());
                System.out.println(bean.getDob());
                System.out.println(bean.getRoleId());
            System.out.println(bean.getGender());
              
            }
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests get Search
     */
    public static void testSearch() {

        try {
            UserBean bean = new UserBean();
            List list = new ArrayList();
            bean.setFirstName("Siya");
            list = model.search(bean, 0, 10);
            if (list.size() < 0) {
                System.out.println("Test Serach fail");
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                bean = (UserBean) it.next();
                System.out.println(bean.getId());
                System.out.println(bean.getFirstName());
                System.out.println(bean.getLastName());
                System.out.println(bean.getLogin());
                System.out.println(bean.getPassword());
                System.out.println(bean.getDob());
                System.out.println(bean.getRoleId());
               System.out.println(bean.getGender());
                
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
            UserBean bean = new UserBean();
            List list = new ArrayList();
            list = model.list(1, 10);
          
            Iterator it = list.iterator();
            while (it.hasNext()) {
                bean = (UserBean) it.next();
                System.out.println(bean.getId());
                System.out.println(bean.getFirstName());
                System.out.println(bean.getLastName());
                System.out.println(bean.getLogin());
                System.out.println(bean.getPassword());
                System.out.println(bean.getDob());
                System.out.println(bean.getRoleId());
                System.out.println(bean.getGender());
                System.out.println(bean.getMobileNo());
                System.out.println(bean.getCreatedBy());
                System.out.println(bean.getModifiedBy());
                System.out.println(bean.getCreatedDatetime());
                System.out.println(bean.getModifiedDatetime());
            }

        } catch (ApplicationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests authenticate User
     */
    public static void testAuthenticate() throws Exception {

        try {
            UserBean bean = new UserBean();
            bean.setLogin("Siya@gmail.com");
            bean.setPassword("Siya@12345");
            bean = model.authenticate(bean.getLogin(), bean.getPassword());
            if (bean != null) {
                System.out.println("Successfully login");

            } else {
                System.out.println("Invalid login Id & password");
            }

        } catch (ApplicationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests add a User register
 
     */

    public static void testRegisterUser() throws ParseException {
        try {
            UserBean bean = new UserBean();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

            // bean.setId(8L);
            bean.setFirstName("siya");
             bean.setLastName("kumawat");
            bean.setLogin("sy@gmail.com");
            bean.setPassword("123456");
            bean.setMobileNo("8989096750");
            bean.setConfirmpassword("123458");
            bean.setDob(sdf.parse("11/20/2015"));
       
            bean.setGender("f");
            bean.setRoleId(3);
            long pk = model.registerUser(bean);
            System.out.println("Successfully register");
            System.out.println(bean.getFirstName());
            System.out.println(bean.getLogin());
            System.out.println(bean.getLastName());
            System.out.println(bean.getDob());
            UserBean registerbean = model.findByPK(pk);
            if (registerbean != null) {
                System.out.println("Test registation fail");
            }
        } catch (ApplicationException e) {
            e.printStackTrace();
        } catch (DuplicateRecordException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests changepassword
 
     */
    public static void testchangePassword() {

        try {
            UserBean bean = model.findByLogin("Ss1@gmail.com");
            String oldPassword = bean.getPassword();
            bean.setId(3);
            bean.setPassword("Ved@1010");
            //bean.setConfirmpassword("Ved@1010");
            String newPassword = bean.getPassword();
            try {
                model.changePassword(5, oldPassword, newPassword);
                System.out.println("password has been change successfully");
            } catch (RecordNotFoundException e) {
                e.printStackTrace();
            }

        } catch (ApplicationException e) {
            e.printStackTrace();
        }

    }

    /**
     * Tests fogetPassword

     */
    public static void testforgetPassword() {
        try {
            boolean b = model.forgetPassword("Ss1@gmail.com");

            System.out.println("Suucess : Test Forget Password Success");

        } catch (RecordNotFoundException e) {
            e.printStackTrace();
        } catch (ApplicationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tests resetPassword
    
     */
    public static void testresetPassword() {
        UserBean bean = new UserBean();
        try {
            bean = model.findByLogin("Ss1@gmail.com");
            if (bean != null) {
                boolean pass = model.resetPassword(bean);
                if (pass = false) {
                    System.out.println("Test Update fail");
                }
            }

        } catch (ApplicationException e) {
            e.printStackTrace();
        }

    }
}
