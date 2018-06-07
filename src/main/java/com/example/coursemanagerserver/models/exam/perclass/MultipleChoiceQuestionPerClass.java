package com.example.coursemanagerserver.models.exam.perclass;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.coursemanagerserver.models.Choice;
import com.example.coursemanagerserver.models.Topic;

@Entity
@Table(name = "PER_CLASS_MULTIPLE_CHOICE_QUESTION")
public class MultipleChoiceQuestionPerClass
	extends BaseQuestionPerClass {
	
	@OneToMany(mappedBy="mcq",orphanRemoval=true)
	 private List<Choice> choices;
	
	public List<Choice> getChoices() {
		return choices;
	}
	public void setChoices(List<Choice> choices) {
		this.choices = choices;
	}

	@Column(name = "CORRECT_CHOICE", nullable = true)
	private String correctChoice;
	
	public String getCorrectChoice() {
		return correctChoice;
	}
	public void setCorrectChoice(String correctChoice) {
		this.correctChoice = correctChoice;
	}
	
	@Column(name = "IS_TRUE", nullable = false)
	private Boolean isTrue;
	public Boolean getIsTrue() {
		return isTrue;
	}
	public void setIsTrue(Boolean isTrue) {
		this.isTrue = isTrue;
	}
	
}
