package com.example.coursemanagerserver.models.exam.perclass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PER_CLASS_ESSAY_QUESTION")
public class EssayQuestionPerClass
	extends BaseQuestionPerClass {
	
}
