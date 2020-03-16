package com.fsap.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Entity
@Table(name="faculty")
public class Faculty {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer facultyId;
	
	@Column(nullable = false)
	@NotNull(message = "Faculty Name Can't be null")
	private String fullName;
	
	@Column(nullable = true)
	@Pattern(regexp = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$", message = "* please provide valid phone number")
	private String phoneNumber;
	
	@Column(nullable = false)
	@NotBlank(message = "Faculty Email name Can't be blank")
	@Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,3})$",message = "* please provide a valid email")
	private String email;
	
	@Column(nullable = true)
	private String officeLocation;
	
	@OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Student> students=new ArrayList<>();

	public Faculty() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Faculty(@NotNull(message = "Faculty Name Can't be null") String fullName,
			@Pattern(regexp = "^\\(?([0-9]{3})\\)?[-.\\s]?([0-9]{3})[-.\\s]?([0-9]{4})$", message = "* please provide valid phone number") String phoneNumber,
			@NotBlank(message = "Faculty Email name Can't be blank") @Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,3})$", message = "* please provide a valid email") String email,
			String officeLocation, List<Student> students) {
		super();
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.officeLocation = officeLocation;
		this.students = students;
	}

	public Integer getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(Integer facultyId) {
		this.facultyId = facultyId;
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

	public String getOfficeLocation() {
		return officeLocation;
	}

	public void setOfficeLocation(String officeLocation) {
		this.officeLocation = officeLocation;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> accounts) {
		this.students = students;
	}

	
}
