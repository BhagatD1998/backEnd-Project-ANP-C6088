package com.apps.courseAdmissionManagementBackEndApp.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.apps.courseAdmissionManagementBackEndApp.dao.StudentDao;
import com.apps.courseAdmissionManagementBackEndApp.dto.Student;
import com.apps.courseAdmissionManagementBackEndApp.hibernateConfig.HibernateConfig;

public class StudentDaoImpl  implements StudentDao{
	private Transaction transaction;
	private Session session;
	private HibernateConfig hibernateConfig; 
	
public StudentDaoImpl() {
	hibernateConfig = HibernateConfig.getHibernateConfig();
}
	@Override
	public Student saveStudent(Student student) {
		transaction = null;
		session = null;
		try {
			session = hibernateConfig.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// save the student object
			session.persist(student);
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
		return student;
		
	}

	@Override
	public Student getStudentById(Long studentId) {
		
		transaction = null;
		session = null;
		Student student = null;
		try {
			session = hibernateConfig.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// find the student object
			student = session.find(Student.class, studentId);
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
		return student;
	}

	@Override
	//from gpt
	public Student deleteStudent(Long studentId) {
	    transaction = null;
	    session = null;
	    Student student = null;
	    try {
	        session = hibernateConfig.getSessionFactory().openSession();
	        transaction = session.beginTransaction();
	        // delete the student object
	        student = getStudentById(studentId);
	        if (student != null) {
	            session.remove(student);
	            // commit transaction
	            transaction.commit();
	            System.out.println("record deleted");
	        } else {
	            System.out.println("Student with id " + studentId + " not found.");
	        }
	    } catch (Exception e) {
	        if (transaction != null) {
	            transaction.rollback();
	        }
	        System.out.println(e);
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	    return student;
	}

	
	
	
	//from sir
//	public Student deleteStudent(Long studentId) {
//		
//		transaction = null;
//		session = null;
//		Student student = null;
//		try {
//			session = hibernateConfig.getSessionFactory().openSession();
//			transaction = session.beginTransaction();
//			// delete the student object
//			student = getStudentById(studentId);
//			session.remove(student);
//			// commit transaction
//			transaction.commit();
//			System.out.println("record delete");
//		} catch (Exception e) {
//		if (transaction != null) {
//			transaction.rollback();
//		}
//			System.out.println(e);
//		} finally {
//			transaction = null;
//			session = null;
//		}
//		return student;
//	}


	@Override
	public Student updateStudent(Student student) {
		
		transaction = null;
		session = null;
		try {
			session = hibernateConfig.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// update the student object
			session.update("Student", student);
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
		return student;
	}

	@Override
	public List<Student> getStudents() {
		
		transaction = null;
		session = null;
		List<Student> students = null;
		try {
			session = hibernateConfig.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			// get list of students
			students = (List<Student>) session.createQuery("from Student").list();
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
		return students;
	}

}
