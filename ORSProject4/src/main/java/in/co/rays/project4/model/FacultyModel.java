package in.co.rays.project4.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.project4.bean.CollegeBean;
import in.co.rays.project4.bean.CourseBean;
import in.co.rays.project4.bean.FacultyBean;
import in.co.rays.project4.bean.SubjectBean;
import in.co.rays.project4.exception.ApplicationException;
import in.co.rays.project4.exception.DuplicateRecordException;
import in.co.rays.project4.util.JDBCDataSource;

/**
 * JDBC Implementation of FacultyModel
 *
 * @author Mayank Dubey
 * 
 */
public class FacultyModel {
	/**
	 * Find next PK of Faculty.
	 *
	 * 
	 */

	public Integer nextPk() throws ApplicationException {
		// log.debug("Faculty Model nextPK method Started");
		Connection conn = null;
		int pk = 0;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(id) FROM ST_FACULTY");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			// log.error("DataBase Exception ..", e);
			throw new ApplicationException("Exception in Getting the PK");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		// log.debug("Faculty Model nextPK method End");
		return pk + 1;
	}

	/**
	 * Add a Faculty.
	 *
	 * @param bean
	 *            the bean
	 * @return the int
	 * @throws ApplicationException
	 *             the application exception
	 * @throws DuplicateRecordException
	 *             the duplicate record exception
	 */

	public int add(FacultyBean bean) throws ApplicationException, DuplicateRecordException {
		// log.debug("Model add Started");
		Connection conn = null;
		// System.out.println("gender :- "+bean.getGender());
		int pk = 0;
		CollegeModel collegeModel = new CollegeModel();
		CollegeBean collegeBean = collegeModel.findByPK(bean.getCollege_id());
		bean.setCollege_Name(collegeBean.getName());

		CourseModel courseModel = new CourseModel();
		CourseBean courseBean = courseModel.findByPk(bean.getCollege_id());
		bean.setCourse_Name(courseBean.getCourse_Name());

		SubjectModel subjectModel = new SubjectModel();
		SubjectBean subjectBean = subjectModel.findByPk(bean.getSubject_id());
		bean.setSubject_Name(subjectBean.getSubject_Name());

		// FacultyBean beanExist = findByEmail(bean.getEmail_id());
		// if (beanExist != null) {
		// throw new DuplicateException("Email already exists");
		// }
		//

		try {
			conn = JDBCDataSource.getConnection();
			pk = nextPk();
			conn.setAutoCommit(false); // Begin transaction
			PreparedStatement pstmt = conn
					.prepareStatement("INSERT INTO ST_FACULTY VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, pk);
			pstmt.setString(2, bean.getFirst_Name());
			pstmt.setString(3, bean.getLast_Name());
			pstmt.setString(4, bean.getGender());
			pstmt.setDate(5, new java.sql.Date(bean.getDOJ().getTime()));
			pstmt.setString(6, bean.getQualification());
			pstmt.setString(7, bean.getEmail_id());
			pstmt.setString(8, bean.getMobile_No());
			pstmt.setInt(9, bean.getCollege_id());
			pstmt.setString(10, bean.getCollege_Name());
			pstmt.setInt(11, bean.getCourse_id());
			pstmt.setString(12, bean.getCourse_Name());
			pstmt.setInt(13, bean.getSubject_id());
			pstmt.setString(14, bean.getSubject_Name());
			pstmt.setString(15, bean.getCreatedBy());
			pstmt.setString(16, bean.getModifiedBy());
			pstmt.setTimestamp(17, bean.getCreatedDatetime());
			pstmt.setTimestamp(18, bean.getModifiedDatetime());

			pstmt.executeUpdate();
			conn.commit(); // End transaction
			System.out.println("faculty add close");
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			// log.error("Database Exception..", e);
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new ApplicationException("Exception : add rollback exception " + ex.getMessage());
			}
			e.printStackTrace();
			throw new ApplicationException("Exception : Exception in add Faculty");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		// log.debug("Model add End");
		return pk;
	}

	/**
	 * Delete a Faculty.
	 *
	 * @param bean
	 *            the bean
	 * @throws ApplicationException
	 *             the application exception
	 */
	public void delete(FacultyBean bean) throws ApplicationException {
		// log.debug("Faculty Model Delete method End");
		Connection conn = null;
		try {

			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM ST_FACULTY WHERE ID=?");
			pstmt.setLong(1, bean.getId());
			pstmt.executeUpdate();
			conn.commit();
		} catch (Exception e) {
			// log.error("DATABASE EXCEPTION ", e);
			try {
				conn.rollback();
			} catch (Exception ex) {
				throw new ApplicationException("Exception in Faculty Model rollback" + ex.getMessage());
			}
			throw new ApplicationException("Exception in Faculty Model Delete Method");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		// log.debug("Faculty Model delete method End");
	}

	/**
	 * Update a Faculty.
	 *
	 * @param bean
	 *            the bean
	 * @throws ApplicationException
	 *             the application exception
	 * @throws DuplicateRecordException
	 *             the duplicate record exception
	 */

	public void update(FacultyBean bean) throws ApplicationException, DuplicateRecordException {
		// log.debug("Model update Started");
		Connection conn = null;
		/*
		 * CollegeModel collegeModel = new CollegeModel(); CollegeBean
		 * collegeBean = collegeModel.findByPK(bean.getCollege_id());
		 * bean.setCollege_Name(collegeBean.getName());
		 * 
		 * CourseModel courseModel = new CourseModel(); CourseBean courseBean =
		 * courseModel.findByPk(bean.getCollege_id());
		 * bean.setCollege_Name(courseBean.getCourse_Name());
		 * 
		 * SubjectModel subjectModel = new SubjectModel(); SubjectBean
		 * subjectBean = subjectModel.findByPk(bean.getSubject_id());
		 * bean.setSubject_Name(subjectBean.getSubject_Name());
		 * 
		 * FacultyBean beanExist = findByEmail(bean.getEmail_id()); // Check if
		 * updated EmailId already exist if (beanExist != null &&
		 * !(beanExist.getId() == bean.getId())) { throw new
		 * DuplicateException("EmailId is already exist"); }
		 */

		try {
			conn = JDBCDataSource.getConnection();
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(
					"UPDATE ST_FACULTY SET  FIRST_NAME=?, LAST_NAME=?, GENDER=?, DOJ=?,QUALIFICATION=?, EMAIL_ID=?, MOBILE_NO=? , COLLEGE_ID=?, COLLEGE_NAME=?,COURSE_ID=?,COURSE_NAME=?, SUBJECT_ID=?, SUBJECT_NAME=?, CREATEDBY=? , MODIFIEDBY=? , CREATEDDATETIME=? , MODIFIEDDATETIME=?  WHERE ID= ? ");

			pstmt.setString(1, bean.getFirst_Name());
			pstmt.setString(2, bean.getLast_Name());
			pstmt.setString(3, bean.getGender());
			pstmt.setDate(4, new java.sql.Date(bean.getDOJ().getTime()));
			pstmt.setString(5, bean.getQualification());
			pstmt.setString(6, bean.getEmail_id());
			pstmt.setString(7, bean.getMobile_No());
			pstmt.setInt(8, bean.getCollege_id());
			pstmt.setString(9, bean.getCollege_Name());
			pstmt.setInt(10, bean.getCourse_id());
			pstmt.setString(11, bean.getCourse_Name());
			pstmt.setInt(12, bean.getSubject_id());
			pstmt.setString(13, bean.getSubject_Name());
			pstmt.setString(14, bean.getCreatedBy());
			pstmt.setString(15, bean.getModifiedBy());
			pstmt.setTimestamp(16, bean.getCreatedDatetime());
			pstmt.setTimestamp(17, bean.getModifiedDatetime());
			pstmt.setLong(18, bean.getId());

			pstmt.executeUpdate();
			conn.commit();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
			// log.error("DATABASE EXCEPTION ...", e);
			try {
				conn.rollback();
			} catch (Exception ex) {
				// throw new ApplicationException("Exception in rollback faculty
				// model .." + ex.getMessage());
			}
			// throw new ApplicationException("Exception in faculty model Update
			// Method..");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		// log.debug("Faculty Model update method End");
	}

	/**
	 * Find User by Faculty name.
	 *
	 * @param EmailId
	 *            : get parameter
	 * @return bean
	 * @throws ApplicationException
	 *             the application exception
	 */

	public FacultyBean findByEmail(String EmailId) throws ApplicationException {
		// log.debug("Faculty Model findByName method Started");
		StringBuffer sql = new StringBuffer("SELECT * FROM ST_FACULTY WHERE EMAIL_Id=?");
		Connection conn = null;
		FacultyBean bean = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, EmailId);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new FacultyBean();
				bean.setId(rs.getInt(1));
				bean.setFirst_Name(rs.getString(2));
				bean.setLast_Name(rs.getString(3));
				bean.setGender(rs.getString(4));
				bean.setDOJ(rs.getDate(5));
				bean.setQualification(rs.getString(6));
				bean.setEmail_id(rs.getString(7));
				bean.setMobile_No(rs.getString(8));
				bean.setCollege_id(rs.getInt(9));
				bean.setCollege_Name(rs.getString(10));
				bean.setCourse_id(rs.getInt(11));
				bean.setCourse_Name(rs.getString(12));
				bean.setSubject_id(rs.getInt(13));
				bean.setSubject_Name(rs.getString(14));
				bean.setCreatedBy(rs.getString(15));
				bean.setModifiedBy(rs.getString(16));
				bean.setCreatedDatetime(rs.getTimestamp(17));
				bean.setModifiedDatetime(rs.getTimestamp(18));

			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			// log.error("database exception ..." , e);
			throw new ApplicationException("Exception : Exception in faculty model in findbyName method");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		// log.debug("Faculty Model findbyName method End");
		return bean;
	}

	/**
	 * Find User by Faculty PK.
	 *
	 * @param pk
	 *            : get parameter
	 * @return bean
	 * @throws ApplicationException
	 *             the application exception
	 */

	public FacultyBean findByPk(long pk) throws ApplicationException {
		// log.debug("Faculty Model findByPK method Started");
		StringBuffer sql = new StringBuffer("SELECT * FROM ST_FACULTY WHERE ID=?");
		Connection conn = null;
		FacultyBean bean = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setLong(1, pk);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new FacultyBean();
				bean.setId(rs.getInt(1));
				bean.setFirst_Name(rs.getString(2));
				bean.setLast_Name(rs.getString(3));
				bean.setGender(rs.getString(4));
				bean.setDOJ(rs.getDate(5));

				bean.setQualification(rs.getString(6));
				bean.setEmail_id(rs.getString(7));
				bean.setMobile_No(rs.getString(8));
				bean.setCollege_id(rs.getInt(9));
				bean.setCollege_Name(rs.getString(10));
				bean.setCourse_id(rs.getInt(11));
				bean.setCourse_Name(rs.getString(12));
				bean.setSubject_id(rs.getInt(13));
				bean.setSubject_Name(rs.getString(14));
				bean.setCreatedBy(rs.getString(15));
				bean.setModifiedBy(rs.getString(16));
				bean.setCreatedDatetime(rs.getTimestamp(17));
				bean.setModifiedDatetime(rs.getTimestamp(18));

			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			// log.error("database exception ..." , e);
			// throw new ApplicationException("Exception : Exception in findByPK
			// in faculty model");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		// log.debug("Faculty Model FindByPK method end");
		return bean;
	}

	/**
	 * Search Faculty.
	 *
	 * @param bean
	 *            : Search Parameters
	 * @return the list
	 * @throws ApplicationException
	 *             the application exception
	 */

	public List search(FacultyBean bean) throws ApplicationException {
		return search(bean, 0, 0);
	}

	/**
	 * Search Faculty with pagination.
	 *
	 * @param bean
	 *            : Search Parameters
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 * @return list : List of Users
	 * @throws ApplicationException
	 *             the application exception
	 */

	public List search(FacultyBean bean, int pageNo, int pageSize) throws ApplicationException {
		// log.debug("Faculty Model search method Started");

		StringBuffer sql = new StringBuffer("SELECT * FROM ST_FACULTY WHERE 1=1");
		if (bean != null) {
			if (bean.getId() > 0) {
				sql.append(" AND id = " + bean.getId());
			}
			if (bean.getCourse_id() > 0) {
				sql.append(" AND college_Id = " + bean.getCourse_id());
			}
			if (bean.getFirst_Name() != null && bean.getFirst_Name().trim().length() > 0) {
				sql.append(" AND First_Name like '" + bean.getFirst_Name() + "%' ");
			}
			if (bean.getLast_Name() != null && bean.getLast_Name().trim().length() > 0) {
				sql.append(" AND LAST_NAME like '" + bean.getLast_Name() + "%' ");
			}

			if (bean.getEmail_id() != null && bean.getEmail_id().length() > 0) {
				sql.append(" AND Email_Id like '" + bean.getEmail_id() + "%' ");
			}

			if (bean.getGender() != null && bean.getGender().length() > 0) {
				sql.append(" AND Gender like '" + bean.getGender() + "%' ");
			}

			if (bean.getMobile_No() != null && bean.getMobile_No().length() > 0) {
				sql.append(" AND Mobile_No like '" + bean.getMobile_No() + "%' ");
			}

			if (bean.getCollege_Name() != null && bean.getCollege_Name().length() > 0) {
				sql.append(" AND college_Name like '" + bean.getCollege_Name() + "%' ");
			}
			if (bean.getCourse_id() > 0) {
				sql.append(" AND course_Id = " + bean.getCourse_id());
			}
			if (bean.getCollege_Name() != null && bean.getCollege_Name().length() > 0) {
				sql.append(" AND course_Name like '" + bean.getCollege_Name() + "%' ");
			}
			if (bean.getSubject_id() > 0) {
				sql.append(" AND Subject_Id = " + bean.getSubject_id());
			}
			if (bean.getSubject_Name() != null && bean.getSubject_Name().length() > 0) {
				sql.append(" AND subject_Name like '" + bean.getSubject_Name() + "%' ");
			}
		}

		// if page no is greater then zero then apply pagination
		System.out.println("model page ........" + pageNo + " " + pageSize);
		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + " , " + pageSize);
		}

		Connection conn = null;
		ArrayList list = new ArrayList();
		try {
			System.out.println(sql);
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println("ONE");
				bean = new FacultyBean();
				bean.setId(rs.getInt(1));
				bean.setFirst_Name(rs.getString(2));
				bean.setLast_Name(rs.getString(3));
				bean.setGender(rs.getString(4));
				System.out.println("wwo");
				bean.setDOJ(rs.getDate(5));
				System.out.println("threee");
				bean.setQualification(rs.getString(6));

				bean.setEmail_id(rs.getString(7));
				bean.setMobile_No(rs.getString(8));
				bean.setCollege_id(rs.getInt(9));
				bean.setCollege_Name(rs.getString(10));
				bean.setCourse_id(rs.getInt(11));
				bean.setCourse_Name(rs.getString(12));
				bean.setSubject_id(rs.getInt(13));
				bean.setSubject_Name(rs.getString(14));
				bean.setCreatedBy(rs.getString(15));
				bean.setModifiedBy(rs.getString(16));
				bean.setCreatedDatetime(rs.getTimestamp(17));
				bean.setModifiedDatetime(rs.getTimestamp(18));
				list.add(bean);

			}
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
			// log.error("database Exception .. " , e);
			e.printStackTrace();
			// throw new ApplicationException("Exception : Exception in Search
			// method of Faculty Model");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		// log.debug("Faculty Model search method End");
		// System.out.println("retuen >>>>>>>>>>>>>>>"+list.size());
		return list;

	}

	/**
	 * Get List of Faculty.
	 *
	 * @return list : List of Faculty
	 * @throws ApplicationException
	 *             the application exception
	 */

	public List list() throws ApplicationException {
		return list(0, 0);
	}

	/**
	 * Get List of Faculty with pagination.
	 *
	 * @param pageNo
	 *            : Current Page No.
	 * @param pageSize
	 *            : Size of Page
	 * @return list : List of Faculty
	 * @throws ApplicationException
	 *             the application exception
	 */

	public List list(int pageNo, int pageSize) throws ApplicationException {
		// log.debug("Faculty Model List method Started");
		StringBuffer sql = new StringBuffer("SELECT * FROM ST_FACULTY");
		Connection conn = null;
		ArrayList list = new ArrayList();

		// if page is greater than zero then apply pagination
		if (pageSize > 0) {
			pageNo = (pageNo - 1) * pageSize;
			sql.append(" limit " + pageNo + " , " + pageSize);
		}
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				FacultyBean bean = new FacultyBean();
				bean.setId(rs.getInt(1));
				bean.setFirst_Name(rs.getString(2));
				bean.setLast_Name(rs.getString(3));
				bean.setGender(rs.getString(4));
				bean.setDOJ(rs.getDate(5));
				bean.setQualification(rs.getString(6));
				bean.setEmail_id(rs.getString(7));
				bean.setMobile_No(rs.getString(8));
				bean.setCollege_id(rs.getInt(9));
				bean.setCollege_Name(rs.getString(10));
				bean.setCourse_id(rs.getInt(11));
				bean.setCourse_Name(rs.getString(12));
				bean.setSubject_id(rs.getInt(13));
				bean.setSubject_Name(rs.getString(14));
				bean.setCreatedBy(rs.getString(15));
				bean.setModifiedBy(rs.getString(16));
				bean.setCreatedDatetime(rs.getTimestamp(17));
				bean.setModifiedDatetime(rs.getTimestamp(18));

				list.add(bean);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			// log.error("Database Exception ......" , e);
			throw new ApplicationException("Exception in list method of FacultyModel");
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		// log.debug("Faculty Model List method End");
		return list;
	}

	public FacultyBean findByName(String firstname) throws ApplicationException {
		// log.debug("Model FindByName Started ");
		StringBuffer sql = new StringBuffer("Select * from st_faculty where first_name=?");

		FacultyBean bean = null;
		Connection conn = null;
		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql.toString());
			stmt.setString(1, firstname);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				bean = new FacultyBean();

				bean.setId(rs.getInt(1));
				bean.setFirst_Name(rs.getString(2));
				bean.setLast_Name(rs.getString(3));
				bean.setGender(rs.getString(4));
				bean.setDOJ(rs.getDate(5));
				bean.setQualification(rs.getString(6));
				bean.setEmail_id(rs.getString(7));
				bean.setMobile_No(rs.getString(8));
				bean.setCollege_id(rs.getInt(9));
				bean.setCollege_Name(rs.getString(10));
				bean.setCourse_id(rs.getInt(11));
				bean.setCourse_Name(rs.getString(12));
				bean.setSubject_id(rs.getInt(13));
				bean.setSubject_Name(rs.getString(14));
				bean.setCreatedBy(rs.getString(15));
				bean.setModifiedBy(rs.getString(16));
				bean.setCreatedDatetime(rs.getTimestamp(17));
				bean.setModifiedDatetime(rs.getTimestamp(18));

			}
			rs.close();

		} catch (Exception e) {
			// log.error("Database Exception..",e);
			throw new ApplicationException("Exception:Exception in getting Faculty by Name");

		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		// log.debug("Model findByName Ended");
		return bean;
	}

}
