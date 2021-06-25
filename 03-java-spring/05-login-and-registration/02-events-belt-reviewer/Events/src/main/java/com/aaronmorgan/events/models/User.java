package com.aaronmorgan.events.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;


@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Size(min=2, message="Longer first name must be given")
    private String firstName;
    @Size(min=2, message="Longer last name must be given")
    private String lastName;
    
    @Email
    private String email;
    
    @Size(min=2, message="Longer location name must be given")
    private String location;
    private String state;
    
    @Size(min=6, message="passwords have a min of 6 characters")
	private String password;
    @Transient
    private String passwordConfirmation;
    
    @OneToMany(mappedBy="host", fetch=FetchType.LAZY)
	private List<Event> eventsHosting;

    @OneToMany(mappedBy="author", fetch=FetchType.LAZY)
	private List<Message> messagesPosted;
    
    @ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(
		name="users_events",
		joinColumns = @JoinColumn(name="user_id"),
		inverseJoinColumns = @JoinColumn(name="event_id")
	)
    private List<Event> eventsAttending;
    
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    
    public User() {
    }
    
    
    public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

    public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}


	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}


	public List<Event> getEventsHosting() {
		return eventsHosting;
	}


	public void setEventsHosting(List<Event> eventsHosting) {
		this.eventsHosting = eventsHosting;
	}


	public List<Message> getMessagesPosted() {
		return messagesPosted;
	}


	public void setMessagesPosted(List<Message> messagesPosted) {
		this.messagesPosted = messagesPosted;
	}


	public List<Event> getEventsAttending() {
		return eventsAttending;
	}


	public void setEventsAttending(List<Event> eventsAttending) {
		this.eventsAttending = eventsAttending;
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

	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
