package edu.miu.cs.cs425.demo.studentmgmtapp.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="classroom")
public class Classroom {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long classroomId;
	
	@Column(name = "buildingName", nullable = false)
	@NotEmpty(message = "Building name must not be empty")
	private String buildingName;
	
	@Column(name = "roomNumber", nullable = false)
	@NotEmpty(message = "Room number must not be empty")
	private String roomNumber;
	
	@ManyToMany(mappedBy = "classroomList")
	private List<Student> studentList;

	public Classroom() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Classroom(@NotEmpty(message = "Building name must not be empty") String buildingName,
			@NotEmpty(message = "Room number must not be empty") String roomNumber, List<Student> studentList) {
		super();
		this.buildingName = buildingName;
		this.roomNumber = roomNumber;
		this.studentList = studentList;
	}

	public Classroom(@NotEmpty(message = "Building name must not be empty") String buildingName,
			@NotEmpty(message = "Room number must not be empty") String roomNumber) {
		super();
		this.buildingName = buildingName;
		this.roomNumber = roomNumber;
	}

	public Long getClassroomId() {
		return classroomId;
	}

	public void setClassroomId(Long classroomId) {
		this.classroomId = classroomId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	
	
	
}
