
package com.example.coursemanagerserver.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
public class AssignmentService {
	@Autowired
	LessonRepository lessonRepository;
	@Autowired
	TrueFalseQuestionRepository trueFalseRepository;
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
}

