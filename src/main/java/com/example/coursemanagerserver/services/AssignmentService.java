
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
import com.example.coursemanagerserver.models.Course;
import com.example.coursemanagerserver.models.Exam;
import com.example.coursemanagerserver.models.Lesson;
import com.example.coursemanagerserver.models.MultipleChoiceQuestion;
import com.example.coursemanagerserver.models.Question;
import com.example.coursemanagerserver.models.TrueFalseQuestion;

import com.example.coursemanagerserver.models.Widget;
import com.example.coursemanagerserver.repositories.AssignmentRepository;
import com.example.coursemanagerserver.repositories.ExamRepository;
import com.example.coursemanagerserver.repositories.LessonRepository;
import com.example.coursemanagerserver.repositories.MultipleChoicesQuestionRepository;
import com.example.coursemanagerserver.repositories.TrueFalseQuestionRepository;
import com.example.coursemanagerserver.repositories.WidgetRepository;



@RestController
@CrossOrigin(origins = "*")
public class AssignmentService {
	@Autowired
	LessonRepository lessonRepository;
	@Autowired
	AssignmentRepository assignRepository;
	@Autowired
	MultipleChoicesQuestionRepository mutiRepo;

//	@GetMapping("/api/multi/{questionId}")
//	public MultipleChoiceQuestion findMultiQuestionById(@PathVariable("questionId") int questionId) {
//		Optional<MultipleChoiceQuestion> optional = mutiRepo.findById(questionId);
//		if(optional.isPresent()) {
//			return optional.get();
//		}
//		return null;
//	}
//
//	@GetMapping("/api/truefalse/{questionId}")
//	public TrueFalseQuestion findTrueFalseQuestionById(@PathVariable("questionId") int questionId) {
//		
//		Optional<TrueFalseQuestion> optional = trueFalseRepository.findById(questionId);
//		if(optional.isPresent()) {
//			return optional.get();
//		}
//		return null;
//	}
	
	
	@GetMapping("/api/assignment")
	public List<Assignment> findAllAssignments(){
		
		return (List<Assignment>) assignRepository.findAll();
		
	}
	
	
	 @GetMapping("/api/assignment/{id}")
		public Assignment findAssignmentById(@PathVariable("id") int id) {
			Optional<Assignment> data = assignRepository.findById(id); 
			
			if(data.isPresent())
				return data.get();
			
			return null;
			
		}
	 
	 @DeleteMapping("/api/assignment/{assignmentId}")
		public void deleteAssignment(
		@PathVariable("assignmentId") int id) {
		 assignRepository.deleteById(id);
		}
	
	@GetMapping("/api/lesson/{lessonId}/assignment")
	public List<Widget> findAllAssignmentsForLesson(@PathVariable("lessonId") int lessonId) {
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
	
	
	@PostMapping("/api/lesson/{lessonId}/assignment")
	public void createWidgets(@PathVariable("lessonId") int lessonId, @RequestBody List<Assignment> assignments) {
		Optional<Lesson> data = lessonRepository.findById(lessonId);
		

		if (data.isPresent()) {
			Lesson les = data.get();
			List<Widget> prevWidgets = les.getWidgets();
			
//			for(Widget widget: prevWidgets){
//				 repository.deleteById(widget.getId());
//			}
//			
//			repository.deleteAll();
			for(Assignment assign: assignments){
				assign.setLesson(les);
				assignRepository.save(assign);
			}
		}
//		return null;
	}
}

