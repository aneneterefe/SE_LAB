package edu.miu.cs.cs425.demo.studentmgmtapp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs.cs425.demo.studentmgmtapp.model.Classroom;

@Repository
public interface IClassroomRepository extends CrudRepository<Classroom, Long>  {

}
