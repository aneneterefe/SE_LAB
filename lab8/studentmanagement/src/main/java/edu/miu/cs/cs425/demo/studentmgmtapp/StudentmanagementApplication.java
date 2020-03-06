package edu.miu.cs.cs425.demo.studentmgmtapp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.miu.cs.cs425.demo.studentmgmtapp.model.Classroom;
import edu.miu.cs.cs425.demo.studentmgmtapp.model.Student;
import edu.miu.cs.cs425.demo.studentmgmtapp.model.Transcript;
import edu.miu.cs.cs425.demo.studentmgmtapp.repository.IClassroomRepository;
import edu.miu.cs.cs425.demo.studentmgmtapp.repository.IStudentRepository;
import edu.miu.cs.cs425.demo.studentmgmtapp.repository.ITranscriptRepository;

@SpringBootApplication
public class StudentmanagementApplication implements CommandLineRunner {

	@Autowired
	private IStudentRepository studentRepository;
	@Autowired
	private ITranscriptRepository transcriptRespository;
	@Autowired
	private IClassroomRepository classroomRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(StudentmanagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Welcome to StudentManagmentApp version 1.0");
		Student student=new Student("000-61-0001","Alex","Mark","John",3.9,LocalDate.now());
		Transcript transcript= new Transcript("BS Computer Science");
		Classroom classroom=new Classroom("McLaughlin building","M105");
		System.out.println(saveStudent(student));
		System.out.println(saveClassroom(classroom));
		System.out.println(saveTranscript(transcript));
//		List<Classroom> classrooms=new ArrayList<>();
//		List<Transcript> transcripts=new ArrayList<>();
//		classrooms.add(classroom);
//		
	}
	
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public Transcript saveTranscript(Transcript transcript) {
		return transcriptRespository.save(transcript);
	}
	
	public Classroom saveClassroom(Classroom classroom) {
		return classroomRepository.save(classroom);
	}

 }
