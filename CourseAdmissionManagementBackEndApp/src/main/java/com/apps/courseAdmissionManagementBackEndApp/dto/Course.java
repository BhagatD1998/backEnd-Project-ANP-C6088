package com.apps.courseAdmissionManagementBackEndApp.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long courseId;
  private String courseName;
  private Double courseFee;
  private Integer courseDuration;
public Course() {
	super();
	
}
public Course( String courseName, Double courseFee, Integer courseDuration) {
	super();
	
	this.courseName = courseName;
	this.courseFee = courseFee;
	this.courseDuration = courseDuration;
}
public Long getCourseId() {
	return courseId;
}

public String getCourseName() {
	return courseName;
}
public void setCourseName(String courseName) {
	this.courseName = courseName;
}
public Double getCourseFee() {
	return courseFee;
}
public void setCourseFee(Double courseFee) {
	this.courseFee = courseFee;
}
public Integer getCourseDuration() {
	return courseDuration;
}
public void setCourseDuration(Integer courseDuration) {
	this.courseDuration = courseDuration;
}
@Override
public String toString() {
	return "Course [courseId=" + courseId + ", courseName=" + courseName + ", courseFee=" + courseFee
			+ ", courseDuration=" + courseDuration + "]";
}
  
}
