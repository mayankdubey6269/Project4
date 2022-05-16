package in.co.rays.project4.Test;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.project4.bean.CourseBean;
import in.co.rays.project4.bean.FacultyBean;
import in.co.rays.project4.bean.TimetableBean;
import in.co.rays.project4.exception.ApplicationException;
import in.co.rays.project4.exception.DuplicateRecordException;
import in.co.rays.project4.model.CourseModel;
import in.co.rays.project4.model.TimetableModel;
/**
 * TimeTable Model Test classes
 *
 * @author Mayank Dubey

 */
public class TEST_TimetableModel {

	public static void main(String[] args) throws Exception {
		 testAdd();
		// testcheckbysem();
		// testlist();
		// testupdate();
		//testFindbyupk();

	}

	private static void testFindbyupk() throws ApplicationException {
		// TODO Auto-generated method stub

		TimetableBean stb = new TimetableBean();

		TimetableModel stm = new TimetableModel();

		stb = stm.findByPK(2);

		System.out.println(stb.getId());
		System.out.println(stb.getCourse_Id());
		System.out.println(stb.getCourse_Name());
		System.out.println(stb.getCreatedBy());
		System.out.println(stb.getModifiedBy());
		System.out.println(stb.getCreatedDatetime());
		System.out.println(stb.getModifiedDatetime());

	}

	public static void testupdate() throws Exception, DuplicateRecordException {
		// TODO Auto-generated method stub
		TimetableBean tb = new TimetableBean();
		TimetableModel tm = new TimetableModel();
		tb.setCourse_Name("botany");
		tb.setSemester("8");
		tb.setSubject_Id(2);
		tb.setId(3);

		tm.update(tb);

	}

	public static void testlist() throws Exception {
		// TODO Auto-generated method stub
		TimetableBean tb = new TimetableBean();
		TimetableModel tm = new TimetableModel();
		List list = new ArrayList();
		list = tm.list();
		Iterator it = list.iterator();
		while (it.hasNext()) {
			tb = (TimetableBean) it.next();
			System.out.println(tb.getCourse_Id());
			System.out.println(tb.getCourse_Name());
			// System.out.println(fb.getDescription());
			System.out.println(tb.getCreatedBy());
		}

	}

	public static void testcheckbysem() throws Exception {
		TimetableBean tb = new TimetableBean();
		TimetableModel tm = new TimetableModel();
		tb = tm.checkBycss(101, 11, 5);
		System.out.println(tb.getCourse_Name());

	}

	public static void testAdd() throws Exception, DuplicateRecordException {
		// TODO Auto-generated method stub
		TimetableBean tb = new TimetableBean();
		TimetableModel tm = new TimetableModel();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dt = new Date();
		dt = sdf.parse("03/03/2012");

		tb.setCourse_Name("Cdbdjgfmmerce");
		tb.setCourse_Id(3);
		tb.setSubject_Name("maths");
		tb.setSubject_Id(2);
		tb.setExam_Date(dt);
		tb.setExam_Time("4:00");
		tb.setSemester("5");
		tm.add(tb);

	}

}