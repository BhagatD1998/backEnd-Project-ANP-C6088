package com.apps.courseAdmissionManagementBackEndApp.dao;

import java.util.List;

import com.apps.courseAdmissionManagementBackEndApp.dto.Course;

public interface CourseDao {
	public Course saveCourse(Course course);
	public Course getCourseById(Long courseId);
	public Course deleteCourse(Long courseId);
	public Course updateCourse(Course course);
	public List<Course> getCourses();
}
