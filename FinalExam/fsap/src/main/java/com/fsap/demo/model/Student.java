package com.fsap.demo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentId;
	
	@Column(nullable = false, unique = true)
	@NotBlank(message = "Faculty Name Can't be null")
	private String studentNumber;
	
	@Column(nullable = false)
	@NotNull(message = "Faculty Name Can't be null")
	private String fullName;
	
	@Column(nullable = true)
	//@Pattern(regexp = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$", message = "* please provide valid phone number")
	private String phoneNumber;
	
	@Column(nullable = false)
	@NotBlank(message = "Student Email name Can't be blank")
	@Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,3})$",message = "* please provide a valid email")
	private String email;
	
	@Column(nullable=false)
	@NotNull(message = "*Please provide date of admission")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dateOfAdmission;
	
	private Double cgpa;
	

	@ManyToOne
	@JoinColumn(name="faculty_id", nullable = false)
    private Faculty faculty;


	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Student(@NotBlank(message = "Faculty Name Can't be null") String studentNumber,
			@NotNull(message = "Faculty Name Can't be null") String fullName,
			@Pattern(regexp = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$", message = "* please provide valid phone number") String phoneNumber,
			@NotBlank(message = "Student Email name Can't be blank") @Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,3})$", message = "* please provide a valid email") String email,
			@NotNull(message = "*Please provide date of admission") LocalDate dateOfAdmission, Double cgpa,
			Faculty faculty) {
		super();
		this.studentNumber = studentNumber;
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.dateOfAdmission = dateOfAdmission;
		this.cgpa = cgpa;
		this.faculty = faculty;
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


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public LocalDate getDateOfAdmission() {
		return dateOfAdmission;
	}


	public void setDateOfAdmission(LocalDate dateOfAdmission) {
		this.dateOfAdmission = dateOfAdmission;
	}


	public Double getCgpa() {
		return cgpa;
	}


	public void setCgpa(Double cgpa) {
		this.cgpa = cgpa;
	}


	public Faculty getFaculty() {
		return faculty;
	}


	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	
	
}
