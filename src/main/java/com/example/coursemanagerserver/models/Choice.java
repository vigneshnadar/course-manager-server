package com.example.coursemanagerserver.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.example.coursemanagerserver.models.exam.perclass.MultipleChoiceQuestionPerClass;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Choice {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String choice;
	@ManyToOne
	@JsonIgnore
	private MultipleChoiceQuestionPerClass mcq;
	
	
	public String getChoice() {
		return choice;
	}
	public void setChoice(String choice) {
		this.choice = choice;
	}
	public MultipleChoiceQuestionPerClass getMcq() {
		return mcq;
	}
	public void setMcq(MultipleChoiceQuestionPerClass mcq) {
		this.mcq = mcq;
	}
	

}
