package com.apps.courseAdmissionManagementBackEndApp.dao;

import java.util.List;

import com.apps.courseAdmissionManagementBackEndApp.dto.CourseEnrolled;

public interface CourseEnrolledDao {
	public CourseEnrolled saveCourseEnrolled(CourseEnrolled courseEnrolled);
	public CourseEnrolled getCourseEnrolledById(Long courseEnrolledId);
	public CourseEnrolled deleteCourseEnrolled(Long courseEnrolledId);
	public CourseEnrolled updateCourseEnrolled(CourseEnrolled courseEnrolledId);
	public List<CourseEnrolled> getCourseEnrolleds();
}
