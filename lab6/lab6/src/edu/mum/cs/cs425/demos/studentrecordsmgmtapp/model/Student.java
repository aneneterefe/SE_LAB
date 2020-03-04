package edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model;

import java.time.LocalDate;

public class Student {

	private int studentID;
	private String name;
	private LocalDate dao;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(int sid,String name,LocalDate dao) {
		this.studentID=sid;
		this.name=name;
		this.dao=dao;
	}
	
	public Student(int sid,String name) {
		this.studentID=sid;
		this.name=name;
	}
	
	public Student(int sid, LocalDate dao) {
		this.studentID=sid;
		this.dao=dao;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDao() {
		return dao;
	}

	public void setDao(LocalDate dao) {
		this.dao = dao;
	}
	
	
}
