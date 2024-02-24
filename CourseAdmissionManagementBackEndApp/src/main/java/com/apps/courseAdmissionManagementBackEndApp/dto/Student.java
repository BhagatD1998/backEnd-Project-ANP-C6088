package com.apps.courseAdmissionManagementBackEndApp.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long studentId;
	private String studentName;
	private Integer studentAge;
	private String studentGender;

	public Student() {
		super();

	}

	public Student(String studentName, Integer studentAge, String studentGender) {
		super();

		this.studentName = studentName;
		this.studentAge = studentAge;
		this.studentGender = studentGender;
	}

	public Long getStudentId() {
		return studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Integer getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(Integer studentAge) {
		this.studentAge = studentAge;
	}

	public String getStudentGender() {
		return studentGender;
	}

	public void setStudentGender(String studentGender) {
		this.studentGender = studentGender;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentAge=" + studentAge
				+ ", studentGender=" + studentGender + "]";
	}

}
