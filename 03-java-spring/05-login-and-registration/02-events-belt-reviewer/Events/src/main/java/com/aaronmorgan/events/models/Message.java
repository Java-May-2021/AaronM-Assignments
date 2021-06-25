package com.aaronmorgan.events.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="messages")
public class Message {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotBlank
    private String content;
	
    @Column(updatable=false)
    @DateTimeFormat
    private Date createdAt;
    @DateTimeFormat
    private Date updatedAt;
    
    @PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	 @ManyToOne(fetch=FetchType.LAZY)
	    @JoinColumn(name="user_id")
	    
	    private User author;
	 
	 @ManyToOne(fetch=FetchType.LAZY)
	    @JoinColumn(name="event_id")
	    
	    private Event topic;

	public Message() {
	
	}
	
	public Message(User author, Event topic, String content) {
	    	this.author = author;
	    	this.topic = topic;
	    	this.content = content;
	}
	 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Event getTopic() {
		return topic;
	}

	public void setTopic(Event topic) {
		this.topic = topic;
	} 
}