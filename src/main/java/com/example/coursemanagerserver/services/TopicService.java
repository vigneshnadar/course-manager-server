package com.example.coursemanagerserver.services;

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

import com.example.coursemanagerserver.models.Lesson;
import com.example.coursemanagerserver.models.Course;
import com.example.coursemanagerserver.models.Topic;
import com.example.coursemanagerserver.repositories.LessonRepository;
import com.example.coursemanagerserver.repositories.TopicRepository;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class TopicService {
	@Autowired
	LessonRepository lessonRepository;
	@Autowired
	TopicRepository topicRepository;
	
	
	@GetMapping("/api/topic")
	public Iterable<Topic> findAllTopics() {
		return topicRepository.findAll(); 
	}

	@PostMapping("/api/lesson/{lessonId}/topic")
	public Topic createTopic(@PathVariable("lessonId") int courseId,@PathVariable("lessonId") int lessonId, @RequestBody Topic newTopic) {
		Optional<Lesson> data = lessonRepository.findById(lessonId);

		if (data.isPresent()) {
			Lesson lesson = data.get();
			newTopic.setLesson(lesson);
			return topicRepository.save(newTopic);

		}
		return null;
	}
	
	@GetMapping("/api/lesson/{mid}/topic")
	public List<Topic> findAllTopicsForLesson(@PathVariable("cid") int cid,@PathVariable("mid") int mid) {
		Optional<Lesson> data = lessonRepository.findById(mid);

		if (data.isPresent()) {
			Lesson lesson = data.get();
			return lesson.getTopics();

		}
		return null;
	}
	
	@DeleteMapping("/api/topic/{topicId}")
	public void deleteTopic(@PathVariable("topicId") int topicId) {
		topicRepository.deleteById(topicId);
	}
}
