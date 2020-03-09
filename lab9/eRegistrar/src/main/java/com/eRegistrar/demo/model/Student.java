package com.eRegistrar.demo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="student")
public class Student {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
	
	@Column(nullable = false)
	@NotBlank(message = "Student Number Can't be blank" )
	private String studentNumber;
	
	@Column(nullable = false)
	@NotBlank(message = "First name Can't be blank" )
	private String firstName;
	
	private String middleName;
	
	@Column(nullable = false)
	@NotBlank(message = "Last name Can't be blank" )
	private String lastName;
	
	private Double cgpa;
	
	@Column(nullable = false)
	@NotBlank(message = "Enrollment Can't be blank" )
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate enrollmentDate;
	
	@Column(nullable = false)
	@NotBlank(message = "isInternational Can't be blank" )
	private Boolean isInternational;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(@NotBlank(message = "Student Can't be blank") String studentNumber,
			@NotBlank(message = "First name Can't be blank") String firstName, String middleName,
			@NotBlank(message = "Last name Can't be blank") String lastName, Double cgpa,
			@NotBlank(message = "Enrollment Can't be blank") LocalDate enrollmentDate,
			@NotBlank(message = "isInternational Can't be blank") Boolean isInternational) {
		super();
		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.cgpa = cgpa;
		this.enrollmentDate = enrollmentDate;
		this.isInternational = isInternational;
	}

	public Student(@NotBlank(message = "Student Can't be blank") String studentNumber,
			@NotBlank(message = "First name Can't be blank") String firstName,
			@NotBlank(message = "Last name Can't be blank") String lastName,
			@NotBlank(message = "Enrollment Can't be blank") LocalDate enrollmentDate,
			@NotBlank(message = "isInternational Can't be blank") Boolean isInternational) {
		super();
		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.enrollmentDate = enrollmentDate;
		this.isInternational = isInternational;
	}
	

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Double getCgpa() {
		return cgpa;
	}

	public void setCgpa(Double cgpa) {
		this.cgpa = cgpa;
	}

	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(LocalDate enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	public Boolean getIsInternational() {
		return isInternational;
	}

	public void setIsInternational(Boolean isInternational) {
		this.isInternational = isInternational;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentNumber=" + studentNumber + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + ", cgpa=" + cgpa + ", enrollmentDate="
				+ enrollmentDate + ", isInternational=" + isInternational + "]";
	}
	
	
}
