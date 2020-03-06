package edu.miu.cs.cs425.demo.studentmgmtapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs.cs425.demo.studentmgmtapp.model.Student;

@Repository
public interface IStudentRepository extends CrudRepository<Student, Long>  {

}
 