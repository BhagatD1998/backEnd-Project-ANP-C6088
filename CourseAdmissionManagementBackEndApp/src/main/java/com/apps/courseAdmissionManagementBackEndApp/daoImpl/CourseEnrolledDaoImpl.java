package com.apps.courseAdmissionManagementBackEndApp.daoImpl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.apps.courseAdmissionManagementBackEndApp.dao.CourseEnrolledDao;
import com.apps.courseAdmissionManagementBackEndApp.dto.CourseEnrolled;
import com.apps.courseAdmissionManagementBackEndApp.dto.Student;
import com.apps.courseAdmissionManagementBackEndApp.hibernateConfig.HibernateConfig;
//import com.mysql.cj.Session;

public class CourseEnrolledDaoImpl implements CourseEnrolledDao {
	private Transaction transaction;
	private Session session;
	private HibernateConfig hibernateConfig;
	
	public CourseEnrolledDaoImpl() {
		hibernateConfig = HibernateConfig.getHibernateConfig();
	}
	@Override
	public CourseEnrolled saveCourseEnrolled(CourseEnrolled courseEnrolled) {
		
		transaction = null;
		session = null;
		try {
			session = hibernateConfig.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// save the courseEnrolled object
			session.persist(courseEnrolled);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			transaction = null;
			session = null;
		}
		return courseEnrolled;
	}

	@Override
	public CourseEnrolled getCourseEnrolledById(Long courseEnrolledId) {
		
		transaction = null;
		session = null;
		CourseEnrolled courseEnrolled = null;
		try {
			session = hibernateConfig.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// find the courseEnrolled object
			courseEnrolled = session.find(CourseEnrolled.class, courseEnrolledId);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			transaction = null;
			session = null;
		}
		return courseEnrolled;
	}

	@Override
	public CourseEnrolled deleteCourseEnrolled(Long courseEnrolledId) {
		
		transaction = null;
		session = null;
		CourseEnrolled courseEnrolled = null;
		try {
			session = hibernateConfig.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// delete the CourseEnrolled object
			courseEnrolled = getCourseEnrolledById(courseEnrolledId);
			session.remove(courseEnrolled);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			System.out.println(e);
		} finally {
			transaction = null;
			session = null;
		}
		return courseEnrolled;
	}

	@Override
	public CourseEnrolled updateCourseEnrolled(CourseEnrolled courseEnrolledId) {
		transaction = null;
		session = null;
		try {
			session = hibernateConfig.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// update the courseEnrolled object
			session.update("CourseEnrolled",courseEnrolledId);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			transaction = null;
			session = null;
		}
		return courseEnrolledId;
	}

	@Override
	public List<CourseEnrolled> getCourseEnrolleds() {
		transaction = null;
		session = null;
		List<CourseEnrolled> courseEnrolleds = null;
		try {
			session = hibernateConfig.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// get list of courseEnrolleds
			courseEnrolleds = (List<CourseEnrolled>) session.createQuery("from CourseEnrolled").list();
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		} finally {
			transaction = null;
			session = null;
		}
		return courseEnrolleds;
	}

}
