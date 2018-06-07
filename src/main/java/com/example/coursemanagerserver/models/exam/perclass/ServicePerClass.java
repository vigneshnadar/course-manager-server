package com.example.coursemanagerserver.models.exam.perclass;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.coursemanagerserver.models.Assignment;
import com.example.coursemanagerserver.models.Exam;
import com.example.coursemanagerserver.models.Lesson;
import com.example.coursemanagerserver.models.Widget;
import com.example.coursemanagerserver.repositories.ExamRepository;

@RestController
public class ServicePerClass {
	@Autowired
	BaseQuestionRepositoryPerClass baseRepo;
	@Autowired
	FillInTheBlankQuestionRepositoryPerClass fillRepo;
	@Autowired
	TrueOrFalseQuestionRepositoryPerClass trueRepo;
	@Autowired
	EssayQuestionRepositoryPerClass essayRepo;
	@Autowired
	MultipleChoiceQuestionRepositoryPerClass mcqRepo;
	
	
	@Autowired
	ExamRepository examRepo;
	
	@GetMapping("/api/inheritance/perclass/base")
	public BaseQuestionPerClass createBaseQuestion() {
		BaseQuestionPerClass q = new BaseQuestionPerClass();
		q.setDescription("descriptions 123");
		q.setInstructions("instructions 123");
		q.setPoints(123);
		q.setTitle("title 123");
		return baseRepo.save(q);
	}
	@GetMapping("/api/inheritance/perclass/fill")
	public FillInTheBlankQuestionPerClass createFillQuestion() {
		FillInTheBlankQuestionPerClass q = new FillInTheBlankQuestionPerClass();
		q.setDescription("descriptions 234");
		q.setInstructions("instructions 234");
		q.setPoints(234);
		q.setTitle("title 234");
		q.setVariables("variables 234");
		return fillRepo.save(q);
	}
	
	@GetMapping("/api/inheritance/perclass/true")
	public TrueOrFalseQuestionPerClass createTrueQuestion() {
		TrueOrFalseQuestionPerClass q = new TrueOrFalseQuestionPerClass();
		q.setDescription("descriptions 345");
		q.setInstructions("instructions 345");
		q.setPoints(345);
		q.setTitle("title 345");
		q.setIsTrue(true);
		return trueRepo.save(q);
	}
	
	
	
	@GetMapping("/api/truefalse/{id}")
	public TrueOrFalseQuestionPerClass findTFById(@PathVariable("id") int id) {
		Optional<TrueOrFalseQuestionPerClass> data = trueRepo.findById(id); 
		
		if(data.isPresent())
			return data.get();
		
		return null;
		
	}
	
	@GetMapping("/api/essay/{id}")
	public EssayQuestionPerClass findEssayById(@PathVariable("id") int id) {
		Optional<EssayQuestionPerClass> data = essayRepo.findById(id); 
		
		if(data.isPresent())
			return data.get();
		
		return null;
		
	}
	
	@GetMapping("/api/choice/{id}")
	public MultipleChoiceQuestionPerClass findMcqById(@PathVariable("id") int id) {
		Optional<MultipleChoiceQuestionPerClass> data = mcqRepo.findById(id); 
		
		if(data.isPresent())
			return data.get();
		
		return null;
		
	}
	
	@GetMapping("/api/blanks/{id}")
	public FillInTheBlankQuestionPerClass findBlankById(@PathVariable("id") int id) {
		Optional<FillInTheBlankQuestionPerClass> data = fillRepo.findById(id); 
		
		if(data.isPresent())
			return data.get();
		
		return null;
		
	}
	
	@PostMapping("/api/exam/{examId}/truefalse")
	public void createTrueFalse(@PathVariable("examId") int examId, @RequestBody TrueOrFalseQuestionPerClass trueFalseQuestion) {
		Optional<Exam> data = examRepo.findById(examId);		
		System.out.println("inside post");
			Exam ex = data.get();
			trueFalseQuestion.setExam(ex);
			trueRepo.save(trueFalseQuestion);

		}
	
	@PostMapping("/api/exam/{examId}/essay")
	public void createEssay(@PathVariable("examId") int examId, @RequestBody EssayQuestionPerClass essayQuestion) {
		Optional<Exam> data = examRepo.findById(examId);		
		    System.out.println("inside post");
			Exam ex = data.get();
			essayQuestion.setExam(ex);
			essayRepo.save(essayQuestion);
		}
	
	@PostMapping("/api/exam/{examId}/choice")
	public void createChoice(@PathVariable("examId") int examId, @RequestBody MultipleChoiceQuestionPerClass mcQuestion) {
		Optional<Exam> data = examRepo.findById(examId);		
		    System.out.println("inside post");
			Exam ex = data.get();
			mcQuestion.setExam(ex);
			mcqRepo.save(mcQuestion);
		}
	
	@PostMapping("/api/exam/{examId}/blanks")
	public void createWidgets(@PathVariable("examId") int examId, @RequestBody FillInTheBlankQuestionPerClass fillQuestion) {
		Optional<Exam> data = examRepo.findById(examId);		
		    System.out.println("inside post");
			Exam ex = data.get();
			fillQuestion.setExam(ex);
			fillRepo.save(fillQuestion);
		}

	
}
