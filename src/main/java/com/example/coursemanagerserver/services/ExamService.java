package com.example.coursemanagerserver.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.coursemanagerserver.models.Assignment;
import com.example.coursemanagerserver.models.Exam;
import com.example.coursemanagerserver.models.Lesson;
import com.example.coursemanagerserver.models.MultipleChoiceQuestion;
import com.example.coursemanagerserver.models.Question;
import com.example.coursemanagerserver.models.TrueFalseQuestion;

import com.example.coursemanagerserver.models.Widget;
import com.example.coursemanagerserver.repositories.ExamRepository;
import com.example.coursemanagerserver.repositories.LessonRepository;
import com.example.coursemanagerserver.repositories.MultipleChoicesQuestionRepository;
import com.example.coursemanagerserver.repositories.TrueFalseQuestionRepository;
import com.example.coursemanagerserver.repositories.WidgetRepository;



@RestController
@CrossOrigin(origins = "*")
public class ExamService {
	@Autowired
	ExamRepository examRepository;
	@Autowired
	LessonRepository lessonRepository;
	@Autowired
	TrueFalseQuestionRepository trueFalseRepository;
	@Autowired
	MultipleChoicesQuestionRepository mutiRepo;
	
	
	@GetMapping("/api/exam")
	public List<Exam> findAllExams(){
		
		return (List<Exam>) examRepository.findAll();
		
	}
	
	
	 @GetMapping("/api/exam/{id}")
		public Exam findExamById(@PathVariable("id") int id) {
			Optional<Exam> data = examRepository.findById(id); 
			
			if(data.isPresent())
				return data.get();
			
			return null;
			
		}
	 
	 @DeleteMapping("/api/exam/{examId}")
		public void deleteExam(
		@PathVariable("examId") int id) {
		 examRepository.deleteById(id);
		}
	 
	 

		@GetMapping("/api/lesson/{lessonId}/exam")
		public List<Widget> findAllExamsForLesson(@PathVariable("lessonId") int lessonId) {
			System.out.println("here");
			Optional<Lesson> optionalLesson = lessonRepository.findById(lessonId);
			
			List<Widget> outputWidgets = new ArrayList<Widget>();
			if(optionalLesson.isPresent()) {
				Lesson lesson = optionalLesson.get();
				List<Widget> widgets = lesson.getWidgets();
				
				
				for(Widget w: widgets) {
					if(w.getWidgetType().equals("Assignment")) {
						outputWidgets.add(w);
					}
				}
				int count = outputWidgets.size();
				return outputWidgets;
			}
			return null;
		}
		
		
		@PostMapping("/api/lesson/{lessonId}/exam")
		public void createWidgets(@PathVariable("lessonId") int lessonId, @RequestBody List<Exam> exams) {
			Optional<Lesson> data = lessonRepository.findById(lessonId);
			

			if (data.isPresent()) {
				Lesson les = data.get();
				List<Widget> prevWidgets = les.getWidgets();
				
//				for(Widget widget: prevWidgets){
//					 repository.deleteById(widget.getId());
//				}
//				
//				repository.deleteAll();
				for(Exam ex: exams){
					ex.setLesson(les);
					examRepository.save(ex);
				}
			}
//			return null;
		}

	@GetMapping("/api/multi/{questionId}")
	public MultipleChoiceQuestion findMultiQuestionById(@PathVariable("questionId") int questionId) {
		Optional<MultipleChoiceQuestion> optional = mutiRepo.findById(questionId);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	
	
	
	

	@GetMapping("/api/truefalse/{questionId}")
	public TrueFalseQuestion findTrueFalseQuestionById(@PathVariable("questionId") int questionId) {
		
		Optional<TrueFalseQuestion> optional = trueFalseRepository.findById(questionId);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	@GetMapping("/api/exam/{examId}/question")
	public List<Question> findAllQuestionsForExam(@PathVariable("examId") int examId) {
		System.out.println("here");
		Optional<Exam> optionalExam = examRepository.findById(examId);
		if(optionalExam.isPresent()) {
			Exam exam = optionalExam.get();
			List<Question> questions = exam.getQuestions();
			int count = questions.size();
			return questions;
		}
		return null;
	}
}
