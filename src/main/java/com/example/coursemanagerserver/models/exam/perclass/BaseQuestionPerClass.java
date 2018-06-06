package com.example.coursemanagerserver.models.exam.perclass;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.coursemanagerserver.models.Exam;
import com.example.coursemanagerserver.models.Module;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "PER_CLASS_BASE_QUESTION")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class BaseQuestionPerClass {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private int points;
	private String title;
	private String description;
	private String instructions;
	@ManyToOne
	@JsonIgnore
	private Exam exam;
	
	
	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getInstructions() {
		return instructions;
	}
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
}
