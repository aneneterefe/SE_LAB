package edu.miu.cs.cs425.demo.studentmgmtapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.miu.cs.cs425.demo.studentmgmtapp.model.Transcript;

@Repository
public interface ITranscriptRepository extends CrudRepository<Transcript, Long> {

}
