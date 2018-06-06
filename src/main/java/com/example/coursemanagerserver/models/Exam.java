package com.example.coursemanagerserver.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.example.coursemanagerserver.models.exam.perclass.BaseQuestionPerClass;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Exam extends Widget {
	private String title;
	private String description;
	private int points;
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	@OneToMany(mappedBy="exam")
	@JsonIgnore
	private List<BaseQuestionPerClass> questions;
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
	public List<BaseQuestionPerClass> getQuestions() {
		return questions;
	}
	public void setQuestions(List<BaseQuestionPerClass> questions) {
		this.questions = questions;
	}
}
