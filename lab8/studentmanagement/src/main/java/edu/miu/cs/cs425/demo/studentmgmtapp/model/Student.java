package edu.miu.cs.cs425.demo.studentmgmtapp.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name="students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long studentId;
	
	@Column(unique = true, nullable = false)
	@NotEmpty(message = "First name should not be empty!")
	private String studentNumber;
	
	@Column(nullable = false)
	@NotEmpty(message = "First name should not be empty!")
	private String firstName;
	
	@Column(nullable = true)
	private String middleName;
	
	@Column(nullable = false)
	@NotEmpty(message = "Last name should not be empty!")
	private String lastName;
	
	@Column(nullable = true)
	private double cgpa;
	
	@Column(nullable = false)
	private LocalDate dateOfEnrollment;
	

	@OneToMany
	@JoinColumn(name="transcript_id",nullable = false)
	private Transcript transcript;
	
	//student can be in multiple classes, classes can have many students. many to many relationships
	//owner of the relationship
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "Student_Class", 
        joinColumns = { @JoinColumn(name = "student_id") }, 
        inverseJoinColumns = { @JoinColumn(name = "classroom_id") }
    )
	private List<Classroom> classroomList;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Student(@NotEmpty(message = "First name should not be empty!") String studentNumber,
			@NotEmpty(message = "First name should not be empty!") String firstName, String middleName,
			@NotEmpty(message = "Last name should not be empty!") String lastName, double cgpa,
			LocalDate dateOfEnrollment) {
		super();
		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.cgpa = cgpa;
		this.dateOfEnrollment = dateOfEnrollment;
	}


	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
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

	public double getCgpa() {
		return cgpa;
	}

	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}

	public LocalDate getDateOfEnrollment() {
		return dateOfEnrollment;
	}

	public void setDateOfEnrollment(LocalDate dateOfEnrollment) {
		this.dateOfEnrollment = dateOfEnrollment;
	}

	public List<Classroom> getClassroomList() {
		return classroomList;
	}

	public void setClassroomList(List<Classroom> classroomList) {
		this.classroomList = classroomList;
	}


	public Transcript getTranscript() {
		return transcript;
	}


	public void setTranscript(Transcript transcript) {
		this.transcript = transcript;
	}


	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentNumber=" + studentNumber + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + ", cgpa=" + cgpa + ", dateOfEnrollment="
				+ dateOfEnrollment + ", transcript=" + transcript + ", classroomList=" + classroomList + "]";
	}


	

}
