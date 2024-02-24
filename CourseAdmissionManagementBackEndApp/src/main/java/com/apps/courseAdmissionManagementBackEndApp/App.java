package com.apps.courseAdmissionManagementBackEndApp;


import java.util.Scanner;

import com.apps.courseAdmissionManagementBackEndApp.dao.CourseDao;
import com.apps.courseAdmissionManagementBackEndApp.dao.CourseEnrolledDao;
import com.apps.courseAdmissionManagementBackEndApp.dao.StudentDao;
import com.apps.courseAdmissionManagementBackEndApp.daoImpl.CourseDaoImpl;
import com.apps.courseAdmissionManagementBackEndApp.daoImpl.CourseEnrolledDaoImpl;
import com.apps.courseAdmissionManagementBackEndApp.daoImpl.StudentDaoImpl;
import com.apps.courseAdmissionManagementBackEndApp.dto.Course;
import com.apps.courseAdmissionManagementBackEndApp.dto.Student;
import com.apps.courseAdmissionManagementBackEndApp.dto.CourseEnrolled;

public class App {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String choice;
		do {
		System.out.println("-----< Chose A Table You want to Operate >----- ");
		System.out.println("  's': Student ,    'c':Course ,    'e': CourseEnrollment,  'b': for break" );

		 choice = sc.next().toLowerCase();
		switch (choice) {
		// Student
		
		case "s":

			StudentDao studentDao = new StudentDaoImpl();
			System.out.println(
					"(Student Table)Enter 1 : insert ,2 : Get data by Id , 3 : update , 4: delete , 5: Display Table");
			int option = sc.nextInt();
			switch (option) {
			case 1:
				System.out.println("Enter name : ");
				String name = sc.next();
				System.out.println("Enter Age: ");
				int age = sc.nextInt();
				System.out.println("Enter Gender : ");
				String gender = sc.next();
				System.out.println(studentDao.saveStudent(new Student(name, age, gender)));
				break;

			case 2:
				System.out.println("Enter Student id : ");
				int id = sc.nextInt();
				System.out.println(studentDao.getStudentById((long) id));

				break;
			case 3:
				System.out.println("Enter id for update : ");
				int idno = sc.nextInt();
				Student student = studentDao.getStudentById((long) idno);
				System.out.println("Enter name for  update : ");
				String updateName = sc.next();
				student.setStudentName(updateName);
				System.out.println(studentDao.updateStudent(student));

				break;
			case 4:
				System.out.println("Enter id for delete : ");
				int idForDelete = sc.nextInt();
				System.out.println(studentDao.deleteStudent((long) idForDelete));
				break;
			case 5:
				System.out.println("sId" +"  "+ "Student Name" +"  "+"Age"+" "+ "Gender");
				for (Student showList : studentDao.getStudents()) {
			
					System.out.println(showList.getStudentId()+"     "+ showList.getStudentName()+"        "+showList.getStudentAge()+"   "+showList.getStudentGender());
				}
				break;
			default:
				System.out.println("Invalid input");
			}
			break;
		// Course
			
		case "c":
			
			CourseDao courseDao = new CourseDaoImpl();
			System.out.println(
					"(Course Table)Enter 1 : insert ,2 : Get data by Id , 3 : update , 4: delete , 5: Display Table");
			int options = sc.nextInt();
			switch (options) {
			case 1:
				System.out.println("Enter Course name : ");
				String cName = sc.next();
				System.out.println("Enter Course fee : ");
				int cFee = sc.nextInt();
				System.out.println("Enter Course Duration in month : ");
				int cDuration = sc.nextInt();
				System.out.println(courseDao.saveCourse(new Course(cName, (double) cFee, cDuration)));
				break;
			case 2:
				System.out.println("Enter Course Id : ");
				long cId = sc.nextLong();
				System.out.println(courseDao.getCourseById(cId));
				break;
			case 3:
				System.out.println("Enter the Course Id for update :");
				Long c3Id = sc.nextLong();
				Course course = courseDao.getCourseById(c3Id);
				System.out.println("Enter the Updated course Name:");
				String newcName = sc.next();
				course.setCourseName(newcName);
				System.out.println(courseDao.updateCourse(course));
				break;
			case 4:
				System.out.println("Enter the Course Id for Delete the row :");
				long dId = sc.nextLong();
				System.out.println(courseDao.deleteCourse(dId));
				System.out.println("delete succesfull");
				break;
			case 5:
				for (Course showList2 : courseDao.getCourses()) {
					System.out.println(showList2);
				}
				break;
			default:
				System.out.println("Invalid option");
				break;
			}
			break;
			// CourseEnrolled
			
		case "e":
			
			CourseEnrolledDao courseEnrolledDao = new CourseEnrolledDaoImpl();
			System.out.println(
					"(CourseEnrolled Table)Enter 1 : insert ,2 : Get data by Id , 3 : update , 4: delete , 5: Display Table");
			int eOptions = sc.nextInt();
			switch (eOptions) {
			case 1:
				System.out.println("Enter Student Id :");
				long sId = sc.nextLong();
				System.out.println("Enter Course Id :");
				long cId = sc.nextLong();
				System.out.println(courseEnrolledDao.saveCourseEnrolled(new CourseEnrolled(sId, cId)));
				break;
			case 2:
				System.out.println("Enter CourseEnrolled Id : ");
				long ceId = sc.nextLong();
				System.out.println(courseEnrolledDao.getCourseEnrolledById(ceId));
				break;

			case 3:
				System.out.println("Enter the CourseEnrolled Id for Update :");
				Long c3Id2 = sc.nextLong();
				CourseEnrolled courseEnrolled = courseEnrolledDao.getCourseEnrolledById(c3Id2);
				System.out.println("Enter the Updated new course Id:");
				long uceId = sc.nextLong();
				courseEnrolled.setCourseId(uceId);
				System.out.println(courseEnrolledDao.updateCourseEnrolled(courseEnrolled));
				break;
			case 4:
				System.out.println("Enter the CourseEnrolled Id for Delete the row :");
				long edId = sc.nextLong();
				System.out.println(courseEnrolledDao.deleteCourseEnrolled(edId));
				System.out.println("delete succesfull");
				break;
			case 5:
				for (CourseEnrolled showList3 : courseEnrolledDao.getCourseEnrolleds()) {
					System.out.println(showList3);

				}
				break;
			default:
				System.out.println("invalid number");
				break;
			}
			break;
		case "b":
			System.exit(0);
		default:
			
			System.out.println("Please! Enter from  Given option");
			break;
		} }
		while(choice != "b");
		sc.close();
	}
}
