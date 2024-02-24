package com.apps.courseAdmissionManagementBackEndApp.hibernateConfig;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.apps.courseAdmissionManagementBackEndApp.dto.Course;
import com.apps.courseAdmissionManagementBackEndApp.dto.CourseEnrolled;
import com.apps.courseAdmissionManagementBackEndApp.dto.Student;

public class HibernateConfig {
	private static HibernateConfig hibernateConfig;
	private SessionFactory sessionFactory;

	private HibernateConfig() {
	}

	public static HibernateConfig getHibernateConfig() {
		hibernateConfig = (hibernateConfig != null ? hibernateConfig : new HibernateConfig());
		return hibernateConfig;
	}

	public SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				// Hibernate settings equivalent to hibernate.cfg.xml's properties
				Properties properties = new Properties();
				properties.put("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
				properties.put("hibernate.connection.url",
						"jdbc:mysql://localhost:3306/courseEnrollmentDB?useSSL=false");
				properties.put("hibernate.connection.username", "root");
				properties.put("hibernate.connection.password", "Deepak@1998");
				properties.put("hibernate.show_sql", "true");
				properties.put("hibernate.format_sql", "true");
				properties.put("hibernate.hbm2ddl.auto", "update");/* update or create */

				configuration.setProperties(properties);
				configuration.addAnnotatedClass(Student.class).addAnnotatedClass(Course.class)
						.addAnnotatedClass(CourseEnrolled.class);

				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);

			} catch (Exception e) {
				System.out.println(e);

				e.printStackTrace();
				// Rethrow the exception or handle it appropriately
				throw new RuntimeException("Failed to initialize Hibernate session factory", e);
			}
		}
		return sessionFactory;
	}
}