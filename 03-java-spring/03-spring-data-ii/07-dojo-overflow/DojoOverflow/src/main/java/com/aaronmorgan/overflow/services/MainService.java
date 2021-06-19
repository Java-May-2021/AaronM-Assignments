package com.aaronmorgan.overflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.aaronmorgan.overflow.models.Answer;
import com.aaronmorgan.overflow.models.Question;
import com.aaronmorgan.overflow.models.Tag;
import com.aaronmorgan.overflow.repositories.AnswerRepository;
import com.aaronmorgan.overflow.repositories.QuestionRepository;
import com.aaronmorgan.overflow.repositories.TagRepository;

@Service
public class MainService {
	private QuestionRepository qRepo;
	private TagRepository tRepo;
	private AnswerRepository aRepo;
	public MainService(QuestionRepository qRepo, TagRepository tRepo, AnswerRepository aRepo) {
		this.qRepo = qRepo;
		this.tRepo = tRepo;
		this.aRepo = aRepo;
	}
	
// QUESTIONS		
	//Display All
	public List<Question> getAllQuestions(){
		return this.qRepo.findAll();
	}
	
	//Display One
	public Question getSingleQuestion(Long id) {
		return this.qRepo.findById(id).orElse(null);
	}
	
	//Create
	public Question createQuestion(Question question) {
		ArrayList<Tag> questionsTags = new ArrayList<Tag>();
		String tags = question.getTags();
		
		String[] qTags = tags.split(",");
		
		for(String subject: qTags) {
			System.out.println(subject);
			Tag tag = this.tRepo.findBySubject(subject.toLowerCase().trim());
			if(tag == null) {
				tag = new Tag(subject);
				tag.setSubject(subject);
				this.tRepo.save(tag);
			}
			
			if(!questionsTags.contains(tag)) {
				questionsTags.add(tag);
			}
		}
		
		Question newQuestion = new Question(question.getQuestion(), questionsTags);
		return this.qRepo.save(null);
	}
	
// TAGS
	//Create
	public Tag createTag(Tag tag) {
		return this.tRepo.save(tag);
	}
		
// ANSWERS
	//Create
	public Answer createAnswer(Answer answer) {
		return this.aRepo.save(answer);
	}
}
