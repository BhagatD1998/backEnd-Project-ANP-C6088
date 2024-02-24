package com.apps.courseAdmissionManagementBackEndApp.daoImpl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.apps.courseAdmissionManagementBackEndApp.dao.CourseDao;
import com.apps.courseAdmissionManagementBackEndApp.dto.Course;

import com.apps.courseAdmissionManagementBackEndApp.hibernateConfig.HibernateConfig;


public class CourseDaoImpl implements CourseDao{
	private Transaction transaction;
	private Session session;
	private HibernateConfig hibernateConfig;
	
	public CourseDaoImpl() {
		hibernateConfig = HibernateConfig.getHibernateConfig();	
	}
	@Override
	public Course saveCourse(Course course) {
		
		transaction = null;
		session = null;
		try {
			session = hibernateConfig.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// save the Course object
			session.persist(course);
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
		return course;
	}

	@Override
	public Course getCourseById(Long courseId) {
	
		transaction = null;
		session = null;
		Course course = null;
		try {
			session = hibernateConfig.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// find the student object
			course = session.find(Course.class, courseId);
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
		return course;
	}

	@Override
	public Course deleteCourse(Long courseId) {
		
		transaction = null;
		session = null;
		Course course = null;
		try {
			session = hibernateConfig.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// delete the Course object
			course = getCourseById(courseId);
			session.remove(course);
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
		return course;
	}

	@Override
	public Course updateCourse(Course course) {
	
		transaction = null;
		session = null;
		try {
			session = hibernateConfig.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// update the Course object
			session.update("Course", course);
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
		return course;
	}

	@Override
	public List<Course> getCourses() {
	
		transaction = null;
		session = null;
		List<Course> courses = null;
		try {
			session = hibernateConfig.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// get list of students
			courses = (List<Course>) session.createQuery("from Course").list();
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
		return courses;
	}

}
