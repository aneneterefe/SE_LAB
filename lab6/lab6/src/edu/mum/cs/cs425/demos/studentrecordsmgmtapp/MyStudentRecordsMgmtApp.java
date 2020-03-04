package edu.mum.cs.cs425.demos.studentrecordsmgmtapp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model.Student;

public class MyStudentRecordsMgmtApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Student> students=new ArrayList<Student>();
		students.add(new Student(110001, "Dave", LocalDate.of(1951, 11, 18)));
		students.add(new Student(110002, "Anna", LocalDate.of(1990, 12, 07)));
		students.add(new Student(110003, "Erica", LocalDate.of(1974, 1, 31)));
		students.add(new Student(110003, "Carlos", LocalDate.of(2009, 8, 22)));
		students.add(new Student(110005, "Bob", LocalDate.of(1990, 3, 05)));
		MyStudentRecordsMgmtApp rec=new MyStudentRecordsMgmtApp();
		rec.printListOfStudents(students);
		List<Student> platinumStudents=rec.getListOfPlatinumAlumniStudents(students);
		System.out.println();
		System.out.println("------Platinum Alumni Students---------");
		rec.printListOfStudents(platinumStudents);
		System.out.println();
		System.out.println("------Multiples of 5 or 7 checking for {7,5,10,35,14,67} ---------");
		int a[]= {7,5,10,35,14,67};
		rec.printHelloWorld(a);
		System.out.println();
		System.out.println("------Second Largest Number for {7,5,10,35,14,67} ---------");
		System.out.println(rec.findSecondBiggest(a).get());
		
	}
	
	public void printListOfStudents(List<Student> stu) {
		
		List<Student> temp=stu.stream().sorted(Comparator.comparing(Student::getName)).collect(Collectors.toList());
		int i=1;
		for (Student student : temp) {
			System.out.println("S"+i+":"+"studentId:"+student.getStudentID()+", name:"+student.getName()+", dateOfAdmission:"+student.getDao().format(DateTimeFormatter.ofPattern("MM/dd/YYYY")));
			i++;
		}
		
	}
	
	public List<Student> getListOfPlatinumAlumniStudents(List<Student> stu){
		
		List<Student> platinumStu=new ArrayList<Student>();
		for (Student lstu : stu) {
				LocalDate temp=lstu.getDao().plusYears(30);
				if(LocalDate.now().isAfter(temp))
					platinumStu.add(lstu);
			
		}
		return platinumStu;
	}
	
	public void printHelloWorld(int[] arr) {
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]%5==0&&arr[i]%7==0) {
				System.out.println("HelloWorld");
			}else if(arr[i]%5==0&&arr[i]%7!=0) {
				System.out.println("Hello");
			}else if(arr[i]%5!=0&&arr[i]%7==0) {
				System.out.println("World");
			}
		}
	}
	
	public Optional<Integer> findSecondBiggest(int arr[]) {
		
		
		if(arr.length<2) {
			Optional.empty();
		}
		int largest=(arr[0]>arr[1])?arr[0]:arr[1];
		int secondlarge=(largest==arr[0])?arr[1]:arr[0];
		for(int i=1;i<arr.length;i++) {
			if(arr[i]>largest) {
				secondlarge=largest;
				largest=arr[i];
			}
			if(arr[i]!=largest && arr[i]>secondlarge) {
				secondlarge=arr[i];
			}
			
		}
		return Optional.of(secondlarge);
		
	}
}
