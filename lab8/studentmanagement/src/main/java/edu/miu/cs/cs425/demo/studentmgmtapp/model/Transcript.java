package edu.miu.cs.cs425.demo.studentmgmtapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "transcript")
public class Transcript {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transcriptId;
	
	@Column(name="degreeTitle", nullable = false)
	@NotEmpty(message = "Degree title can't be empty")
	private String degreeTitle;
	
	
	public Transcript() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transcript(@NotEmpty(message = "Degree title can't be empty") String degreeTitle) {
		super();
		this.degreeTitle = degreeTitle;
	}

	public Long getTranscriptId() {
		return transcriptId;
	}

	public void setTranscriptId(Long transcriptId) {
		this.transcriptId = transcriptId;
	}

	public String getDegreeTitle() {
		return degreeTitle;
	}

	public void setDegreeTitle(String degreeTitle) {
		this.degreeTitle = degreeTitle;
	}

	@Override
	public String toString() {
		return "Transcript [transcriptId=" + transcriptId + ", degreeTitle=" + degreeTitle + "]";
	}
	
	
	
}
